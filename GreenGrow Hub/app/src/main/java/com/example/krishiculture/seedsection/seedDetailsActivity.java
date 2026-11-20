package com.example.krishiculture.seedsection;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.krishiculture.MainActivity;
import com.example.krishiculture.R;

import java.util.ArrayList;

public class seedDetailsActivity extends AppCompatActivity {
    // Seed data
    String[] seedNames = {
            "Aus Paddy", "Boro Paddy", "IR-36", "Golden Rice", "Jasmine Rice",
            "Hybrid Paddy", "IR-64", "Swarna", "Red Rice", "Sticky Rice",
            "Basmati", "Sharbati"
    };

    String[] seedPrices = {
            "Price: 200/kg", "Price: 250/kg", "Price: 180/kg", "Price: 300/kg", "Price: 350/kg",
            "Price: 400/kg", "Price: 220/kg", "Price: 150/kg", "Price: 270/kg", "Price: 320/kg",
            "Price: 280/kg", "Price: 230/kg"
    };


    int[] seedImages = {
            R.drawable.aus_paddy, R.drawable.boro_paddy, R.drawable.ir_36, R.drawable.golden_rice, R.drawable.jasmine_rice,
            R.drawable.hybrid_paddy, R.drawable.ir_64, R.drawable.swarna_rice, R.drawable.red_rice, R.drawable.sticky_rice,
            R.drawable.basmati, R.drawable.sharbati
    };

    // Add these arrays for seed details
    private String[] seedDescriptions = {
            "Aus Paddy: Early maturing variety, drought tolerant, suitable for direct seeding.",
            "Boro Paddy: Winter season rice, high yielding, requires irrigation.",
            "IR-36: Semi-dwarf variety, disease resistant, good grain quality.",
            "Golden Rice: Biofortified rice, rich in beta-carotene, good for nutrition.",
            "Jasmine Rice: Aromatic variety, long grain, premium quality.",
            "Hybrid Paddy: High yielding variety, better disease resistance.",
            "IR-64: Popular variety, good grain quality, disease resistant.",
            "Swarna: High yielding variety, suitable for low-lying areas.",
            "Red Rice: Nutritious variety, rich in antioxidants.",
            "Sticky Rice: Glutinous variety, used in special dishes.",
            "Basmati: Premium aromatic rice, long grain, excellent quality.",
            "Sharbati: Fine grain variety, good cooking quality."
    };

    // Add Bengali descriptions
    private String[] seedDescriptionsBengali = {
            "আউশ ধান: তাড়াতাড়ি পাকা জাত, খরা সহনশীল, সরাসরি বীজ বপনের জন্য উপযুক্ত।",
            "বোরো ধান: শীতকালীন ধান, অধিক ফলনশীল, সেচের প্রয়োজন।",
            "আইআর-৩৬: আধা-বামন জাত, রোগ প্রতিরোধী, ভালো দানার গুণমান।",
            "গোল্ডেন রাইস: বায়োফোর্টিফাইড চাল, বিটা-ক্যারোটিন সমৃদ্ধ, পুষ্টির জন্য ভালো।",
            "জ্যাসমিন রাইস: সুগন্ধি জাত, লম্বা দানা, প্রিমিয়াম মানের।",
            "হাইব্রিড ধান: অধিক ফলনশীল জাত, ভালো রোগ প্রতিরোধ ক্ষমতা।",
            "আইআর-৬৪: জনপ্রিয় জাত, ভালো দানার গুণমান, রোগ প্রতিরোধী।",
            "স্বর্ণা: অধিক ফলনশীল জাত, নিচু জমির জন্য উপযুক্ত।",
            "লাল চাল: পুষ্টিকর জাত, অ্যান্টিঅক্সিডেন্ট সমৃদ্ধ।",
            "আঠা চাল: আঠালো জাত, বিশেষ খাবারে ব্যবহৃত হয়।",
            "বাসমতি: প্রিমিয়াম সুগন্ধি চাল, লম্বা দানা, উৎকৃষ্ট মানের।",
            "শারবতি: মিহি দানার জাত, ভালো রান্নার গুণমান।"
    };

