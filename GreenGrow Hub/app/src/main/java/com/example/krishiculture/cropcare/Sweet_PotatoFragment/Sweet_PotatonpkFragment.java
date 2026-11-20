package com.example.krishiculture.cropcare.Sweet_PotatoFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.krishiculture.R;
import com.example.krishiculture.databinding.FragmentBeangrowingBinding;
import com.example.krishiculture.databinding.FragmentSweetPotatonkpBinding;

public class Sweet_PotatonpkFragment extends Fragment {
    FragmentSweetPotatonkpBinding binding;


    public Sweet_PotatonpkFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSweetPotatonkpBinding.inflate(inflater, container, false);

        String rawText = getString(R.string.Sweet_Potato_NPK_Fertilizer_and_Soil_Management);
        // Set the formatted text to the TextView
        binding.SweetPotatonpkdetail.setText(rawText);


        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}