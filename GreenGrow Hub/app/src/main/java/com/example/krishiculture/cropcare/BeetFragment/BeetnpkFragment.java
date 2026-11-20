package com.example.krishiculture.cropcare.BeetFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.krishiculture.R;
import com.example.krishiculture.databinding.FragmentBeangrowingBinding;
import com.example.krishiculture.databinding.FragmentBeetnpkBinding;

public class BeetnpkFragment extends Fragment {
    FragmentBeetnpkBinding binding;


    public BeetnpkFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentBeetnpkBinding.inflate(inflater, container, false);

        String rawText = getString(R.string.Beet_NPK_Fertilizer_and_Soil_Management);
        // Set the formatted text to the TextView
        binding.Beetnpkdetail.setText(rawText);




        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}