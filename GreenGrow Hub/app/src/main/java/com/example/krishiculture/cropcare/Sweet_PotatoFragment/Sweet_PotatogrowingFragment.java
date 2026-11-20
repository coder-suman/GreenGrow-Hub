package com.example.krishiculture.cropcare.Sweet_PotatoFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.krishiculture.R;
import com.example.krishiculture.databinding.FragmentBeangrowingBinding;
import com.example.krishiculture.databinding.FragmentSweetPotatogrowingBinding;

public class Sweet_PotatogrowingFragment extends Fragment {
    FragmentSweetPotatogrowingBinding binding;


    public Sweet_PotatogrowingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSweetPotatogrowingBinding.inflate(inflater, container, false);

        String rawText = getString(R.string.Sweet_Potato_Growing_Process);
        // Set the formatted text to the TextView
        binding.SweetPotatogrowingdetail.setText(rawText);


        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}