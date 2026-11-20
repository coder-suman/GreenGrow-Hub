package com.example.krishiculture.cropcare.CucumberFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.krishiculture.R;
import com.example.krishiculture.databinding.FragmentBeangrowingBinding;
import com.example.krishiculture.databinding.FragmentCucumberotherBinding;


public class CucumberotherFragment extends Fragment {
    FragmentCucumberotherBinding binding;


    public CucumberotherFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCucumberotherBinding.inflate(inflater, container, false);

        String rawText = getString(R.string.Cucumber_Others);
        // Set the formatted text to the TextView
        binding.Cucumberotherdetail.setText(rawText);


        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}