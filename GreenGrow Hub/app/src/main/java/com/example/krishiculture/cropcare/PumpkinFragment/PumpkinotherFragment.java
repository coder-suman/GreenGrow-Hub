package com.example.krishiculture.cropcare.PumpkinFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.krishiculture.R;
import com.example.krishiculture.databinding.FragmentBeangrowingBinding;
import com.example.krishiculture.databinding.FragmentPumpkinotherBinding;

public class PumpkinotherFragment extends Fragment {
    FragmentPumpkinotherBinding binding;


    public PumpkinotherFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentPumpkinotherBinding.inflate(inflater, container, false);
        String rawText = getString(R.string.Pumpkin_Others);
        // Set the formatted text to the TextView
        binding.Pumpkinotherdetail.setText(rawText);


        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}