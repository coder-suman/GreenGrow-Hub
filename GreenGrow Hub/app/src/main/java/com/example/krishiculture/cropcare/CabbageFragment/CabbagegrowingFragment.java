package com.example.krishiculture.cropcare.CabbageFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.krishiculture.R;
import com.example.krishiculture.databinding.FragmentCabbagegrowingBinding;
import com.example.krishiculture.databinding.FragmentLadisfingergrowingBinding;


public class CabbagegrowingFragment extends Fragment {
    FragmentCabbagegrowingBinding binding;



    public CabbagegrowingFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCabbagegrowingBinding.inflate(inflater, container, false);

        String rawText = getString(R.string.Cabbage_Growing_Process);
        // Set the formatted text to the TextView
        binding.Cabbagegrowingdetail.setText(rawText);



        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}