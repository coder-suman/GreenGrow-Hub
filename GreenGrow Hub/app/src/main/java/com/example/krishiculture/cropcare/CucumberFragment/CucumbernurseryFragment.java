package com.example.krishiculture.cropcare.CucumberFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.krishiculture.R;
import com.example.krishiculture.databinding.FragmentBeangrowingBinding;
import com.example.krishiculture.databinding.FragmentCucumbernurseryBinding;

public class CucumbernurseryFragment extends Fragment {
    FragmentCucumbernurseryBinding binding;

    public CucumbernurseryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCucumbernurseryBinding.inflate(inflater, container, false);

        String rawText = getString(R.string.Cucumber_Nursery);
        // Set the formatted text to the TextView
        binding.Cucumbernurserydetail.setText(rawText);


        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}