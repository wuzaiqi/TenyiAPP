package com.sxzx.Presenter;

import com.sxzx.bean.LbBSbean;
import com.sxzx.model.LoginModel;
import com.sxzx.model.TBSModel;
import com.sxzx.net.ModelCallBack;
import com.sxzx.view.MyView;

public class LbsPresenter {
    TBSModel tbsModel = new TBSModel();
    MyView.TBSView tbsView;
    public LbsPresenter(MyView.TBSView tbsView){
        this.tbsView = tbsView;
    }

    public void getData(int uset_id, String token){
        tbsModel.getTBSData(uset_id, token, new ModelCallBack.LBSCallBack() {
            @Override
            public void success(LbBSbean lbBSbean) {
                tbsView.sucess(lbBSbean);
                System.out.print("机房"+lbBSbean.toString());
            }

            @Override
            public void failed(Throwable code) {

                System.out.print("机房错误"+code.toString());
            }
        });
    }
}
