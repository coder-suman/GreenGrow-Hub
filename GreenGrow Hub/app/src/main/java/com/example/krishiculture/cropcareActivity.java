package com.example.krishiculture;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.krishiculture.cropcare.cropcarePage;


public class cropcareActivity extends AppCompatActivity {

    private final String[] cropNames = {
            "Tomato", "Ladyfinger", "Cabbage", "Cauliflower",
            "Brinjal", "Beans", "Green Chili", "Onion",
            "Potato", "Pumpkin", "Papaya", "Cucumber",
            "Beet", "Carrot", "Lemon", "Coriander",
            "Ginger", "Tumeric", "Garlic", "Bitter Gourd",
            "Radish", "Bottle Gourd", "Sweet Potato", "Ridge Gourd"
    };

    int[] cropImages={
            R.drawable.tomato,R.drawable.ledisfinger,R.drawable.cabage,R.drawable.cauliflower,
            R.drawable.brinjal,R.drawable.beans,R.drawable.chili,R.drawable.onion,
            R.drawable.potato,R.drawable.pumkin,R.drawable.papaya,R.drawable.cucumber,
            R.drawable.beet,R.drawable.carrot,R.drawable.lemon,R.drawable.dhania,
            R.drawable.ginger,R.drawable.haldi,R.drawable.rasun,R.drawable.karola,
            R.drawable.mula,R.drawable.potol,R.drawable.sweetpotato,R.drawable.jhinga
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cropcare);

