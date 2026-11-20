package com.example.krishiculture.cropcare.RadishFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.krishiculture.R;
import com.example.krishiculture.databinding.FragmentBeangrowingBinding;
import com.example.krishiculture.databinding.FragmentRadishgrowingBinding;

public class RadishgrowingFragment extends Fragment {
    FragmentRadishgrowingBinding binding;

    public RadishgrowingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentRadishgrowingBinding.inflate(inflater, container, false);

        String rawText = getString(R.string.Radish_Growing_Process);
        // Set the formatted text to the TextView
        binding.Radishgrowingdetail.setText(rawText);


        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}