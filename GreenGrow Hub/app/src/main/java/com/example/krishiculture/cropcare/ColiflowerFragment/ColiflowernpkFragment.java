package com.example.krishiculture.cropcare.ColiflowerFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.krishiculture.R;
import com.example.krishiculture.databinding.FragmentCabbagenpkBinding;
import com.example.krishiculture.databinding.FragmentColiflowernpkBinding;

public class ColiflowernpkFragment extends Fragment {
    FragmentColiflowernpkBinding binding;

    public ColiflowernpkFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentColiflowernpkBinding.inflate(inflater, container, false);

        String rawText = getString(R.string.Cauliflower_NPK_Fertilizer_and_Soil_Management);
        // Set the formatted text to the TextView
        binding.Coliflowernpkdetail.setText(rawText);



        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}