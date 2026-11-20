package com.example.krishiculture.seedsection;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.krishiculture.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class SeedOrderDetailsActivity extends AppCompatActivity {
    private TextView orderIdText;
    private TextView dateText;
    private TextView statusText;
    private TextView addressText;
    private TextView totalAmountText;
    private ListView itemsListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seed_order_details);

        // Initialize views
        orderIdText = findViewById(R.id.order_id_text);
        dateText = findViewById(R.id.order_date_text);
        statusText = findViewById(R.id.order_status_text);
        addressText = findViewById(R.id.delivery_address_text);
        totalAmountText = findViewById(R.id.total_amount_text);
        itemsListView = findViewById(R.id.items_list_view);

        // Get order ID from intent
        String orderId = getIntent().getStringExtra("order_id");
        if (orderId == null) {
            Toast.makeText(this, "Order details not found", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }

        // Back button
        findViewById(R.id.back_button).setOnClickListener(v -> finish());

        // Load order details
        loadOrderDetails(orderId);
    }

    private void loadOrderDetails(String orderId) {
        String userId = FirebaseAuth.getInstance().getCurrentUser().getUid();
        DatabaseReference orderRef = FirebaseDatabase.getInstance().getReference()
            .child("users")
            .child(userId)
            .child("seed_orders")
            .child(orderId);

        orderRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                try {
                    SeedOrder order = dataSnapshot.getValue(SeedOrder.class);
                    if (order != null) {
                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault());
                        
                        // Set order details
                        orderIdText.setText("Order ID: " + order.getOrderId());
                        dateText.setText("Ordered on: " + dateFormat.format(new Date(order.getTimestamp())));
                        statusText.setText("Status: " + order.getStatus());
                        addressText.setText("Delivery Address:\n" + order.getAddress() + 
                            "\nPIN: " + order.getPinCode() + "\nPhone: " + order.getPhoneNumber());
                        totalAmountText.setText(String.format("Total Amount: ₹%.2f", order.getTotalAmount()));

                        // Set up items list
                        SeedOrderItemAdapter adapter = new SeedOrderItemAdapter(
                            SeedOrderDetailsActivity.this, order.getItems());
                        itemsListView.setAdapter(adapter);
                    } else {
                        Toast.makeText(SeedOrderDetailsActivity.this, 
                            "Order not found", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                } catch (Exception e) {
                    Log.e("SeedOrderDetails", "Error loading order: " + e.getMessage());
                    Toast.makeText(SeedOrderDetailsActivity.this, 
                        "Error loading order details", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(SeedOrderDetailsActivity.this, 
                    "Error loading order details", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
} 