package com.shengui.app.android.shengui.android.ui.activity.activity;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.base.platform.utils.android.Logger;
import com.shengui.app.android.shengui.R;
import com.shengui.app.android.shengui.android.base.BaseActivity;
import com.shengui.app.android.shengui.android.ui.fragment.GuiMiFragment;
import com.shengui.app.android.shengui.android.ui.fragment.SelectFragment;
import com.shengui.app.android.shengui.android.ui.fragment.SgMineFragment;
import com.shengui.app.android.shengui.utils.im.CommonUtil;
import com.umeng.analytics.MobclickAgent;

import java.io.Serializable;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by yanbo on 16-7-4.
 */
public class MainTabActivity extends BaseActivity {

    @Bind(R.id.realtabcontent)
    FrameLayout realtabcontent;
    //    @Bind(R.id.drawer_layout)
//    LinearLayout drawerLayout;
    @Bind(R.id.tv_featured)
    TextView featured;
    @Bind(R.id.tv_service)
    TextView service;
    @Bind(R.id.tv_mine)
    TextView mine;
    @Bind(R.id.im_featured)
    ImageView imFeatured;
    @Bind(R.id.im_service)
    ImageView imService;
    @Bind(R.id.im_mine)
    ImageView imMine;
    @Bind(R.id.startLayout)
    RelativeLayout startLayout;
    @Bind(R.id.guimiLayout)
    RelativeLayout guimiLayout;
    @Bind(R.id.mineLayout)
    RelativeLayout mineLayout;

    private Fragment curFragment;
    private SelectFragment selectedFragment;
    private GuiMiFragment serviceFragment;
    private SgMineFragment customerMineFragment;
    private int colorBlue = 0xfffc7b42;
    private int colorGray = 0xff9f9f9f;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MobclickAgent.openActivityDurationTrack(false);
    }

    @Override
    protected void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);       //统计时长
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                try {
                    if (curFragment instanceof GuiMiFragment) {
                        CommonUtil.FlymeSetStatusBarLightMode(getWindow(), true);
                        CommonUtil.MIUISetStatusBarLightMode(getWindow(), true);
                    } else if ((curFragment instanceof SelectFragment)) {
                        CommonUtil.FlymeSetStatusBarLightMode(getWindow(), false);
                        CommonUtil.MIUISetStatusBarLightMode(getWindow(), false);
                    } else if (curFragment instanceof SgMineFragment) {
                        CommonUtil.FlymeSetStatusBarLightMode(getWindow(), true);
                        CommonUtil.MIUISetStatusBarLightMode(getWindow(), true);
                    }
                } catch (Exception e) {
                }
            }
        }, 889);
    }

    @Override
    protected void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
//        boolean needAnim = getIntent().getBooleanExtra("needAnim",true);
//        if(needAnim){
//            IntentTools.startLoadingAnim(this,false);
//            new CountDownTimer(1000,1000){
//
//                @Override
//                public void onTick(long millisUntilFinished) {
//
//                }
//
//                @Override
//                public void onFinish() {
////                    toSelectedFragment();
//                    findViewById(R.id.ll_transition).setVisibility(View.GONE);
//                }
//            }.start();
//
//        }
//        else{
////            toSelectedFragment();
//            findViewById(R.id.ll_transition).setVisibility(View.GONE);
//        }
        toSelectedFragment();
