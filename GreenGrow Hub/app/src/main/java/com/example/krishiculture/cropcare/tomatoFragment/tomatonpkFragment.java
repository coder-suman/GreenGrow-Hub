package com.example.krishiculture.cropcare.tomatoFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.krishiculture.R;
import com.example.krishiculture.databinding.FragmentTomatogrowingBinding;
import com.example.krishiculture.databinding.FragmentTomatonpkBinding;


public class tomatonpkFragment extends Fragment {
    FragmentTomatonpkBinding binding;


    public tomatonpkFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentTomatonpkBinding.inflate(inflater, container, false);

        String rawText = getString(R.string.Tomato_NPK_fertilizer_details);
        // Set the formatted text to the TextView
        binding.tomatonpkdetail.setText(rawText);



        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}