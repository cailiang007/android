package com.example.myapplication;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MyActivity extends AppCompatActivity {
    private Button button1,button2,button3;
    private EditText myText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cl02);
        button1 = (Button)findViewById(R.id.button1);
        button2 = (Button)findViewById(R.id.button2);
        button3 = (Button)findViewById(R.id.button_back);
        myText = (EditText)findViewById(R.id.text_clear);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(button2.getText().equals("清空")){
                    button1.setEnabled(false);
                    myText.setText("");
                }else {
                    button1.setEnabled(true);
                    button2.setText("清空");
                }

            }
        });
        myText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                System.out.println("addTextChangedListener:beforeTextChanged"+s.toString());

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                System.out.println("addTextChangedListener:onTextChanged"+s.toString());

            }

            @Override
            public void afterTextChanged(Editable s) {
                System.out.println("addTextChangedListener:afterTextChanged"+s.toString());
            }
        });
    }
}
