package com.example.mydome_day0717;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.mydome_day0717.Activity.FirstActivity;
import com.example.mydome_day0717.Activity.SecondActivity;
import com.example.mydome_day0717.Activity.ThirdActivity;

public class MainActivity extends AppCompatActivity {
    private ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取资源ID
        listview = findViewById(R.id.listview);
        listview.setAdapter(new ArrayAdapter<String>(this,R.layout.arrayadapter,new String[]{"布局管理器","瀑布流","多条目"}));
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent=null;
                switch (i){
                    case 0:

                        intent= new Intent(MainActivity.this, FirstActivity.class);

                        break;

                    case  1 :
                        intent= new Intent(MainActivity.this,SecondActivity.class);
                        break;

                    case  2:
                        intent= new Intent(MainActivity.this, ThirdActivity.class);
                        break;

                }
                if(intent!=null){
                    startActivity(intent);
                }
            }
        });

    }
}
