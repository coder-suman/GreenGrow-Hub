package com.example.krishiculture.cropcare.LadisfingerFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.krishiculture.R;
import com.example.krishiculture.databinding.FragmentLadisfingergrowingBinding;
import com.example.krishiculture.databinding.FragmentTomatogrowingBinding;

public class LadisfingergrowingFragment extends Fragment {
    FragmentLadisfingergrowingBinding binding;


    public LadisfingergrowingFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentLadisfingergrowingBinding.inflate(inflater, container, false);
        String rawText = getString(R.string.Ladyfinger_Growing_Process);
        // Set the formatted text to the TextView
        binding.Ladyfingergrowingdetail.setText(rawText);


        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}