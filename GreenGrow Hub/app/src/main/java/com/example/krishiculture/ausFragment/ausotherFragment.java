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
import com.example.krishiculture.databinding.FragmentAusotherBinding;
import com.example.krishiculture.databinding.FragmentBorootherBinding;


public class ausotherFragment extends Fragment {
    FragmentAusotherBinding binding;



    public ausotherFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAusotherBinding.inflate(inflater, container, false);

        //for video
        WebView webview=binding.ausothervideo;
        String video="<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/JCDf7xXMhRw?si=9DCObjet6hrOBZOm\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" referrerpolicy=\"strict-origin-when-cross-origin\" allowfullscreen></iframe>";
        webview.loadData(video,"text/html","utf-8");
        webview.getSettings().setJavaScriptEnabled(true);
        webview.setWebChromeClient(new WebChromeClient());


        // Get the string from resources
        String rawText = getString(R.string.ausOthers);

        // Format the string using SpannableStringBuilder
        SpannableStringBuilder formattedText = new SpannableStringBuilder(rawText);

        // Apply bold styling programmatically for specific phrases
        applyHeadingStyle(formattedText, "1.Weather Considerations:");
        applyHeadingStyle(formattedText, "2.Pest and Disease Management:");
        applyHeadingStyle(formattedText, "3.Harvesting:");
        applyHeadingStyle(formattedText, "4.Popular Varieties:");

        applyBoldStyling(formattedText, "Season:");
        applyBoldStyling(formattedText, "Temperature Requirements:");
        applyBoldStyling(formattedText, "Germination:");
        applyBoldStyling(formattedText, "Tillering:");
        applyBoldStyling(formattedText, "Ripening:");
        applyBoldStyling(formattedText, "Rainfall: ");
        applyBoldStyling(formattedText, "Weeds:");
        applyBoldStyling(formattedText, "Pests:");
        applyBoldStyling(formattedText, "Diseases:");
        applyBoldStyling(formattedText, "Timing:");
        applyBoldStyling(formattedText, "Moisture Content:");
        applyBoldStyling(formattedText, "Post-Harvest Practices:");

        // Set the formatted text to the TextView
        binding.ausotherdetail.setText(formattedText);

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