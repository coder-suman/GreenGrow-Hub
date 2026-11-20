package com.example.krishiculture.boroFragment;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class viewPagerboroAdapter extends FragmentPagerAdapter {


    public viewPagerboroAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if(position==0){
            return new boroprenurseryFragment();
        }else if(position==1){
            return new boronpkfertilizerFragment();
        }else if(position==2){
            return new borogrowingFragment();
        }else{
            return new borootherFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;//how meny fregment or tab is used.
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if(position==0){
            return "Pre Nursery";
        }else if(position==1){
            return "NPK Fertilizer";
        }else if(position==2){
            return "Growing Paddy";
        }else{
            return "Other";
        }
    }
}
