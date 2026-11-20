package com.example.krishiculture.cropcare.PotatoFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.krishiculture.R;
import com.example.krishiculture.databinding.FragmentBeangrowingBinding;
import com.example.krishiculture.databinding.FragmentPotatootherBinding;

public class PotatootherFragment extends Fragment {
    FragmentPotatootherBinding binding;


    public PotatootherFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentPotatootherBinding.inflate(inflater, container, false);

        String rawText = getString(R.string.Potato_Others);
        // Set the formatted text to the TextView
        binding.Potatootherdetail.setText(rawText);


        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}