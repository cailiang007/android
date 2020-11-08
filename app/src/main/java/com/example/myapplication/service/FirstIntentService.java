package com.example.myapplication.service;

import android.app.IntentService;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

public class FirstIntentService extends IntentService {
    private final String TAG = "hehe";
    private firstBinder firstBinder = new firstBinder();

    public FirstIntentService() {
        super("FirstIntentService");
    }


    public class firstBinder extends Binder{

    }


    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        if(intent.getStringExtra("param").equals("1")){
            Log.i("FirstIntentService", "开启服务1!");
        }else if(intent.getStringExtra("param").equals("2")){
            Log.i("FirstIntentService", "开启服务2!");
        }else {
            Log.i("FirstIntentService", "开启服务3!");
        }
        //让服务休眠2秒
        try{
            Thread.sleep(2000);
        }catch(InterruptedException e){e.printStackTrace();}
    }

    //重写其他方法,用于查看方法的调用顺序
    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG,"onBind");
        return super.onBind(intent);
    }

    @Override
    public void onCreate() {
        Log.i(TAG,"onCreate");
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG,"onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }


    @Override
    public void setIntentRedelivery(boolean enabled) {
        super.setIntentRedelivery(enabled);
        Log.i(TAG,"setIntentRedelivery");
    }

    @Override
    public void onDestroy() {
        Log.i(TAG,"onDestroy");
        super.onDestroy();
    }

}
