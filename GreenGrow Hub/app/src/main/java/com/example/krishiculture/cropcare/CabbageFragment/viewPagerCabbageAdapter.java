package com.example.krishiculture.cropcare.CabbageFragment;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class viewPagerCabbageAdapter extends FragmentPagerAdapter {

    public viewPagerCabbageAdapter(@NonNull FragmentManager fm){
        super(fm);
    }

    public Fragment getItem(int position) {
        if(position==0){
            return new CabbagenurseryFragment();
        }else if(position==1){
            return new CabbagenpkFragment();
        }else if(position==2){
            return new CabbagegrowingFragment();
        }else{
            return new CabbageotherFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;//how meny fregment or tab is used.
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if(position==0){
            return "Nursery";
        }else if(position==1){
            return "NPK Fertilizer";
        }else if(position==2){
            return "Growing Process";
        }else{
            return "Other";
        }
    }
}
