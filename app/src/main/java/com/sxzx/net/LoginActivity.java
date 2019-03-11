package com.sxzx.net;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.Toast;

import com.sxzx.activity.ForgotActivity;
import com.wzq.sxzx.R;

import com.sxzx.Presenter.LoginPresenter;
import com.sxzx.bean.LoginBean;
import com.sxzx.activity.FragementActivity;
import com.sxzx.utils.SharedUtils;
import com.sxzx.view.MyView;



import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import crossoverone.statuslib.StatusUtil;


public class LoginActivity extends AppCompatActivity implements MyView.LoginView{
    @BindView(R.id.tel)
    EditText tel;
    @BindView(R.id.pwd)
    EditText pwd;
    @BindView(R.id.btn)
    Button btn;
    @BindView(R.id.reg)
    Button reg;
    @BindView(R.id.ForgotPassword)
    Button ForgotPassword;
    private LoginPresenter presenter;
    //退出时的时间
    private long mExitTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

       //沉浸式状态栏
        // 第二个参数是状态栏色值。
        // 第三个参数是兼容5.0到6.0之间的状态栏颜色字体只能是白色，如果沉浸的颜色与状态栏颜色冲突, 设置一层浅色对比能显示出状态栏字体（可以找ui给一个合适颜色值）。
        // 如果您的项目是6.0以上机型或者某些界面不适用沉浸, 推荐使用两个参数的setUseStatusBarColor。
        StatusUtil.setUseStatusBarColor(this, Color.TRANSPARENT, Color.parseColor("#33000000"));//沉浸式状态栏
        StatusUtil.setSystemStatus(this, false, true);// 第二个参数是是否沉浸,第三个参数是状态栏字体是否为黑色。

        ButterKnife.bind(this);

        //调用p层
        presenter = new LoginPresenter(this);


    }

    @Override
    public void success(LoginBean loginBean) {
        Toast.makeText(this, "登录结果：  " + loginBean.getMsg(), Toast.LENGTH_SHORT).show();
        System.out.println("登录Token数据："+loginBean.getToken().toString());

        if(loginBean.getError_code()==0){
            /* Thread.sleep(1000);*/
            Intent intent = new Intent(LoginActivity.this, FragementActivity.class);
            startActivity(intent);
            finish();
            SharedUtils.saveBeanByFastJson(LoginActivity.this,"data","userdate",loginBean);//调用SharedPreferences工具类保存Json

        }else if (loginBean.getError_code()!=0){
            Log.d("name",loginBean.getMsg());
            Toast.makeText(this, "登录失败！   "+loginBean.getError_code()+"   请检查登录信息" , Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void failed(int code) {
        Toast.makeText(this, "登录失败！000  请检查登录信息" + code, Toast.LENGTH_SHORT).show();
    }

    //登录注册按钮监听
    @OnClick({R.id.btn, R.id.reg,R.id.ForgotPassword})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn:
                if (!TextUtils.isEmpty(tel.getText().toString()) && !TextUtils.isEmpty(pwd.getText().toString())) {
                    //如果都不为空,请求接口
                    presenter.getData(tel.getText().toString(), pwd.getText().toString());
                } else {
                    Toast.makeText(this, "账号或密码不能为空", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.reg:      //注册页
                Intent intent = new Intent(LoginActivity.this, RegActivity.class);
                startActivity(intent);
                break;

            case R.id.ForgotPassword:
                Intent intent1 = new Intent(LoginActivity.this, ForgotActivity.class);
                startActivity(intent1);
                break;
        }
    }



    //监听返回键
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            exit();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    //退出方法
    private void exit() {
        if ((System.currentTimeMillis() - mExitTime) > 2000) {
            Toast.makeText(LoginActivity.this, "再按一次退出应用", Toast.LENGTH_SHORT).show();
            mExitTime = System.currentTimeMillis();
        } else {
            //用户退出处理
            finish();
            SharedUtils.clear(LoginActivity.this);
            System.exit(0);
        }
    }


}
