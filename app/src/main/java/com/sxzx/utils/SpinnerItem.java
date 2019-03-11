package com.sxzx.utils;

public class SpinnerItem {
    private int ID = getID();
    private String Value = "";

    public SpinnerItem() {
        ID = getID();
        Value = "";
    }

    public SpinnerItem(int iD, String value) {
        ID = iD;
        Value = value;
    }

    @Override
    public String toString() {
        // 为什么要重写toString()呢？
        // 因为适配器在显示数据的时候，
        // 如果传入适配器的对象不是字符串的情况下，
        // 直接就使用对象.toString()
        return Value;
    }

    public int getID() {
        return ID;
    }

    public void setID(int iD) {
        ID = iD;
    }

    public String getValue() {
        return Value;
    }

    public void setValue(String value) {
        Value = value;
    }

}