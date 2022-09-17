package com.msbteapp.msbtewallah.ui.gallery;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.msbteapp.msbtewallah.R;
import com.msbteapp.msbtewallah.databinding.FragmentGalleryBinding;

public class GalleryFragment extends Fragment {

    ShimmerFrameLayout shimmerFrameLayout;

    SwipeRefreshLayout swipe;
    ProgressBar progressBar;

    WebView webView;

    private FragmentGalleryBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gallery, container, false);

        shimmerFrameLayout = view.findViewById(R.id.shimmer_website);
        shimmerFrameLayout.startShimmer();

        swipe = view.findViewById(R.id.swipe);

        progressBar = view.findViewById(R.id.pbar);
        progressBar.setMax(100);

        webView = view.findViewById(R.id.msbteWebView);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://msbte.org.in/");

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        progressBar.setProgress(0);

        webView.setWebChromeClient(new WebChromeClient(){

            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                progressBar.setProgress(newProgress);
                if (newProgress >= 50){
                    shimmerFrameLayout.stopShimmer();
                    shimmerFrameLayout.setVisibility(View.GONE);
                    swipe.setVisibility(View.VISIBLE);
                }

                if (newProgress == 100){
                    progressBar.setVisibility(View.INVISIBLE);
                    shimmerFrameLayout.stopShimmer();
                    shimmerFrameLayout.setVisibility(View.GONE);
                    swipe.setVisibility(View.VISIBLE);
                }else{
                    progressBar.setVisibility(View.VISIBLE);
                }
                super.onProgressChanged(view, newProgress);
            }
        });

        webView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() == keyEvent.ACTION_DOWN){
                    if (i == KeyEvent.KEYCODE_BACK){
                        if (webView.canGoBack()){
                            webView.goBack();
                        }else{
                            getActivity().onBackPressed();
                        }
                    }
                }
                return true;
            }
        });

        swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                webView.reload();
                swipe.setRefreshing(false);
            }
        });

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}