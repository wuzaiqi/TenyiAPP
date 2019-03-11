package com.sxzx.net;

import com.sxzx.bean.Cptbean;
import com.sxzx.bean.FAULTSBean;
import com.sxzx.bean.ForgotPasswordBean;
import com.sxzx.bean.GetRepairOrdersListBean;
import com.sxzx.bean.LbBSbean;
import com.sxzx.bean.LoginBean;
import com.sxzx.bean.RegBean;
import com.sxzx.bean.SubmitRepairOrderBean;

/**
 * MVP的三层编写步骤：
 * 1. 先写model层接口类，进行数据的存取
 */

public interface ModelCallBack {
    public interface LoginCallBack{

        //登录时，数据获取成功的方法，返回一个值表示登陆成功
        public void success(LoginBean loginBean);

        /*public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response);*/

        //登录时，数据获取失败的方法，返回一个int响应码表示登陆失败
        public void failed(Throwable code);
    }


    public interface RegCallBack {
        //注册时，数据获取成功的方法，返回一个值表示登陆成功
        public void success(RegBean regBean);
        //注册时，数据获取失败的方法，返回一个int值响应码表示登陆失败
        public void failed(Throwable code);
    }

    public interface forgotCallBack {
        //忘记密码时，数据获取成功的方法，返回一个值表示登陆成功
        public void success(ForgotPasswordBean forgotPasswordBean);
        //忘记密码时，数据获取失败的方法，返回一个int值响应码表示登陆失败
        public void failed(Throwable code);
    }

    public interface LBSCallBack{
        //机房数据获取成功的方法，返回一个值表示登陆成功
        public void success(LbBSbean lbBSbean);
        //机房数据获取失败的方法，返回一个int值响应码表示登陆失败
        public void failed(Throwable code);
    }

    public interface CPTCallBack{
        //设备数据获取成功的方法，返回一个值表示登陆成功
        public void success(Cptbean cptbean);
        //设备数据获取失败的方法，返回一个int值响应码表示登陆失败
        public void failed(Throwable code);
    }

    public interface FaultsCallBack{
        //故障类型数据获取成功的方法，返回一个值表示登陆成功
        public void success(FAULTSBean faultsBean);
        //故障类型数据获取失败的方法，返回一个int值响应码表示登陆失败
        public void failed(Throwable code);
    }

    public interface GetRepairCallBack{
        //订单数据获取成功的方法，返回一个值表示登陆成功
        public void success(GetRepairOrdersListBean getRepairOrdersListBean);
        //订单数据获取失败的方法，返回一个int值响应码表示登陆失败
        public void failed(Throwable code);
    }

    public interface SubmitRepairCallBack{
        //提交订单数据获取成功的方法，返回一个值表示登陆成功
        public void success(SubmitRepairOrderBean submitRepairOrderBean);
        //提交订单数据获取失败的方法，返回一个int值响应码表示登陆失败
        public void failed(Throwable code);
    }




}
