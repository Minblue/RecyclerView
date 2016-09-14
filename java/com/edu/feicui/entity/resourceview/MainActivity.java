package com.edu.feicui.entity.resourceview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.edu.feicui.entity.resourceview.demo_b.DemoBActivity;
import com.edu.feicui.entity.resourceview.demo_c.DemoCActivity;
import com.edu.feicui.entity.resourceview.demo_d.DemoDActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnItemClick;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.listView)
    ListView listView;
    private ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        String[] datas = {
                "RecyclerView基本运用",
                "下拉刷新",
                "上拉加载",
                "视图封装"};
        arrayAdapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, datas);
        listView.setAdapter(arrayAdapter);
    }

    @OnItemClick(R.id.listView)
    void onItemClick(int position) {
        Intent intent = null;
        switch (position) {
            case 0:
                //RecyclerView基本运用
                intent = new Intent(this, DemoAActivity.class);
                startActivity(intent);
                break;
            case 1:
                //上拉刷新
                intent = new Intent(this, DemoBActivity.class);
                startActivity(intent);
                break;
            case 2:
                //下拉加载
                intent = new Intent(this, DemoCActivity.class);
                startActivity(intent);
                break;
            case 3:
                //视图封装
                intent = new Intent(this, DemoDActivity.class);
                startActivity(intent);
                break;
            default:
                throw new RuntimeException("error");
        }
    }
}
