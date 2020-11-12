package com.example.myapplication.service;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;

public class FirstTestService extends Service {
    private final String TAG = "TestService1";

    //必须要实现的方法
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG, "onBind方法被调用!");
        return null;
    }

    //Service被创建时调用
    @Override
    public void onCreate() {
        Log.i(TAG, "onCreate方法被调用!");
        Notification.Builder builder = new Notification.Builder(this);
        builder.setContentIntent(PendingIntent.getActivity(this,0,new Intent(this, MainActivity.class),0));
        builder.setAutoCancel(false);
        builder.setSmallIcon(R.mipmap.test);
        builder.setContentTitle("server服务");
        builder.setContentText("正在运行中");
        builder.setTicker("is running");
        startForeground(2,builder.getNotification());
        super.onCreate();
    }

    //Service被启动时调用
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "onStartCommand方法被调用!");
        return super.onStartCommand(intent, flags, startId);
    }

    //Service被关闭之前回调
    @Override
    public void onDestroy() {
        Log.i(TAG, "onDestory方法被调用!");
        super.onDestroy();
    }
}
