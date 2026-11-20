package com.example.krishiculture.cropcare.LadisfingerFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.krishiculture.R;
import com.example.krishiculture.databinding.FragmentLadisfingernurseryBinding;
import com.example.krishiculture.databinding.FragmentTomatonurseryBinding;

public class LadisfingernurseryFragment extends Fragment {
    FragmentLadisfingernurseryBinding binding;


    public LadisfingernurseryFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentLadisfingernurseryBinding.inflate(inflater, container, false);

        String rawText = getString(R.string.Ladyfinger_Nursery_Details);
        // Set the formatted text to the TextView
        binding.Ladyfingernurserydetail.setText(rawText);


        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}