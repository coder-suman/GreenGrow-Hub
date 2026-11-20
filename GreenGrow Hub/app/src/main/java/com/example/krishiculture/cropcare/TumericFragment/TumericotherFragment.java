package com.example.krishiculture.cropcare.TumericFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.krishiculture.R;
import com.example.krishiculture.databinding.FragmentBeangrowingBinding;
import com.example.krishiculture.databinding.FragmentTumericotherBinding;

public class TumericotherFragment extends Fragment {
    FragmentTumericotherBinding binding;


    public TumericotherFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentTumericotherBinding.inflate(inflater, container, false);
        String rawText = getString(R.string.Turmeric_Others);
        // Set the formatted text to the TextView
        binding.Tumericotherdetail.setText(rawText);


        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}