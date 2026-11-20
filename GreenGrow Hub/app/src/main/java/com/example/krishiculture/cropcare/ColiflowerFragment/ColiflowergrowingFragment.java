package com.example.krishiculture.cropcare.ColiflowerFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.krishiculture.R;
import com.example.krishiculture.databinding.FragmentCabbagegrowingBinding;
import com.example.krishiculture.databinding.FragmentColiflowergrowingBinding;

public class ColiflowergrowingFragment extends Fragment {
    FragmentColiflowergrowingBinding binding;


    public ColiflowergrowingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentColiflowergrowingBinding.inflate(inflater, container, false);

        String rawText = getString(R.string.Cauliflower_Growing_Process);
        // Set the formatted text to the TextView
        binding.Coliflowergrowingdetail.setText(rawText);




        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}