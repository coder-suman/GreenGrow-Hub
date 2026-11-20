package com.example.krishiculture;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.krishiculture.CropProtection.cropProtectionActivity;
import com.example.krishiculture.ausFragment.AusPage;
import com.example.krishiculture.feedback.feedbackpageActivity;
import com.example.krishiculture.fertilizerStore.cartActivity;
import com.example.krishiculture.seedsection.seedDetailsActivity;
import com.example.krishiculture.weatherForecust.weatherActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    Animation rotateOpen,rotateClose,fromBottom,toBottom;
    Boolean Clicked=false;
    FloatingActionButton feedback_button,Add_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Find views
        LinearLayout linearLayout = findViewById(R.id.linearLayoutanim);
        ImageView imageView2 = findViewById(R.id.imageViewanim1);
        ImageView imageView3 = findViewById(R.id.imageViewanim2);
        feedback_button =findViewById(R.id.feedback_button);
        Add_button=findViewById(R.id.add_Button);

        // Load slide-in animation
        Animation slideInImageView2 = AnimationUtils.loadAnimation(this, R.anim.slide_in_left);
        Animation slideInImageView3 = AnimationUtils.loadAnimation(this, R.anim.slide_in_left);

        //load feedback Animation
        rotateOpen = AnimationUtils.loadAnimation(this, R.anim.rotate_open_anim);
        rotateClose = AnimationUtils.loadAnimation(this, R.anim.rotate_close_anim);
        fromBottom = AnimationUtils.loadAnimation(this, R.anim.from_bottom_anim);
        toBottom = AnimationUtils.loadAnimation(this, R.anim.to_bottom_anim);

        // Start animation for imageView2
        slideInImageView2.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                // Make imageView2 visible
                imageView2.setVisibility(ImageView.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                // Start animation for imageView3
                imageView3.startAnimation(slideInImageView3);
            }

            @Override
            public void onAnimationRepeat(Animation animation) { }
        });

        slideInImageView3.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                // Make imageView3 visible
                imageView3.setVisibility(ImageView.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animation animation) { }

            @Override
            public void onAnimationRepeat(Animation animation) { }
        });

        // Start the first animation
        imageView2.startAnimation(slideInImageView2);
    }

    @Override
    public void onBackPressed() {
        // Exit the app when the back button is pressed
        finishAffinity(); // This closes all activities and exits the app
        System.exit(0); // Ensures the app process is terminated
    }

    public void aus_page ( View v ){
//        ImageView ausPaddy = findViewById(R.id.ausPaddy);
        Intent ausPage = new Intent(this, AusPage.class);
        startActivity(ausPage);
        Toast.makeText(this, "Aus Page Opening.", Toast.LENGTH_SHORT).show();
    }

    public void amon_page ( View v ){
//        ImageView amonPaddy = findViewById(R.id.amonPaddy);
        Intent amonPage = new Intent(this, com.example.krishiculture.amonFragment.amonPage.class);
        startActivity(amonPage);

        Toast.makeText(this, "Amon Page Opening.", Toast.LENGTH_SHORT).show();
    }

    public void boro_page ( View v ){
//        ImageView boroPaddy = findViewById(R.id.boroPaddy);
        Intent boroPage = new Intent(this, com.example.krishiculture.boroFragment.boroPage.class);
        startActivity(boroPage);
        Toast.makeText(this, "Boro Page Opening.", Toast.LENGTH_SHORT).show();
    }

    public void fartilizer_page ( View v ){
        Intent fertilizerPage = new Intent(this, cartActivity.class);
        startActivity(fertilizerPage);
        Toast.makeText(this, "fertilizer Page Opening.", Toast.LENGTH_SHORT).show();
    }

    public void seedSection_page ( View v ){
        Intent seedSectionpage = new Intent(this, seedDetailsActivity.class);
        startActivity(seedSectionpage);
        Toast.makeText(this, "Seed Page Opening.", Toast.LENGTH_SHORT).show();
    }



    // Tools Section
    public void weather_page(View view){
        Intent weather=new Intent(MainActivity.this, weatherActivity.class);
        startActivity(weather);
        Toast.makeText(this, "Weather Page Opening.", Toast.LENGTH_SHORT).show();
    }

    public void cropcare_page(View view){
        Intent cropcare=new Intent(MainActivity.this, cropcareActivity.class);
        startActivity(cropcare);
        Toast.makeText(this, "Crop_care Page Opening.", Toast.LENGTH_SHORT).show();
    }

    public void lawsection_page(View view){
        Intent law=new Intent(MainActivity.this, lawsectionActivity.class);
        startActivity(law);
        Toast.makeText(this, "Law section Page Opening.", Toast.LENGTH_SHORT).show();
    }
    public void cropProtection_page(View view){
        Intent cropprotect=new Intent(MainActivity.this, cropProtectionActivity.class);
        startActivity(cropprotect);
        Toast.makeText(this, "Crop Protection Page Opening.", Toast.LENGTH_SHORT).show();
    }

    //feedback section
    public void click_addButton(View view){
        setvisibility(Clicked);
        setAnimation(Clicked);
        Clicked=!Clicked;

    }
    public void setvisibility(Boolean clicked){
        if(!clicked){
            feedback_button.setVisibility(View.VISIBLE);
        }else{
            feedback_button.setVisibility(View.INVISIBLE);
        }

    }
    public void setAnimation(Boolean clicked){
        if(!clicked){
            feedback_button.startAnimation(fromBottom);
            Add_button.startAnimation(rotateOpen);
        }else{
            feedback_button.startAnimation(toBottom);
            Add_button.startAnimation(rotateClose);
        }

    }
    public void Feedback_page(View view){
        Intent feedback=new Intent(MainActivity.this, feedbackpageActivity.class);
        startActivity(feedback);
        Toast.makeText(this, "Feedback Page Opening.", Toast.LENGTH_SHORT).show();
    }

}