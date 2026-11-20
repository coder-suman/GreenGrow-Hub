package com.example.krishiculture.fertilizerStore;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.krishiculture.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class MyOrdersActivity extends AppCompatActivity {
    private ListView ordersListView;
    private DatabaseReference ordersRef;
    private List<Map<String, String>> ordersList;
    private SimpleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_orders);

        ordersListView = findViewById(R.id.orders_list_view);
        ordersList = new ArrayList<>();

        String userId = FirebaseAuth.getInstance().getCurrentUser().getUid();
        ordersRef = FirebaseDatabase.getInstance()
            .getReference()
            .child("users")
            .child(userId)
            .child("orders");

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

        // Load orders
        loadOrders();

        // Set click listener
        ordersListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String orderId = ordersList.get(position).get("orderId").split(": ")[1];
                Intent intent = new Intent(MyOrdersActivity.this, OrderDetailsActivity.class);
                intent.putExtra("order_id", orderId);
                startActivity(intent);
            }
        });
    }

    private void loadOrders() {
        ordersRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                ordersList.clear();
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault());

                for (DataSnapshot orderSnapshot : dataSnapshot.getChildren()) {
                    Order order = orderSnapshot.getValue(Order.class);
                    if (order != null) {
                        Map<String, String> orderMap = new HashMap<>();
                        orderMap.put("orderId", "Order ID: " + order.getOrderId());
                        orderMap.put("status", "Status: " + order.getOrderStatus());
                        orderMap.put("date", "Ordered on: " + 
                            dateFormat.format(new Date(order.getOrderTime())));
                        orderMap.put("amount", "Total Amount: ₹" + order.getTotalAmount());
                        ordersList.add(orderMap);
                    }
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(MyOrdersActivity.this, 
                    "Error loading orders", Toast.LENGTH_SHORT).show();
            }
        });
    }
} 