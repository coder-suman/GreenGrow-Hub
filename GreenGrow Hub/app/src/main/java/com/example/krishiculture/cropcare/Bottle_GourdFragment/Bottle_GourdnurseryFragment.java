package com.example.krishiculture.cropcare.Bottle_GourdFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.krishiculture.R;
import com.example.krishiculture.databinding.FragmentBeangrowingBinding;
import com.example.krishiculture.databinding.FragmentBottleGourdnurseryBinding;

public class Bottle_GourdnurseryFragment extends Fragment {
    FragmentBottleGourdnurseryBinding binding;


    public Bottle_GourdnurseryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentBottleGourdnurseryBinding.inflate(inflater, container, false);

        String rawText = getString(R.string.Bottle_Gourd_Others);
        // Set the formatted text to the TextView
        binding.BottleGourdnurserydetail.setText(rawText);




        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}