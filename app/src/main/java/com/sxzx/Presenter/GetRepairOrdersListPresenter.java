package com.sxzx.Presenter;

import android.app.Activity;

import com.sxzx.activity.OrderActivty;
import com.sxzx.bean.GetRepairOrdersListBean;
import com.sxzx.model.GetRepairOrdersListModel;
import com.sxzx.net.ModelCallBack;
import com.sxzx.utils.SharedUtils;
import com.sxzx.view.MyView;

public class GetRepairOrdersListPresenter extends Activity{
    GetRepairOrdersListModel GetRepair = new GetRepairOrdersListModel();
    MyView.GetRepairView getRepairView;
    public GetRepairOrdersListPresenter(MyView.GetRepairView getrepairview){
        this.getRepairView = getrepairview;
    }

    public void getData(int user_id, String token,int status){
        GetRepair.getRepairData(user_id, token, status,new ModelCallBack.GetRepairCallBack(){
            @Override
            public void success(GetRepairOrdersListBean getRepairOrdersListBean) {
                getRepairView.sucess(getRepairOrdersListBean);
//                SharedUtils.saveBeanByFastJson(GetRepairOrdersListPresenter.this,"data","Repairdate",GetRepair);
                System.out.print("订单"+getRepairOrdersListBean.toString());
            }

            @Override
            public void failed(Throwable code) {

                System.out.print("获取订单错误"+code.toString());
            }
        });
    }
}
