package com.example.krishiculture.userlogin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.krishiculture.MainActivity;
import com.example.krishiculture.R;
import com.google.firebase.auth.FirebaseAuth;

public class userdetailsActivity extends AppCompatActivity {

    //ProgressBar
    ProgressBar progressBar;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_userdetails);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        auth = FirebaseAuth.getInstance();

        progressBar = findViewById(R.id.progressbar);
        progressBar.setVisibility(View.GONE);


        //if already have authorized
        if ( auth.getCurrentUser() != null){
            progressBar.setVisibility(View.VISIBLE);
            Toast.makeText(this, "Please wait you are already logged in", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(userdetailsActivity.this, MainActivity.class));
        }

    }

    public void login(View view) {

        startActivity(new Intent(userdetailsActivity.this, loginActivity.class));
    }

    public void registration(View view) {
        startActivity(new Intent(userdetailsActivity.this, registrationActivity.class));
    }
}