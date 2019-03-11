package com.sxzx.Presenter;

import com.sxzx.bean.RegBean;
import com.sxzx.bean.SubmitRepairOrderBean;
import com.sxzx.model.SubmitRepairOrderModel;
import com.sxzx.model.registerModel;
import com.sxzx.net.ModelCallBack;
import com.sxzx.view.MyView;

public class RegPresenter {
    registerModel reg = new registerModel();
    MyView.RegView regView;
    public RegPresenter(MyView.RegView regView) {

        this.regView = regView;
    }

    public void getRegData(String emploee_id, String username,String mobile,String email,String password,String password_confirm) {
        reg.geregData(emploee_id,username,mobile,email,password,password_confirm, new ModelCallBack.RegCallBack() {
            @Override
            public void success(RegBean regBean) {
                regView.sucess(regBean);
                System.out.println("注册p数据："+regBean.toString());
            }

            @Override
            public void failed(Throwable code) {
                System.out.println("注册p错误："+code);
            }
        });
    }
}

