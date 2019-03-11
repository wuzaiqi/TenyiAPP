package com.sxzx.Presenter;

import com.sxzx.bean.FAULTSBean;
import com.sxzx.model.FaultsListModel;
import com.sxzx.net.ModelCallBack;
import com.sxzx.view.MyView;

public class FaultsListPresenter {

    FaultsListModel FaultsFistModel = new FaultsListModel();
    MyView.FAULTSView FaultsView;
    public FaultsListPresenter(MyView.FAULTSView FAULTSView){
        this.FaultsView = FAULTSView;
    }

    public void getData(int user_id, String token){
        FaultsFistModel.getFaultsListData(user_id, token,new ModelCallBack.FaultsCallBack(){
            @Override
            public void success(FAULTSBean faultsBean) {
                FaultsView.sucess(faultsBean);
                System.out.print("获取故障列表"+ faultsBean.toString());
            }

            @Override
            public void failed(Throwable code) {

                System.out.print("获取故障列表错误"+code.toString());
            }
        });
    }

}
