package com.example.krishiculture.ausFragment;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager.widget.ViewPager;

import com.example.krishiculture.R;
import com.google.android.material.tabs.TabLayout;

public class AusPage extends AppCompatActivity {
    TabLayout Tab;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_aus_page);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        Tab=findViewById(R.id.austab);
        viewPager=findViewById(R.id.ausviewpager);

        viewPagerausAdapter adapter=new viewPagerausAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        Tab.setupWithViewPager(viewPager);
    }
}