package com.example.krishiculture.cropcare.LadisfingerFragment;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;


public class viewPagerLadisfingerAdapter extends FragmentPagerAdapter {

    public viewPagerLadisfingerAdapter(@NonNull FragmentManager fm){
        super(fm);
    }

    public Fragment getItem(int position) {
        if(position==0){
            return new LadisfingernurseryFragment();
        }else if(position==1){
            return new LadisfingernpkFragment();
        }else if(position==2){
            return new LadisfingernurseryFragment();
        }else{
            return new LadisfingerotherFragment();
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
