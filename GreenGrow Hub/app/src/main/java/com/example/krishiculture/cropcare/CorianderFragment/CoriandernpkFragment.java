package com.example.krishiculture.cropcare.CorianderFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.krishiculture.R;
import com.example.krishiculture.databinding.FragmentBeangrowingBinding;
import com.example.krishiculture.databinding.FragmentCoriandernpkBinding;

public class CoriandernpkFragment extends Fragment {
    FragmentCoriandernpkBinding binding;


    public CoriandernpkFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCoriandernpkBinding.inflate(inflater, container, false);

        String rawText = getString(R.string.Coriander_NPK_Fertilizer_and_Soil_Management);
        // Set the formatted text to the TextView
        binding.Coriandernpkdetail.setText(rawText);


        // Get the string from resources

        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}