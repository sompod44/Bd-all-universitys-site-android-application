package com.sompod44soft.bduvsites;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class PrivateWebView extends AppCompatActivity {
    public WebView webView;
    public int value;
    public String[] PrivateUniversitys;
    public String[] PrivateUniversitys_sites;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_private_web_view);

        webView = findViewById(R.id.websiteID22);
        PrivateUniversitys = getResources().getStringArray(R.array.Private_University);
        PrivateUniversitys_sites = getResources().getStringArray(R.array.PrivatUniversity_Sites);

        Bundle bundle;
        bundle = getIntent().getExtras();
        try {
            if (bundle != null) {
                value = bundle.getInt("key_value");
            }
        } catch (Exception e) {
            Toast.makeText(this, "I see problem something.", Toast.LENGTH_SHORT).show();
        }

        getSupportActionBar().setTitle(PrivateUniversitys[value]);
        Toast.makeText(this, "Wait until your website is not loading!!!", Toast.LENGTH_LONG).show();

        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(PrivateUniversitys_sites[value]);
    }


    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
