package com.example.krishiculture.cropcare.Ridge_GourdFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.krishiculture.R;
import com.example.krishiculture.databinding.FragmentBeangrowingBinding;
import com.example.krishiculture.databinding.FragmentRidgeGourdgrowingBinding;

public class Ridge_GourdgrowingFragment extends Fragment {
    FragmentRidgeGourdgrowingBinding binding;

    public Ridge_GourdgrowingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentRidgeGourdgrowingBinding.inflate(inflater, container, false);
        String rawText = getString(R.string.Ridge_gourd_Growing_Process);
        // Set the formatted text to the TextView
        binding.RidgeGourdgrowingdetail.setText(rawText);


        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}