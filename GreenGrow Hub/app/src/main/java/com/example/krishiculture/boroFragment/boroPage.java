package com.example.krishiculture.boroFragment;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager.widget.ViewPager;

import com.example.krishiculture.R;
import com.google.android.material.tabs.TabLayout;

public class boroPage extends AppCompatActivity {
    TabLayout Tab;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_boro_page);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Tab=findViewById(R.id.borotab);
        viewPager=findViewById(R.id.boroviewpager);

        viewPagerboroAdapter adapter=new viewPagerboroAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        Tab.setupWithViewPager(viewPager);
    }
}