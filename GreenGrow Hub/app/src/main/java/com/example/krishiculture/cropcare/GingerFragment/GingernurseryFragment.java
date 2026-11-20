package com.example.krishiculture.cropcare.GingerFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.krishiculture.R;
import com.example.krishiculture.databinding.FragmentBeangrowingBinding;
import com.example.krishiculture.databinding.FragmentGingernurseryBinding;

public class GingernurseryFragment extends Fragment {
    FragmentGingernurseryBinding binding;


    public GingernurseryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentGingernurseryBinding.inflate(inflater, container, false);

        String rawText = getString(R.string.Ginger_Nursery);
        // Set the formatted text to the TextView
        binding.Gingernurserydetail.setText(rawText);


        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}