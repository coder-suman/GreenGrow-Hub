package com.example.krishiculture.fertilizerStore;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
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
import java.util.ArrayList;
import java.util.List;

public class OrderDetailsActivity extends AppCompatActivity {
    private TextView orderIdText;
    private TextView orderStatusText;
    private TextView deliveryAddressText;
    private TextView totalAmountText;
    private TextView orderItemsCountText;
    private ListView orderedItemsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);

        // Initialize views
        orderIdText = findViewById(R.id.order_id);
        orderStatusText = findViewById(R.id.order_status);
        deliveryAddressText = findViewById(R.id.delivery_address);
        totalAmountText = findViewById(R.id.total_amount);
        orderItemsCountText = findViewById(R.id.order_items_count);
        orderedItemsList = findViewById(R.id.ordered_items_list);

        // Get order ID from intent
        String orderId = getIntent().getStringExtra("order_id");
        if (orderId != null) {
            loadOrderDetails(orderId);
        }
    }

    private void loadOrderDetails(String orderId) {
        String userId = FirebaseAuth.getInstance().getCurrentUser().getUid();
        DatabaseReference orderRef = FirebaseDatabase.getInstance()
            .getReference()
            .child("users")
            .child(userId)
            .child("orders")
            .child(orderId);

        orderRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Order order = dataSnapshot.getValue(Order.class);
                if (order != null) {
                    orderIdText.setText("Order ID: " + order.getOrderId());
                    orderStatusText.setText("Status: " + order.getOrderStatus());
                    deliveryAddressText.setText(order.getDeliveryAddress());
                    totalAmountText.setText("Total Amount: ₹" + order.getTotalAmount());

                    // Add number of items
                    List<CartItem> items = order.getItems();
                    if (items != null) {
                        orderItemsCountText.setText("Number of Items: " + items.size());
                        OrderItemsAdapter adapter = new OrderItemsAdapter(
                            OrderDetailsActivity.this, 
                            items
                        );
                        orderedItemsList.setAdapter(adapter);
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(OrderDetailsActivity.this, 
                    "Error loading order details", Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Custom adapter for order items
    private class OrderItemsAdapter extends ArrayAdapter<CartItem> {
        private final Context context;
        private final List<CartItem> items;

        public OrderItemsAdapter(Context context, List<CartItem> items) {
            super(context, R.layout.order_item_detail_layout, items);
            this.context = context;
            this.items = items;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = LayoutInflater.from(context)
                    .inflate(R.layout.order_item_detail_layout, parent, false);
            }

            CartItem item = items.get(position);

            ImageView imageView = convertView.findViewById(R.id.item_image);
            TextView nameText = convertView.findViewById(R.id.item_name);
            TextView quantityText = convertView.findViewById(R.id.item_quantity);
            TextView priceText = convertView.findViewById(R.id.item_price);

            imageView.setImageResource(item.getImage());
            nameText.setText(item.getName());
            quantityText.setText("x" + item.getQuantity());
            priceText.setText("₹" + item.getTotalPrice());

            return convertView;
        }
    }
} 