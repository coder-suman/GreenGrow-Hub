package com.example.krishiculture.cropcare.LemonFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.krishiculture.R;
import com.example.krishiculture.databinding.FragmentBeangrowingBinding;
import com.example.krishiculture.databinding.FragmentLemonotherBinding;

public class LemonotherFragment extends Fragment {
    FragmentLemonotherBinding binding;


    public LemonotherFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentLemonotherBinding.inflate(inflater, container, false);
        String rawText = getString(R.string.Lemon_Others);
        // Set the formatted text to the TextView
        binding.Lemonotherdetail.setText(rawText);


        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}