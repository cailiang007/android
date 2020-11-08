package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cl10);
        Button button = (Button)findViewById(R.id.btnpost);
        final RadioGroup radioGroup = (RadioGroup)findViewById(R.id.radioGroup);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i <radioGroup.getChildCount() ; i++) {
                    RadioButton radioButton = (RadioButton)radioGroup.getChildAt(i);
                    if(radioButton.isChecked()){
                        Toast.makeText(getApplicationContext(),"按钮组值发生改变,你选了" +radioButton.getText(),Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
        Button button1 = (Button)findViewById(R.id.btnpost1);
        final CheckBox box1 = (CheckBox)findViewById(R.id.box1);
        final CheckBox box2 = (CheckBox)findViewById(R.id.box2);
        CheckBox box3 = (CheckBox)findViewById(R.id.box3);
        CheckBox box4 = (CheckBox)findViewById(R.id.box4);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(box1.isChecked()){
                    Toast.makeText(getApplicationContext(),"按钮组值发生改变,你选了" +box1.getText(),Toast.LENGTH_LONG).show();
                }
                if(box2.isChecked()){
                    Toast.makeText(getApplicationContext(),"按钮组值发生改变,你选了" +box2.getText(),Toast.LENGTH_LONG).show();
                }

            }
        });
       /* radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = (RadioButton)findViewById(checkedId);
                Toast.makeText(getApplicationContext(),"按钮组值发生改变,你选了" +radioButton.getText(),Toast.LENGTH_LONG).show();
            }
        });*/

    }

    @Override
    protected void onStart() {
        super.onStart();
    }
}
