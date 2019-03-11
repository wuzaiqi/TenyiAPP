package com.sxzx.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.wzq.sxzx.R;
import com.sxzx.Presenter.GetRepairOrdersListPresenter;
import com.sxzx.bean.GetRepairOrdersListBean;
import com.sxzx.bean.LoginBean;
import com.sxzx.net.LoginActivity;
import com.sxzx.utils.SharedUtils;
import com.sxzx.utils.TimeDataUtils;
import com.sxzx.view.MyView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import crossoverone.statuslib.StatusUtil;


public class OrderActivty extends AppCompatActivity implements MyView.GetRepairView{

    //初始化ListView
    ListView listView;
    private List<Map<String,Object>> newsList;
    private GetRepairOrdersListPresenter presenter;
    //退出时的时间
    private long mExitTime;






    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order);

        //沉浸式状态栏
        // 第二个参数是状态栏色值。
        // 第三个参数是兼容5.0到6.0之间的状态栏颜色字体只能是白色，如果沉浸的颜色与状态栏颜色冲突, 设置一层浅色对比能显示出状态栏字体（可以找ui给一个合适颜色值）。
        // 如果您的项目是6.0以上机型或者某些界面不适用沉浸, 推荐使用两个参数的setUseStatusBarColor。
        StatusUtil.setUseStatusBarColor(this, Color.TRANSPARENT, Color.parseColor("#33000000"));//沉浸式状态栏
        StatusUtil.setSystemStatus(this, false, true);// 第二个参数是是否沉浸,第三个参数是状态栏字体是否为黑色。

        listView = findViewById(android.R.id.list);
        newsList = new ArrayList<>();

        LoginBean LB =  SharedUtils.getBeanByFastJson(OrderActivty.this,"data","userdate",LoginBean.class);
        System.out.print("测试"+LB.getMsg());
        final int user_id = LB.getUserInfo().getUser_id();
        final String token = LB.getToken();
        int status = 3;

        presenter = new GetRepairOrdersListPresenter(this);
        presenter.getData(user_id,token,status);

        GetRepairOrdersListBean bean = SharedUtils.getBeanByFastJson(OrderActivty.this, "RepairData", "Repairdate", GetRepairOrdersListBean.class);//缓存的JSON映射到LbBSbean实体类

        if (bean==null) {
            Intent intent = new Intent(OrderActivty.this, OrderActivty.class);
            startActivity(intent);
            finish();
        }

        if (bean != null) {
            presenter = new GetRepairOrdersListPresenter(this);
            presenter.getData(user_id,token,status);
                for (int i = 0; i < bean.getOrderList().size(); i++) {
                    Map<String, Object> listItem = new HashMap<>();
                    listItem.put("trade_no", bean.getOrderList().get(i).getTrade_no());//订单号

                    //订单时间
                    long milSecond = bean.getOrderList().get(i).getCreate_date();//获取时间戳
                    String deta = TimeDataUtils.getDateToString(milSecond);//将时间戳转化为String
                    listItem.put("create_date", deta);

                    listItem.put("lab_name", bean.getOrderList().get(i).getLab_name().toString());//机房

                    //设备数量
                    String ss = bean.getOrderList().get(i).getComputer_id();
                    String[] aa = ss.split(",");
                    List<String> list = java.util.Arrays.asList(aa);
                    for (int j = 0; j <= list.size(); j++) {
                        listItem.put("computer_id", j);
                    }


                    listItem.put("fault_type", bean.getOrderList().get(i).getFault_type().toString());//故障类型
                    listItem.put("memo", bean.getOrderList().get(i).getMemo().toString());//备注
                    //状态
                    if (bean.getOrderList().get(i).getStatus() == 0) {
                        String status01 = "未处理";
                        int im = R.drawable.no_02;
                        listItem.put("status", im);
                    } else {
                        String status02 = "已处理";
                        int im2 = R.drawable.yes_02;
                        listItem.put("status", im2);
                    }
                    newsList.add(listItem);
                    System.out.print(newsList);
                }

            } else {
                System.out.print("bean为空");
            }


            final SimpleAdapter adapter = new SimpleAdapter(OrderActivty.this, newsList,
                    R.layout.order_list_item_card, new String[]{"trade_no", "create_date", "lab_name", "computer_id", "fault_type", "memo", "status"},
                    new int[]{R.id.order_trade_no, R.id.order_create_date, R.id.order_lab_name, R.id.order_Tb_name,
                            R.id.order_fault_type, R.id.order_memo, R.id.order_status});
            listView.setAdapter(adapter);


    }


    @Override
    public void failed(int code) {

    }

    @Override
    public void sucess(GetRepairOrdersListBean GetRepair) {

        /*Toast.makeText(this, "获取订单结果：  " + GetRepair.getMsg(), Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "订单数量：  " + GetRepair.getCount(), Toast.LENGTH_SHORT).show();*/
        if (GetRepair.getError_code() == 0) {
            SharedUtils.saveBeanByFastJson(OrderActivty.this,"RepairData","Repairdate",GetRepair);
        }else if (GetRepair.getError_code() == 20001){
            System.out.print("获取订单Token不正确");
        }else {
            System.out.print("获取订单参数错误");
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
       /* if ((System.currentTimeMillis() - mExitTime) > 2000) {
            Toast.makeText(OrderActivty.this, "再按一次退出应用", Toast.LENGTH_SHORT).show();
            mExitTime = System.currentTimeMillis();
        } else {*/
            //用户退出处理
            startActivity(new Intent(OrderActivty.this,FragementActivity.class));
            finish();
            SharedUtils.clear1(OrderActivty.this);
            System.exit(0);
       /* }*/
    }

}
