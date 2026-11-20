package com.example.krishiculture.cropcare.PumpkinFragment;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;


public class viewPagerPumpkinAdapter extends FragmentPagerAdapter {
    public viewPagerPumpkinAdapter(@NonNull FragmentManager fm){
        super(fm);
    }

    public Fragment getItem(int position) {
        if(position==0){
            return new PumpkinnurseryFragment();
        }else if(position==1){
            return new PumpkinnpkFragment();
        }else if(position==2){
            return new PumpkinnurseryFragment();
        }else{
            return new PumpkinotherFragment();
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