//        CommonUtil.FlymeSetStatusBarLightMode(getWindow(), true);
//        CommonUtil.MIUISetStatusBarLightMode(getWindow(), true);

        initBar();
    }

    @Override
    protected void initEvent() {
//        mainTabSelectedLayout.setOnClickListener(layoutClickListener);
//        tabMenuServiceIv.setOnClickListener(layoutClickListener);
//        mainTabWealthLayout.setOnClickListener(layoutClickListener);

        featured.setOnClickListener(layoutClickListener);
        service.setOnClickListener(layoutClickListener);
        mine.setOnClickListener(layoutClickListener);

        imFeatured.setOnClickListener(layoutClickListener);
        imService.setOnClickListener(layoutClickListener);
        imMine.setOnClickListener(layoutClickListener);

        startLayout.setOnClickListener(layoutClickListener);
        guimiLayout.setOnClickListener(layoutClickListener);
        mineLayout.setOnClickListener(layoutClickListener);
    }

    @Override
    protected void initData() {
//        UserController.getInstance().userInfo(this);
//        LoginController.getInstance().bindDevice(MainTabActivity.this, UmengRegistrar.getRegistrationId(MainTabActivity.this));
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    View.OnClickListener layoutClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.im_featured:
                    toSelectedFragment();
                    break;
                case R.id.im_service:
                    toServiceFragment();
                    break;
                case R.id.im_mine:
                    toCustomerMyFragment();
                    break;
                case R.id.startLayout:
                    toSelectedFragment();
                    break;
                case R.id.guimiLayout:
                    toServiceFragment();
                    break;
                case R.id.mineLayout:
                    toCustomerMyFragment();
                    break;
            }
        }
    };


    @Override
    public void onWindowAttributesChanged(WindowManager.LayoutParams params) {
        super.onWindowAttributesChanged(params);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        Logger.e("MaintabActivity----onWindowFocusChanged");

    }

    private void toServiceFragment() {
        CommonUtil.FlymeSetStatusBarLightMode(getWindow(), true);
        CommonUtil.MIUISetStatusBarLightMode(getWindow(), true);
        clearAllMenu();
//        service.setSelected(true);
        setSelected(1);
        serviceFragment = (GuiMiFragment) getSupportFragmentManager()
                .findFragmentByTag(GuiMiFragment.class.getName());
        if (null == serviceFragment) {
            serviceFragment = GuiMiFragment.newInstance();
        }
        switchContent(R.id.realtabcontent, curFragment, serviceFragment,
                GuiMiFragment.class.getName());
    }


    private void toCustomerMyFragment() {
        CommonUtil.FlymeSetStatusBarLightMode(getWindow(), true);
        CommonUtil.MIUISetStatusBarLightMode(getWindow(), true);
        clearAllMenu();

//        mine.setSelected(true);
        setSelected(2);
        customerMineFragment = (SgMineFragment) getSupportFragmentManager()
                .findFragmentByTag(SgMineFragment.class.getName());
        if (null == customerMineFragment) {
            customerMineFragment = SgMineFragment.newInstance();
        }
        switchContent(R.id.realtabcontent, curFragment, customerMineFragment,
                SgMineFragment.class.getName());
    }

    private void toSelectedFragment() {
        CommonUtil.FlymeSetStatusBarLightMode(getWindow(), false);
        CommonUtil.MIUISetStatusBarLightMode(getWindow(), false);
        clearAllMenu();
//        featured.setSelected(true);
//        setSelected(featured, service, mine);
        setSelected(0);
        selectedFragment = (SelectFragment) getSupportFragmentManager()
                .findFragmentByTag(SelectFragment.class.getName());
        if (null == selectedFragment) {
            selectedFragment = SelectFragment.newInstance();
        }
        switchContent(R.id.realtabcontent, curFragment, selectedFragment,
                SelectFragment.class.getName());
    }

    public void switchContent(int id, Fragment from, Fragment to, String tag) {
        if (from != to) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            if (!to.isAdded()) {    // 先判断是否被add过
                if (null == from) {
                    transaction.add(id, to, tag).commitAllowingStateLoss(); // 隐藏当前的fragment，add下一个到Activity中
                } else {
                    transaction.hide(from).add(id, to, tag).commitAllowingStateLoss(); // 隐藏当前的fragment，add下一个到Activity中
                }
            } else {
                if (null == from) {
                    transaction.show(to).commitAllowingStateLoss(); // 隐藏当前的fragment，显示下一个
                } else {
                    transaction.hide(from).show(to).commitAllowingStateLoss(); // 隐藏当前的fragment，显示下一个
                }
            }
            curFragment = to;
        }
    }

    private void setSelected(TextView tv1, TextView tv2, TextView tv3) {
        tv1.setTextColor(colorBlue);
        tv2.setTextColor(colorGray);
        tv3.setTextColor(colorGray);
    }

    private void setSelected(int flags) {
        switch (flags) {
            case 0:
                imFeatured.setBackgroundResource(R.drawable.start_select_img);
                imService.setBackgroundResource(R.drawable.guimi_unselect_img);
                imMine.setBackgroundResource(R.drawable.ming_unselect_img);
                break;
            case 1:
                imFeatured.setBackgroundResource(R.drawable.start_unselect_img);
                imService.setBackgroundResource(R.drawable.guimi_select_img);
                imMine.setBackgroundResource(R.drawable.ming_unselect_img);
                break;
            case 2:
                imFeatured.setBackgroundResource(R.drawable.start_unselect_img);
                imService.setBackgroundResource(R.drawable.guimi_unselect_img);
                imMine.setBackgroundResource(R.drawable.mine_select_img);
                break;
        }
    }

    private void setUnSelected(TextView tv1, TextView tv2, TextView tv3) {
        tv1.setTextColor(colorGray);
        tv2.setTextColor(colorGray);
        tv3.setTextColor(colorGray);
        imFeatured.setBackgroundResource(R.drawable.start_unselect_img);
        imService.setBackgroundResource(R.drawable.guimi_unselect_img);
        imMine.setBackgroundResource(R.drawable.ming_unselect_img);
    }

    protected void onSaveInstanceState(Bundle outState) {
        if (null != curFragment) {
            outState.putString("tag", curFragment.getTag());
            getSupportFragmentManager().putFragment(outState, curFragment.getTag(),
                    curFragment);
        }
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String tag = savedInstanceState.getString("tag");
        Fragment fragment = getSupportFragmentManager().getFragment(
                savedInstanceState, tag);
        curFragment = fragment;
        if (SelectFragment.class.getName().equalsIgnoreCase(tag)) {
            toSelectedFragment();
        } else if (GuiMiFragment.class.getName().equalsIgnoreCase(tag)) {
            toServiceFragment();
        } else if (SgMineFragment.class.getName().equalsIgnoreCase(tag)) {
            toCustomerMyFragment();
        }
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        for (Fragment f : getSupportFragmentManager().getFragments()) {
            if (null == f) {
                continue;
            }
            if (!f.getTag().equalsIgnoreCase(tag)) {
                ft.hide(f);
            }
            /*else {
                ft.show(f);
			}*/
        }
        ft.commit();
    }

    /****
     * 清除按钮的选中状态
     */
    private void clearAllMenu() {
//        tabMenuSelectedTextCN.setSelected(false);
//        tabMenuServiceIv.setSelected(false);
//        tabMenuWealthTextCN.setSelected(false);
//        tabMenuSelectedEN.setSelected(false);
//        tabMenuWealthTextEN.setSelected(false);

        service.setSelected(false);
        featured.setSelected(false);
        mine.setSelected(false);
        setUnSelected(featured, service, mine);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    @Override
    public void onData(Serializable result, int flag, boolean fromNet, Object o, Map<String, Object> param) {
//        if (flag == HttpConfig.userInfo.getType()) {
//            UserModel model = (UserModel) result;
//            UserPreference.setUser(model);
//            EventBus.getDefault().post(new UpdateAvatarEvent());
//        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            ExitApp();
        }
        return false;
    }

    /****
     * 再按一次退出程序
     */
    private long exitTime = 0;

    public void ExitApp() {
        if ((System.currentTimeMillis() - exitTime) > 2000) {
            Toast.makeText(this, "再按一次退出龟蜜", Toast.LENGTH_SHORT).show();
            exitTime = System.currentTimeMillis();
        } else {
            this.finish();
        }
    }


}
