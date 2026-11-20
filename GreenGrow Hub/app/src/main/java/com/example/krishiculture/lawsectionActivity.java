package com.example.krishiculture;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.krishiculture.seedsection.seedDetailsActivity;

public class lawsectionActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lawsection);

        // Arrays for laws names and details IDs
        int[] lawTextIds = {
                R.id.lawsText1, R.id.lawsText2, R.id.lawsText3,
                R.id.lawsText4, R.id.lawsText5, R.id.lawsText6,
                R.id.lawsText7, R.id.lawsText8, R.id.lawsText9
        };
        int[] lawDetailIds = {
                R.id.lawsDetails1, R.id.lawsDetails2, R.id.lawsDetails3,
                R.id.lawsDetails4, R.id.lawsDetails5, R.id.lawsDetails6,
                R.id.lawsDetails7, R.id.lawsDetails8, R.id.lawsDetails9
        };
        // Loop through each pair of TextView IDs
        for (int i = 0; i < lawTextIds.length; i++) {
            TextView lawText = findViewById(lawTextIds[i]);
            TextView lawDetail = findViewById(lawDetailIds[i]);

            // Set click listener to toggle visibility
            lawText.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    toggleVisibility(lawDetail);
                }
            });
        }
    }
    private void toggleVisibility(TextView textView) {
        if (textView.getVisibility() == View.GONE) {
            textView.setVisibility(View.VISIBLE); // Show details
        } else {
            textView.setVisibility(View.GONE); // Hide details
        }
    }

    ImageView imageView;
    public void backFrmLaws ( View view){
        imageView = findViewById(R.id.backFromlaws);
        startActivity(new Intent(lawsectionActivity.this, MainActivity.class));
        Toast.makeText(this, "Back to main Page...!!", Toast.LENGTH_SHORT).show();
        finish();
    }
}
