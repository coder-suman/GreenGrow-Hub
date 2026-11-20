package com.example.krishiculture.boroFragment;

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
import com.example.krishiculture.databinding.FragmentBoronpkfertilizerBinding;
import com.example.krishiculture.databinding.FragmentBoroprenurseryBinding;


public class boronpkfertilizerFragment extends Fragment {
    FragmentBoronpkfertilizerBinding binding;


    public boronpkfertilizerFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentBoronpkfertilizerBinding.inflate(inflater, container, false);
        //for video
        WebView webview=binding.boronpkfertilizervideo;
        String video="<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/gwdi_xjBXeA?si=si3dyTOcf3QozewZ\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" referrerpolicy=\"strict-origin-when-cross-origin\" allowfullscreen></iframe>";
        webview.loadData(video,"text/html","utf-8");
        webview.getSettings().setJavaScriptEnabled(true);
        webview.setWebChromeClient(new WebChromeClient());

        // Get the string from resources
        String rawText = getString(R.string.boroNPKfertilizer);

        // Format the string using SpannableStringBuilder
        SpannableStringBuilder formattedText = new SpannableStringBuilder(rawText);

        // Apply bold styling programmatically for specific phrases
        applyHeadingStyle(formattedText, "1.Soil Type:");
        applyHeadingStyle(formattedText, "2.Soil pH:");
        applyHeadingStyle(formattedText, "3.Fertilizer Application:");
        applyBoldStyling(formattedText, "Organic Manure:");
        applyBoldStyling(formattedText, "Chemical Fertilizers:");
        applyBoldStyling(formattedText, "Nitrogen (Urea):");
        applyBoldStyling(formattedText, "Phosphorus (P₂O₅):");
        applyBoldStyling(formattedText, "Potassium (K₂O): ");
        applyBoldStyling(formattedText, "Zinc (ZnSO₄):");


        // Set the formatted text to the TextView
        binding.boronpkfertilizerdetail.setText(formattedText);

        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

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