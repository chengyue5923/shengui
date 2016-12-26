package com.shengui.app.android.shengui.android.ui.activity.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.shengui.app.android.shengui.R;
import com.shengui.app.android.shengui.android.base.BaseActivity;
import com.shengui.app.android.shengui.android.ui.utilsview.NoScrollListView;
import com.shengui.app.android.shengui.android.ui.view.ActivityQuanziListAdapter;
import com.shengui.app.android.shengui.models.ProductModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;

import static android.R.id.list;
import static android.R.id.switchInputMethod;

/**
 * Created by admin on 2016/12/20.
 */

public class SgQuanziListActivity extends BaseActivity implements View.OnClickListener {
    @Bind(R.id.cancelTextView)
    TextView cancelTextView;
    @Bind(R.id.pushTextView)
    TextView pushTextView;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.listview)
    NoScrollListView listview;
    @Bind(R.id.activity_main)
    LinearLayout activityMain;

    ActivityQuanziListAdapter adapter;
    List<ProductModel> modellist;

    @Override
    protected void initView() {
        ButterKnife.bind(this);
    }

    @Override
    protected void initEvent() {
        cancelTextView.setOnClickListener(this);
        pushTextView.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        adapter=new ActivityQuanziListAdapter(this);
        listview.setAdapter(adapter);
        modellist=new ArrayList<>();
        for(int i=0;i<20;i++){
            modellist.add(new ProductModel());
        }
        adapter.setRes(modellist);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_quanzi_list_activity;
    }

    @Override
    public void onData(Serializable result, int flag, boolean fromNet, Object o, Map<String, Object> param) {

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case  R.id.pushTextView:
                finish();
                break;
            case  R.id.cancelTextView:
                finish();
                break;
        }
    }
}
