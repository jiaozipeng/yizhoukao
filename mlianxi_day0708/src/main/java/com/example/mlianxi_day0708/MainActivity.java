package com.example.mlianxi_day0708;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText name;
    private EditText sex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        sex = findViewById(R.id.sex);

        Button but = findViewById(R.id.but_01);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(new Intent().setClass(MainActivity.this,Main2Activity.class));

                String text = name.getText().toString();
                String text1 = sex.getText().toString();

                Intent intent = new Intent();
                intent.putExtra("name",text);
                intent.putExtra("sex",text1);
                intent.setClass(MainActivity.this,Main2Activity.class);
                startActivity(intent);

            }
        });



    }
}
