package com.dfyt.app;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import com.ashokvarma.bottomnavigation.BottomNavigationBar;

/**
 * Created by Administrator on 2017/3/3.
 */
public class UserGuideActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initWebView();
    }

    @Override
    protected void initBottomNavigationBar() {
        //禁用底部导航
        //findViewById(R.id.bottom_navigation_bar).setVisibility(View.GONE);
    }

    @Override
    protected void initClientView(LinearLayout clientView) {
        super.initClientView(clientView);
        //将activity_main布局加入主布局中
        LayoutInflater layoutInflater = LayoutInflater.from(this);
        clientView.addView(layoutInflater.inflate(R.layout.activity_user_guide,null));
    }

    private void initWebView(){
        WebView webView = (WebView)findViewById(R.id.index_webView);
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
