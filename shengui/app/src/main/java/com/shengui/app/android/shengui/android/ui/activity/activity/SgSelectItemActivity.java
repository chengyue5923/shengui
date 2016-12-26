package com.shengui.app.android.shengui.android.ui.activity.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.shengui.app.android.shengui.R;
import com.shengui.app.android.shengui.android.base.BaseActivity;

import java.io.Serializable;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by admin on 2016/12/15.
 */

public class SgSelectItemActivity extends BaseActivity implements View.OnClickListener {
    @Bind(R.id.cancelTextView)
    TextView cancelTextView;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.sellTextView)
    TextView sellTextView;
    @Bind(R.id.BuyTextView)
    TextView BuyTextView;
    @Bind(R.id.addressSelectLayout)
    RelativeLayout addressSelectLayout;
    @Bind(R.id.typeSelectLayout)
    RelativeLayout typeSelectLayout;
    @Bind(R.id.text)
    TextView text;
    @Bind(R.id.SureButtonView)
    TextView SureButtonView;
    @Bind(R.id.drawer_layout)
    LinearLayout drawerLayout;

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.cancelTextView:
                finish();
                break;
            case R.id.sellTextView:
                ChangeTypeItem(true);
                break;
            case R.id.BuyTextView:
                ChangeTypeItem(false);
                break;
            case R.id.addressSelectLayout:
                break;
            case R.id.typeSelectLayout:
                break;
            case R.id.SureButtonView:
                finish();
                break;
        }
    }

    private void ChangeTypeItem(boolean isSell) {
        if(isSell){
            sellTextView.setBackgroundResource(R.drawable.activity_select_item_select);
            BuyTextView.setBackgroundResource(R.drawable.activity_select_item_unselect);
            sellTextView.setTextColor(getResources().getColor(R.color.white));
            BuyTextView.setTextColor(getResources().getColor(R.color.shenguiappcolor));
        }else{
            sellTextView.setBackgroundResource(R.drawable.activity_select_item_unselect);
            BuyTextView.setBackgroundResource(R.drawable.activity_select_item_select);
            sellTextView.setTextColor(getResources().getColor(R.color.shenguiappcolor));
            BuyTextView.setTextColor(getResources().getColor(R.color.white));
        }
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
    }

    @Override
    protected void initEvent() {
        cancelTextView.setOnClickListener(this);
        sellTextView.setOnClickListener(this);
        BuyTextView.setOnClickListener(this);
        addressSelectLayout.setOnClickListener(this);
        typeSelectLayout.setOnClickListener(this);
        SureButtonView.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_search_item;
    }

    @Override
    public void onData(Serializable result, int flag, boolean fromNet, Object o, Map<String, Object> param) {

    }

}
