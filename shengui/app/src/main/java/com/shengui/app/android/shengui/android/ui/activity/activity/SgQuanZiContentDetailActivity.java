package com.shengui.app.android.shengui.android.ui.activity.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.shengui.app.android.shengui.R;
import com.shengui.app.android.shengui.android.base.BaseActivity;
import com.shengui.app.android.shengui.android.ui.dialog.ShareInvationPopUpDialog;
import com.shengui.app.android.shengui.android.ui.dialog.ShareReportPopUpDialog;
import com.shengui.app.android.shengui.android.ui.utilsview.CircleImageView;

import java.io.Serializable;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by admin on 2016/12/26.
 */

public class SgQuanZiContentDetailActivity extends BaseActivity implements View.OnClickListener {
    @Bind(R.id.backImageView)
    ImageView backImageView;
    @Bind(R.id.NameText)
    TextView NameText;
    @Bind(R.id.topLayout)
    TextView topLayout;
    @Bind(R.id.personInfoIv)
    CircleImageView personInfoIv;
    @Bind(R.id.nextDetailLayout)
    ImageView nextDetailLayout;
    @Bind(R.id.QuanZiNameText)
    TextView QuanZiNameText;
    @Bind(R.id.QuanzitypeText)
    TextView QuanzitypeText;
    @Bind(R.id.topLauout)
    RelativeLayout topLauout;
    @Bind(R.id.NumberTextView)
    TextView NumberTextView;
    @Bind(R.id.tiezaiNumberText)
    TextView tiezaiNumberText;
    @Bind(R.id.addressQuanziText)
    TextView addressQuanziText;
    @Bind(R.id.textDetail)
    TextView textDetail;
    @Bind(R.id.titlenameLayout)
    RelativeLayout titlenameLayout;
    @Bind(R.id.allTextView)
    TextView allTextView;
    @Bind(R.id.personInfoIvItemd)
    CircleImageView personInfoIvItemd;
    @Bind(R.id.personOnelayout)
    RelativeLayout personOnelayout;
    @Bind(R.id.personInfoIvItemtwo)
    CircleImageView personInfoIvItemtwo;
    @Bind(R.id.personTwolayout)
    RelativeLayout personTwolayout;
    @Bind(R.id.personInfoIvthree)
    CircleImageView personInfoIvthree;
    @Bind(R.id.personThreelayout)
    RelativeLayout personThreelayout;
    @Bind(R.id.personInfoIvfour)
    CircleImageView personInfoIvfour;
    @Bind(R.id.personfourlayout)
    RelativeLayout personfourlayout;
    @Bind(R.id.personInfoIvfive)
    CircleImageView personInfoIvfive;
    @Bind(R.id.personfivelayout)
    RelativeLayout personfivelayout;
    @Bind(R.id.personInfoIvItemdsix)
    CircleImageView personInfoIvItemdsix;
    @Bind(R.id.personsixlayout)
    RelativeLayout personsixlayout;
    @Bind(R.id.allLayout)
    RelativeLayout allLayout;
    @Bind(R.id.contentDetailText)
    TextView contentDetailText;
    @Bind(R.id.reportText)
    TextView reportText;
    @Bind(R.id.contentlayout)
    LinearLayout contentlayout;
    @Bind(R.id.exitText)
    TextView exitText;
    @Bind(R.id.JoinQuznIText)
    TextView JoinQuznIText;
    @Bind(R.id.activity_main)
    RelativeLayout activityMain;

    @Override
    protected void initView() {
        ButterKnife.bind(this);

    }

    @Override
    protected void initEvent() {
        backImageView.setOnClickListener(this);
        topLayout.setOnClickListener(this);
        exitText.setOnClickListener(this);
        JoinQuznIText.setOnClickListener(this);
        reportText.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_quanzi_content_detail_activity;
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
                ShareJinghuaPopUpDialog();
                break;
            case R.id.exitText:

                break;
            case R.id.JoinQuznIText:
                break;
            case R.id.reportText:
                ShareReportPopUpDialog();
                break;
        }
    }
    //邀请好友弹窗
    public void ShareJinghuaPopUpDialog() {   //弹框
        ShareInvationPopUpDialog PopUpDialogs = new ShareInvationPopUpDialog(this);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        PopUpDialogs.show(fragmentTransaction, "SharePopUpDialog");
    }
    //举报弹窗
    public void ShareReportPopUpDialog() {   //弹框
        ShareReportPopUpDialog PopUpDialogs = new ShareReportPopUpDialog(this);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        PopUpDialogs.show(fragmentTransaction, "SharePopUpDialog");
    }

}
