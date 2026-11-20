package com.example.krishiculture.cropcare.Ridge_GourdFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.krishiculture.R;
import com.example.krishiculture.databinding.FragmentBeangrowingBinding;
import com.example.krishiculture.databinding.FragmentRidgeGourdotherBinding;

public class Ridge_GourdotherFragment extends Fragment {
    FragmentRidgeGourdotherBinding binding;


    public Ridge_GourdotherFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentRidgeGourdotherBinding.inflate(inflater, container, false);

        String rawText = getString(R.string.Ridge_gourd_Others);
        // Set the formatted text to the TextView
        binding.RidgeGourdotherdetail.setText(rawText);


        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}