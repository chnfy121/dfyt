package com.dfyt.app;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by Administrator on 2017/3/3.
 */
public class UserGuideActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_guide);

        WebView webView = (WebView)findViewById(R.id.webView);
        webView.loadUrl("http://mp.weixin.qq.com/s/BromhqNiWq7qQeHP4Jappg");
//        webView.setWebViewClient(new WebViewClient());
        WebSettings webSettings = webView.getSettings();

        webSettings.setAppCacheEnabled(true);//缓存
//        if (Build.VERSION.SDK_INT >= 19) {
//            webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);//缓存
//        }
        webSettings.setJavaScriptEnabled(true);
        webSettings.setBlockNetworkImage(false);
    }
}
