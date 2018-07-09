package com.example.mlianxi_day0708;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView name = findViewById(R.id.name1);
        TextView sex = findViewById(R.id.sex1);


        Intent intent = getIntent();
        String name1 = intent.getStringExtra("name");
        String sex1 = intent.getStringExtra("sex");

        name.setText(name1);
        sex.setText(sex1);
    }
}
