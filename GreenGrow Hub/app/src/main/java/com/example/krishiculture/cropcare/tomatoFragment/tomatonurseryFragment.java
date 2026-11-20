package com.example.krishiculture.cropcare.tomatoFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.krishiculture.R;
import com.example.krishiculture.databinding.FragmentAmonPrenurseryBinding;
import com.example.krishiculture.databinding.FragmentTomatonurseryBinding;


public class tomatonurseryFragment extends Fragment {
    FragmentTomatonurseryBinding binding;
    public tomatonurseryFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentTomatonurseryBinding.inflate(inflater, container, false);

        String rawText = getString(R.string.Tomato_Nursery);
        // Set the formatted text to the TextView
        binding.tomatonurserydetail.setText(rawText);
        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}