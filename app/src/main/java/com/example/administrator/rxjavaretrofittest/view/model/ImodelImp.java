package com.example.administrator.rxjavaretrofittest.view.model;

import com.example.administrator.rxjavaretrofittest.view.api.ConnectApi;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2018/9/19 0019.
 */


//在model中连接网络
public class ImodelImp implements IModel {

    @Override
    public ConnectApi getData(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://fanyi.youdao.com/") // 设置 网络请求 Url
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create()) //设置使用Gson解析(记得加入依赖)
                .build();

        // 步骤5:创建 网络请求接口 的实例
        ConnectApi request = retrofit.create(ConnectApi.class);
        //对 发送请求 进行封装(设置需要翻译的内容)
        return request;
    }


}
