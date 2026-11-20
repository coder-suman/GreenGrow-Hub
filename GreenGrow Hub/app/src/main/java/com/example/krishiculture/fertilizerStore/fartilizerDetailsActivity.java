package com.example.krishiculture.fertilizerStore;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;
import java.util.ArrayList;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.krishiculture.R;

public class fartilizerDetailsActivity extends AppCompatActivity {

    // Add this static list to store cart items
    public static ArrayList<CartItem> cartItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_fartilizer_details);

        // Get references to UI elements
        ImageView fertilizerImage = findViewById(R.id.fertilizer_image);
        TextView fertilizerName = findViewById(R.id.fertilizer_name);
        TextView fertilizerDetails = findViewById(R.id.fertilizer_details);
        ImageView backArrow = findViewById(R.id.backArrow);  // Initialize backArrow ImageView
        Button addToCartButton = findViewById(R.id.add_to_cart_button);

        // Set up the back button click listener
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start CartActivity when backArrow is clicked
                startActivity(new Intent(fartilizerDetailsActivity.this, cartActivity.class));
                finish();  // Finish current activity (optional, if you want to remove this activity from the back stack)
            }
        });

        // Get data from Intent
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String name = extras.getString("fertilizer_name");
            int image = extras.getInt("fertilizer_image");
            String details = extras.getString("fertilizer_details");

            // Set data to UI
            fertilizerImage.setImageResource(image);
            fertilizerName.setText(name);
            fertilizerDetails.setText(details);

            // Add to cart button click listener
            final String finalName = name;
            final int finalImage = image;
            addToCartButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Check if item already exists in cart
                    boolean itemExists = false;
                    for (CartItem item : cartItems) {
                        if (item.getName().equals(finalName)) {
                            item.setQuantity(item.getQuantity() + 1);
                            itemExists = true;
                            break;
                        }
                    }
                    // If item doesn't exist, add new item
                    if (!itemExists) {
                        cartItems.add(new CartItem(finalName, finalImage, 500.0)); // Default price 500
                    }

                    Toast.makeText(fartilizerDetailsActivity.this, 
                        "Added to cart", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}