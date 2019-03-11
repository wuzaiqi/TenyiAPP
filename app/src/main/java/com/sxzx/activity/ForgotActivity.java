package com.sxzx.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.qmuiteam.qmui.widget.dialog.QMUITipDialog;
import com.sxzx.Presenter.ForgotPreseter;
import com.sxzx.Presenter.LoginPresenter;
import com.sxzx.bean.ForgotPasswordBean;
import com.sxzx.net.LoginActivity;
import com.sxzx.utils.SharedUtils;
import com.sxzx.view.MyView;
import com.wzq.sxzx.R;


public class ForgotActivity extends AppCompatActivity implements MyView.ForgotView {

    private ForgotPreseter presenter;
    private EditText email;
    private Button email_bt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgot);
        email_bt = findViewById(R.id.forgot_bt);
        email = findViewById(R.id.email_forgot);

        //调用p层
        presenter = new ForgotPreseter(this);

        email_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!TextUtils.isEmpty(email.getText().toString())) {
                    //如果不为空,请求接口
                    presenter.getData(email.getText().toString());
                } else {
                    //Toast.makeText(this, "账号或密码不能为空", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }







    @Override
    public void failed(int code) {

    }

    @Override
    public void sucess(ForgotPasswordBean forgotPasswordBean) {

       // Toast.makeText(this, "忘记密码结果：  " + forgotPasswordBean.getMsg(), Toast.LENGTH_SHORT).show();

        if(forgotPasswordBean.getError_code()==0){
          /*  *//* Thread.sleep(1000);*//*
            Intent intent = new Intent(LoginActivity.this, FragementActivity.class);
            startActivity(intent);
            finish();*/
            Toast.makeText(this, "提交成功！登录邮箱操作！"+forgotPasswordBean.getMsg(), Toast.LENGTH_LONG).show();
            /*QMUITipDialog tipDialog;
            tipDialog = new QMUITipDialog.Builder(ForgotActivity.this)
                    .setIconType(QMUITipDialog.Builder.ICON_TYPE_SUCCESS)
                    .setTipWord("操作成功")
                    .create();
            tipDialog.show();*/

            Intent intent = new Intent(ForgotActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        }else if (forgotPasswordBean.getError_code()!=0){
            Toast.makeText(this, "提交失败！   "+forgotPasswordBean.getMsg()+"   请检查邮箱信息" , Toast.LENGTH_SHORT).show();
        }

    }
}