        // Set padding to handle insets for edge-to-edge display
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.cropcarepage), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void tomato_page(View view){
        Intent tomatopage=new Intent(cropcareActivity.this, cropcarePage.class);
        tomatopage.putExtra("crop_name",cropNames[0]);
        tomatopage.putExtra("crop_Image",cropImages[0]);
        startActivity(tomatopage);
        Toast.makeText(this, "Tomato Page Opening.", Toast.LENGTH_SHORT).show();
    }

    public void ladisfinger_page(View view){
        Intent ladisfingerpage=new Intent(cropcareActivity.this, cropcarePage.class);
        ladisfingerpage.putExtra("crop_name",cropNames[1]);
        ladisfingerpage.putExtra("crop_Image",cropImages[1]);
        startActivity(ladisfingerpage);
//        Toast.makeText(this, "Tomato Page Opening.", Toast.LENGTH_SHORT).show();
    }
    public void cabbage_page(View view){
        Intent cabbagepage=new Intent(cropcareActivity.this, cropcarePage.class);
        cabbagepage.putExtra("crop_name",cropNames[2]);
        cabbagepage.putExtra("crop_Image",cropImages[2]);
        startActivity(cabbagepage);
//        Toast.makeText(this, "Tomato Page Opening.", Toast.LENGTH_SHORT).show();
    }
    public void coliflower_page(View view){
        Intent coliflowerpage=new Intent(cropcareActivity.this, cropcarePage.class);
        coliflowerpage.putExtra("crop_name",cropNames[3]);
        coliflowerpage.putExtra("crop_Image",cropImages[3]);
        startActivity(coliflowerpage);
//        Toast.makeText(this, "Tomato Page Opening.", Toast.LENGTH_SHORT).show();
    }

    public void brinjal_page(View view){
        Intent brinjalpage=new Intent(cropcareActivity.this, cropcarePage.class);
        brinjalpage.putExtra("crop_name",cropNames[4]);
        brinjalpage.putExtra("crop_Image",cropImages[4]);
        startActivity(brinjalpage);

    }
    public void beans_page(View view){
        Intent beanspage=new Intent(cropcareActivity.this, cropcarePage.class);
        beanspage.putExtra("crop_name",cropNames[5]);
        beanspage.putExtra("crop_Image",cropImages[5]);
        startActivity(beanspage);

    }
    public void chili_page(View view){
        Intent chilipage=new Intent(cropcareActivity.this, cropcarePage.class);
        chilipage.putExtra("crop_name",cropNames[6]);
        chilipage.putExtra("crop_Image",cropImages[6]);
        startActivity(chilipage);

    }
    public void onion_page(View view){
        Intent onionpage=new Intent(cropcareActivity.this, cropcarePage.class);
        onionpage.putExtra("crop_name",cropNames[7]);
        onionpage.putExtra("crop_Image",cropImages[7]);
        startActivity(onionpage);

    }
    public void potato_page(View view){
        Intent potatopage=new Intent(cropcareActivity.this, cropcarePage.class);
        potatopage.putExtra("crop_name",cropNames[8]);
        potatopage.putExtra("crop_Image",cropImages[8]);
        startActivity(potatopage);

    }
    public void pumkin_page(View view){
        Intent pumkinpage=new Intent(cropcareActivity.this, cropcarePage.class);
        pumkinpage.putExtra("crop_name",cropNames[9]);
        pumkinpage.putExtra("crop_Image",cropImages[9]);
        startActivity(pumkinpage);

    }
    public void papaya_page(View view){
        Intent papayapage=new Intent(cropcareActivity.this, cropcarePage.class);
        papayapage.putExtra("crop_name",cropNames[10]);
        papayapage.putExtra("crop_Image",cropImages[10]);
        startActivity(papayapage);

    }
    public void cucumber_page(View view){
        Intent cucumberpage=new Intent(cropcareActivity.this, cropcarePage.class);
        cucumberpage.putExtra("crop_name",cropNames[11]);
        cucumberpage.putExtra("crop_Image",cropImages[11]);
        startActivity(cucumberpage);
    }
    public void beet_page(View view){
        Intent beet_page=new Intent(cropcareActivity.this, cropcarePage.class);
        beet_page.putExtra("crop_name",cropNames[12]);
        beet_page.putExtra("crop_Image",cropImages[12]);
        startActivity(beet_page);
    }

    public void Carrot_page(View view){
        Intent Carrot_page=new Intent(cropcareActivity.this, cropcarePage.class);
        Carrot_page.putExtra("crop_name",cropNames[13]);
        Carrot_page.putExtra("crop_Image",cropImages[13]);
        startActivity(Carrot_page);
    }
    public void Lemon_page(View view){
        Intent Lemon_page=new Intent(cropcareActivity.this, cropcarePage.class);
        Lemon_page.putExtra("crop_name",cropNames[14]);
        Lemon_page.putExtra("crop_Image",cropImages[14]);
        startActivity(Lemon_page);
    }
    public void Coriander_page(View view){
        Intent Coriander_page=new Intent(cropcareActivity.this, cropcarePage.class);
        Coriander_page.putExtra("crop_name",cropNames[15]);
        Coriander_page.putExtra("crop_Image",cropImages[15]);
        startActivity(Coriander_page);
    }
    public void Ginger_page(View view){
        Intent Ginger_page=new Intent(cropcareActivity.this, cropcarePage.class);
        Ginger_page.putExtra("crop_name",cropNames[16]);
        Ginger_page.putExtra("crop_Image",cropImages[16]);
        startActivity(Ginger_page);
    }
    public void Tumeric_page(View view){
        Intent Tumeric_page=new Intent(cropcareActivity.this, cropcarePage.class);
        Tumeric_page.putExtra("crop_name",cropNames[17]);
        Tumeric_page.putExtra("crop_Image",cropImages[17]);
        startActivity(Tumeric_page);
    }
    public void Garlic_page(View view){
        Intent Garlic_page=new Intent(cropcareActivity.this, cropcarePage.class);
        Garlic_page.putExtra("crop_name",cropNames[18]);
        Garlic_page.putExtra("crop_Image",cropImages[18]);
        startActivity(Garlic_page);
    }
    public void BitterGourd_page(View view){
        Intent BitterGourd_page=new Intent(cropcareActivity.this, cropcarePage.class);
        BitterGourd_page.putExtra("crop_name",cropNames[19]);
        BitterGourd_page.putExtra("crop_Image",cropImages[19]);
        startActivity(BitterGourd_page);
    }
    public void Radish_page(View view){
        Intent cucumberpage=new Intent(cropcareActivity.this, cropcarePage.class);
        cucumberpage.putExtra("crop_name",cropNames[20]);
        cucumberpage.putExtra("crop_Image",cropImages[20]);
        startActivity(cucumberpage);
    }
    public void BottleGourd_page(View view){
        Intent cucumberpage=new Intent(cropcareActivity.this, cropcarePage.class);
        cucumberpage.putExtra("crop_name",cropNames[21]);
        cucumberpage.putExtra("crop_Image",cropImages[21]);
        startActivity(cucumberpage);
    }
    public void SweetPotato_page(View view){
        Intent cucumberpage=new Intent(cropcareActivity.this, cropcarePage.class);
        cucumberpage.putExtra("crop_name",cropNames[22]);
        cucumberpage.putExtra("crop_Image",cropImages[22]);
        startActivity(cucumberpage);
    }
    public void RidgeGourd_page(View view){
        Intent cucumberpage=new Intent(cropcareActivity.this, cropcarePage.class);
        cucumberpage.putExtra("crop_name",cropNames[23]);
        cucumberpage.putExtra("crop_Image",cropImages[23]);
        startActivity(cucumberpage);
    }

    ImageView imageView;
    public void backFrmCropDisplay ( View V ){
        imageView = findViewById(R.id.CropLogo);
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

}
