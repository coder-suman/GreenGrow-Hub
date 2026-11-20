package com.example.krishiculture.cropcare.PapayaFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.krishiculture.R;
import com.example.krishiculture.databinding.FragmentBeannpkBinding;
import com.example.krishiculture.databinding.FragmentPapayagrowingBinding;


public class PapayagrowingFragment extends Fragment {
    FragmentPapayagrowingBinding binding;

    public PapayagrowingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentPapayagrowingBinding.inflate(inflater, container, false);

        String rawText = getString(R.string.Papaya_Growing_Process);
        // Set the formatted text to the TextView
        binding.Papayagrowingdetail.setText(rawText);


        return binding.getRoot();
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}