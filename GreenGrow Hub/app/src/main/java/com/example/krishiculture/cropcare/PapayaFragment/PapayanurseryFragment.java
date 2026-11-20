package com.example.krishiculture.cropcare.PapayaFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.krishiculture.R;
import com.example.krishiculture.databinding.FragmentBeannpkBinding;
import com.example.krishiculture.databinding.FragmentPapayanurseryBinding;
import com.example.krishiculture.databinding.FragmentPumpkinnurseryBinding;


public class PapayanurseryFragment extends Fragment {
    FragmentPapayanurseryBinding binding;

    public PapayanurseryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentPapayanurseryBinding.inflate(inflater, container, false);

        String rawText = getString(R.string.Papaya_Nursery);
        // Set the formatted text to the TextView
        binding.Papayanurserydetail.setText(rawText);


        return binding.getRoot();
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}