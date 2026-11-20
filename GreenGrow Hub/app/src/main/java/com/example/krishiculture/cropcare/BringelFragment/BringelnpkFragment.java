package com.example.krishiculture.cropcare.BringelFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.krishiculture.R;
import com.example.krishiculture.databinding.FragmentBringelnpkBinding;
import com.example.krishiculture.databinding.FragmentColiflowerotherBinding;


public class BringelnpkFragment extends Fragment {
    FragmentBringelnpkBinding binding;



    public BringelnpkFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentBringelnpkBinding.inflate(inflater, container, false);
        String rawText = getString(R.string.Brinjal_NPK_Fertilizer_and_Soil_Management);
        // Set the formatted text to the TextView
        binding.Bringelnpkdetail.setText(rawText);



        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}