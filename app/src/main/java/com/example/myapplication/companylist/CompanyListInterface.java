package com.example.myapplication.companylist;

import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;

public interface CompanyListInterface {

    @GET("/etm/payTax/getHomePageDetails?time=2020-10")
    Call<CompanyListResponse>  getCompanyList();
}
