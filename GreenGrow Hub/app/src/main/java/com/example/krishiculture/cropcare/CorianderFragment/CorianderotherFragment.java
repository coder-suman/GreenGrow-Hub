package com.example.krishiculture.cropcare.CorianderFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.krishiculture.R;
import com.example.krishiculture.databinding.FragmentBeangrowingBinding;
import com.example.krishiculture.databinding.FragmentCorianderotherBinding;

public class CorianderotherFragment extends Fragment {
    FragmentCorianderotherBinding binding;


    public CorianderotherFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCorianderotherBinding.inflate(inflater, container, false);

        String rawText = getString(R.string.Coriander_Others);
        // Set the formatted text to the TextView
        binding.Corianderotherdetail.setText(rawText);


        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}