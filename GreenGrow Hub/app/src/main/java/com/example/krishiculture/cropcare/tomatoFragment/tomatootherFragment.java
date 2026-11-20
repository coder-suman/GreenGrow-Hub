package com.example.krishiculture.cropcare.tomatoFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.krishiculture.R;
import com.example.krishiculture.databinding.FragmentTomatogrowingBinding;
import com.example.krishiculture.databinding.FragmentTomatootherBinding;


public class tomatootherFragment extends Fragment {
    FragmentTomatootherBinding binding;


    public tomatootherFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentTomatootherBinding.inflate(inflater, container, false);

        String rawText = getString(R.string.Tomato_Other_details);
        // Set the formatted text to the TextView
        binding.tomatootherdetail.setText(rawText);


        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}