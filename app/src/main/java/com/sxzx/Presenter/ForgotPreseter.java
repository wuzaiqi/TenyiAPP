package com.sxzx.Presenter;

import com.sxzx.bean.ForgotPasswordBean;
import com.sxzx.bean.LoginBean;
import com.sxzx.model.ForgotModel;
import com.sxzx.model.LoginModel;
import com.sxzx.net.ModelCallBack;
import com.sxzx.view.MyView;

public class ForgotPreseter {

    ForgotModel forgotModel = new ForgotModel();
    MyView.ForgotView forgotView;
    public ForgotPreseter(MyView.ForgotView forgotView) {
        this.forgotView = forgotView;
    }

    public void getData(String email) {
        forgotModel.getForgotData(email, new ModelCallBack.forgotCallBack() {
            @Override
            public void success(ForgotPasswordBean forgotPasswordBean) {
                forgotView.sucess(forgotPasswordBean);
                System.out.println("忘记密码p数据："+forgotPasswordBean.toString());
            }

           /* @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

            }*/

            @Override
            public void failed(Throwable code) {
                System.out.println("登录p错误："+code);
            }
        });
    }
}
