package com.sxzx.activity;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.wzq.sxzx.R;
import com.sxzx.Presenter.CptPresenter;
import com.sxzx.bean.Cptbean;
import com.sxzx.bean.LbBSbean;
import com.sxzx.bean.LoginBean;
import com.sxzx.utils.SharedUtils;
import com.sxzx.view.MyView;
import com.wzq.mylibrary.SeatTable;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class SSS extends AppCompatActivity implements MyView.CPTView{

        private CptPresenter presenter;
        public SeatTable seatTableView;
        private Button SU;
        private int tab_id;
        private int Type;
        private int rw;
        private int row1;
        private int col;
         private int roww;
         private int coll;

    @Override
    public void failed(int code) {

    }

    @Override
    public void sucess(Cptbean cptbean) {
        System.out.print("测试设备"+cptbean.getMsg());
        if (cptbean.getError_code() == 0) {
            /*  Thread.sleep(1000);*/
            SharedUtils.saveBeanByFastJson(SSS.this, "CptData", "Cptdata", cptbean);//存数据
        }else if(cptbean.getError_code() == 10001){
            System.out.print("token不正确"+cptbean.getError_code());
        }else if(cptbean.getError_code() == 20001) {
            System.out.print("设备不存在" + cptbean.getError_code());
        }else{
            System.out.print("参数丢失"+cptbean.getError_code());
        }

    }

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.sss);

          /*  Bundle b=getIntent().getExtras();
            int a = Integer.parseInt(b.getString("Lab_id"));*/

            //ShareUtils工具过去Bean对象的方法使用
            LoginBean LB =  SharedUtils.getBeanByFastJson(SSS.this,"data","userdate",LoginBean.class);
            System.out.print("测试"+LB.getMsg());
            int user_id = LB.getUserInfo().getUser_id();
            String token = LB.getToken();



            LbBSbean LBS = SharedUtils.getBeanByFastJson(SSS.this, "data", "LbsData", LbBSbean.class);//缓存的JSON映射到LbBSbean实体类
       /*     if (LBS!=null){
                for (int i = 0; i < LBS.getLabs().size(); i++) {
                  tab_id  =  LBS.getLabs().get(i).getLab_id();//获取到实体类list通过.get()获取到里面的对象
                }}else {
                System.out.print("bean为空");
            }
*/
            //调用P层
            presenter = new CptPresenter(this);
            presenter.getData(user_id,token,1);





            Cptbean CPT = SharedUtils.getBeanByFastJson(SSS.this, "CptData", "Cptdata", Cptbean.class);//缓存的JSON映射到LbBSbean实体类
            int MaxCol = CPT.getMaxCols();
            String name = CPT.getLab();
            if(CPT!=null) {
                for (int i = 0;i<CPT.getComputers().size();i++) {
                    rw = CPT.getComputers().size()/MaxCol;
                    int Type = CPT.getComputers().get(i).getType();
                    int status = CPT.getComputers().get(i).getStatus();
                    if (Type==0){
                       /* ArrayList list1 = new ArrayList();
                     list1.add(CPT.getComputers().get(i).getComputer_row());
                     list1.add(CPT.getComputers().get(i).getComputer_col());
                        Map<String , List> map = new HashMap<String ,List>();
                        map.put("colrow",list1);*/
                       col = CPT.getComputers().get(i).getComputer_col();
                       row1 =CPT.getComputers().get(i).getComputer_row();
                    }
                    if (status==0){
                        coll = CPT.getComputers().get(i).getComputer_col();
                        roww = CPT.getComputers().get(i).getComputer_row();

                    }

                }
            }








            seatTableView = (SeatTable) findViewById(R.id.seatView);
            SU = findViewById(R.id.BT);
            seatTableView.setScreenName(name);//设置屏幕名称
            seatTableView.setMaxSelected(100);//设置最多选中



            seatTableView.setSeatChecker(new SeatTable.SeatChecker() {

                //是否在图上绘制
                @Override
                public boolean isValidSeat(int row, int column) {
                    if(column==col-1&&row==row1-1) {
                        return false;
                    }
                    return true;
                }

                //是否绘制有损坏
                @Override
                public boolean isSold(int row, int column) {
                    if(row==(roww-1)&&column==(coll-1)){
                        return true;
                    }
                    return false;
                }


                @Override
                public void checked(int row, int column) {


                }

                @Override
                public void unCheck(int row, int column) {

                }

                //获取选中后座位上显示的文字
                @Override
                public String[] checkedSeatTxt(int row, int column) {
                    return null;
                }

            });

                seatTableView.setData(rw,MaxCol);

            seatTableView.getSelectedSeat().size();
        }


}

