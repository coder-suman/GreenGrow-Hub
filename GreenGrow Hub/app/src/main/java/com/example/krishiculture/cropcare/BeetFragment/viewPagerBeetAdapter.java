package com.example.krishiculture.cropcare.BeetFragment;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.krishiculture.cropcare.BeanFragment.BeannpkFragment;
import com.example.krishiculture.cropcare.BeanFragment.BeannurseryFragment;
import com.example.krishiculture.cropcare.BeanFragment.BeanotherFragment;

public class viewPagerBeetAdapter extends FragmentPagerAdapter {
    public viewPagerBeetAdapter(@NonNull FragmentManager fm){
        super(fm);
    }
    public Fragment getItem(int position) {
        if(position==0){
            return new BeetnurseryFragment();
        }else if(position==1){
            return new BeetnpkFragment();
        }else if(position==2){
            return new BeetnurseryFragment();
        }else{
            return new BeetotherFragment();
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
