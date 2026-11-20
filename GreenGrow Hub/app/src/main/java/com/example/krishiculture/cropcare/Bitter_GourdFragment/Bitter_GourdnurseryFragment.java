package com.example.krishiculture.cropcare.Bitter_GourdFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.krishiculture.R;
import com.example.krishiculture.databinding.FragmentBeangrowingBinding;
import com.example.krishiculture.databinding.FragmentBitterGourdnurseryBinding;

public class Bitter_GourdnurseryFragment extends Fragment {
    FragmentBitterGourdnurseryBinding binding;


    public Bitter_GourdnurseryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentBitterGourdnurseryBinding.inflate(inflater, container, false);

        String rawText = getString(R.string.Bitter_Gourd_Nursery);
        // Set the formatted text to the TextView
        binding.BitterGourdnurserydetail.setText(rawText);



        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}