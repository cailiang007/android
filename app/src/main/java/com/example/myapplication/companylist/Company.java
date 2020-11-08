package com.example.myapplication.companylist;

import java.util.Date;

public class Company {
    private String companyName;
    private String createTime;
    private String merchantsYear;

    public Company(String companyName, String createTime, String merchantsYear) {
        this.companyName = companyName;
        this.createTime = createTime;
        this.merchantsYear = merchantsYear;
    }

    @Override
    public String toString() {
        return "Company{" +
                "companyName='" + companyName + '\'' +
                ", createTime='" + createTime + '\'' +
                ", merchantsYear='" + merchantsYear + '\'' +
                '}';
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getMerchantsYear() {
        return merchantsYear;
    }

    public void setMerchantsYear(String merchantsYear) {
        this.merchantsYear = merchantsYear;
    }
}
