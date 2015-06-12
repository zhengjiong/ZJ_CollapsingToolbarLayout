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
            "下滑时AppbarLayout立刻显示(CollapsingToolbarLayout设置scrollFlags=scroll|enterAlways)"
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
