package com.example.krishiculture.cropcare.OnionFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.krishiculture.R;
import com.example.krishiculture.databinding.FragmentBeangrowingBinding;
import com.example.krishiculture.databinding.FragmentOnionnurseryBinding;


public class OnionnurseryFragment extends Fragment {
    FragmentOnionnurseryBinding binding;

    public OnionnurseryFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentOnionnurseryBinding.inflate(inflater, container, false);

        String rawText = getString(R.string.Onion_Nursery);
        // Set the formatted text to the TextView
        binding.Onionnurserydetail.setText(rawText);


        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}