package com.example.krishiculture.seedsection;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.krishiculture.R;

public class seedGridAdapter extends BaseAdapter {
    private Context context;
    private String[] seedNames;
    private String[] seedPrices;
    private int[] seedImages;

    LayoutInflater inflater;

    public seedGridAdapter(Context context, String[] seedNames, String[] seedPrices, int[] seedImages) {
        this.context = context;
        this.seedNames = seedNames;
        this.seedPrices = seedPrices;
        this.seedImages = seedImages;
    }

    @Override
    public int getCount() {
        return seedNames.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //end code here
        if (convertView == null) {
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        if ( convertView == null){
            convertView = inflater.inflate(R.layout.seedgrid_item,null);
        }

        // Get references to the views
        ImageView seedImage = convertView.findViewById(R.id.seed_image);
        TextView seedName = convertView.findViewById(R.id.seed_name);
        TextView seedPrice = convertView.findViewById(R.id.seed_price);

        // Set the data for each item
        seedImage.setImageResource(seedImages[position]);
        seedName.setText(seedNames[position]);
        seedPrice.setText(seedPrices[position]);

        return convertView;
    }
}
