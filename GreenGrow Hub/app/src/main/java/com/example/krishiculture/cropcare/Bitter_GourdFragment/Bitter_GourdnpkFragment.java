package com.example.krishiculture.cropcare.Bitter_GourdFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.krishiculture.R;
import com.example.krishiculture.databinding.FragmentBeangrowingBinding;
import com.example.krishiculture.databinding.FragmentBitterGourdnpkBinding;

public class Bitter_GourdnpkFragment extends Fragment {
    FragmentBitterGourdnpkBinding binding;

    public Bitter_GourdnpkFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentBitterGourdnpkBinding.inflate(inflater, container, false);

        String rawText = getString(R.string.Bitter_Gourd_NPK_Fertilizer_and_Soil_Management);
        // Set the formatted text to the TextView
        binding.BitterGourdnpkdetail.setText(rawText);




        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}