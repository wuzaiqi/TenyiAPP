package com.sxzx.net;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.wzq.sxzx.R;
import com.sxzx.Presenter.RegPresenter;
import com.sxzx.bean.RegBean;
import com.sxzx.view.MyView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import crossoverone.statuslib.StatusUtil;

public class RegActivity extends AppCompatActivity implements MyView.RegView {

    @BindView(R.id.back)
    TextView back;
    @BindView(R.id.text)
    TextView text;

    @BindView(R.id.emploee_id_re)
    EditText emploee_id;
    @BindView(R.id.username_re)
    EditText user_name_re;
    @BindView(R.id.mobile_re)
    EditText mobile_re;
    @BindView(R.id.email_re)
    EditText email_re;
    @BindView(R.id.password_re)
    EditText pwd_re;
    @BindView(R.id.password_confirm_re)
    EditText pwd_confirm_re;
    @BindView(R.id.regNow)
    Button regNow;

    private RegPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reg_activity);

        //沉浸式状态栏
        // 第二个参数是状态栏色值。
        // 第三个参数是兼容5.0到6.0之间的状态栏颜色字体只能是白色，如果沉浸的颜色与状态栏颜色冲突, 设置一层浅色对比能显示出状态栏字体（可以找ui给一个合适颜色值）。
        // 如果您的项目是6.0以上机型或者某些界面不适用沉浸, 推荐使用两个参数的setUseStatusBarColor。
        StatusUtil.setUseStatusBarColor(this, Color.TRANSPARENT, Color.parseColor("#33000000"));//沉浸式状态栏
        StatusUtil.setSystemStatus(this, false, true);// 第二个参数是是否沉浸,第三个参数是状态栏字体是否为黑色。

        ButterKnife.bind(this);


        //调用p层
        presenter = new RegPresenter(this);
    }


    @OnClick({R.id.back, R.id.regNow})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                //点击返回按钮，返回到登录页面
                finish();
                break;

            case R.id.regNow: //注册按钮
                if (!TextUtils.isEmpty(emploee_id.getText().toString()) && !TextUtils.isEmpty(user_name_re.getText().toString())
                        && !TextUtils.isEmpty(mobile_re.getText().toString()) && !TextUtils.isEmpty(email_re.getText().toString())
                        && !TextUtils.isEmpty(pwd_re.getText().toString()) && !TextUtils.isEmpty(pwd_confirm_re.getText().toString())) {

                    if (pwd_re.getText().toString().length() < 6){
                        Toast.makeText(this, "密码长度不能小于 6 位", Toast.LENGTH_SHORT).show();
                    }else {
                        // mvp请求注册的接口
                        presenter.getRegData(
                                emploee_id.getText().toString(), user_name_re.getText().toString(),
                                mobile_re.getText().toString(), email_re.getText().toString(),
                                pwd_re.getText().toString(), pwd_confirm_re.getText().toString());
                    }

                } else {
                    Toast.makeText(this, "账号或密码不能为空", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }





    @Override
    public void failed(int code) {
        Toast.makeText(this, "注册失败！请检查网络"+ code, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void sucess(RegBean regBean) {
        Toast.makeText(this, "注册结果：      "+regBean.getMsg(), Toast.LENGTH_SHORT).show();

        if(regBean.getError_code() == 0){
            try {
                Thread.sleep(1000);
                Toast.makeText(this, "即将跳转到登录页面", Toast.LENGTH_LONG).show();
                finish();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        } else if(regBean.getError_code()!=0){
            Log.d("name",regBean.getMsg());
            Toast.makeText(this, "注册失败！   "+regBean.getError_code()+"   请检查登录信息" , Toast.LENGTH_SHORT).show();
        }
    }


}
