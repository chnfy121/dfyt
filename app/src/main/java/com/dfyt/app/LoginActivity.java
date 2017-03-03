package com.dfyt.app;

import android.os.Bundle;
import android.support.design.internal.BottomNavigationItemView;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import com.ashokvarma.bottomnavigation.BottomNavigationBar;

/**
 * Created by Administrator on 2017/3/1.
 */
public class LoginActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //设置导航栏Item未选中
        getBottomNavigationBar().setFirstSelectedPosition(-1);
        getBottomNavigationBar().initialise();
    }

    @Override
    protected void initClientView(LinearLayout clientView) {
        super.initClientView(clientView);
        //将activity_main布局加入主布局中
        LayoutInflater layoutInflater = LayoutInflater.from(this);
        clientView.addView(layoutInflater.inflate(R.layout.activity_login,null));
    }
}
