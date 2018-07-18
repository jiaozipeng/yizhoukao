package com.example.mydome_day0717.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.SimpleAdapter;

import com.example.mydome_day0717.Adapter.ArrayAdapter;
import com.example.mydome_day0717.R;

import java.util.ArrayList;
import java.util.List;

public class FirstActivity extends AppCompatActivity {

    private RecyclerView recycler;
    private List<String> list = new ArrayList<>();

    private ArrayAdapter arrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        //获取资源ID
        recycler = findViewById(R.id.recycler);

        // 创建假数据
        for (int i = 0; i < 1000; i++) {
            list.add("因吹死厅" + i);

        }
        recycler.setLayoutManager(new LinearLayoutManager(this));
        arrayAdapter = new ArrayAdapter(this,list);
        recycler.setAdapter(arrayAdapter);
    }
    public  void getlist(View v){
        recycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        arrayAdapter.notifyDataSetChanged();
    }
    public void getgird(View v){
        recycler.setLayoutManager(new GridLayoutManager(this,3));
        arrayAdapter.notifyDataSetChanged();

    }
    public void single(View v){
        recycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        arrayAdapter.notifyDataSetChanged();
    }

    public void mutple(View v){

        recycler.setLayoutManager(new GridLayoutManager(this,3,LinearLayoutManager.HORIZONTAL,false));
        arrayAdapter.notifyDataSetChanged();
    }
}
