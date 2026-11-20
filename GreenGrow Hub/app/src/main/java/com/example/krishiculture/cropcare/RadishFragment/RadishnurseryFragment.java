package com.example.krishiculture.cropcare.RadishFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.krishiculture.R;
import com.example.krishiculture.databinding.FragmentBeangrowingBinding;
import com.example.krishiculture.databinding.FragmentRadishnurseryBinding;

public class RadishnurseryFragment extends Fragment {
    FragmentRadishnurseryBinding binding;


    public RadishnurseryFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentRadishnurseryBinding.inflate(inflater, container, false);

        String rawText = getString(R.string.Radish_Nursery);
        // Set the formatted text to the TextView
        binding.Radishnurserydetail.setText(rawText);


        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}