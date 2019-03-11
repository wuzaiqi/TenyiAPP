package com.sxzx.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.wzq.sxzx.R;
import com.sxzx.Presenter.LoginPresenter;
import com.sxzx.Presenter.SubmitRepairOrderPresenter;
import com.sxzx.bean.FAULTSBean;
import com.sxzx.bean.LbBSbean;
import com.sxzx.bean.LoginBean;
import com.sxzx.bean.SubmitRepairOrderBean;
import com.sxzx.net.LoginActivity;
import com.sxzx.net.RegActivity;
import com.sxzx.utils.SharedUtils;
import com.sxzx.utils.SpinnerItem;
import com.sxzx.view.MyView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.OnClick;
import crossoverone.statuslib.StatusUtil;

public class SubmitActivity extends AppCompatActivity implements MyView.SubmitRepairView {

    private Spinner spinner;
    private List<String> data_list;
    private ArrayAdapter<String> arr_adapter;
    private Button Submit;
    private Button Return;
    private EditText SubmitEdit;
    private SubmitRepairOrderPresenter presenter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.submitrepair);

        //沉浸式状态栏
        // 第二个参数是状态栏色值。
        // 第三个参数是兼容5.0到6.0之间的状态栏颜色字体只能是白色，如果沉浸的颜色与状态栏颜色冲突, 设置一层浅色对比能显示出状态栏字体（可以找ui给一个合适颜色值）。
        // 如果您的项目是6.0以上机型或者某些界面不适用沉浸, 推荐使用两个参数的setUseStatusBarColor。
        StatusUtil.setUseStatusBarColor(this, Color.TRANSPARENT, Color.parseColor("#33000000"));//沉浸式状态栏
        StatusUtil.setSystemStatus(this, false, true);// 第二个参数是是否沉浸,第三个参数是状态栏字体是否为黑色。

        spinner = findViewById(R.id.submit_spinner);
        Submit = findViewById(R.id.submit_button);
        SubmitEdit = findViewById(R.id.memo);


        //ShareUtils工具过去Bean对象的方法使用
        LoginBean LB =  SharedUtils.getBeanByFastJson(SubmitActivity.this,"data","userdate",LoginBean.class);
        System.out.print("测试"+LB.getMsg());
        final int user_id = LB.getUserInfo().getUser_id();
        final String token = LB.getToken();



        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
         final int Lab_id = extras.getInt("Lab_id");
         final int Tb_id = extras.getInt("Tb_id");
        System.out.print("LLLLLLLLLLLL"+Lab_id);
        System.out.print("TTTTTTTTTTTT"+Tb_id);
         final String computer_id = "-1";




    Submit.setOnClickListener(new View.OnClickListener() {


        @Override
        public void onClick(View view) {
            final String memo = SubmitEdit.getText().toString();
            int fault_id =  ((SpinnerItem)spinner.getSelectedItem()).getID();
            presenter.getSubmitData(user_id, token, Tb_id, Lab_id, computer_id, fault_id, memo);

        }
    });

        //取出故障列表
        FAULTSBean FB =  SharedUtils.getBeanByFastJson(SubmitActivity.this,"data","FaultsData",FAULTSBean.class);
        System.out.print("测试"+FB.getFaultsList());


        List<SpinnerItem> list = new ArrayList<SpinnerItem>();

        data_list = new ArrayList<String>();
        if (FB!=null){
            for (int i = 0; i < FB.getFaultsList().size(); i++) {
                data_list.add(FB.getFaultsList().get(i).getFault_type()+String.valueOf(FB.getFaultsList().get(i).getFault_id()));
                /*data_list.add(String.valueOf(FB.getFaultsList().get(i).getFault_id()));*/
                SpinnerItem spinnerItem=new SpinnerItem(FB.getFaultsList().get(i).getFault_id(), FB.getFaultsList().get(i).getFault_type());
                list.add(spinnerItem);
            }}else {
            System.out.print("bean为空");
        }

        //适配器
       // arr_adapter= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, data_list);

        ArrayAdapter<SpinnerItem> adapter= new ArrayAdapter<SpinnerItem>(this, android.R.layout.simple_spinner_item, list);

        //设置样式
     //   arr_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //加载适配器
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int fault_id =  ((SpinnerItem)spinner.getSelectedItem()).getID();//获取Spinner上对应的ID
                System.out.print("测试选中数据"+fault_id);

            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



        //调用p层
        presenter = new SubmitRepairOrderPresenter(this);
      //  presenter.getSubmitData(user_id, token, Tb_id, Lab_id, computer_id, b, memo1);
        // presenter.getSubmitData(user_id1,token1,Lab_id1,Td1, a,b,memo1);

    }




    @Override
    public void failed(int code) {

    }

    @Override
    public void sucess(SubmitRepairOrderBean SubmitRepair) {
        Toast.makeText(this, "提交订单结果：  " + SubmitRepair.getMsg(), Toast.LENGTH_SHORT).show();
//        Toast.makeText(this, "订单号：  " + SubmitRepair.getTrade_no(), Toast.LENGTH_SHORT).show();
        if(SubmitRepair.getError_code()==0){
            /* Thread.sleep(1000);*/
            Intent intent = new Intent(SubmitActivity.this, FragementActivity.class);
            startActivity(intent);
            finish();
           // SharedUtils.saveBeanByFastJson(SubmitActivity.this,"data","userdate",SubmitRepair);

        }else if (SubmitRepair.getError_code()!=0){
            Log.d("name",SubmitRepair.getMsg());
            Toast.makeText(this, "提交失败！   "+SubmitRepair.getError_code()+"   请检查提交信息" , Toast.LENGTH_SHORT).show();

    }



}
}
