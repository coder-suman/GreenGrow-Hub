package com.example.krishiculture.cropcare.BeanFragment;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;


public class viewPagerBeanAdapter extends FragmentPagerAdapter {

    public viewPagerBeanAdapter(@NonNull FragmentManager fm){
        super(fm);
    }

    public Fragment getItem(int position) {
        if(position==0){
            return new BeannurseryFragment();
        }else if(position==1){
            return new BeannpkFragment();
        }else if(position==2){
            return new BeannurseryFragment();
        }else{
            return new BeanotherFragment();
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
