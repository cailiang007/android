package com.example.myapplication.companylist;

import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Presenter {

    private CompanyListActivity companyListActivity;

    public Presenter(CompanyListActivity companyListActivity) {
           this.companyListActivity=companyListActivity;
    }

    public void getCompanyList(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://101.133.216.79:8010") //设置网络请求的Url地址
                .addConverterFactory(GsonConverterFactory.create()) //设置数据解析器
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        // 创建 网络请求接口 的实例
        CompanyListInterface request = retrofit.create(CompanyListInterface.class);
        //对 发送请求 进行封装
        Call<CompanyListResponse> call = request.getCompanyList();

        call.enqueue(new Callback<CompanyListResponse>() {
            //请求成功时回调
            @Override
            public void onResponse(Call<CompanyListResponse> call, final Response<CompanyListResponse> response) {
                companyListActivity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        CompanyListResponse body = response.body();
                        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(companyListActivity, RecyclerView.VERTICAL,false);
                        companyListActivity.recyclerView.setLayoutManager(linearLayoutManager);
                        List<Company> list = new ArrayList<>();
                        for (int i = 0; i < 5; i++) {
                            list.add(new Company("公司"+i,i+"",i+""));
                        }
                        CompanyListAdapter companyListAdapter = new CompanyListAdapter(companyListActivity, list);
                        companyListAdapter.setOnCompanyItemClickListener(new OnCompanyItemClickListener() {
                            @Override
                            public void onCompanyItemClick(int position) {
                                Toast.makeText(companyListActivity,position+"",Toast.LENGTH_SHORT).show();
                            }
                        });
                        companyListActivity.recyclerView.setAdapter(companyListAdapter);
                        //请求处理,输出结果
                        System.out.println( "企业信息："+response.body().toString());
                    }
                });
            }
            //请求失败时候的回调
            @Override
            public void onFailure(Call<CompanyListResponse> call, Throwable throwable) {
                System.out.println(throwable);
                System.out.println("连接失败");
            }
        });
    }
}
