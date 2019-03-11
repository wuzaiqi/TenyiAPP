package com.sxzx.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.util.ArrayList;

//SharedPreferences自定义存取数据
public class SharedUtils {

    static SharedPreferences preferences;
    static String dataFile = "data";
    static String dataFile1 = "RepairData";

    //保存数据的方法
    public static void savaBooleanData(Context context, String key, boolean value) {
     /*   if (preferences == null) {*/
            //Context.MODE_WORLD_READABLE：指定该SharedPreferences数据能被其他应用程序读，但不能写
            preferences = context.getSharedPreferences(dataFile, Context.MODE_PRIVATE);
     /*   }*/
        //获取编辑器对象
        Editor editor = preferences.edit();
        editor.putBoolean(key, value).commit();
    }

    //获取数据的方法
    public static boolean getBooleanData(Context context, String key, boolean defValue) {
       /* if (preferences == null) {*/
            preferences = context.getSharedPreferences(dataFile, Context.MODE_PRIVATE);
      /*  }*/
        return preferences.getBoolean(key, defValue);
    }

    //删除数据
    public static void clear(Context context) {
        File file = new File("/data/data/"+context.getPackageName()+"/shared_prefs");
        file.delete();
        preferences = context.getSharedPreferences(dataFile, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        editor.commit();

    }

    public static void clear1(Context context) {
        File file = new File("/data/data/"+context.getPackageName()+"/shared_prefs/RepairData");
        file.delete();
        preferences = context.getSharedPreferences(dataFile1, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        editor.commit();

    }



    // 保存bean对象
    public static void saveBeanByFastJson(Context context, String name, String key, Object obj){
      /*  if (preferences == null) {*/
            //Context.MODE_WORLD_READABLE：指定该SharedPreferences数据能被其他应用程序读，但不能写
            preferences = context.getSharedPreferences(name, Context.MODE_PRIVATE);
      /*  }*/
     /*   SharedPreferences.Editor editor = (SharedPreferences.Editor) context.getSharedPreferences(name,Context.MODE_PRIVATE);*/

        Editor editor = preferences.edit();
        String toJson = new Gson().toJson(obj);
        editor.putString(key,toJson).commit();
    }

    // 提取bean对象
    //Class<T> clazz 这里用到的是反射机制,传入你的javaBean的Class对象
    //用Bean实体类获取
    public static <T> T getBeanByFastJson(Context context,String name,String key,Class<T> clazz){
        String string = context.getSharedPreferences(name, Context.MODE_PRIVATE).getString(key, "");
        return new Gson().fromJson(string,clazz);
    }



}
