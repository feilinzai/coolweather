package com.example.coolweather.db;

import org.litepal.crud.DataSupport;
import org.litepal.crud.LitePalSupport;

public class Province extends LitePalSupport {
    private String provinceName;
    private int provinceCode;
    private int id;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public int getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(int provinceCode) {
        this.provinceCode = provinceCode;
    }


}
