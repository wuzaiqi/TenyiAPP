package com.sxzx.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.wzq.sxzx.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Fragment03 extends android.support.v4.app.Fragment {


    ListView message_user_name_listView;
    private String[] message_user_name = {"1201", "1202", "1205", "1206", "1207", "1208", "1301", "1302", "1303", "3208", "3506"};
    private String[] week = {"星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日"};

    // private ArrayList<Map<String, Object>> mData = new ArrayList<Map<String, Object>>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View cirCleLayout = inflater.inflate(R.layout.fragment03, container, false);

        //在xml中，要加载的ListView的id必须设置为 android:id="@+id/android:list"  !!!
        // 而在代码中ListView的名称必须设置为list
        message_user_name_listView = (ListView) cirCleLayout.findViewById(android.R.id.list);


        List<Map<String, Object>> listItems = new ArrayList<>();
        for (int i = 0; i < message_user_name.length; i++) {
            Map<String, Object> listItem = new HashMap<>();
            listItem.put("name", message_user_name[i]);
            listItems.add(listItem);
        }

        List<Map<String, Object>> week_listItems = new ArrayList<>();
        for (int i = 0; i < week.length; i++) {
            Map<String, Object> listItem = new HashMap<>();
            listItem.put("week", week[i]);
            week_listItems.add(listItem);
        }

        SimpleAdapter week_adapter = new SimpleAdapter(getActivity(), listItems, R.layout.message_itme, new String[]{"week"}, new int[]{R.id.message_thims});
        message_user_name_listView.setAdapter(week_adapter);


        SimpleAdapter adapter = new SimpleAdapter(getActivity(), listItems, R.layout.message_itme, new String[]{"name"}, new int[]{R.id.massage_user_name});
        message_user_name_listView.setAdapter(adapter);



        return cirCleLayout;
    }
}

