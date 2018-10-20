package com.sompod44soft.bduvsites;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class PublicWebView extends AppCompatActivity {
public WebView webView;
public int value;
public String[] PublicUniversitys;
    public String[] PublicUniversitys_Sites;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_public_web_view);

        webView = findViewById(R.id.websiteID11);
        PublicUniversitys = getResources().getStringArray(R.array.public_universitys);
        PublicUniversitys_Sites = getResources().getStringArray(R.array.publicUiversity_sites);


        Bundle bundle;
        bundle = getIntent().getExtras();
        try {
            if (bundle != null) {
                value = bundle.getInt("key_value");
            }
        } catch (Exception e) {
            Toast.makeText(this, "I see problem something.", Toast.LENGTH_SHORT).show();
        }

        getSupportActionBar().setTitle(PublicUniversitys[value]);

        Toast.makeText(this, "Wait until your website is not loading!!!", Toast.LENGTH_LONG).show();

            webView.getSettings().setJavaScriptEnabled(true);
            webView.setWebViewClient(new WebViewClient());
            webView.loadUrl(PublicUniversitys_Sites[value]);


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
