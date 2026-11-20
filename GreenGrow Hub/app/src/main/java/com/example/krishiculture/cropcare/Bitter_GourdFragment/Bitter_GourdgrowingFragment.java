package com.example.krishiculture.cropcare.Bitter_GourdFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.krishiculture.R;
import com.example.krishiculture.databinding.FragmentBeangrowingBinding;
import com.example.krishiculture.databinding.FragmentBitterGourdgrowingBinding;

public class Bitter_GourdgrowingFragment extends Fragment {
    FragmentBitterGourdgrowingBinding binding;


    public Bitter_GourdgrowingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentBitterGourdgrowingBinding.inflate(inflater, container, false);

        String rawText = getString(R.string.Bitter_Gourd_Growing_Process);
        // Set the formatted text to the TextView
        binding.BitterGourdgrowingdetail.setText(rawText);




        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}