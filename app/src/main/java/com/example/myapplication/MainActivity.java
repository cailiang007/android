package com.example.myapplication;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.bitmap.BitMapActivity;
import com.example.myapplication.broadcastReceiver.MyFirstReceiver;
import com.example.myapplication.companylist.CompanyListActivity;
import com.example.myapplication.notification.FirstNotificationActivity;
import com.example.myapplication.service.FirstIntentServiceActivity;
import com.example.myapplication.service.FirstServiceActivity;
import com.example.myapplication.service.SecondServiceActivity;
import com.example.myapplication.viewpager.OneActivity;

public class MainActivity extends AppCompatActivity {
    MyFirstReceiver myFirstReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myFirstReceiver = new MyFirstReceiver();
        IntentFilter intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        registerReceiver(myFirstReceiver,intentFilter);
        Button button = findViewById(R.id.btn_recyclerview);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,RecyclerViewActivity.class));
            }
        });

        Button button1 = findViewById(R.id.btn_company);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CompanyListActivity.class));
            }
        });
        Button button2 = findViewById(R.id.btn_first_service);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, FirstServiceActivity.class));
            }
        });

        Button button3 = findViewById(R.id.btn_second_service);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SecondServiceActivity.class));
            }
        });

        Button button4 = findViewById(R.id.btn_first_intent_service);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, FirstIntentServiceActivity.class));
            }
        });

        Button button5 = findViewById(R.id.btn_first_notification_service);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, FirstNotificationActivity.class));
            }
        });

        Button button6 = findViewById(R.id.btn_first_viewpager);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, OneActivity.class));
            }
        });

        Button button7 = findViewById(R.id.btn_first_bitmap);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, BitMapActivity.class));
            }
        });

    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        myFirstReceiver.getDebugUnregister();
    }
}
