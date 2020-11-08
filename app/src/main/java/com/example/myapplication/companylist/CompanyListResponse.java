package com.example.myapplication.companylist;

import java.util.List;

public class CompanyListResponse {
    public int total;
    public List<Company> rows;

    @Override
    public String toString() {
        return "CompanyListResponse{" +
                "total=" + total +
                ", rows=" + rows +
                '}';
    }
}
