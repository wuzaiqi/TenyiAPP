package com.sxzx.net;


import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Retrofit+Rxjava+OkHttp 单例模式+双重锁模式 封装类
 */

public class RetrofitUnitl {

    private Retrofit mRetrofit;
    private String baseUrl;
    OkHttpClient client;
    private static RetrofitUnitl mRetrofitManager;


    private RetrofitUnitl(String baseUrl,OkHttpClient client){
        this.baseUrl=baseUrl;
        this.client=client;
        initRetrofit();
    }

    //单例模式+双重锁模式 封装方法
    public static synchronized RetrofitUnitl getInstance(String baseUrl,OkHttpClient client){
        if (mRetrofitManager == null){
            mRetrofitManager = new RetrofitUnitl(baseUrl,client);
        }
        return mRetrofitManager;
    }

    //创建Retrofit请求实例化
    private void initRetrofit() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())//这个方法是利用gson网络解析json字符串
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())//添加一个RxJava适配器
                .client(client)
                .build();


    }

    //封装泛型方法
    public <T> T setCreate(Class<T> reqServer) {
        return mRetrofit.create(reqServer);
    }

}
