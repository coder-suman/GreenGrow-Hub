package com.example.krishiculture.cropcare.Ridge_GourdFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.krishiculture.R;
import com.example.krishiculture.databinding.FragmentBeangrowingBinding;
import com.example.krishiculture.databinding.FragmentRidgeGourdnpkBinding;

public class Ridge_GourdnpkFragment extends Fragment {
    FragmentRidgeGourdnpkBinding binding;


    public Ridge_GourdnpkFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentRidgeGourdnpkBinding.inflate(inflater, container, false);
        String rawText = getString(R.string.Ridge_gourd_NPK_Fertilizer_and_Soil_Management);
        // Set the formatted text to the TextView
        binding.RidgeGourdnpkdetail.setText(rawText);


        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}