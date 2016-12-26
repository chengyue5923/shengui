package com.shengui.app.android.shengui.android.ui.activity.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.shengui.app.android.shengui.R;
import com.shengui.app.android.shengui.android.base.BaseActivity;
import com.shengui.app.android.shengui.android.ui.view.HotMinePagerAdapter;
import com.shengui.app.android.shengui.utils.android.Logger;

import java.io.Serializable;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by admin on 2016/12/22.
 */

public class SgHotQuanZiListActivity extends BaseActivity implements ViewPager.OnPageChangeListener, View.OnClickListener {
    HotMinePagerAdapter adapter;
    @Bind(R.id.my_pager)
    ViewPager myPager;
    @Bind(R.id.hotlayout)
    TextView hotlayout;
    @Bind(R.id.originzationLayout)
    TextView originzationLayout;
    @Bind(R.id.allLayout)
    TextView allLayout;
    @Bind(R.id.mineLayout)
    TextView mineLayout;
    @Bind(R.id.line)
    View line;
    @Bind(R.id.backImageview)
    ImageView backImageview;
    @Bind(R.id.createTextView)
    TextView createTextView;
    @Bind(R.id.hotlineView)
    View hotlineView;
    @Bind(R.id.origiazationlineView)
    View origiazationlineView;
    @Bind(R.id.alllineView)
    View alllineView;
    @Bind(R.id.minelineView)
    View minelineView;
    @Bind(R.id.myTabLayout)
    LinearLayout myTabLayout;
    @Bind(R.id.topLayout)
    RelativeLayout topLayout;

    @Override
    protected void initView() {

        ButterKnife.bind(this);
        myPager.setOffscreenPageLimit(4);
        String[] strings = getResources().getStringArray(R.array.mine_tab);
        myPager.setOnPageChangeListener(this);
        adapter = new HotMinePagerAdapter(getSupportFragmentManager(), strings);
        myPager.setAdapter(adapter);
    }

    @Override
    protected void initEvent() {
        hotlayout.setOnClickListener(this);
        originzationLayout.setOnClickListener(this);
        allLayout.setOnClickListener(this);
        mineLayout.setOnClickListener(this);
        backImageview.setOnClickListener(this);
        createTextView.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_hot_list_activity;
    }

    @Override
    public void onData(Serializable result, int flag, boolean fromNet, Object o, Map<String, Object> param) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        setCurrentTab(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.hotlayout:
                setCurrentTab(0);
                break;
            case R.id.originzationLayout:
                setCurrentTab(1);
                break;
            case R.id.allLayout:
                setCurrentTab(2);
                break;
            case R.id.mineLayout:
                setCurrentTab(3);
                break;
            case R.id.backImageview:
                finish();
                break;
            case R.id.createTextView:
                Logger.e("create----------");
                break;
        }
    }

    private void setCurrentTab(int index) {
        ChangeView(index);
        myPager.setCurrentItem(index);
    }
    public void ChangeView(int flags){
        switch (flags){
            case 0:
                hotlayout.setTextColor(getResources().getColor(R.color.shenguiappcolor));
                hotlineView.setBackgroundColor(getResources().getColor(R.color.shenguiappcolor));
                originzationLayout.setTextColor(getResources().getColor(R.color.titlecolor));
                origiazationlineView.setBackgroundColor(getResources().getColor(R.color.white));
                allLayout.setTextColor(getResources().getColor(R.color.titlecolor));
                alllineView.setBackgroundColor(getResources().getColor(R.color.white));
                mineLayout.setTextColor(getResources().getColor(R.color.titlecolor));
                minelineView.setBackgroundColor(getResources().getColor(R.color.white));
                break;
            case 1:
                hotlayout.setTextColor(getResources().getColor(R.color.titlecolor));
                hotlineView.setBackgroundColor(getResources().getColor(R.color.white));
                originzationLayout.setTextColor(getResources().getColor(R.color.shenguiappcolor));
                origiazationlineView.setBackgroundColor(getResources().getColor(R.color.shenguiappcolor));
                allLayout.setTextColor(getResources().getColor(R.color.titlecolor));
                alllineView.setBackgroundColor(getResources().getColor(R.color.white));
                mineLayout.setTextColor(getResources().getColor(R.color.titlecolor));
                minelineView.setBackgroundColor(getResources().getColor(R.color.white));
                break;
            case 2:
                hotlayout.setTextColor(getResources().getColor(R.color.titlecolor));
                hotlineView.setBackgroundColor(getResources().getColor(R.color.white));

                originzationLayout.setTextColor(getResources().getColor(R.color.titlecolor));
                origiazationlineView.setBackgroundColor(getResources().getColor(R.color.white));
                allLayout.setTextColor(getResources().getColor(R.color.shenguiappcolor));
                alllineView.setBackgroundColor(getResources().getColor(R.color.shenguiappcolor));
                mineLayout.setTextColor(getResources().getColor(R.color.titlecolor));
                minelineView.setBackgroundColor(getResources().getColor(R.color.white));
                break;
            case 3:
                hotlayout.setTextColor(getResources().getColor(R.color.titlecolor));
                hotlineView.setBackgroundColor(getResources().getColor(R.color.white));
                originzationLayout.setTextColor(getResources().getColor(R.color.titlecolor));
                origiazationlineView.setBackgroundColor(getResources().getColor(R.color.white));
                allLayout.setTextColor(getResources().getColor(R.color.titlecolor));
                alllineView.setBackgroundColor(getResources().getColor(R.color.white));
                mineLayout.setTextColor(getResources().getColor(R.color.shenguiappcolor));
                minelineView.setBackgroundColor(getResources().getColor(R.color.shenguiappcolor));
                break;
        }

    }

}
