package com.example.krishiculture.cropcare.CorianderFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.krishiculture.R;
import com.example.krishiculture.databinding.FragmentBeangrowingBinding;
import com.example.krishiculture.databinding.FragmentCoriandernurseryBinding;

public class CoriandernurseryFragment extends Fragment {
    FragmentCoriandernurseryBinding binding;

    public CoriandernurseryFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCoriandernurseryBinding.inflate(inflater, container, false);

        String rawText = getString(R.string.Coriander_Nursery);
        // Set the formatted text to the TextView
        binding.Coriandernurserydetail.setText(rawText);


        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}