    // Add these at class level
    private static ArrayList<CartItem> cartItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seed_details);
        EdgeToEdge.enable(this);

        GridView seedGridView = findViewById(R.id.seedGridView);
        
        // Enable hardware acceleration for better scrolling
        seedGridView.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        
        seedGridAdapter adapter = new seedGridAdapter(this, seedNames, seedPrices, seedImages);
        seedGridView.setAdapter(adapter);

        seedGridView.setOnItemClickListener((adapterView, view, position, l) -> {
            showSeedDetailsDialog(position);
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.seed), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ImageView cartIcon = findViewById(R.id.seed_cart_icon);
        cartIcon.setOnClickListener(v -> {
            Intent intent = new Intent(seedDetailsActivity.this, SeedCartActivity.class);
            startActivity(intent);
        });
    }

    private void showSeedDetailsDialog(int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View dialogView = getLayoutInflater().inflate(R.layout.seed_details_dialog, null);

        ImageView seedImage = dialogView.findViewById(R.id.dialog_seed_image);
        TextView seedName = dialogView.findViewById(R.id.dialog_seed_name);
        TextView seedPrice = dialogView.findViewById(R.id.dialog_seed_price);
        TextView seedDescription = dialogView.findViewById(R.id.dialog_seed_description);
        TextView seedDescriptionBengali = dialogView.findViewById(R.id.dialog_seed_description_bengali);
        EditText quantityInput = dialogView.findViewById(R.id.quantity_input);
        Button addToCartButton = dialogView.findViewById(R.id.add_to_cart_button);

        seedImage.setImageResource(seedImages[position]);
        seedName.setText(seedNames[position]);
        seedPrice.setText(seedPrices[position]);
        seedDescription.setText(seedDescriptions[position]);
        seedDescriptionBengali.setText(seedDescriptionsBengali[position]);

        AlertDialog dialog = builder.setView(dialogView).create();

        addToCartButton.setOnClickListener(v -> {
            String quantityStr = quantityInput.getText().toString();
            if (!quantityStr.isEmpty()) {
                int quantity = Integer.parseInt(quantityStr);
                if (quantity > 0) {
                    CartItem newItem = new CartItem(
                        seedNames[position],
                        seedImages[position],
                        getPriceValue(seedPrices[position]),
                        quantity
                    );
                    addToCart(newItem);
                    Toast.makeText(this, "Added to cart!", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                } else {
                    Toast.makeText(this, "Please enter a valid quantity", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "Please enter quantity", Toast.LENGTH_SHORT).show();
            }
        });

        dialog.show();
    }

    private void addToCart(CartItem newItem) {
        boolean itemExists = false;
        for (CartItem item : cartItems) {
            if (item.getName().equals(newItem.getName())) {
                item.setQuantity(item.getQuantity() + newItem.getQuantity());
                itemExists = true;
                break;
            }
        }
        if (!itemExists) {
            cartItems.add(newItem);
        }
    }

    private double getPriceValue(String priceStr) {
        // Extract numeric value from price string (e.g., "Price: 200/kg" -> 200.0)
        return Double.parseDouble(priceStr.replaceAll("[^0-9]", ""));
    }

    ImageView imageView;
    public void backFrmSeedsCart ( View view){
        imageView = findViewById(R.id.backFrmSeedsCart);
        startActivity(new Intent(seedDetailsActivity.this, MainActivity.class));
        Toast.makeText(this, "Back to main Page...!!", Toast.LENGTH_SHORT).show();
        finish();
    }

    // Add this method to access cart items from other activities
    public static ArrayList<CartItem> getCartItems() {
        return cartItems;
    }

    // Add this method to clear the cart
    public static void clearCart() {
        cartItems.clear();
    }
}