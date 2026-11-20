package com.example.krishiculture.cropcare.BeetFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.krishiculture.R;
import com.example.krishiculture.databinding.FragmentBeangrowingBinding;
import com.example.krishiculture.databinding.FragmentBeetnurseryBinding;

public class BeetnurseryFragment extends Fragment {
    FragmentBeetnurseryBinding binding;

    public BeetnurseryFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentBeetnurseryBinding.inflate(inflater, container, false);

        String rawText = getString(R.string.Beet_Nursery);
        // Set the formatted text to the TextView
        binding.Beetnurserydetail.setText(rawText);




        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}