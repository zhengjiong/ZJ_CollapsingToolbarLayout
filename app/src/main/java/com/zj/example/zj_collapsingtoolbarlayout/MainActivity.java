package com.zj.example.zj_collapsingtoolbarlayout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Arrays;
import java.util.List;

/**
 * CollaspingToolbarLayout demo
 *
 * @author zhengjiong
 * @date 2015年06月10日17:48:13
 */
public class MainActivity extends AppCompatActivity {

    private ListView mListView;
    private List<String> mItems = Arrays.asList(
            "基本用法",
            "加入图片视差滚动效果",
            "上滑时AppbarLayout完全隐藏(CollapsingToolbarLayout设置scrollFlags=scroll)",
            "下滑时AppbarLayout立刻显示(CollapsingToolbarLayout设置scrollFlags=scroll|enterAlways)",
            "NestScrollView",
            "demo6",
            "demo7(仿饿了么步骤1)",
            "demo8(仿饿了么步骤2)",
            "demo9(仿饿了么步骤3)",
            "demo10(仿饿了么步骤4)",
            "demo11(仿饿了么最终效果1)",
            "demo12(仿饿了么最终效果2<最好的效果>)",
            "demo13(仿淘宝搜索结果)",
            "demo14(顶部透明渐变效果)",
            "demo15(顶部固定,中间可滑动,下面滑动停靠在顶部下方-方式1)",
            "demo16(顶部固定,中间可滑动,下面滑动停靠在顶部下方-方式2)"
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = (ListView) findViewById(R.id.listview);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                mItems);
        mListView.setAdapter(arrayAdapter);


        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        startActivity(new Intent(MainActivity.this, Demo1.class));
                        break;
                    case 1:
                        startActivity(new Intent(MainActivity.this, Demo2.class));
                        break;
                    case 2:
                        startActivity(new Intent(MainActivity.this, Demo3.class));
                        break;
                    case 3:
                        startActivity(new Intent(MainActivity.this, Demo4.class));
                        break;
                    case 4:
                        startActivity(new Intent(MainActivity.this, Demo5.class));
                        break;
                    case 5:
                        startActivity(new Intent(MainActivity.this, Demo6.class));
                        break;
                    case 6:
                        startActivity(new Intent(MainActivity.this, Demo7.class));
                        break;
                    case 7:
                        startActivity(new Intent(MainActivity.this, Demo8.class));
                        break;
                    case 8:
                        startActivity(new Intent(MainActivity.this, Demo9.class));
                        break;
                    case 9:
                        startActivity(new Intent(MainActivity.this, Demo10.class));
                        break;
                    case 10:
                        startActivity(new Intent(MainActivity.this, Demo11.class));
                        break;
                    case 11:
                        startActivity(new Intent(MainActivity.this, Demo12.class));
                        break;
                    case 12:
                        startActivity(new Intent(MainActivity.this, Demo13TaoBao.class));
                        break;
                    case 13:
                        startActivity(new Intent(MainActivity.this, Demo14.class));
                        break;
                    case 14:
                        startActivity(new Intent(MainActivity.this, Demo15.class));
                        break;
                    case 15:
                        startActivity(new Intent(MainActivity.this, Demo16.class));
                        break;
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
