package com.example.krishiculture.cropcare.GingerFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.krishiculture.R;
import com.example.krishiculture.databinding.FragmentBeangrowingBinding;
import com.example.krishiculture.databinding.FragmentGingergrowingBinding;

public class GingergrowingFragment extends Fragment {
    FragmentGingergrowingBinding binding;


    public GingergrowingFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentGingergrowingBinding.inflate(inflater, container, false);

        String rawText = getString(R.string.Ginger_Growing_Process);
        // Set the formatted text to the TextView
        binding.Gingergrowingdetail.setText(rawText);


        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}