package com.example.krishiculture.cropcare.BringelFragment;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.krishiculture.cropcare.ColiflowerFragment.ColiflowergrowingFragment;
import com.example.krishiculture.cropcare.ColiflowerFragment.ColiflowernpkFragment;
import com.example.krishiculture.cropcare.ColiflowerFragment.ColiflowernurseryFragment;
import com.example.krishiculture.cropcare.ColiflowerFragment.ColiflowerotherFragment;

public class viewPagerBringelAdapter extends FragmentPagerAdapter {

    public viewPagerBringelAdapter(@NonNull FragmentManager fm){
        super(fm);
    }

    public Fragment getItem(int position) {
        if(position==0){
            return new BringelnurseryFragment();
        }else if(position==1){
            return new BringelnpkFragment();
        }else if(position==2){
            return new BringelnurseryFragment();
        }else{
            return new BringelotherFragment();
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
