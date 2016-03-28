package com.coolweather.app.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.coolweather.app.db.CoolWeatherOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mrj on 16/3/28.
 */
public class CoolWeatherDB {

    public  static  final  String DB_NAME = "cool_weather";
    public  static  final  int VERSION = 1;

    public  static  CoolWeatherDB coolWeatherDB;
    public SQLiteDatabase db;

    private  CoolWeatherDB(Context context){
        CoolWeatherOpenHelper weatherOpenHelper = new CoolWeatherOpenHelper(context,DB_NAME,null,VERSION);
        db = weatherOpenHelper.getWritableDatabase();

    }
    public synchronized static  CoolWeatherDB getInstance(Context context){

        if (coolWeatherDB == null){
            coolWeatherDB = new CoolWeatherDB(context);

        }

        return  coolWeatherDB;
    }

    public  void  saveProvince(Province province){

        if (province != null){

            ContentValues values = new ContentValues();
            values.put("province_name",province.getProvinceName());
            values.put("province_code",province.getProvinceCode());
            db.insert("Province",null,values);
        }
    }
    public List<Province> loadProvinces(){

        List<Province> list = new ArrayList<Province>();
        Cursor cursor = db.query("Province",null,null,null,null,null,null);
        if (cursor.moveToFirst()){

            do {
                Province province = new Province();
                province.setId(cursor.getInt(cursor.getColumnIndex("id")));
                province.setProvinceName(cursor.getString(cursor.getColumnIndex("province_name")));
                province.setProvinceCode(cursor.getString(cursor.getColumnIndex("province_code")));
                list.add(province);

            }while (cursor.moveToNext());
        }
        return list;

    }
    public  void  saveCity(City city){

        if(city != null){
            ContentValues values = new ContentValues();
            values.put("city_name",city.getCityName());
            values.put("ciyt_code",city.getCityCode());
            values.put("province_id",city.getId());
            db.insert("City",null,values);
        }
    }
    public  List<City> loadCities(int provinceId){

        List<City> list = new ArrayList<City>();
        Cursor cursor = db.query("City", null, "province_id = ?",
                new String[] { String.valueOf(provinceId) }, null, null, null);
         if (cursor.moveToFirst()) do {
             City city = new City();
             city.setId(cursor.getInt(cursor.getColumnIndex("id")));
             city.setCityName(cursor.getString(cursor.getColumnIndex("city_name")));
             city.setCityCode(cursor.getString(cursor.getColumnIndex("city_code")));
             city.setProvinceId(provinceId);
             list.add(city);
         } while (cursor.moveToNext());
        return list;
    }
    public  void  saveCounty(County county){
        if (county != null){
            ContentValues values = new ContentValues();
            values.put("county_name",county.getContyName());
            values.put("county_code",county.getContyCode());
            db.insert("County",null,values);
        }
    }
    public List<County> loadCounties(int city_id){
        List<County> list = new ArrayList<County>();
        Cursor cursor = db.query("County",null,"city_id=?",new String[]{String.valueOf(city_id)},null,null,null);
        if (cursor.moveToFirst()){
            do {
                County county = new County();
                county.setContyName(cursor.getString(cursor.getColumnIndex("county_name")));
                county.setContyCode(cursor.getString(cursor.getColumnIndex("county_code")));
                county.setCityId(city_id);
                list.add(county);

            }while (cursor.moveToNext());
        }
        return list;
    }
}
