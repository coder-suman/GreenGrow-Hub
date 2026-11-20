package com.example.krishiculture.cropcare.OnionFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.krishiculture.R;
import com.example.krishiculture.databinding.FragmentBeangrowingBinding;
import com.example.krishiculture.databinding.FragmentOnionnpkBinding;


public class OnionnpkFragment extends Fragment {
    FragmentOnionnpkBinding binding;


    public OnionnpkFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentOnionnpkBinding.inflate(inflater, container, false);

        String rawText = getString(R.string.Onion_NPK_Fertilizer_and_Soil_Management);
        // Set the formatted text to the TextView
        binding.Onionnpkdetail.setText(rawText);


        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}