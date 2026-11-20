package com.example.krishiculture.cropcare.Ridge_GourdFragment;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.krishiculture.cropcare.BeanFragment.BeannpkFragment;
import com.example.krishiculture.cropcare.BeanFragment.BeannurseryFragment;
import com.example.krishiculture.cropcare.BeanFragment.BeanotherFragment;

public class viewPagerRidge_GourdAdapter extends FragmentPagerAdapter {
    public viewPagerRidge_GourdAdapter(@NonNull FragmentManager fm){
        super(fm);
    }

    public Fragment getItem(int position) {
        if(position==0){
            return new Ridge_GourdnurseryFragment();
        }else if(position==1){
            return new Ridge_GourdnpkFragment();
        }else if(position==2){
            return new Ridge_GourdnurseryFragment();
        }else{
            return new Ridge_GourdotherFragment();
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
