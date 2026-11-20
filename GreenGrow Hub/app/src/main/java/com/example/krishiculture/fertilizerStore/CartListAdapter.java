package com.example.krishiculture.fertilizerStore;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import com.example.krishiculture.R;

public class CartListAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<CartItem> cartItems;
    private CartListActivity activity;

    public CartListAdapter(Context context, ArrayList<CartItem> cartItems) {
        this.context = context;
        this.cartItems = cartItems;
        this.activity = (CartListActivity) context;
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

        ImageView itemImage = convertView.findViewById(R.id.cart_item_image);
        TextView itemName = convertView.findViewById(R.id.cart_item_name);
        TextView itemPrice = convertView.findViewById(R.id.cart_item_price);
        TextView itemQuantity = convertView.findViewById(R.id.cart_item_quantity);
        TextView increaseBtn = convertView.findViewById(R.id.increase_quantity_btn);
        TextView decreaseBtn = convertView.findViewById(R.id.decrease_quantity_btn);

        itemImage.setImageResource(item.getImage());
        itemName.setText(item.getName());
        itemPrice.setText("₹" + String.format("%.2f", item.getTotalPrice()));
        itemQuantity.setText(String.valueOf(item.getQuantity()));

        increaseBtn.setOnClickListener(v -> {
            item.setQuantity(item.getQuantity() + 1);
            notifyDataSetChanged();
            activity.updateTotalPrice();
        });

        decreaseBtn.setOnClickListener(v -> {
            if (item.getQuantity() > 1) {
                item.setQuantity(item.getQuantity() - 1);
                notifyDataSetChanged();
                activity.updateTotalPrice();
            }
        });

        return convertView;
    }
} 