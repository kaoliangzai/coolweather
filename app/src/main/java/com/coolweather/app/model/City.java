package com.coolweather.app.model;

/**
 * Created by mrj on 16/3/28.
 */
public class City {
    private  int id;
    private  String cityName;
    private  String cityCode;
    private  int provinceId;

    public  int getId(){

        return id;
    }
    public  void  setId(int id){

        this.id = id;
    }
    public String getCityName(){

        return  cityName;
    }
    public  void  setCityName(String city_name){

        this.cityName = cityName;
    }
    public  String getCityCode(){

        return cityCode;
    }
    public  void  setCityCode(String city_code){

        this.cityCode = cityCode;
    }
    public  int getProvinceId(){
        return provinceId;
    }
    public  void  setProvinceId(int province_id){
        this.provinceId = provinceId;
    }
}
