package com.example.krishiculture.amonFragment;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class viewPageramonAdapter extends FragmentPagerAdapter {

    public viewPageramonAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if(position==0){
            return new amonPrenurseryFragment();
        }else if(position==1){
            return new amonnpkfertilizerFragment();
        }else if(position==2){
            return new amongrowingFragment();
        }else{
            return new amonotherFragment();
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
            return "Growing Paddy";
        }else{
            return "Other";
        }
    }
}
