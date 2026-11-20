package com.example.krishiculture.ausFragment;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class viewPagerausAdapter extends FragmentPagerAdapter {

    public viewPagerausAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if(position==0){
            return new ausprenurseryFragment();
        }
        else if(position==1){
            return new ausnpkfertilizerFragment();
        }else if(position==2){
            return new ausgrowingFragment();
        }else{
            return new ausotherFragment();
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
        }
        else if(position==1){
            return "NPK Fertilizer";
        }else if(position==2){
            return "Growing Paddy";
        }else{
            return "Other";
        }
    }
}
