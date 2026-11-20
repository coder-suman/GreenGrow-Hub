package com.example.krishiculture.cropcare.GarlicFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.krishiculture.R;
import com.example.krishiculture.databinding.FragmentBeangrowingBinding;
import com.example.krishiculture.databinding.FragmentGarlicnpkBinding;

public class GarlicnpkFragment extends Fragment {
    FragmentGarlicnpkBinding binding;


    public GarlicnpkFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentGarlicnpkBinding.inflate(inflater, container, false);

        String rawText = getString(R.string.Garlic_NPK_Fertilizer_and_Soil_Management);
        // Set the formatted text to the TextView
        binding.Garlicnpkdetail.setText(rawText);


        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}