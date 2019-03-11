package com.sxzx.view;

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
 * 2. View 层 数据展示类
 * View – 用户界面：View通常是指Activity、Fragment或者某个View控件，它含有一个Presenter成员变量。
 通常View需要实现一个逻辑接口，将View上的操作转交给Presenter进行实现，
 最后，Presenter 调用View逻辑接口将结果返回给View元素。
 */

public interface MyView {

    //登录页面由presenter层交互数据到view层MainActivity
    public interface LoginView{
        //登录时，数据获取成功的方法，返回一个值表示登陆成功
        void success(LoginBean loginBean);
        //登录时，数据获取失败的方法，返回一个int值响应码表示登陆失败
        void failed(int code);
    }

    //注册页面由presenter层到view层RegActivity
    public interface RegView{

        void failed(int code);
        void sucess(RegBean regBean);
    }

    public interface ForgotView{
        void failed(int code);
        void sucess(ForgotPasswordBean forgotPasswordBean);
    }


    public interface TBSView{
        void failed(int code);
        void sucess(LbBSbean LbsBean);
    }

    public interface CPTView{
        void failed(int code);
        void sucess(Cptbean cptbean);
    }

    public interface FAULTSView{
        void failed(int code);
        void sucess(FAULTSBean FAULTSList);
    }

    public interface GetRepairView{
        void failed(int code);
        void sucess(GetRepairOrdersListBean GetRepair);
    }

    public interface SubmitRepairView{
        void failed(int code);
        void sucess(SubmitRepairOrderBean SubmitRepair);
    }

}
