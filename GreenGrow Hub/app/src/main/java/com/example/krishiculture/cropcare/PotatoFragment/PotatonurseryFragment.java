package com.example.krishiculture.cropcare.PotatoFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.krishiculture.R;
import com.example.krishiculture.databinding.FragmentBeangrowingBinding;
import com.example.krishiculture.databinding.FragmentPotatonurseryBinding;


public class PotatonurseryFragment extends Fragment {
    FragmentPotatonurseryBinding binding;

    public PotatonurseryFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentPotatonurseryBinding.inflate(inflater, container, false);

        String rawText = getString(R.string.Potato_Nursery);
        // Set the formatted text to the TextView
        binding.Potatonurserydetail.setText(rawText);


        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}