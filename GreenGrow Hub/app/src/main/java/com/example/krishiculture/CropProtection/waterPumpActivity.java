package com.example.krishiculture.CropProtection;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.krishiculture.R;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class waterPumpActivity extends AppCompatActivity {

    private ToggleButton pumpToggle;
    private ProgressBar pumpIndicator, waterLevelProgress;
    private TextView percentageText;

    private DatabaseReference pumpRef, moistureRef;
    private FirebaseAuth auth;
    private FirebaseUser currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_pump);

        // UI initialization
        pumpToggle = findViewById(R.id.pumpToggle);
        pumpIndicator = findViewById(R.id.pumpIndicator);
        waterLevelProgress = findViewById(R.id.waterLevelProgress);
        percentageText = findViewById(R.id.percentageText);

        // Firebase initialization
        FirebaseApp.initializeApp(this);
        auth = FirebaseAuth.getInstance();
        currentUser = auth.getCurrentUser();

        if (currentUser == null) {
            Toast.makeText(this, "User not logged in", Toast.LENGTH_LONG).show();
            finish();
            return;
        }

        String uid = currentUser.getUid();
        FirebaseDatabase database = FirebaseDatabase.getInstance();

        // Per-user database paths
        pumpRef = database.getReference("users").child(uid).child("pumpControl");
        moistureRef = database.getReference("users").child(uid).child("SoilMoisture");

        // Read pump state and update toggle
        pumpRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Boolean pumpState = snapshot.getValue(Boolean.class);
                if (pumpState != null) {
                    pumpToggle.setChecked(pumpState);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(waterPumpActivity.this, "Failed to load pump state", Toast.LENGTH_SHORT).show();
            }
        });

        // Update pump state on toggle
        pumpToggle.setOnCheckedChangeListener((buttonView, isChecked) -> {
            pumpIndicator.setVisibility(View.VISIBLE);
            pumpRef.setValue(isChecked).addOnCompleteListener(task -> {
                pumpIndicator.setVisibility(View.INVISIBLE);
                if (task.isSuccessful()) {
                    Toast.makeText(waterPumpActivity.this, "Pump " + (isChecked ? "Started" : "Stopped"), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(waterPumpActivity.this, "Failed to update pump", Toast.LENGTH_SHORT).show();
                }
            });
        });

        // Read real-time soil moisture
        int dryValue =4090;
        int wetValue=2004;

        moistureRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Integer moistureValue = snapshot.getValue(Integer.class);
                if (moistureValue != null) {
                    // Calculate moisture percentage
                    int percentage = (moistureValue - dryValue) * 100 / (wetValue - dryValue);
//                    percentage = 100 - percentage; // Invert because lower value means wetter
                    percentage = Math.max(0, Math.min(100, percentage)); // Clamp to 0–100

                    waterLevelProgress.setProgress(percentage);
                    percentageText.setText(percentage + "%");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(waterPumpActivity.this, "Failed to read soil moisture", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
