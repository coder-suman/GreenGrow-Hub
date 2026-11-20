package com.example.krishiculture.cropcare.Sweet_PotatoFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.krishiculture.R;
import com.example.krishiculture.databinding.FragmentBeangrowingBinding;
import com.example.krishiculture.databinding.FragmentSweetPotatootherBinding;

public class Sweet_PotatootherFragment extends Fragment {
    FragmentSweetPotatootherBinding binding;


    public Sweet_PotatootherFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSweetPotatootherBinding.inflate(inflater, container, false);
        String rawText = getString(R.string.Sweet_Potato_Others);
        // Set the formatted text to the TextView
        binding.SweetPotatootherdetail.setText(rawText);


        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}