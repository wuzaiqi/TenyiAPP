package com.sxzx.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.wzq.sxzx.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Fragment05 extends android.support.v4.app.Fragment implements AdapterView.OnItemSelectedListener {

    private TextView tvShow;
    private Spinner ReasonSp;
    private Spinner yearSp;
    private Spinner monthSp;
    private Spinner daySp;
    private Spinner timeSp1;
    private Spinner timeSp2;
    private List<String> list;
    private ArrayList<String> yearlist;
    private List<String> monthlist;
    private List<String> daylist;
    private List<String> timelist;
    private ArrayAdapter<String> adapter;
    private ArrayAdapter<String> yearadapter;
    private ArrayAdapter<String> monthadapter;
    private ArrayAdapter<String> dayadapter;
    private ArrayAdapter<String> timedapter;
    private ArrayAdapter<String> timedapter1;

    String [] year = {"2000","2001","2002","2003","2004","2005","2006","2007","2008","2009","2010",
                      "2011","2012","2013","2014","2015","2016","2017","2018","2019","2020","2021","2022",
                         "2023","2024","2025","2026","2027","2028","2029","2030"};

    String [] month = {"1","2","3","4","5","6","7","8","9","10","11","12"};

    String [] day ={"1","2","3","4","5","6","7","8","9","10", "11",
                          "12","13","14","15","16","17","18","19","20",
                    "21","22","23","24","25","26","27","28","29","30","31",};

    String [] time ={"1:00","2:00","3:00","4:00","5:00","6:00","7:00","8:00","9:00","10:00", "11:00",
            "12:00","13:00","14:00","15:00","16:00","17:00","18:00","19:00","20:00", "21:00","22:00","23:00","24:00"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View centerLayout = inflater.inflate(R.layout.fragment05, container, false);

        tvShow=(TextView) centerLayout.findViewById(R.id.tvShow);
        ReasonSp=(Spinner) centerLayout.findViewById(R.id.ReasonSp);
        yearSp=(Spinner) centerLayout.findViewById(R.id.yearSp);
        monthSp=(Spinner) centerLayout.findViewById(R.id.monthSp);
        daySp=(Spinner) centerLayout.findViewById(R.id.daySp);
        timeSp1=(Spinner) centerLayout.findViewById(R.id.timeSp1);
        timeSp2=(Spinner) centerLayout.findViewById(R.id.timeSp2);
        tvShow.setText("您选择的故障原因是硬件");

        /*设置数据源*/
        list=new ArrayList<String>();
        list.add("硬件");
        list.add("软件");

        yearlist = new ArrayList<String>();
        yearlist.addAll(Arrays.asList(year));
        yearlist.add("");

        monthlist = new ArrayList<String>();
        monthlist.addAll(Arrays.asList(month));
        monthlist.add("");

        daylist = new ArrayList<String>();
        daylist.addAll(Arrays.asList(day));
        daylist.add("");

        timelist = new ArrayList<String>();
        timelist.addAll(Arrays.asList(time));
        timelist.add("");


        /*新建适配器*/
        adapter=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item,list);
        yearadapter=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item,yearlist);
        monthadapter=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item,monthlist);
        dayadapter=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item,daylist);
        timedapter=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item,timelist);
        timedapter1=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item,timelist);


        /*adapter设置一个下拉列表样式，参数为系统子布局*/
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        yearadapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        monthadapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        dayadapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        timedapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        timedapter1.setDropDownViewResource(android.R.layout.simple_spinner_item);


        /*加载适配器*/
        ReasonSp.setAdapter(adapter);
        yearSp.setAdapter(yearadapter);
        monthSp.setAdapter(monthadapter);
        daySp.setAdapter(dayadapter);
        timeSp1.setAdapter(timedapter);
        timeSp2.setAdapter(timedapter);

        /*监听器*/
        ReasonSp.setOnItemSelectedListener(this);
        yearSp.setOnItemSelectedListener(this);
        monthSp.setOnItemSelectedListener(this);
        daySp.setOnItemSelectedListener(this);
        timeSp1.setOnItemSelectedListener(this);
        timeSp2.setOnItemSelectedListener(this);

        return centerLayout;
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
        String Reason=adapter.getItem(position);   //获取选中的那一项
        tvShow.setText("您选择的故障原因是"+Reason);
        yearadapter.getItem(position);
        monthadapter.getItem(position);
        dayadapter.getItem(position);
        timedapter.getItem(position);
        timedapter1.getItem(position);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}