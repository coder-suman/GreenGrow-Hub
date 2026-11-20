package com.example.krishiculture.cropcare.BeanFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.krishiculture.R;
import com.example.krishiculture.databinding.FragmentBeannurseryBinding;
import com.example.krishiculture.databinding.FragmentBringelgrowingBinding;


public class BeannurseryFragment extends Fragment {
    FragmentBeannurseryBinding binding;


    public BeannurseryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentBeannurseryBinding.inflate(inflater, container, false);

        String rawText = getString(R.string.Beans_Nursery);
        // Set the formatted text to the TextView
        binding.Beannurserydetail.setText(rawText);



        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}