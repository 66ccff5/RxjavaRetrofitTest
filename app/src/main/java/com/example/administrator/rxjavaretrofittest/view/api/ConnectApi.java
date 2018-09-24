package com.example.administrator.rxjavaretrofittest.view.api;

import com.example.administrator.rxjavaretrofittest.view.bean.Translation;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Administrator on 2018/9/19 0019.
 */

public interface ConnectApi {

    @POST("translate?doctype=json&jsonversion=&type=&keyfrom=&model=&mid=&imei=&vendor=&screen=&ssid=&network=&abtest=")
    @FormUrlEncoded
    rx.Observable<Translation> getCall(@Field("i") String targetSentence);

}
