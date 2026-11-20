package com.example.krishiculture.cropcare.Ridge_GourdFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.krishiculture.R;
import com.example.krishiculture.databinding.FragmentBeangrowingBinding;
import com.example.krishiculture.databinding.FragmentRidgeGourdnurseryBinding;

public class Ridge_GourdnurseryFragment extends Fragment {
    FragmentRidgeGourdnurseryBinding binding;


    public Ridge_GourdnurseryFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentRidgeGourdnurseryBinding.inflate(inflater, container, false);

        String rawText = getString(R.string.Ridge_gourd_Nursery);
        // Set the formatted text to the TextView
        binding.RidgeGourdnurserydetail.setText(rawText);


        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}