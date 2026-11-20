package com.example.krishiculture.cropcare.LadisfingerFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.krishiculture.R;
import com.example.krishiculture.databinding.FragmentLadisfingernpkBinding;
import com.example.krishiculture.databinding.FragmentTomatonpkBinding;


public class LadisfingernpkFragment extends Fragment {
    FragmentLadisfingernpkBinding binding;



    public LadisfingernpkFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentLadisfingernpkBinding.inflate(inflater, container, false);
        String rawText = getString(R.string.Ladyfinger_NPK_Fertilizer_and_Soil_Management);
        // Set the formatted text to the TextView
        binding.Ladyfingernpkdetail.setText(rawText);


        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}