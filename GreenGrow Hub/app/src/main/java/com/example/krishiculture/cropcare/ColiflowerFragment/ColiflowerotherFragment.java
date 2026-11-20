package com.example.krishiculture.cropcare.ColiflowerFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.krishiculture.R;
import com.example.krishiculture.databinding.FragmentCabbageotherBinding;
import com.example.krishiculture.databinding.FragmentColiflowerotherBinding;

public class ColiflowerotherFragment extends Fragment {
    FragmentColiflowerotherBinding binding;


    public ColiflowerotherFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentColiflowerotherBinding.inflate(inflater, container, false);

        String rawText = getString(R.string.Cauliflower_others);
        // Set the formatted text to the TextView
        binding.Coliflowerotherdetail.setText(rawText);




        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}