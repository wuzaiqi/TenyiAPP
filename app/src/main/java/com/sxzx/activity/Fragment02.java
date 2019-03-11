package com.sxzx.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wzq.sxzx.R;


public class Fragment02 extends android.support.v4.app.Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View discoveryLayout = inflater.inflate(R.layout.fragment02, container, false);
        return discoveryLayout;
    }


}
