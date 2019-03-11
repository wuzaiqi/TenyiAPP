package com.sxzx.activity;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.wzq.sxzx.R;
import com.sxzx.bean.LoginBean;
import com.sxzx.net.LoginActivity;
import com.sxzx.net.RegActivity;
import com.sxzx.utils.SharedUtils;


public class Fragment04 extends android.support.v4.app.Fragment {

    private RadioGroup mGroup;
    private RadioButton myfinish, mywait, myundone;
    private TextView username;
    Bundle bundle;
    String name;
    private Button Order_button;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View centerLayout = inflater.inflate(R.layout.fragment04, container, false);

        //初始化RadioGroup按钮
      //  mGroup = (RadioGroup) centerLayout.findViewById(R.id.user_rg);
        myfinish = (RadioButton)centerLayout.findViewById(R.id.id_tab_mycircle);
        mywait = (RadioButton)centerLayout.findViewById(R.id.id_tab_discovery);
        myundone = (RadioButton)centerLayout.findViewById(R.id.id_tab_message);
        username = centerLayout.findViewById(R.id.username_user);
        Order_button =centerLayout.findViewById(R.id.Order_button);

        Order_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity(), OrderActivty.class);
                startActivity(intent);
            }
        });


        //利用SharedUtils工具类获取用户名 Fragment中Context用getActivtiy（）获取
        LoginBean LB = SharedUtils.getBeanByFastJson(getActivity(),"data","userdate",LoginBean.class);
        String username1 = LB.getUserInfo().getUsername();
        username.setText(username1);


      /*  mGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {

                }


        });*/

        return centerLayout;
    }






}
