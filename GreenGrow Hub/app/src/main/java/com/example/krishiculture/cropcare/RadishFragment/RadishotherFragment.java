package com.example.krishiculture.cropcare.RadishFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.krishiculture.R;
import com.example.krishiculture.databinding.FragmentBeangrowingBinding;
import com.example.krishiculture.databinding.FragmentRadishotherBinding;

public class RadishotherFragment extends Fragment {
    FragmentRadishotherBinding binding;

    public RadishotherFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentRadishotherBinding.inflate(inflater, container, false);

        String rawText = getString(R.string.Radish_Others);
        // Set the formatted text to the TextView
        binding.Radishotherdetail.setText(rawText);


        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}