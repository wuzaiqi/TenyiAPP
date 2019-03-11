package com.sxzx.Presenter;

import com.sxzx.bean.LoginBean;
import com.sxzx.bean.SubmitRepairOrderBean;
import com.sxzx.model.LoginModel;
import com.sxzx.model.SubmitRepairOrderModel;
import com.sxzx.net.ModelCallBack;
import com.sxzx.view.MyView;

public class SubmitRepairOrderPresenter {
    SubmitRepairOrderModel Submit = new SubmitRepairOrderModel();
    MyView.SubmitRepairView Submitview;
    public SubmitRepairOrderPresenter(MyView.SubmitRepairView submitRepairView) {
        this.Submitview = submitRepairView;
    }

    public void getSubmitData(int user_id, String token,int tb_id,int lab_id,String computer_id,int fault_id,String memo) {
        Submit.getSubmitData(user_id,token,tb_id,lab_id,computer_id,fault_id,memo, new ModelCallBack.SubmitRepairCallBack() {
            @Override
            public void success(SubmitRepairOrderBean submitRepairOrderBean) {
                Submitview.sucess(submitRepairOrderBean);
                System.out.println("提交订单p数据："+submitRepairOrderBean.toString());
            }

           /* @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

            }*/

            @Override
            public void failed(Throwable code) {
                System.out.println("获取订单p错误："+code);
            }
        });
    }
}
