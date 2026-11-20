package com.example.krishiculture.cropcare.BeetFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.krishiculture.R;
import com.example.krishiculture.databinding.FragmentBeangrowingBinding;
import com.example.krishiculture.databinding.FragmentBeetgrowingBinding;

public class BeetgrowingFragment extends Fragment {
    FragmentBeetgrowingBinding binding;


    public BeetgrowingFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentBeetgrowingBinding.inflate(inflater, container, false);

        String rawText = getString(R.string.Beet_Growing_Process);
        // Set the formatted text to the TextView
        binding.Beetgrowingdetail.setText(rawText);




        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}