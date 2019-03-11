package com.sxzx.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.githang.statusbar.StatusBarCompat;
import com.sxzx.utils.StatusBarUtil;
import com.wzq.sxzx.R;

import com.sxzx.Presenter.FaultsListPresenter;
import com.sxzx.Presenter.LbsPresenter;
import com.sxzx.bean.FAULTSBean;
import com.sxzx.bean.LbBSbean;
import com.sxzx.bean.LoginBean;
import com.sxzx.net.LoginActivity;


import com.sxzx.net.RegActivity;
import com.sxzx.utils.SharedUtils;
import com.sxzx.view.MyView;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import crossoverone.statuslib.StatusUtil;


public class FragementActivity extends AppCompatActivity implements View.OnClickListener, MyView.TBSView ,MyView.FAULTSView{
    //定义控件
    private ViewPager mViewPager;
    private FragmentPagerAdapter mAdpter;
    private List<Fragment> mFragments = new ArrayList<>();
    private RadioGroup mGroup;
    private RadioButton myCircle, myDisconvery, myMsg, myCenter,myPuls;
    private ListView mListView;
    ListView listView;
    private List<Map<String,Object>> newsList;
    //侧滑栏list文本
    String strs[] = new String[]{"个人中心", "设置", "退出登录"};
    //侧滑栏list图标
    private int[] imgIds = new int[]{R.drawable.ic_leftmenu, R.drawable.ic_leftmenu, R.drawable.ic_leftmenu};

    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;//侧滑菜单
    private Toolbar toolbar;
    private Button exitBon,ddBon,myweb;
    private LbsPresenter presenter;
    private FaultsListPresenter FaultsList;
    private TextView username,labname;
    //退出时的时间
    private long mExitTime;



    @SuppressLint("ResourceAsColor")
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 第二个参数是状态栏色值。
        // 第三个参数是兼容5.0到6.0之间的状态栏颜色字体只能是白色，如果沉浸的颜色与状态栏颜色冲突, 设置一层浅色对比能显示出状态栏字体（可以找ui给一个合适颜色值）。
        // 如果您的项目是6.0以上机型或者某些界面不适用沉浸, 推荐使用两个参数的setUseStatusBarColor。
        StatusUtil.setUseStatusBarColor(this, Color.TRANSPARENT, Color.parseColor("#33000000"));//沉浸式状态栏


        initViews();//初始化控件
        initEvent();//监听逻辑事件
        initViewPages();//初始化viewpager



        //ShareUtils工具过去Bean对象的方法使用
        LoginBean LB =  SharedUtils.getBeanByFastJson(FragementActivity.this,"data","userdate",LoginBean.class);
       if (LB!=null) {
           System.out.print("测试" + LB.getMsg());
           int user_id = LB.getUserInfo().getUser_id();
           String token = LB.getToken();
           String username1 = LB.getUserInfo().getUsername();

           username.setText(username1);
           //调用机房P层
           presenter = new LbsPresenter(this);
           presenter.getData(user_id, token);
           //调用故障列表P层
           FaultsList = new FaultsListPresenter(this);
           FaultsList.getData(user_id, token);
       }

