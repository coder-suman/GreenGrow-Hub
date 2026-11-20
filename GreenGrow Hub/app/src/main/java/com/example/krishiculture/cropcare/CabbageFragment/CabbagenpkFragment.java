package com.example.krishiculture.cropcare.CabbageFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.krishiculture.R;
import com.example.krishiculture.databinding.FragmentCabbagenpkBinding;
import com.example.krishiculture.databinding.FragmentLadisfingernpkBinding;


public class CabbagenpkFragment extends Fragment {
    FragmentCabbagenpkBinding binding;



    public CabbagenpkFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCabbagenpkBinding.inflate(inflater, container, false);

        String rawText = getString(R.string.Cabbage_NPK_Fertilizer_and_Soil_Management);
        // Set the formatted text to the TextView
        binding.Cabbagenpkdetail.setText(rawText);



        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}