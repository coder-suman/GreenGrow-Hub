package com.example.krishiculture.cropcare;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager.widget.ViewPager;

import com.example.krishiculture.R;
import com.google.android.material.tabs.TabLayout;

import java.util.HashMap;
import java.util.Map;

public class cropcarePage  extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ImageView cropImage;
    private TextView cropName;

    // Map to associate crop names with their adapters
    private final Map<String, Class<? extends androidx.fragment.app.FragmentPagerAdapter>> cropAdapters = new HashMap<>();
    private final Map<String, Integer> cropImages = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tomato_page);

        initializeUI();
        initializeData();

        // Extract crop data from intent
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String name = extras.getString("crop_name", "").toLowerCase();
            int imageResId = extras.getInt("crop_Image", 0);

            setupCropDetails(name, imageResId);
        }
    }

    private void initializeUI() {
        cropImage = findViewById(R.id.crop_Image);
        cropName = findViewById(R.id.crop_Text);
        tabLayout = findViewById(R.id.cropcaretab);
        viewPager = findViewById(R.id.cropcareviewpager);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void initializeData() {
        // Map crop names to their corresponding adapters
        cropAdapters.put("tomato", com.example.krishiculture.cropcare.tomatoFragment.viewPagertomatoAdapter.class);
        cropAdapters.put("ladyfinger", com.example.krishiculture.cropcare.LadisfingerFragment.viewPagerLadisfingerAdapter.class);
        cropAdapters.put("cabbage", com.example.krishiculture.cropcare.CabbageFragment.viewPagerCabbageAdapter.class);
        cropAdapters.put("cauliflower", com.example.krishiculture.cropcare.ColiflowerFragment.viewPagerColiflowerAdapter.class);
        cropAdapters.put("brinjal", com.example.krishiculture.cropcare.BringelFragment.viewPagerBringelAdapter.class);
        cropAdapters.put("beans", com.example.krishiculture.cropcare.BeanFragment.viewPagerBeanAdapter.class);
        cropAdapters.put("green chili", com.example.krishiculture.cropcare.ChiliFragment.viewPagerChiliAdapter.class);
        cropAdapters.put("onion", com.example.krishiculture.cropcare.OnionFragment.viewPagerOnionAdapter.class);
        cropAdapters.put("potato", com.example.krishiculture.cropcare.PotatoFragment.viewPagerPotatoAdapter.class);
        cropAdapters.put("pumpkin", com.example.krishiculture.cropcare.PumpkinFragment.viewPagerPumpkinAdapter.class);
        cropAdapters.put("papaya", com.example.krishiculture.cropcare.PapayaFragment.viewPagerPapayaAdapter.class);
        cropAdapters.put("cucumber", com.example.krishiculture.cropcare.CucumberFragment.viewPagerCucumberAdapter.class);
        cropAdapters.put("beet", com.example.krishiculture.cropcare.BeetFragment.viewPagerBeetAdapter.class);
        cropAdapters.put("carrot", com.example.krishiculture.cropcare.CarrotFragment.viewPagerCarrotAdapter.class);
        cropAdapters.put("lemon", com.example.krishiculture.cropcare.LemonFragment.viewPagerLemonAdapter.class);
        cropAdapters.put("coriander", com.example.krishiculture.cropcare.CorianderFragment.viewPagerCorianderAdapter.class);
        cropAdapters.put("ginger", com.example.krishiculture.cropcare.GingerFragment.viewPagerGingerAdapter.class);
        cropAdapters.put("tumeric", com.example.krishiculture.cropcare.TumericFragment.viewPagerTumericAdapter.class);
        cropAdapters.put("garlic", com.example.krishiculture.cropcare.GarlicFragment.viewPagerGarlicAdapter.class);
        cropAdapters.put("bitter gourd", com.example.krishiculture.cropcare.Bitter_GourdFragment.viewPagerBitter_GourdAdapter.class);
        cropAdapters.put("radish", com.example.krishiculture.cropcare.RadishFragment.viewPagerRadishAdapter.class);
        cropAdapters.put("bottle gourd", com.example.krishiculture.cropcare.Bottle_GourdFragment.viewPagerBottle_GourdAdapter.class);
        cropAdapters.put("sweet potato", com.example.krishiculture.cropcare.Sweet_PotatoFragment.viewPagerSweet_PotatoAdapter.class);
        cropAdapters.put("ridge gourd", com.example.krishiculture.cropcare.Ridge_GourdFragment.viewPagerRidge_GourdAdapter.class);

        // Add default crop images (optional: handle dynamic loading later)
        cropImages.put("tomato", R.drawable.tomato);
        cropImages.put("ladyfinger", R.drawable.ledisfinger);
        cropImages.put("cabbage", R.drawable.cabage);
        cropImages.put("cauliflower", R.drawable.cauliflower);
        cropImages.put("brinjal", R.drawable.brinjal);
        cropImages.put("beans", R.drawable.beans);
        cropImages.put("green chili", R.drawable.chili);
        cropImages.put("onion", R.drawable.onion);
        cropImages.put("potato", R.drawable.potato);
        cropImages.put("pumpkin", R.drawable.pumkin);
        cropImages.put("papaya", R.drawable.papaya);
        cropImages.put("cucumber", R.drawable.cucumber);
        cropImages.put("beet", R.drawable.beet);
        cropImages.put("carrot", R.drawable.carrot);
        cropImages.put("lemon", R.drawable.lemon);
        cropImages.put("coriander", R.drawable.dhania);
        cropImages.put("ginger", R.drawable.ginger);
        cropImages.put("tumeric", R.drawable.haldi);
        cropImages.put("garlic", R.drawable.rasun);
        cropImages.put("bitter gourd", R.drawable.karola);
        cropImages.put("radish", R.drawable.mula);
        cropImages.put("bottle gourd", R.drawable.potol);
        cropImages.put("sweet potato", R.drawable.sweetpotato);
        cropImages.put("ridge gourd", R.drawable.jhinga);
    }

    private void setupCropDetails(String cropNameKey, int imageResId) {
        if (!cropAdapters.containsKey(cropNameKey)) {
            cropName.setText("Tomato");
            cropImage.setBackgroundResource(R.drawable.tomato); // Default image
            return;
        }

        // Update crop name and image
        cropName.setText(cropNameKey.substring(0, 1).toUpperCase() + cropNameKey.substring(1));
        cropImage.setBackgroundResource(imageResId > 0 ? imageResId : cropImages.getOrDefault(cropNameKey, R.drawable.tomato));

        try {
            // Dynamically instantiate adapter
            androidx.fragment.app.FragmentPagerAdapter adapter = cropAdapters.get(cropNameKey)
                    .getDeclaredConstructor(androidx.fragment.app.FragmentManager.class)
                    .newInstance(getSupportFragmentManager());

            viewPager.setAdapter(adapter);
            tabLayout.setupWithViewPager(viewPager);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
