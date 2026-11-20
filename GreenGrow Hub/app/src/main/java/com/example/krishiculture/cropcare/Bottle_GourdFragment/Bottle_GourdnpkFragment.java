package com.example.krishiculture.cropcare.Bottle_GourdFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.krishiculture.R;
import com.example.krishiculture.databinding.FragmentBeangrowingBinding;
import com.example.krishiculture.databinding.FragmentBottleGourdnpkBinding;

public class Bottle_GourdnpkFragment extends Fragment {
    FragmentBottleGourdnpkBinding binding;


    public Bottle_GourdnpkFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentBottleGourdnpkBinding.inflate(inflater, container, false);

        String rawText = getString(R.string.Bottle_Gourd_NPK_Fertilizer_and_Soil_Management);
        // Set the formatted text to the TextView
        binding.BottolGourdnpkdetail.setText(rawText);




        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}