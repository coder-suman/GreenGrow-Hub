package com.example.krishiculture.cropcare.Bottle_GourdFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.krishiculture.R;
import com.example.krishiculture.databinding.FragmentBeangrowingBinding;
import com.example.krishiculture.databinding.FragmentBottleGourdgrowingBinding;

public class Bottle_GourdgrowingFragment extends Fragment {
    FragmentBottleGourdgrowingBinding binding;


    public Bottle_GourdgrowingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentBottleGourdgrowingBinding.inflate(inflater, container, false);

        String rawText = getString(R.string.Bottle_Gourd_Growing_Process);
        // Set the formatted text to the TextView
        binding.BottleGourdgrowingdetail.setText(rawText);

        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}