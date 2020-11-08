package com.example.myapplication.service;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class FirstIntentServiceActivity extends AppCompatActivity {
    private Button button1;
    private Button button2;
    private Button button3;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_intent_service);
        final Intent intent = new Intent(this,FirstIntentService.class);
        Intent it1 = new Intent(this,FirstIntentService.class);
        Bundle b1 = new Bundle();
        b1.putString("param", "1");
        it1.putExtras(b1);

        Intent it2 = new Intent(this,FirstIntentService.class);
        Bundle b2 = new Bundle();
        b2.putString("param", "2");
        it2.putExtras(b2);

        Intent it3 = new Intent(this,FirstIntentService.class);
        Bundle b3 = new Bundle();
        b3.putString("param", "3");
        it3.putExtras(b3);

        //接着启动多次IntentService,每次启动,都会新建一个工作线程
        //但始终只有一个IntentService实例
        startService(it1);
        startService(it2);
        startService(it3);
        /*button1 = findViewById(R.id.btn_first_intent_one);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("key","1");
                startService(intent);
            }
        });
        button2 = findViewById(R.id.btn_first_intent_two);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("key","2");
                startService(intent);
            }
        });
        button3 = findViewById(R.id.btn_first_intent_three);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("key","3");
                startService(intent);
            }
        });*/
    }
}