        final LbBSbean bean = SharedUtils.getBeanByFastJson(FragementActivity.this, "data", "LbsData", LbBSbean.class);//缓存的JSON映射到LbBSbean实体类
        if (bean==null) {
            Intent intent = new Intent(FragementActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }


        listView = findViewById(android.R.id.list);
        newsList = new ArrayList<>();//初始化ArrayList<Map<String,Object>>
        if (bean!=null){
            for (int i = 0; i < bean.getLabs().size(); i++) {
                Map<String, Object> listItem = new HashMap<>();
                listItem.put("lab_name",bean.getLabs().get(i).getLab_name().toString());//获取到实体类list通过.get()获取到里面的对象
                listItem.put("Td_name",bean.getLabs().get(i).getTb_name().toString());
                listItem.put("lab_id",bean.getLabs().get(i).getLab_id());
                newsList.add(listItem);
                System.out.print(newsList);
            }}else {
            System.out.print("bean为空");
        }

         SimpleAdapter adapter = new SimpleAdapter(FragementActivity.this,newsList, R.layout.list_item_card,
                 new String[]{"lab_name","Td_name"}, new int[]{R.id.name,R.id.Td_name});
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long ID) {

                int Lab_id = bean.getLabs().get(i).getLab_id();
                int tb_id = bean.getLabs().get(i).getTb_id();

                Bundle bundle = new Bundle();
                bundle.putInt("Lab_id",Lab_id);
                bundle.putInt("Tb_id",tb_id);

                Intent intent = new Intent(FragementActivity.this,SubmitActivity.class);
                intent.putExtras(bundle);

                startActivity(intent);

            }
        });







    }




    //初始化控件
    private void initViews() {
      /*  mViewPager = (ViewPager) findViewById(R.id.id_viewpager);
        //初始化RadioGroup按钮
        mGroup = (RadioGroup) findViewById(R.id.radioGroup);
       myCircle = (RadioButton) findViewById(R.id.id_tab_mycircle);
     *//*   myDisconvery = (RadioButton) findViewById(R.id.id_tab_discovery);
        myMsg = (RadioButton) findViewById(R.id.id_tab_message);*//*
        myCenter = (RadioButton) findViewById(R.id.id_tab_setting);
      *//*  myPuls = (RadioButton) findViewById(R.id.id_tab_puls);*/

        //侧滑栏
        mListView = (ListView) findViewById(R.id.id_lv);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.id_drawerlayout);
        toolbar = (Toolbar) findViewById(R.id.tl_custom);
        exitBon = (Button) findViewById(R.id.exitBon);
        username = findViewById(R.id.usernameTT);
        ddBon =findViewById(R.id.DDBon);
        myweb = findViewById(R.id.Myweb);

        //在xml中，要加载的ListView的id必须设置为 android:id="@+id/android:list"  !!!
        // 而在代码中ListView的名称必须设置为list
        listView = findViewById(android.R.id.list);
    }

    private void initViewPages() {
       /* //初始化四个布局
        Fragment01 tab01 = new Fragment01();
        Fragment04 tab02 = new Fragment04();
        mFragments.add(tab01);
        mFragments.add(tab02);


        //初始化Adapter这里使用FragmentPagerAdapter
        mAdpter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            //返回Fragment对象
            @Override
            public Fragment getItem(int position) {

                return mFragments.get(position);

            }
            //Viewpage页面数量
            @Override
            public int getCount() {
                return mFragments.size();
            }


        };
        mViewPager.setAdapter(mAdpter);*/

    }

    //监听逻辑事件
    public void initEvent() {
        //监听RadioGroup
   /*     mGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.id_tab_mycircle:
                        mViewPager.setCurrentItem(0, false);
                        break;
                    case R.id.id_tab_setting:
                        mViewPager.setCurrentItem(4, false);
                        break;
                    default:
                        break;

                }
            }
        });

        //监听Page滑动
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                //当viewPager滑动的时候
                switch (position) {
                    case 0:
                        mGroup.check(R.id.id_tab_mycircle);
                        break;

                    case 1:
                        mGroup.check(R.id.id_tab_setting);
                        break;

                        default:
                       break;

                       *//*  case 1:
                       mGroup.check(R.id.id_tab_discovery);
                        break;
                    case 2:
                        mGroup.check(R.id.id_tab_puls);
                        break;
                    case 3:
                        mGroup.check(R.id.id_tab_message);
                        break;*//*
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


      *//*
      * *//**//*设置listView的Adapter*//**//*
        //将图片和文字加入到listview中
        List<Map<String, Object>> listItems = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            Map<String, Object> listItem = new HashMap<>();
            listItem.put("Img", imgIds[i]);
            listItem.put("text", strs[i]);
            listItems.add(listItem);
        }
        //创建SimpleAdapter
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, listItems,
                R.layout.simpleitem, new String[]{"Img", "text"},
                new int[]{R.id.Img, R.id.textView});
        mListView.setAdapter(simpleAdapter);
*/


        //ToolBar

        toolbar.setTitle("腾易—在线报修");//设置Toolbar标题
        toolbar.setTitleTextColor(Color.parseColor("#ffffff")); //设置标题颜色


        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);// 给左上角图标的左边加上一个返回的图标
       getSupportActionBar().setHomeButtonEnabled(true);//左上角图标是否可以点击

        mDrawerToggle = new ActionBarDrawerToggle(this,
                mDrawerLayout,
                toolbar,
                R.string.drawopen,
                R.string.drawclose) {

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                toolbar.setTitle("个人中心");

            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                toolbar.setTitle("腾易—在线报修");
            }


        };


        mDrawerToggle.syncState();//设置显示三条杠
        mDrawerLayout.setDrawerListener(mDrawerToggle);

        //监听退出按钮
        exitBon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragementActivity.this.finish();
                SharedUtils.clear(FragementActivity.this);
                startActivity(new Intent(FragementActivity.this,MainActivity.class));
                finish();


            }
        });

        //监听订单按钮
        ddBon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(FragementActivity.this,OrderActivty.class));

            }
        });

        myweb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Uri uri = Uri.parse("http://www.tenyi.net");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);


            }
        });

    }

    //optionMenus
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
     //   getMenuInflater().inflate(R.menu.menu_main, menu);//打开右边菜单
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        //此处进行Item逻辑判断处理
        return super.onOptionsItemSelected(item);
    }
    //
    // 通过反射，设置menu显示icon
    // 显示出optionmenu的按钮图标，使用反射让其显示出来
    @Override
    public boolean onMenuOpened(int featureId, Menu menu) {
        if (menu != null) {
            if (menu.getClass().getSimpleName().equals("MenuBuilder")) {

                try {
                    Method m = menu.getClass().getDeclaredMethod(
                            "setOptionalIconsVisible", Boolean.TYPE);
                    m.setAccessible(true);
                    m.invoke(menu, true);
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

            }
        }

        return false;//关闭系统menu按键
    }
    @Override
    public void onClick(View v) {


    }



//故障列表
    @Override
    public void failed(int code) {

    }
    @Override
    public void sucess(FAULTSBean FAULTSListbean) {

        System.out.print("测试故障列表"+FAULTSListbean.getFaultsList());

        if (FAULTSListbean.getError_code() == 0) {
            /*  Thread.sleep(1000);*/
            SharedUtils.saveBeanByFastJson(FragementActivity.this, "data", "FaultsData", FAULTSListbean);

        }else if(FAULTSListbean.getError_code() == 10001){
            System.out.print("token错误"+FAULTSListbean.getError_code());
        }else if (FAULTSListbean.getError_code()==20001){
            System.out.print("教学楼不存在"+FAULTSListbean.getError_code());
        }else {
            System.out.print("参数错误"+FAULTSListbean.getError_code());
        }
    }


    //机房
    @Override
    public void sucess(LbBSbean LbsBean) {

        System.out.print("测试LBS"+LbsBean.getLabs());

        if (LbsBean.getError_code() == 0) {
           //   Thread.sleep(1000);
            SharedUtils.saveBeanByFastJson(FragementActivity.this, "data", "LbsData", LbsBean);

        }else if(LbsBean.getError_code() == 20001){
                System.out.print("token错误"+LbsBean.getError_code());
        }else{
            System.out.print("参数丢失"+LbsBean.getError_code());
        }
    }


    //监听返回键
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            exit();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    //退出方法
    private void exit() {
        if ((System.currentTimeMillis() - mExitTime) > 2000) {
            Toast.makeText(FragementActivity.this, "再按一次退出应用", Toast.LENGTH_SHORT).show();
            mExitTime = System.currentTimeMillis();
        } else {
            //用户退出处理
            finish();
            System.exit(0);
        }
    }


}