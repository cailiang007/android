package com.example.myapplication.companylist;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.TestAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class CompanyListActivity extends AppCompatActivity {
    public RecyclerView recyclerView;

//
//    private OnCompanyItemClickListener onCompanyItemClickListener= new OnCompanyItemClickListener() {
//        @Override
//        public void onCompanyItemClick(int po) {
//StaggeredGridLayoutManager
//            Toast.makeText(CompanyListActivity.this,po+"",Toast.LENGTH_SHORT).show();
//        }
//    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company);
        recyclerView = findViewById(R.id.rv_company_list);
        Presenter presenter = new Presenter(CompanyListActivity.this);
        presenter.getCompanyList();
    }


}
