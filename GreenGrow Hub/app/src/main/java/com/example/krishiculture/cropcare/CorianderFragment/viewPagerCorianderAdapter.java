package com.example.krishiculture.cropcare.CorianderFragment;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.krishiculture.cropcare.BeetFragment.BeetnpkFragment;
import com.example.krishiculture.cropcare.BeetFragment.BeetnurseryFragment;
import com.example.krishiculture.cropcare.BeetFragment.BeetotherFragment;

public class viewPagerCorianderAdapter extends FragmentPagerAdapter {
    public viewPagerCorianderAdapter(@NonNull FragmentManager fm){
        super(fm);
    }

    public Fragment getItem(int position) {
        if(position==0){
            return new CoriandernurseryFragment();
        }else if(position==1){
            return new CoriandernpkFragment();
        }else if(position==2){
            return new CoriandernurseryFragment();
        }else{
            return new CorianderotherFragment();
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
