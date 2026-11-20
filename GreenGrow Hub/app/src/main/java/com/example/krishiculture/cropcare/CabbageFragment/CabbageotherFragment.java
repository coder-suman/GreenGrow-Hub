package com.example.krishiculture.cropcare.CabbageFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.krishiculture.R;
import com.example.krishiculture.databinding.FragmentCabbageotherBinding;
import com.example.krishiculture.databinding.FragmentLadisfingerotherBinding;


public class CabbageotherFragment extends Fragment {
    FragmentCabbageotherBinding binding;

    public CabbageotherFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCabbageotherBinding.inflate(inflater, container, false);

        String rawText = getString(R.string.Cabbage_Others);
        // Set the formatted text to the TextView
        binding.Cabbageotherdetail.setText(rawText);



        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}