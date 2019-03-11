package com.sxzx.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.wzq.sxzx.R;
import com.google.gson.Gson;
import com.sxzx.Presenter.LbsPresenter;
import com.sxzx.bean.LbBSbean;
import com.sxzx.bean.LoginBean;
import com.sxzx.utils.SharedUtils;
import com.sxzx.view.MyView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Fragment01 extends android.support.v4.app.Fragment
{

    //初始化ListView
    ListView listView;

    private LbsPresenter presenter;

    private List<Map<String,Object>> newsList;
    private int lab_id;



    private String[] data = { "1201", "1202", "1205", "1206", "1207", "1208", "1301","1302", "1303", "3208", "3506" };

    // private ArrayList<Map<String, Object>> mData = new ArrayList<Map<String, Object>>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View cirCleLayout = inflater.inflate(R.layout.fragment01, container, false);

       /* //在xml中，要加载的ListView的id必须设置为 android:id="@+id/android:list"  !!!
        // 而在代码中ListView的名称必须设置为list
        listView = (ListView) cirCleLayout.findViewById(android.R.id.list);

        //ShareUtils工具过去Bean对象的方法使用
        LoginBean LB =  SharedUtils.getBeanByFastJson(getActivity(),"data","userdate",LoginBean.class);
        System.out.print("测试"+LB.getMsg());
        int user_id = LB.getUserInfo().getUser_id();
        String token = LB.getToken();


        //调用机房P层
        presenter = new LbsPresenter(this);
        presenter.getData(user_id,token);



        final LbBSbean bean = SharedUtils.getBeanByFastJson(getActivity(), "data", "LbsData", LbBSbean.class);//缓存的JSON映射到LbBSbean实体类

        if (bean==null) {
            Intent intent = new Intent(getActivity(), MainActivity.class);
            startActivity(intent);
        }

        newsList = new ArrayList<>();//初始化ArrayList<Map<String,Object>>
        if (bean!=null){
        for (int i = 0; i < bean.getLabs().size(); i++) {
            Map<String, Object> listItem = new HashMap<>();
            listItem.put("lab_name",bean.getLabs().get(i).getLab_name().toString());//获取到实体类list通过.get()获取到里面的对象
            listItem.put("lab_id",bean.getLabs().get(i).getLab_id());
            newsList.add(listItem);
            System.out.print(newsList);
        }}else {
            System.out.print("bean为空");
        }

            final SimpleAdapter adapter = new SimpleAdapter(getActivity(),newsList,
                    R.layout.list_item_card, new String[]{"lab_name"},
                    new int[]{R.id.name});
            listView.setAdapter(adapter);


            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long ID) {

                    int Lab_id = bean.getLabs().get(i).getLab_id();
                    int tb_id = bean.getLabs().get(i).getTb_id();

                    Bundle bundle = new Bundle();
                    bundle.putInt("Lab_id",Lab_id);
                    bundle.putInt("Tb_id",tb_id);

                    Intent intent = new Intent(getActivity(),SubmitActivity.class);
                    intent.putExtras(bundle);

                    startActivity(intent);

                }
            });*/
            return cirCleLayout;
        }

/*
    @Override
    public void failed(int code) {

    }

    @Override
    public void sucess(LbBSbean LbsBean) {

        System.out.print("测试LBS"+LbsBean.getLabs());

        if (LbsBean.getError_code() == 0) {
            *//*  Thread.sleep(1000);*//*
            SharedUtils.saveBeanByFastJson(getActivity(), "data", "LbsData", LbsBean);

        }else if(LbsBean.getError_code() == 20001){
            System.out.print("token错误"+LbsBean.getError_code());
        }else{
            System.out.print("参数丢失"+LbsBean.getError_code());
        }

    }*/
}
