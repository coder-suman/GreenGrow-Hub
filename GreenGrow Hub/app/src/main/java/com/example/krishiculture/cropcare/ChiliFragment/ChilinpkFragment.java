package com.example.krishiculture.cropcare.ChiliFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.krishiculture.R;
import com.example.krishiculture.databinding.FragmentBeangrowingBinding;
import com.example.krishiculture.databinding.FragmentChilinpkBinding;


public class ChilinpkFragment extends Fragment {
    FragmentChilinpkBinding binding;


    public ChilinpkFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentChilinpkBinding.inflate(inflater, container, false);
        String rawText = getString(R.string.Green_Chili_NPK_Fertilizer_and_Soil_Management);
        // Set the formatted text to the TextView
        binding.Chilinpkdetail.setText(rawText);


        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}