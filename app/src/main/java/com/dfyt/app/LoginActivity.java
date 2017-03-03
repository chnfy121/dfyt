package com.dfyt.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

/**
 * Created by Administrator on 2017/3/1.
 */
public class LoginActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void initContextView(LinearLayout contextView) {
        super.initContextView(contextView);
        //将activity_main布局加入主布局中
        LayoutInflater layoutInflater = LayoutInflater.from(this);
        contextView.addView(layoutInflater.inflate(R.layout.activity_login,null));
    }
}
