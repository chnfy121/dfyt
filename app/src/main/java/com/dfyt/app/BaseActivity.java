package com.dfyt.app;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.ActivityManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
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
    private Boolean useBackButton = true; //主页禁用返回按钮事件

    public Boolean getUseBackButton() {
        return useBackButton;
    }
    public void setUseBackButton(Boolean useBackButton) {
        this.useBackButton = useBackButton;
    }

    public BottomNavigationBar getBottomNavigationBar() {
        return bottomNavigationBar;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE); //去掉系统的actionBar

        initContentView();
        initToolBar();
        initClientView((LinearLayout)findViewById(R.id.llClient));  //加入继承布局xml
        initBottomNavigationBar(); //底部导航
    }

    //加载主布局
    protected void initContentView(){
        setContentView(R.layout.activity_base);
    }

    //主布局下Clinet布局
    protected void initClientView(LinearLayout clientView){

    }

    //toolbar导航
    protected void initToolBar(){
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(useBackButton){
                    onBackPressed();
                }
            }
        });
    }

    //底部导航
    protected void initBottomNavigationBar(){
        bottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);
        bottomNavigationBar.setVisibility(View.VISIBLE);

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
                switch (position){
                    case 0:
                        if(useBackButton){
                            onBackPressed();
                        }
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                }
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
