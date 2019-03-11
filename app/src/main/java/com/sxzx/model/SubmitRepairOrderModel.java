package com.sxzx.model;

import android.annotation.SuppressLint;
import android.util.Log;

import com.sxzx.bean.Cptbean;
import com.sxzx.bean.SubmitRepairOrderBean;
import com.sxzx.net.GetDataInterface;
import com.sxzx.net.LoggingInterceptor;
import com.sxzx.net.ModelCallBack;
import com.sxzx.net.RetrofitUnitl;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.https.HttpsUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;

public class SubmitRepairOrderModel {
    @SuppressLint("CheckResult")
    public void getSubmitData(int user_id, String token,int tb_id,int lab_id,String computer_id,int fault_id,String memo,final ModelCallBack.SubmitRepairCallBack callBack){

        //允许访问所有Https
        final HttpsUtils.SSLParams sslParams = HttpsUtils.getSslSocketFactory(null, null, null);
        //使用okhttp请求,添加拦截器时把下面代码解释
        OkHttpClient ok = new OkHttpClient.Builder()
                .connectTimeout(20000, TimeUnit.SECONDS)
                .writeTimeout(20000,TimeUnit.SECONDS)
                .readTimeout(20000,TimeUnit.SECONDS)
                .sslSocketFactory(sslParams.sSLSocketFactory, sslParams.trustManager)//允许访问所有Https
                .addInterceptor(new LoggingInterceptor())
                .build();

        OkHttpUtils.initClient(ok);//允许访问所有Https


        //使用Retrofit结合RxJava，okhttp封装类的单例模式
        Map<String,String> map = new HashMap<>();
        map.put("user_id", String.valueOf(user_id));
        map.put("token",token);
        map.put("tb_id", String.valueOf(tb_id));
        map.put("lab_id", String.valueOf(lab_id));
        map.put("fault_id", String.valueOf(fault_id));
        map.put("computer_id",computer_id);
        map.put("memo",memo);
        Log.d("map", String.valueOf(map));


        RetrofitUnitl.getInstance("https://www.tenyi.net/",ok)//baseUrl必须以/结尾
                .setCreate(GetDataInterface.class)
                .Submit_Repair_Order(map)
                .subscribeOn(Schedulers.io())               //请求完成后在io线程中执行
                .observeOn(AndroidSchedulers.mainThread())  //最后在主线程中执行

                //进行事件的订阅，使用Consumer实现
                .subscribe(new Consumer<SubmitRepairOrderBean>() {
                    @Override
                    public void accept(SubmitRepairOrderBean submitRepairOrderBean) throws Exception {
                        //请求成功时返回数据
                        callBack.success(submitRepairOrderBean);
                        System.out.println("m提交信息：" + submitRepairOrderBean.toString());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        callBack.failed(throwable);
                    }
                });
    }
}
