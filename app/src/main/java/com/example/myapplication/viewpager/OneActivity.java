package com.example.myapplication.viewpager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.myapplication.R;

import java.util.ArrayList;

public class OneActivity extends AppCompatActivity {
    private ViewPager vpager_one;
    private ArrayList<View> aList;
    private MyPagerAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vpager_one = (ViewPager) findViewById(R.id.vpager_one);
        aList = new ArrayList<>();
        LayoutInflater inflater = getLayoutInflater();
        aList.add(inflater.inflate(R.layout.view_one,null,false));
        aList.add(inflater.inflate(R.layout.view_two,null,false));
        aList.add(inflater.inflate(R.layout.view_tree,null,false));
        mAdapter = new MyPagerAdapter(aList);
        vpager_one.setAdapter(mAdapter);
    }
}
