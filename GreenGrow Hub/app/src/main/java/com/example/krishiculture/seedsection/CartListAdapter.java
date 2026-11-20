package com.example.krishiculture.seedsection;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ImageButton;
import android.widget.Toast;
import com.example.krishiculture.R;
import java.util.ArrayList;

public class CartListAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<CartItem> cartItems;
    private SeedCartActivity activity;

    public CartListAdapter(Context context, ArrayList<CartItem> cartItems) {
        this.context = context;
        this.cartItems = cartItems;
        this.activity = (SeedCartActivity) context;
    }

    @Override
    public int getCount() {
        return cartItems.size();
    }

    @Override
    public Object getItem(int position) {
        return cartItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.cart_list_item, parent, false);
        }

        CartItem item = cartItems.get(position);

        ImageView imageView = convertView.findViewById(R.id.cart_item_image);
        TextView nameText = convertView.findViewById(R.id.cart_item_name);
        TextView priceText = convertView.findViewById(R.id.cart_item_price);
        TextView quantityText = convertView.findViewById(R.id.cart_item_quantity);
        TextView decreaseBtn = convertView.findViewById(R.id.decrease_quantity_btn);
        TextView increaseBtn = convertView.findViewById(R.id.increase_quantity_btn);
        ImageButton deleteButton = convertView.findViewById(R.id.delete_item_button);

        imageView.setImageResource(item.getImageResource());
        nameText.setText(item.getName());
        priceText.setText(String.format("₹%.2f", item.getPrice()));
        quantityText.setText(String.valueOf(item.getQuantity()));

        decreaseBtn.setOnClickListener(v -> {
            if (item.getQuantity() > 1) {
                item.setQuantity(item.getQuantity() - 1);
                notifyDataSetChanged();
                activity.updateTotalAmount();
            }
        });

        increaseBtn.setOnClickListener(v -> {
            item.setQuantity(item.getQuantity() + 1);
            notifyDataSetChanged();
            activity.updateTotalAmount();
        });

        deleteButton.setOnClickListener(v -> {
            cartItems.remove(position);
            notifyDataSetChanged();
            activity.updateTotalAmount();
            Toast.makeText(context, "Item removed from cart", Toast.LENGTH_SHORT).show();
        });

        return convertView;
    }
} 