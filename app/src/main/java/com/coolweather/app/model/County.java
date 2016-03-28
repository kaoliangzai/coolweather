package com.coolweather.app.model;

/**
 * Created by mrj on 16/3/28.
 */
public class County {

    private  int id;
    private  String contyName;
    private  String contyCode;
    private  int cityId;

    public int getId(){
        return id;
    }
    public  void  setId(int id){
        this.id = id;
    }

    public String getContyName(){

        return contyName;
    }
    public void  setContyName(String  contyName){
        this.contyName = contyName;
    }
    public  String getContyCode(){

        return contyCode;
    }
    public  void  setContyCode(String contyCode){
        this.contyCode = contyCode;
    }
    public int getCityId(){

        return cityId;
    }
    public  void  setCityId(int cityId){

        this.cityId = cityId;
    }
}
