package com.example.krishiculture.cropcare.BringelFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.krishiculture.R;
import com.example.krishiculture.databinding.FragmentBringelotherBinding;
import com.example.krishiculture.databinding.FragmentColiflowerotherBinding;

public class BringelotherFragment extends Fragment {
    FragmentBringelotherBinding binding;

    public BringelotherFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentBringelotherBinding.inflate(inflater, container, false);
        String rawText = getString(R.string.Brinjal_Others);
        // Set the formatted text to the TextView
        binding.Bringelotherdetail.setText(rawText);



        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}