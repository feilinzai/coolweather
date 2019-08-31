package com.example.coolweather.util;

import android.text.TextUtils;
import android.util.Log;

import com.example.coolweather.db.City;

import com.example.coolweather.db.County;
import com.example.coolweather.db.Province;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Utility {
public static boolean handleProvinceResponse(String response){
    if (!TextUtils.isEmpty(response)){
        try{
            JSONArray allProvince = new JSONArray(response);
            for (int i =0;i<allProvince.length();i++){
                JSONObject provinceObject = allProvince.getJSONObject(i);
                Province province = new Province();
                province.setProvinceName(provinceObject.getString("name"));
                province.setProvinceCode(provinceObject.getInt("id"));
                province.save();
            }
            return true;

        }catch (JSONException e){
            e.printStackTrace();
        }
    }
    return false;
}

public static boolean handleCityResponse(String response,int provinceId){
    if (!TextUtils.isEmpty(response)){
        try{
            JSONArray allCities = new JSONArray(response);
            for (int i = 0;i<allCities.length();i++){
                JSONObject cityObject = allCities.getJSONObject(i);
                City city = new City();
                city.setCityName(cityObject.getString("name"));
                city.setCityCode(cityObject.getInt("id"));
                city.setProvinceId(provinceId);
                city.save();
            }
            return true;
        }catch (JSONException e){
            e.printStackTrace();
        }
    }

    return false;
}
public static boolean handleContyResponse(String response,int cityID){
    if (!TextUtils.isEmpty(response)){
        try {
            JSONArray allconties = new JSONArray(response);
            for (int i =0;i < allconties.length();i++){
                JSONObject countiesObject = allconties.getJSONObject(i);
                County county = new County();
                county.setCountyName(countiesObject.getString("name"));
                county.setWeatherId(countiesObject.getString("weather_id"));
                county.setCityId(cityID);
                county.save();
            }
            return true;
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    return false;
}

}