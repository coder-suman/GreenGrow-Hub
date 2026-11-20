package com.example.krishiculture.seedsection;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.krishiculture.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class MySeedOrdersActivity extends AppCompatActivity {
    private ListView ordersListView;
    private DatabaseReference ordersRef;
    private List<Map<String, String>> ordersList;
    private SimpleAdapter adapter;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_seed_orders);

        mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();

        if (currentUser == null) {
            Toast.makeText(this, "Please login first", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }

        ordersListView = findViewById(R.id.orders_list_view);
        ordersList = new ArrayList<>();

        // Create adapter
        adapter = new SimpleAdapter(
                this,
                ordersList,
                R.layout.order_list_item,
                new String[]{"orderId", "status", "date", "amount"},
                new int[]{R.id.order_id_text, R.id.order_status_text,
                        R.id.order_date_text, R.id.order_amount_text}
        );

        ordersListView.setAdapter(adapter);

        // Initialize Firebase reference
        ordersRef = FirebaseDatabase.getInstance().getReference()
                .child("users")
                .child(currentUser.getUid())
                .child("seed_orders");

        // Load orders
        loadOrders();

        // Set click listener for order details
        ordersListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String orderId = ordersList.get(position).get("orderId").split(": ")[1];
                Intent intent = new Intent(MySeedOrdersActivity.this, SeedOrderDetailsActivity.class);
                intent.putExtra("order_id", orderId);
                startActivity(intent);
            }
        });

        // Back button
        findViewById(R.id.back_button).setOnClickListener(v -> finish());
    }

    private void loadOrders() {
        ordersRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                ordersList.clear();
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault());

                for (DataSnapshot orderSnapshot : dataSnapshot.getChildren()) {
                    try {
                        SeedOrder order = orderSnapshot.getValue(SeedOrder.class);
                        if (order != null) {
                            Map<String, String> orderMap = new HashMap<>();
                            orderMap.put("orderId", "Order ID: " + order.getOrderId());
                            orderMap.put("status", "Status: " + order.getStatus());  // Changed to use actual status
                            orderMap.put("date", "Ordered on: " + dateFormat.format(new Date(order.getTimestamp())));
                            orderMap.put("amount", "Total Amount: ₹" + String.format("%.2f", order.getTotalAmount()));
                            ordersList.add(orderMap);
                        }
                    } catch (Exception e) {
                        Log.e("MySeedOrdersActivity", "Error parsing order: " + e.getMessage());
                    }
                }

                // Update UI based on whether orders exist
                TextView emptyView = findViewById(R.id.empty_view);
                if (ordersList.isEmpty()) {
                    ordersListView.setVisibility(View.GONE);
                    emptyView.setVisibility(View.VISIBLE);
                } else {
                    ordersListView.setVisibility(View.VISIBLE);
                    emptyView.setVisibility(View.GONE);
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(MySeedOrdersActivity.this,
                        "Error loading orders", Toast.LENGTH_SHORT).show();
            }
        });
    }
}