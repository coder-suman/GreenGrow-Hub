package com.example.krishiculture.cropcare.BeanFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.krishiculture.R;
import com.example.krishiculture.databinding.FragmentBeannpkBinding;
import com.example.krishiculture.databinding.FragmentBringelgrowingBinding;


public class BeannpkFragment extends Fragment {
    FragmentBeannpkBinding binding;



    public BeannpkFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentBeannpkBinding.inflate(inflater, container, false);
        String rawText = getString(R.string.Beans_NPK_Fertilizer_and_Soil_Management);
        // Set the formatted text to the TextView
        binding.beannpkdetail.setText(rawText);




        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}