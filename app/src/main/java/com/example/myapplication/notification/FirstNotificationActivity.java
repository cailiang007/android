package com.example.myapplication.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;

public class FirstNotificationActivity extends AppCompatActivity implements View.OnClickListener {
    private Context context;
    private NotificationManager manager;
    private Notification notification;
    Bitmap largeBitmap = null;
    private static final int NOTIFIYID_1 = 1;

    private Button btn_show_notification;
    private Button btn_close_notification;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_notification);
        context = FirstNotificationActivity.this;
        //创建大图标的bitmap
        largeBitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.cl);
        manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        bindView();
    }

    private void bindView(){
        btn_show_notification = findViewById(R.id.btn_show_notification);
        btn_close_notification = findViewById(R.id.btn_close_notification);
        btn_show_notification.setOnClickListener(this);
        btn_close_notification.setOnClickListener(this);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_show_notification:
                //定义一个PendingIntent点击Notification后启动一个Activity
                Intent intent = new Intent(context, OtherActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(context,0,intent,0);
                //设置图片,通知标题,发送时间,提示方式等属性
                NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
                builder.setContentTitle("叶良辰")                        //标题
                        .setContentText("我有一百种方法让你呆不下去~")      //内容
                        .setSubText("——记住我叫叶良辰")                    //内容下面的一小段文字
                        .setTicker("收到叶良辰发送过来的信息~")             //收到信息后状态栏显示的文字信息
                        .setWhen(System.currentTimeMillis())           //设置通知时间
                        .setSmallIcon(R.mipmap.test)            //设置小图标
                        .setLargeIcon(largeBitmap)                     //设置大图标
                        .setDefaults(Notification.DEFAULT_LIGHTS | Notification.DEFAULT_VIBRATE)    //设置默认的三色灯与振动器
                        //.setSound(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.biaobiao))  //设置自定义的提示音
                        .setAutoCancel(true)                           //设置点击后取消Notification
                        .setContentIntent(pendingIntent);
                notification = builder.build();
                manager.notify(NOTIFIYID_1,notification);
                Log.e("FirstNotification","start notification");
                break;

            case R.id.btn_close_notification:
                manager.cancel(NOTIFIYID_1);
                break;
        }
    }
}
