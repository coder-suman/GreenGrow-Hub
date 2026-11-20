package com.example.krishiculture.cropcare.BringelFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.krishiculture.R;
import com.example.krishiculture.databinding.FragmentBringelnurseryBinding;
import com.example.krishiculture.databinding.FragmentColiflowerotherBinding;


public class BringelnurseryFragment extends Fragment {
    FragmentBringelnurseryBinding binding;



    public BringelnurseryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentBringelnurseryBinding.inflate(inflater, container, false);
        String rawText = getString(R.string.Brinjal_Nursery);
        // Set the formatted text to the TextView
        binding.Bringelnurserydetail.setText(rawText);



        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}