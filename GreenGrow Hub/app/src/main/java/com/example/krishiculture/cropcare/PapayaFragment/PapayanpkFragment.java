package com.example.krishiculture.cropcare.PapayaFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.krishiculture.R;
import com.example.krishiculture.databinding.FragmentBeannpkBinding;
import com.example.krishiculture.databinding.FragmentPapayanpkBinding;


public class PapayanpkFragment extends Fragment {
    FragmentPapayanpkBinding binding;

    public PapayanpkFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentPapayanpkBinding.inflate(inflater, container, false);
        String rawText = getString(R.string.Papaya_NPK_Fertilizer_and_Soil_Management);
        // Set the formatted text to the TextView
        binding.Papayanpkdetail.setText(rawText);


        return binding.getRoot();
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}