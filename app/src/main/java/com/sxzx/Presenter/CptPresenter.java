package com.sxzx.Presenter;

import com.sxzx.bean.Cptbean;
import com.sxzx.model.CptModel;
import com.sxzx.net.ModelCallBack;
import com.sxzx.view.MyView;

public class CptPresenter {
    CptModel CptModel = new CptModel();
    MyView.CPTView cptView;
    public CptPresenter(MyView.CPTView cptView){
        this.cptView = cptView;
    }

    public void getData(int user_id, String token,int tab_id){
        CptModel.getCptData(user_id, token, tab_id,new ModelCallBack.CPTCallBack(){
            @Override
            public void success(Cptbean cptbean) {
                cptView.sucess(cptbean);
                System.out.print("机房"+cptbean.toString());
            }

            @Override
            public void failed(Throwable code) {

                System.out.print("机房错误"+code.toString());
            }
        });
    }
}
