package com.shengui.app.android.shengui.android.ui.activity.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.shengui.app.android.shengui.R;
import com.shengui.app.android.shengui.android.base.BaseActivity;
import com.shengui.app.android.shengui.android.ui.view.MyFragmentPagerAdapter;
import com.shengui.app.android.shengui.android.ui.view.QuanziDetailListPagerAdapter;
import com.shengui.app.android.shengui.utils.android.IntentTools;

import java.io.Serializable;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by admin on 2016/12/23.
 */

public class SgGuiQuanDetailActivityNewActivity extends BaseActivity implements View.OnClickListener  {
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private MyFragmentPagerAdapter myFragmentPagerAdapter;
    private TabLayout.Tab one;
    private TabLayout.Tab two;
    private TabLayout.Tab three;
    private TabLayout.Tab four;
    private TabLayout.Tab five;
    private ImageView backImageView;
    private TextView topLayout;
    private RelativeLayout titlenameLayout,allLayout;

//    private Toolbar mToolBar;


    @Override
    protected void initView() {
        ButterKnife.bind(this);
        backImageView=(ImageView)findViewById(R.id.backImageView);
        topLayout=(TextView)findViewById(R.id.topLayout);
        titlenameLayout=(RelativeLayout)findViewById(R.id.titlenameLayout);
        allLayout=(RelativeLayout)findViewById(R.id.allLayout);
//        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);  //隐藏掉系统原先的导航栏
//        mToolBar = (Toolbar) findViewById(R.id.mToolBar);
//        setSupportActionBar(mToolBar);   //把toolbar作为导航栏
        mTabLayout = (TabLayout) findViewById(R.id.tab_main);
        mViewPager = (ViewPager) findViewById(R.id.vp_main);
        myFragmentPagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(myFragmentPagerAdapter);


        //将TabLayout和ViewPager绑定在一起，使双方各自的改变都能直接影响另一方，解放了开发人员对双方变动事件的监听
        mTabLayout.setupWithViewPager(mViewPager);

        //指定Tab的位置
        one = mTabLayout.getTabAt(0);
        two = mTabLayout.getTabAt(1);
        three = mTabLayout.getTabAt(2);
        four = mTabLayout.getTabAt(3);
        five = mTabLayout.getTabAt(4);
    }

    @Override
    protected void initEvent() {
        backImageView.setOnClickListener(this);
        topLayout.setOnClickListener(this);
        titlenameLayout.setOnClickListener(this);
        allLayout.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_gui_quan_detail_new_activity;
    }

    @Override
    public void onData(Serializable result, int flag, boolean fromNet, Object o, Map<String, Object> param) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.backImageView:
                finish();
                break;
            case R.id.topLayout:
                break;
            case R.id.titlenameLayout:
                IntentTools.startquanziDetail(this);
                break;
            case R.id.allLayout:
                break;
        }

    }
}
