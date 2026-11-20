package com.example.krishiculture.ausFragment;

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
import com.example.krishiculture.databinding.FragmentAusgrowingBinding;
import com.example.krishiculture.databinding.FragmentBorogrowingBinding;


public class ausgrowingFragment extends Fragment {
    FragmentAusgrowingBinding binding;



    public ausgrowingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAusgrowingBinding.inflate(inflater, container, false);

        //for video
        WebView webview=binding.ausgrowingvideo;
        String video="<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/JCDf7xXMhRw?si=9DCObjet6hrOBZOm\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" referrerpolicy=\"strict-origin-when-cross-origin\" allowfullscreen></iframe>";
        webview.loadData(video,"text/html","utf-8");
        webview.getSettings().setJavaScriptEnabled(true);
        webview.setWebChromeClient(new WebChromeClient());


        // Get the string from resources
        String rawText = getString(R.string.ausGrowingpaddy);

        // Format the string using SpannableStringBuilder
        SpannableStringBuilder formattedText = new SpannableStringBuilder(rawText);

        // Apply bold styling programmatically for specific phrases
        applyHeadingStyle(formattedText, "1.Transplanting Age:");
        applyHeadingStyle(formattedText, "2.Spacing:");
        applyHeadingStyle(formattedText, "3.Depth:");
        applyHeadingStyle(formattedText, "4.Irrigation Management:");
        applyHeadingStyle(formattedText, "5.Critical Water Stages:");

        // Set the formatted text to the TextView
        binding.ausgrowingdetail.setText(formattedText);

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