package com.example.krishiculture.cropcare.PapayaFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.krishiculture.R;
import com.example.krishiculture.databinding.FragmentBeannpkBinding;
import com.example.krishiculture.databinding.FragmentPapayaotherBinding;


public class PapayaotherFragment extends Fragment {
    FragmentPapayaotherBinding binding;


    public PapayaotherFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentPapayaotherBinding.inflate(inflater, container, false);

        String rawText = getString(R.string.Papaya_Others);
        // Set the formatted text to the TextView
        binding.Papayaotherdetail.setText(rawText);


        return binding.getRoot();
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}