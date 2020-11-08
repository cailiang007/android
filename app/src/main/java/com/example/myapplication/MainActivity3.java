package com.example.myapplication;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

public class MainActivity3 extends AppCompatActivity implements View.OnClickListener{
    private Context mContext;
    private NotificationManager mNManager;
    private Notification notify1;
    Bitmap LargeBitmap = null;

    private Button btn_show_normal;
    private Button btn_close_normal;
    private NotificationManager notificationManager;
    String id = "my_channel_01";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notify);
        mContext = MainActivity3.this;
        //创建大图标的Bitmap
        LargeBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.test);
        mNManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        bindView();

    }


    private void bindView() {
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        btn_show_normal = (Button) findViewById(R.id.btn_show_normal);
        //btn_show_normal.setText(bundle.getInt("age")+"");
        btn_close_normal = (Button) findViewById(R.id.btn_close_normal);
       // btn_close_normal.setText(bundle.getString("name"));
        btn_show_normal.setOnClickListener(this);
        btn_close_normal.setOnClickListener(this);
    }


    @TargetApi(Build.VERSION_CODES.O)
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn_show_normal:
                Intent it = new Intent(mContext, otherActivity.class);
                PendingIntent pit = PendingIntent.getActivity(mContext, 0, it, 0);
                String name="我是渠道名字";
                notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                Notification notification = null;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    NotificationChannel mChannel = new NotificationChannel(id, name, NotificationManager.IMPORTANCE_LOW);
                    Toast.makeText(this, mChannel.toString(), Toast.LENGTH_SHORT).show();
                    notificationManager.createNotificationChannel(mChannel);
                    notification = new Notification.Builder(this)
                            .setChannelId(id)
                            .setContentTitle("5 new messages")
                            .setContentText("hahahaggggggg")
                            .setContentIntent(pit)
                            .setSmallIcon(R.mipmap.ic_launcher).build();
                } else {
                    NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
                            .setContentTitle("5 new messages")
                            .setContentText("hahaha")
                            .setContentIntent(pit)
                            .setSmallIcon(R.mipmap.ic_launcher)
                            .setOngoing(true);
                    notification = notificationBuilder.build();
                }
                notificationManager.notify(111123, notification);
              /*  //定义一个PendingIntent点击Notification后启动一个Activity
                Intent it = new Intent(mContext, otherActivity.class);
                PendingIntent pit = PendingIntent.getActivity(mContext, 0, it, 0);
                String id = "my_channel_01";
                //设置图片,通知标题,发送时间,提示方式等属性
                Notification.Builder mBuilder = new Notification.Builder(this);
                mBuilder.setChannelId(id)
                        .setContentTitle("叶良辰")                        //标题
                        .setContentText("我有一百种方法让你呆不下去~")      //内容
                        .setSubText("——记住我叫叶良辰")                    //内容下面的一小段文字
                        .setTicker("收到叶良辰发送过来的信息~")             //收到信息后状态栏显示的文字信息
                        .setWhen(System.currentTimeMillis())           //设置通知时间
                        .setSmallIcon(R.mipmap.test)            //设置小图标
                        .setLargeIcon(LargeBitmap)                     //设置大图标
                        .setDefaults(Notification.DEFAULT_LIGHTS | Notification.DEFAULT_VIBRATE)    //设置默认的三色灯与振动器
                        //.setSound(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.biaobiao))  //设置自定义的提示音
                        .setAutoCancel(true)                           //设置点击后取消Notification
                        .setContentIntent(pit);                        //设置PendingIntent
                notify1 = mBuilder.build();
                mNManager.notify(NOTIFYID_1, notify1);*/
                break;

            case R.id.btn_close_normal:
                //除了可以根据ID来取消Notification外,还可以调用cancelAll();关闭该应用产生的所有通知
                notificationManager.cancelAll();                          //取消Notification
                break;

        }
    }
   /* private Context context;
    private NotificationManager manager;
    private Notification notification;
    Bitmap bitmap = null;
    private static final int NOTIFYID_1 = 1;
    private Button btn_show_normal;
    private Button btn_close_normal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notify);
        context = MainActivity3.this;
        bitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.test);
        manager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);


    }
    private void bindView(){
        btn_show_normal = (Button)findViewById(R.id.button_show);
        btn_close_normal = (Button)findViewById(R.id.button_close);
        btn_show_normal.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,otherActivity.class);
                PendingIntent pendingIntent =PendingIntent.getActivity(context,0,intent,0);
                Notification.Builder builder = new Notification.Builder(context);
                builder.setContentTitle("叶良辰")                        //标题
                        .setContentText("我有一百种方法让你呆不下去~")      //内容
                        .setSubText("——记住我叫叶良辰")                    //内容下面的一小段文字
                        .setTicker("收到叶良辰发送过来的信息~")             //收到信息后状态栏显示的文字信息
                        .setWhen(System.currentTimeMillis())           //设置通知时间
                        .setSmallIcon(R.mipmap.test)            //设置小图标
                        .setLargeIcon(bitmap)                     //设置大图标
                        .setDefaults(Notification.DEFAULT_LIGHTS | Notification.DEFAULT_VIBRATE)    //设置默认的三色灯与振动器
                        //.setSound(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.biaobiao))  //设置自定义的提示音
                        .setAutoCancel(true)                           //设置点击后取消Notification
                        .setContentIntent(pendingIntent);                        //设置PendingIntent
                notification = builder.build();
                manager.notify(NOTIFYID_1, notification);
            }
        });
        btn_close_normal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                manager.cancel(NOTIFYID_1);
            }
        });
    }*/
}
