package com.example.myapplication.service;

import android.app.Activity;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapplication.R;

public class SecondServiceActivity extends Activity {
    private Button btnbind;
    private Button btncancel;
    private Button btnstatus;

    //保持所启动的Service的IBinder对象,同时定义一个ServiceConnection对象
    SecondTestService.MyBinder binder;
    private ServiceConnection conn = new ServiceConnection() {

        //Activity与Service断开连接时回调该方法
        @Override
        public void onServiceDisconnected(ComponentName name) {
            System.out.println("------Service DisConnected-------");
        }

        //Activity与Service连接成功时回调该方法
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            System.out.println("------Service Connected-------");
            binder = (SecondTestService.MyBinder) service;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_test_service);
        btnbind = (Button) findViewById(R.id.btn_first_service_bind);
        btncancel = (Button) findViewById(R.id.btn_first_service_cancel);
        btnstatus  = (Button) findViewById(R.id.btn_first_service_status);
        final Intent intent = new Intent(this,SecondTestService.class);
        //intent.setAction("com.jay.example.service.TEST_SERVICE2");
        btnbind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //绑定service
                bindService(intent, conn, Service.BIND_AUTO_CREATE);
            }
        });

        btncancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //解除service绑定
                unbindService(conn);
            }
        });

        btnstatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Service的count的值为:"
                        + binder.getCount()+binder.getCompany().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
