package com.sxzx.Presenter;

// Presenter层，进行view层与model数据的交互

import com.sxzx.bean.LoginBean;
import com.sxzx.model.LoginModel;
import com.sxzx.net.ModelCallBack;
import com.sxzx.view.MyView;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;

/**
 * 登录p层
 */

public class LoginPresenter {

    LoginModel loginModel = new LoginModel();
    MyView.LoginView loginView;
    public LoginPresenter(MyView.LoginView loginView) {
        this.loginView = loginView;
    }

    public void getData(String username, String password) {
        loginModel.getLoginData(username,password, new ModelCallBack.LoginCallBack() {
            @Override
            public void success(LoginBean dengluBean) {
                loginView.success(dengluBean);
                System.out.println("登录p数据："+dengluBean.toString());
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
