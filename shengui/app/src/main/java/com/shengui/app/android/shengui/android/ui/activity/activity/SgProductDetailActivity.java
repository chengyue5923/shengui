package com.shengui.app.android.shengui.android.ui.activity.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.shengui.app.android.shengui.R;
import com.shengui.app.android.shengui.android.base.BaseActivity;
import com.shengui.app.android.shengui.android.ui.utilsview.CircleImageView;
import com.shengui.app.android.shengui.android.ui.utilsview.ImagePagerView;
import com.shengui.app.android.shengui.android.ui.utilsview.ScrollViewExtend;

import java.io.Serializable;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by admin on 2016/12/16.
 */

public class SgProductDetailActivity extends BaseActivity implements View.OnClickListener {
    @Bind(R.id.collectLayout)
    RelativeLayout collectLayout;
    @Bind(R.id.chatDetail)
    RelativeLayout chatDetail;
    @Bind(R.id.phoneLayout)
    RelativeLayout phoneLayout;
    @Bind(R.id.bottomLayout)
    LinearLayout bottomLayout;
    @Bind(R.id.backImageView)
    ImageView backImageView;
    @Bind(R.id.shareForUser)
    ImageView shareForUser;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.pager)
    ImagePagerView pager;
    @Bind(R.id.detailTitleview)
    TextView detailTitleview;
    @Bind(R.id.productBuyText)
    TextView productBuyText;
    @Bind(R.id.productBuyTypeText)
    TextView productBuyTypeText;
    @Bind(R.id.detailDostanceText)
    TextView detailDostanceText;
    @Bind(R.id.DetailContentTextView)
    TextView DetailContentTextView;
    @Bind(R.id.detailNumberText)
    TextView detailNumberText;
    @Bind(R.id.personInfoIv)
    CircleImageView personInfoIv;
    @Bind(R.id.personInaDetailText)
    TextView personInaDetailText;
    @Bind(R.id.personNameText)
    TextView personNameText;
    @Bind(R.id.PersonInfoAddress)
    TextView PersonInfoAddress;
    @Bind(R.id.PersonInfoPhoneNumber)
    TextView PersonInfoPhoneNumber;
    @Bind(R.id.scrollView)
    ScrollViewExtend scrollView;
    @Bind(R.id.activity_main)
    RelativeLayout activityMain;

    @Override
    protected void initView() {

        ButterKnife.bind(this);
    }

    @Override
    protected void initEvent() {
        backImageView.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_guimi_detail_page;
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
        }
    }
}
