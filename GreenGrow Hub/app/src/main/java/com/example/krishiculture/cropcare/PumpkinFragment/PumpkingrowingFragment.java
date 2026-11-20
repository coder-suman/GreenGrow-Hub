package com.example.krishiculture.cropcare.PumpkinFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.krishiculture.R;
import com.example.krishiculture.databinding.FragmentBeangrowingBinding;
import com.example.krishiculture.databinding.FragmentPumpkingrowingBinding;

public class PumpkingrowingFragment extends Fragment {
    FragmentPumpkingrowingBinding binding;

    public PumpkingrowingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentPumpkingrowingBinding.inflate(inflater, container, false);

        String rawText = getString(R.string.Pumpkin_Growing_Process);
        // Set the formatted text to the TextView
        binding.Pumpkingrowingdetail.setText(rawText);


        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}