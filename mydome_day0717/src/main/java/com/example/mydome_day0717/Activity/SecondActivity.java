package com.example.mydome_day0717.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.example.mydome_day0717.Adapter.WaterAdapter;
import com.example.mydome_day0717.R;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {

    private RecyclerView recyclerview;
    private List<String> list = new ArrayList<>();
    private WaterAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        //获取资源
        recyclerview = findViewById(R.id.recyclerview);
        //创建数据源
        for (int i =0;i<1000;i++){
            list.add("因吹斯听"+i);
        }
        recyclerview.setLayoutManager(new StaggeredGridLayoutManager(3, OrientationHelper.VERTICAL));
        adapter = new WaterAdapter(this,list);
        recyclerview.setAdapter(adapter);

        recyclerview.setItemAnimator(new DefaultItemAnimator());



    }

    public void add(View view){

        list.add(5,"呕死吹列");
        adapter.notifyDataSetChanged();
    }

    public void remove(View view){
        list.remove(5);
        adapter.notifyDataSetChanged();

    }
}
