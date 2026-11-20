package com.example.krishiculture.CropProtection;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.krishiculture.R;

public class cropProtectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_crop_protection);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void cropRecommend_page(View view){
        Intent cropprotect=new Intent(cropProtectionActivity.this, cropRecommendationActivity.class);
        startActivity(cropprotect);
        Toast.makeText(this, "Crop Recommendation Page Opening.", Toast.LENGTH_SHORT).show();
    }
    public void fertilizerRecommend_page(View view){
        Intent cropprotect=new Intent(cropProtectionActivity.this, fertilizerRecommendationActivity.class);
        startActivity(cropprotect);
        Toast.makeText(this, "Fertilizer Recommendation Page Opening.", Toast.LENGTH_SHORT).show();
    }
    public void waterPump_page(View view){
        Intent waterpump=new Intent(cropProtectionActivity.this, waterPumpActivity.class);
        startActivity(waterpump);
        Toast.makeText(this, "Water Pump Page Opening.", Toast.LENGTH_SHORT).show();
    }
}