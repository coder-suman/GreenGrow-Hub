package com.example.krishiculture.amonFragment;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager.widget.ViewPager;

import com.example.krishiculture.R;
import com.google.android.material.tabs.TabLayout;

public class amonPage extends AppCompatActivity {
    TabLayout Tab;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_amon_page);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Tab=findViewById(R.id.amontab);
        viewPager=findViewById(R.id.amonviewpager);

        viewPageramonAdapter adapter=new viewPageramonAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        Tab.setupWithViewPager(viewPager);

    }
}