package com.example.krishiculture.seedsection;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.example.krishiculture.R;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class SeedOrderAdapter extends ArrayAdapter<SeedOrder> {
    private final Context context;
    private final List<SeedOrder> orders;
    private final SimpleDateFormat dateFormat;

    public SeedOrderAdapter(Context context, List<SeedOrder> orders) {
        super(context, R.layout.order_list_item, orders);
        this.context = context;
        this.orders = orders;
        this.dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault());
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context)
                .inflate(R.layout.order_list_item, parent, false);
        }

        SeedOrder order = orders.get(position);

        TextView orderIdText = convertView.findViewById(R.id.order_id_text);
        TextView statusText = convertView.findViewById(R.id.order_status_text);
        TextView dateText = convertView.findViewById(R.id.order_date_text);
        TextView amountText = convertView.findViewById(R.id.order_amount_text);

        // Format and set the texts
        orderIdText.setText("Order ID: " + order.getOrderId());
        statusText.setText("Status: " + order.getStatus());
        dateText.setText("Date: " + dateFormat.format(new Date(order.getTimestamp())));
        amountText.setText(String.format("Amount: ₹%.2f", order.getTotalAmount()));

        // Set background color based on status
        int statusColor;
        switch (order.getStatus().toLowerCase()) {
            case "completed":
                statusColor = 0xFF4CAF50; // Green
                break;
            case "pending":
                statusColor = 0xFFFFA000; // Orange
                break;
            case "cancelled":
                statusColor = 0xFFE53935; // Red
                break;
            default:
                statusColor = 0xFF757575; // Grey
        }
        statusText.setTextColor(statusColor);

        return convertView;
    }
} 