package com.example.krishiculture.cropcare.tomatoFragment;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.krishiculture.amonFragment.amonPrenurseryFragment;
import com.example.krishiculture.amonFragment.amongrowingFragment;
import com.example.krishiculture.amonFragment.amonnpkfertilizerFragment;
import com.example.krishiculture.amonFragment.amonotherFragment;

public class viewPagertomatoAdapter extends FragmentPagerAdapter {

    public viewPagertomatoAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    public Fragment getItem(int position) {
        if(position==0){
            return new tomatonurseryFragment();
        }else if(position==1){
            return new tomatonpkFragment();
        }else if(position==2){
            return new tomatogrowingFragment();
        }else{
            return new tomatootherFragment();
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
