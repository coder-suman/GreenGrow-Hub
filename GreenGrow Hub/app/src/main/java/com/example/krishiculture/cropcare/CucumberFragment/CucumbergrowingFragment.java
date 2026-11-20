package com.example.krishiculture.cropcare.CucumberFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.krishiculture.R;
import com.example.krishiculture.databinding.FragmentBeangrowingBinding;
import com.example.krishiculture.databinding.FragmentCucumbergrowingBinding;

public class CucumbergrowingFragment extends Fragment {
    FragmentCucumbergrowingBinding binding;

    public CucumbergrowingFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCucumbergrowingBinding.inflate(inflater, container, false);

        String rawText = getString(R.string.Cucumber_Growing_Process);
        // Set the formatted text to the TextView
        binding.Cucumbergrowingdetail.setText(rawText);


        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}