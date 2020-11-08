package com.example.myapplication.bitmap;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class BitMapActivity extends AppCompatActivity {
    private ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bitmap_one);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.cl);
        Bitmap bitmap1 = bitmap.createBitmap(bitmap,200,200,200,300);
        Bitmap bitmap2 = bitmap.createScaledBitmap(bitmap,300,300,true);
        imageView = findViewById(R.id.iv_bit_one);
        imageView.setImageBitmap(bitmap2);

    }
}


