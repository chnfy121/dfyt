package com.dfyt.app;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

/**
 * Created by Administrator on 2017/3/3.
 */
public class BaseActivity extends AppCompatActivity {

    private BottomNavigationBar bottomNavigationBar;

    public void onCreate(Bundle savedInstanceState, boolean useToolBar, boolean useBottomNavigationBar) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE); //去掉系统的actionBar
        setContentView(R.layout.activity_base);

        if (useToolBar){
            initToolBar();
        }

        initContextView((LinearLayout)findViewById(R.id.llClient));  //加入继承布局xml

        if (useBottomNavigationBar){
            initBottomNavigationBar(); //底部导航
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE); //去掉系统的actionBar
        setContentView(R.layout.activity_base);

        initToolBar();
        initContextView((LinearLayout)findViewById(R.id.llClient));  //加入继承布局xml
        initBottomNavigationBar(); //底部导航
    }

    protected void initContextView(LinearLayout contextView){

    }

    protected void initToolBar(){
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    protected void initBottomNavigationBar(){
        bottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);

        bottomNavigationBar.addItem(new BottomNavigationItem(R.drawable.bnb_11,"主页").setActiveColorResource(R.color.bottomNavigationItemColor))
                           .addItem(new BottomNavigationItem(R.drawable.bnb_21,"我要投资").setActiveColorResource(R.color.bottomNavigationItemColor))
                           .addItem(new BottomNavigationItem(R.drawable.bnb_31,"我的账户").setActiveColorResource(R.color.bottomNavigationItemColor))
                           .setFirstSelectedPosition(0)
                           //.setMode(BottomNavigationBar.MODE_SHIFTING)
                           //.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_RIPPLE)
                           .initialise();
        bottomNavigationBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener(){
            @Override
            public void onTabSelected(int position) {

            }
            @Override
            public void onTabUnselected(int position) {

            }
            @Override
            public void onTabReselected(int position) {

            }
        });
    }
}
