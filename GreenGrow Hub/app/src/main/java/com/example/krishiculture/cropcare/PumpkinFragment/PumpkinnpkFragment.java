package com.example.krishiculture.cropcare.PumpkinFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.krishiculture.R;
import com.example.krishiculture.databinding.FragmentBeangrowingBinding;
import com.example.krishiculture.databinding.FragmentPumpkinnpkBinding;

public class PumpkinnpkFragment extends Fragment {
    FragmentPumpkinnpkBinding binding;


    public PumpkinnpkFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentPumpkinnpkBinding.inflate(inflater, container, false);

        String rawText = getString(R.string.Pumpkin_NPK_Fertilizer_and_Soil_Management);
        // Set the formatted text to the TextView
        binding.Pumpkinnpkdetail.setText(rawText);


        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}