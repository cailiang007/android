package com.example.myapplication.listview;

import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

import java.util.List;

public class AnimalActivity extends AppCompatActivity {

    private Context mContext;
    private List<Animal> mData;
    private ListView listView;
    private AnimalAdapter animalAdapter = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = AnimalActivity.this;
        listView = findViewById(R.id.list_animal);

    }
}
