package com.dfyt.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private int[] imageRes = { R.drawable.gv_1, R.drawable.gv_2,
            R.drawable.gv_3, R.drawable.gv_4, R.drawable.gv_5,
            R.drawable.gv_6, R.drawable.gv_7, R.drawable.gv_8,
            R.drawable.gv_9};

    private String[] names  = { "注册账户", "立即登录", "新手指引", "我要投资", "立即充值", "我的账户", "帮助中心",
            "联系我们", "活动中心"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

//        Button btnLogin = (Button) findViewById(R.id.btnLogin);
//        btnLogin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent();
//                intent.setClass(MainActivity.this,LoginActivity.class);
//                startActivity(intent);
//                //overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
//            }
//        });
        initGridView();
    }

    private void initGridView(){
        GridView gridview = (GridView) findViewById(R.id.gridView);
        int length = imageRes.length;
        //生成动态数组，并且转入数据
        ArrayList<HashMap<String, Object>> lstImageItem = new ArrayList<HashMap<String, Object>>();
        for (int i = 0; i < length; i++) {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("ItemImage", imageRes[i]);//添加图像资源的ID
            map.put("ItemText", names[i]);//按序号做ItemText
            lstImageItem.add(map);
        }
        //生成适配器的ImageItem 与动态数组的元素相对应
        SimpleAdapter saImageItems = new SimpleAdapter(this,
                lstImageItem,//数据来源
                R.layout.layout_dfyt_gridview_item,//item的XML实现

                //动态数组与ImageItem对应的子项
                new String[]{"ItemImage", "ItemText"},

                //ImageItem的XML文件里面的一个ImageView,两个TextView ID
                new int[]{R.id.item_img, R.id.item_text});
        //添加并且显示
        gridview.setAdapter(saImageItems);
        //添加消息处理
        gridview.setOnItemClickListener(new DfytOnTemClickListener());
    }

    class DfytOnTemClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            //Toast.makeText(MainActivity.this,names[position],Toast.LENGTH_LONG).show();

           switch (position){
               case 1:{
                   Intent loginIntent = new Intent(MainActivity.this, LoginActivity.class);
                   startActivity(loginIntent);
                   break;
               }
               case 2:{
                   Intent userGuidIntent = new Intent(MainActivity.this, UserGuideActivity.class);
                   startActivity(userGuidIntent);
               }
           }
        }
    }
}
