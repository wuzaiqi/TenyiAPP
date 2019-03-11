package com.sxzx.net;

import com.sxzx.bean.Cptbean;
import com.sxzx.bean.FAULTSBean;
import com.sxzx.bean.ForgotPasswordBean;
import com.sxzx.bean.GetRepairOrdersListBean;
import com.sxzx.bean.LbBSbean;
import com.sxzx.bean.LoginBean;
import com.sxzx.bean.RegBean;
import com.sxzx.bean.SubmitRepairOrderBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * 网络接口数据的请求类
 */
public interface GetDataInterface {


    //登录的接口
    //http://beta.tengyi.net/api/userLogin
    @FormUrlEncoded
    @POST("/api/userLogin")//这段url将拼在BaseUrl后面
    Observable<LoginBean> login(@FieldMap Map<String,String> map);

    //注册的接口
    //https://www.tenyi.net/api/userRegister
    @FormUrlEncoded
    @POST("/api/userRegister")
    Observable<RegBean> reg(@FieldMap Map<String,String> map);


    //忘记密码的接口
    //https://www.tenyi.net/api/userForgotPassword
    @FormUrlEncoded
    @POST("/api/userForgotPassword")
    Observable<ForgotPasswordBean> forgot(@FieldMap Map<String,String> map);

    //获取机房的接口
    //http://beta.tengyi.net/api/etTeachingBuildings
    @FormUrlEncoded
    @POST("/api/getLabs")//这段url将拼在BaseUrl后面
    Observable<LbBSbean> Lbs(@FieldMap Map<String,String> map);

    //获取设备的接口
    //https://www.tenyi.net/api/getComputers
    @FormUrlEncoded
    @POST("/api/getComputers")//这段url将拼在BaseUrl后面
    Observable<Cptbean> Cpt(@FieldMap Map<String,String> map);

    //获取故障类型列表接口
    //https://www.tenyi.net/api/getFaultsList
    @FormUrlEncoded
    @POST("/api/getFaultsList")//这段url将拼在BaseUrl后面
    Observable<FAULTSBean> FAULTS_List(@FieldMap Map<String,String> map);

    //获取订单列表接口
    //https://www.tenyi.net/api/getRepairOrdersList
    @FormUrlEncoded
    @POST("/api/getRepairOrdersList")//这段url将拼在BaseUrl后面
    Observable<GetRepairOrdersListBean> Get_RepairOrders_List(@FieldMap Map<String,String> map);

    //提交订单接口
    //https://www.tenyi.net/api/submitRepairOrder
    @FormUrlEncoded
    @POST("/api/submitRepairOrder")//这段url将拼在BaseUrl后面
    Observable<SubmitRepairOrderBean> Submit_Repair_Order(@FieldMap Map<String,String> map);



}
