package com.example.krishiculture.amonFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

import com.example.krishiculture.R;
import com.example.krishiculture.databinding.FragmentAmonPrenurseryBinding;
import com.example.krishiculture.databinding.FragmentAusprenurseryBinding;


public class amonPrenurseryFragment extends Fragment {
    FragmentAmonPrenurseryBinding binding;


    public amonPrenurseryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAmonPrenurseryBinding.inflate(inflater, container, false);
        //for video1
        WebView webview=binding.amonprenurseryvideo;
        String video="<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/lnYqt9nxxdc?si=EUo_e9lMKcWdwwYl\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" referrerpolicy=\"strict-origin-when-cross-origin\" allowfullscreen></iframe>";
        webview.loadData(video,"text/html","utf-8");
        webview.getSettings().setJavaScriptEnabled(true);
        webview.setWebChromeClient(new WebChromeClient());
        //for video2
        WebView webview2=binding.amonprenurseryvideo2;
        String video2="<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/9dZkytapA68?si=Z-kp7uuox-3LuvoG\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" referrerpolicy=\"strict-origin-when-cross-origin\" allowfullscreen></iframe>";
        webview2.loadData(video2,"text/html","utf-8");
        webview2.getSettings().setJavaScriptEnabled(true);
        webview2.setWebChromeClient(new WebChromeClient());


        // Get the string from resources
        String rawText = getString(R.string.amonPrenursery);

        // Format the string using SpannableStringBuilder
        SpannableStringBuilder formattedText = new SpannableStringBuilder(rawText);

        // Apply bold styling programmatically for specific phrases
        applyHeadingStyle(formattedText, "1.Seed Selection:");
        applyHeadingStyle(formattedText, "2.Seed Treatment:");
        applyHeadingStyle(formattedText, "3.Seedbed Preparation:");
        applyHeadingStyle(formattedText, "4.Area Requirement:");
        applyHeadingStyle(formattedText, "5.Land Preparation:");
        applyHeadingStyle(formattedText, "6.Seed Rate:");
        applyHeadingStyle(formattedText, "7.Water Management:");
        applyHeadingStyle(formattedText, "8.Nutrient Management:");
        applyHeadingStyle(formattedText, "9.Time Frame:");

        // Set the formatted text to the TextView
        binding.amonprenurserydetail.setText(formattedText);

        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


    /**
     * Apply bold styling to specific substrings in the text.
     */
    private void applyBoldStyling(SpannableStringBuilder builder, String substring) {
        int start = builder.toString().indexOf(substring);
        if (start >= 0) {
            int end = start + substring.length();
            builder.setSpan(new StyleSpan(android.graphics.Typeface.BOLD), start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
    }

    //for Apply bold and size styling to specific substrings in the text.
    private void applyHeadingStyle(SpannableStringBuilder builder, String substring) {
        int start = builder.toString().indexOf(substring);
        if (start >= 0) {
            int end = start + substring.length();
            builder.setSpan(new StyleSpan(android.graphics.Typeface.BOLD), start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            builder.setSpan(new RelativeSizeSpan(1.3f), start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); // Increase the font size
        }
    }
}