package com.example.krishiculture.seedsection;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.example.krishiculture.R;
import java.util.List;

public class SeedOrderItemAdapter extends ArrayAdapter<CartItem> {
    private final Context context;
    private final List<CartItem> items;

    public SeedOrderItemAdapter(Context context, List<CartItem> items) {
        super(context, R.layout.seed_order_item, items);
        this.context = context;
        this.items = items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.seed_order_item, parent, false);
        }

        CartItem item = items.get(position);

        TextView nameText = convertView.findViewById(R.id.item_name);
        TextView quantityText = convertView.findViewById(R.id.item_quantity);
        TextView priceText = convertView.findViewById(R.id.item_price);

        nameText.setText(item.getName());
        quantityText.setText("Quantity: " + item.getQuantity());
        priceText.setText(String.format("₹%.2f", item.getTotalPrice()));

        return convertView;
    }
} 