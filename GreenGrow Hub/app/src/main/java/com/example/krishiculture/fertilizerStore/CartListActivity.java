package com.example.krishiculture.fertilizerStore;

import android.app.Dialog;
import android.content.SharedPreferences;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.krishiculture.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import java.util.ArrayList;
import java.util.UUID;
import com.example.krishiculture.userlogin.loginActivity;
import com.google.firebase.database.Transaction;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.MutableData;

public class CartListActivity extends AppCompatActivity {
    private ListView cartListView;
    private TextView totalPriceText;
    private TextView checkoutButton;
    private CartListAdapter adapter;
    private SharedPreferences sharedPreferences;
    private DatabaseReference ordersRef;
    private FirebaseAuth mAuth;
    private String userId;
    private Dialog loadingDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_list);

        sharedPreferences = getSharedPreferences("DeliveryAddresses", MODE_PRIVATE);

        cartListView = findViewById(R.id.cart_list_view);
        totalPriceText = findViewById(R.id.total_price_text);
        checkoutButton = findViewById(R.id.checkout_button);
        
        // Update checkout button text
        checkoutButton.setText("Buy Now");

        adapter = new CartListAdapter(this, fartilizerDetailsActivity.cartItems);
        cartListView.setAdapter(adapter);

        updateTotalPrice();

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        
        if (currentUser == null) {
            Toast.makeText(this, "Please login first", Toast.LENGTH_SHORT).show();
            // Fix the class reference to loginActivity
            startActivity(new Intent(this, loginActivity.class));
            finish();
            return;
        }
        
        userId = currentUser.getUid();
        
        // Initialize database reference
        ordersRef = FirebaseDatabase.getInstance().getReference()
            .child("users")
            .child(userId)
            .child("orders");

        checkoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fartilizerDetailsActivity.cartItems.isEmpty()) {
                    Toast.makeText(CartListActivity.this, 
                        "Cart is empty", Toast.LENGTH_SHORT).show();
                    return;
                }
                showDeliveryAddressDialog();
            }
        });

        //for view previous order
        TextView viewOrdersButton = findViewById(R.id.view_orders_button);
        viewOrdersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Check if user is logged in
                if (mAuth.getCurrentUser() != null) {
                    startActivity(new Intent(CartListActivity.this, MyOrdersActivity.class));
                } else {
                    Toast.makeText(CartListActivity.this, 
                        "Please login to view orders", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(CartListActivity.this, loginActivity.class));
                }
            }
        });
    }

    private void showDeliveryAddressDialog() {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_delivery_address);

        EditText addressInput = dialog.findViewById(R.id.address_input);
        EditText pincodeInput = dialog.findViewById(R.id.pincode_input);
        EditText phoneInput = dialog.findViewById(R.id.phone_input);
        Button confirmButton = dialog.findViewById(R.id.confirm_order_btn);

        // Load saved address if exists
        addressInput.setText(sharedPreferences.getString("lastAddress", ""));
        pincodeInput.setText(sharedPreferences.getString("lastPincode", ""));
        phoneInput.setText(sharedPreferences.getString("lastPhone", ""));

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String address = addressInput.getText().toString().trim();
                String pincode = pincodeInput.getText().toString().trim();
                String phone = phoneInput.getText().toString().trim();

                if (address.isEmpty() || pincode.isEmpty() || phone.isEmpty()) {
                    Toast.makeText(CartListActivity.this, 
                        "Please fill all fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (pincode.length() != 6) {
                    Toast.makeText(CartListActivity.this, 
                        "Please enter valid PIN code", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (phone.length() != 10) {
                    Toast.makeText(CartListActivity.this, 
                        "Please enter valid phone number", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Save address to SharedPreferences
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("lastAddress", address);
                editor.putString("lastPincode", pincode);
                editor.putString("lastPhone", phone);
                editor.apply();

                // Create delivery address object
                DeliveryAddress deliveryAddress = new DeliveryAddress(address, pincode, phone);

                // Process order
                processOrder(deliveryAddress);
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    private void processOrder(DeliveryAddress deliveryAddress) {
        try {
            showLoadingDialog();
            FirebaseUser currentUser = mAuth.getCurrentUser();
            if (currentUser == null) {
                hideLoadingDialog();
                Toast.makeText(this, "Please login first", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, loginActivity.class));
                finish();
                return;
            }
            String orderId = UUID.randomUUID().toString();
            final double totalAmount = calculateTotalAmount();

            Order order = new Order(
                orderId,
                currentUser.getUid(),
                currentUser.getEmail(),
                deliveryAddress.getFullAddress(),
                deliveryAddress.getPinCode(),
                deliveryAddress.getPhoneNumber(),
                new ArrayList<>(fartilizerDetailsActivity.cartItems),
                totalAmount,
                deliveryAddress.getFullAddress()
            );

            DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
            DatabaseReference userOrderRef = rootRef.child("users")
                .child(currentUser.getUid())
                .child("orders")
                .child(orderId);
            DatabaseReference allOrdersRef = rootRef.child("all_orders").child(orderId);

            // First save to user orders
            userOrderRef.setValue(order)
                .addOnSuccessListener(aVoid -> {
                    // Then save to all orders
                    allOrdersRef.setValue(order)
                        .addOnSuccessListener(aVoid2 -> {
                            hideLoadingDialog();
                            // Clear cart in background
                            new Thread(() -> {
                                fartilizerDetailsActivity.cartItems.clear();
                                runOnUiThread(() -> {
                                    updateTotalPrice();
                                    adapter.notifyDataSetChanged();
                                    Toast.makeText(CartListActivity.this, 
                                        "Order placed successfully!", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(CartListActivity.this, OrderDetailsActivity.class);
                                    intent.putExtra("order_id", orderId);
                                    startActivity(intent);
                                    finish();
                                });
                            }).start();
                        })
                        .addOnFailureListener(e -> {
                            hideLoadingDialog();
                            Toast.makeText(CartListActivity.this, 
                                "Failed to place order: " + e.getMessage(), 
                                Toast.LENGTH_SHORT).show();
                        });
                })
                .addOnFailureListener(e -> {
                    hideLoadingDialog();
                    Toast.makeText(CartListActivity.this, 
                        "Failed to place order: " + e.getMessage(), 
                        Toast.LENGTH_SHORT).show();
                });

        } catch (Exception e) {
            hideLoadingDialog();
            Toast.makeText(this, "Error processing order: " + e.getMessage(), 
                Toast.LENGTH_SHORT).show();
            Log.e("CartListActivity", "Order processing error", e);
        }
    }

    private double calculateTotalAmount() {
        double total = 0;
        for (CartItem item : fartilizerDetailsActivity.cartItems) {
            total += item.getTotalPrice();
        }
        return total;
    }

    public void updateTotalPrice() {
        double total = 0;
        for (CartItem item : fartilizerDetailsActivity.cartItems) {
            total += item.getTotalPrice();
        }
        totalPriceText.setText("Total: ₹" + String.format("%.2f", total));
    }

    private void showLoadingDialog() {
        if (loadingDialog == null) {
            loadingDialog = new Dialog(this);
            loadingDialog.setContentView(R.layout.dialog_loading);
            loadingDialog.setCancelable(false);
        }
        loadingDialog.show();
    }

    private void hideLoadingDialog() {
        if (loadingDialog != null && loadingDialog.isShowing()) {
            loadingDialog.dismiss();
        }
    }
} 