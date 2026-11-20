package com.example.krishiculture.fertilizerStore;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.krishiculture.MainActivity;
import com.example.krishiculture.R;
import com.example.krishiculture.databinding.ActivityCartBinding;

public class cartActivity extends AppCompatActivity {

    private ActivityCartBinding binding;

    // Fertilizer data
    String[] fertilizerName = {
            "Ammonium Nitrate", "Ammonium Sulfate", "Bone Meal",
            "Chemical NPK Fertilizer", "Di ammonium Phosphate",
            "Green Gold Calcium Ammonium Nitrate", "Gypsum", "Iron Chelate",
            "Magnesium Sulphate", "Manure Organic", "Mono Ammonium Phosphate",
            "Muriate Of Potash", "Organic Compost", "Potassium Nitrate KNO3",
            "Sansar Agro NPK", "Single Super Phosphate", "Sulfate Of Potash",
            "Super Phosphate", "Triple Super phosphate", "Urea", "Zinc Sulfate"
    };

    int[] fertilizerImage = {
            R.drawable.ammonium_nitrate, R.drawable.ammonium_sulfate, R.drawable.bone_meal,
            R.drawable.chemical_npk_fertilizer, R.drawable.diammonium_phosphate, R.drawable.green_gold_calcium_ammonium_nitrate,
            R.drawable.gypsum, R.drawable.iron_chelate, R.drawable.magnesium_sulphate, R.drawable.manure_organic,
            R.drawable.mono_ammonium_phosphate, R.drawable.muriate_of_potash, R.drawable.organic_compost,
            R.drawable.potassium_nitrate_kno3, R.drawable.sansar_agro_npk, R.drawable.single_super_phosphate,
            R.drawable.sulfate_of_potash, R.drawable.super_phosphate, R.drawable.triple_superphosphate,
            R.drawable.urea, R.drawable.zinc_sulfate
    };

    // Fetch fertilizer descriptions from the strings resource
    String[] fertilizerDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cart);
        binding = ActivityCartBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Initialize the fertilizer descriptions by fetching from strings.xml
        fertilizerDetails = getResources().getStringArray(R.array.fertilizer_descriptions);

        gridAdapter gridAdapter = new gridAdapter(cartActivity.this, fertilizerName, fertilizerImage);
        binding.gridView.setAdapter(gridAdapter);

        binding.gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(cartActivity.this, "You Clicked on " + fertilizerName[position], Toast.LENGTH_SHORT).show();

                // Create an Intent to open FertilizerDetailsActivity
                Intent intent = new Intent(cartActivity.this, fartilizerDetailsActivity.class);

                // Pass fertilizer data to the intent
                intent.putExtra("fertilizer_name", fertilizerName[position]);
                intent.putExtra("fertilizer_image", fertilizerImage[position]);
                intent.putExtra("fertilizer_details", fertilizerDetails[position]);

                // Start the activity
                startActivity(intent);
            }
        });

        // Add cart icon click listener
        ImageView cartIcon = findViewById(R.id.cart_icon);
        cartIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open cart list activity
                Intent intent = new Intent(cartActivity.this, CartListActivity.class);
                startActivity(intent);
            }
        });
    }

    public void gotomain(View view){
        startActivity(new Intent(cartActivity.this, MainActivity.class));
        finish();  // Finish current activity (optional, if you want to remove this activity from the back stack)

    }
}