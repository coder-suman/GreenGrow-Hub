package com.example.krishiculture.cropcare.CarrotFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.krishiculture.R;
import com.example.krishiculture.databinding.FragmentBeangrowingBinding;
import com.example.krishiculture.databinding.FragmentCarrotgrowingBinding;

public class CarrotgrowingFragment extends Fragment {
    FragmentCarrotgrowingBinding binding;


    public CarrotgrowingFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCarrotgrowingBinding.inflate(inflater, container, false);

        String rawText = getString(R.string.Carrot_Growing_Process);
        // Set the formatted text to the TextView
        binding.Carrotgrowingdetail.setText(rawText);


        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}