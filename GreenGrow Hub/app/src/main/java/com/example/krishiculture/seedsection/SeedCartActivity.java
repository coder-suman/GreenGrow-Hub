package com.example.krishiculture.seedsection;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.example.krishiculture.R;
import com.example.krishiculture.userlogin.loginActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Transaction;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.MutableData;
import android.app.Dialog;
import java.util.ArrayList;
import java.util.UUID;

public class SeedCartActivity extends AppCompatActivity {
    private ListView cartListView;
    private TextView totalAmountText;
    private ArrayList<CartItem> cartItems;
    private SharedPreferences sharedPreferences;
    private FirebaseAuth mAuth;
    private String userId;
    private Dialog loadingDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seed_cart);

        sharedPreferences = getSharedPreferences("DeliveryAddresses", MODE_PRIVATE);
        mAuth = FirebaseAuth.getInstance();

        // Initialize views
        cartListView = findViewById(R.id.cart_list);
        totalAmountText = findViewById(R.id.total_amount);
        Button checkoutButton = findViewById(R.id.checkout_button);
        checkoutButton.setText("Order Now");

        // Get cart items from seedDetailsActivity
        cartItems = seedDetailsActivity.getCartItems();

        // Set up cart list adapter
        CartListAdapter adapter = new CartListAdapter(this, cartItems);
        cartListView.setAdapter(adapter);

        // Update total amount
        updateTotalAmount();

        // Back button click listener
        findViewById(R.id.back_button).setOnClickListener(v -> finish());

        // Order now button click listener
        checkoutButton.setOnClickListener(v -> {
            FirebaseUser currentUser = mAuth.getCurrentUser();
            if (currentUser == null) {
                Toast.makeText(this, "Please login first", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, loginActivity.class));
                finish();
                return;
            }
            userId = currentUser.getUid();
            showAddressDialog();
        });

        // Add My Orders button click listener
        findViewById(R.id.my_orders_button).setOnClickListener(v -> {
            startActivity(new Intent(this, MySeedOrdersActivity.class));
        });
    }

    private void showAddressDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View dialogView = LayoutInflater.from(this).inflate(R.layout.address_dialog, null);
        builder.setView(dialogView);

        EditText addressInput = dialogView.findViewById(R.id.address_input);
        EditText pincodeInput = dialogView.findViewById(R.id.pincode_input);
        EditText phoneInput = dialogView.findViewById(R.id.phone_input);
        Button confirmButton = dialogView.findViewById(R.id.confirm_button);

        // Pre-fill with saved address if available
        addressInput.setText(sharedPreferences.getString("lastAddress", ""));
        pincodeInput.setText(sharedPreferences.getString("lastPincode", ""));
        phoneInput.setText(sharedPreferences.getString("lastPhone", ""));

        AlertDialog dialog = builder.create();

        confirmButton.setOnClickListener(v -> {
            String address = addressInput.getText().toString().trim();
            String pincode = pincodeInput.getText().toString().trim();
            String phone = phoneInput.getText().toString().trim();

            if (address.isEmpty() || pincode.isEmpty() || phone.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            if (pincode.length() != 6) {
                Toast.makeText(this, "Please enter valid PIN code", Toast.LENGTH_SHORT).show();
                return;
            }

            if (phone.length() != 10) {
                Toast.makeText(this, "Please enter valid phone number", Toast.LENGTH_SHORT).show();
                return;
            }

            // Save address
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("lastAddress", address);
            editor.putString("lastPincode", pincode);
            editor.putString("lastPhone", phone);
            editor.apply();

            processOrder(address, pincode, phone);
            dialog.dismiss();
        });

        dialog.show();
    }

    private void processOrder(String address, String pincode, String phone) {
        showLoadingDialog();
        
        String orderId = UUID.randomUUID().toString();
        final double totalAmount = calculateTotalAmount();

        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser == null) {
            hideLoadingDialog();
            return;
        }

        SeedOrder order = new SeedOrder(
            orderId,
            currentUser.getUid(),
            currentUser.getEmail(),
            address,
            pincode,
            phone,
            new ArrayList<>(cartItems),
            totalAmount
        );

        DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
        DatabaseReference userOrderRef = rootRef.child("users")
            .child(currentUser.getUid())
            .child("seed_orders")
            .child(orderId);
        DatabaseReference allOrdersRef = rootRef.child("all_seed_orders").child(orderId);

        // First save to user orders
        userOrderRef.setValue(order)
            .addOnSuccessListener(aVoid -> {
                // Then save to all orders
                allOrdersRef.setValue(order)
                    .addOnSuccessListener(aVoid2 -> {
                        hideLoadingDialog();
                        // Clear cart in background
                        new Thread(() -> {
                            cartItems.clear();
                            seedDetailsActivity.clearCart();
                            runOnUiThread(() -> {
                                updateTotalAmount();
                                Toast.makeText(SeedCartActivity.this, 
                                    "Order placed successfully!", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(SeedCartActivity.this, MySeedOrdersActivity.class));
                                finish();
                            });
                        }).start();
                    })
                    .addOnFailureListener(e -> {
                        hideLoadingDialog();
                        Toast.makeText(SeedCartActivity.this, 
                            "Failed to place order: " + e.getMessage(), 
                            Toast.LENGTH_SHORT).show();
                    });
            })
            .addOnFailureListener(e -> {
                hideLoadingDialog();
                Toast.makeText(SeedCartActivity.this, 
                    "Failed to place order: " + e.getMessage(), 
                    Toast.LENGTH_SHORT).show();
            });
    }

    // Add this helper method to calculate total amount
    private double calculateTotalAmount() {
        double total = 0;
        for (CartItem item : cartItems) {
            total += item.getTotalPrice();
        }
        return total;
    }

    public void updateTotalAmount() {
        double total = 0;
        for (CartItem item : cartItems) {
            total += item.getTotalPrice();
        }
        totalAmountText.setText(String.format("Total: ₹%.2f", total));
    }

    // Add loading dialog methods
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