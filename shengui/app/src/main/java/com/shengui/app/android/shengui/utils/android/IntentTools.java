package com.shengui.app.android.shengui.utils.android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;


import com.shengui.app.android.shengui.android.ui.activity.activity.MainTabActivity;
import com.shengui.app.android.shengui.android.ui.activity.activity.SgGuiQuanDetailActivity;
import com.shengui.app.android.shengui.android.ui.activity.activity.SgGuiQuanDetailActivityNewActivity;
import com.shengui.app.android.shengui.android.ui.activity.activity.SgHotQuanZiListActivity;
import com.shengui.app.android.shengui.android.ui.activity.activity.SgProductDetailActivity;
import com.shengui.app.android.shengui.android.ui.activity.activity.SgPushGongQiuDetailActivity;
import com.shengui.app.android.shengui.android.ui.activity.activity.SgPushQuestionDetailActivity;
import com.shengui.app.android.shengui.android.ui.activity.activity.SgPushTieziDetailActivity;
import com.shengui.app.android.shengui.android.ui.activity.activity.SgQuanZiContentDetailActivity;
import com.shengui.app.android.shengui.android.ui.activity.activity.SgQuanziListActivity;
import com.shengui.app.android.shengui.android.ui.activity.activity.SgSelectItemActivity;
import com.shengui.app.android.shengui.android.ui.activity.activity.video.MainActivity;
import com.shengui.app.android.shengui.android.ui.utilsview.MultiImageSelectorActivity;

import java.util.ArrayList;

/**
 * Created by lenovo on 2016/7/11.
 */
public class IntentTools {

    /**
     *首页
     * @param context
     */
    public static void startMain(Context context) {
        Intent intent = new Intent(context, MainTabActivity.class);
        context.startActivity(intent);
    }

    /**
     *
     * @param context
     */
    public static void startSelectItem(Context context) {
        Intent intent = new Intent(context, SgSelectItemActivity.class);
        context.startActivity(intent);
    }

    /**
     * 产品详情
     * @param context
     */
    public static void startProductDetail(Context context){
        Intent intent = new Intent(context, SgProductDetailActivity.class);
        context.startActivity(intent);
    }
    /**
     * 选择圈子
     * @param context
     */
    public static void startquanzilist(Context context){
        Intent intent = new Intent(context, SgQuanziListActivity.class);
        context.startActivity(intent);
    }
    /**
     * 选择圈子详情
     * @param context
     */
    public static void startquanziDetail(Context context){
        Intent intent = new Intent(context, SgQuanZiContentDetailActivity.class);
        context.startActivity(intent);
    }
    /**
     * t图片选择发帖子
     * @param context
     */
    public static void startPushTiezi(Context context){
        Intent intent = new Intent(context, SgPushTieziDetailActivity.class);
        context.startActivity(intent);
    }
    /**
     * 圈子列表
     * @param context
     */
    public static void startQuanziList(Context context){
        Intent intent = new Intent(context, SgHotQuanZiListActivity.class);
        context.startActivity(intent);
    }
    /**
     * 圈子详情
     * @param context
     */
    public static void startQuanziDetail(Context context){
        Intent intent = new Intent(context, SgGuiQuanDetailActivityNewActivity.class);
        context.startActivity(intent);
    }
    /**
     * t录制视频
     * @param context
     */
    public static void startPushVideo(Context context){
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }
    /**
     * t图片供求
     * @param context
     */
    public static void startPushGongQiu(Context context){
        Intent intent = new Intent(context, SgPushGongQiuDetailActivity.class);
        context.startActivity(intent);
    } /**
     * t图片提问
     * @param context
     */
    public static void startPushQuestion(Context context){
        Intent intent = new Intent(context, SgPushQuestionDetailActivity.class);
        context.startActivity(intent);
    }
    /****
     * 打开选择图片的页面
     *
     * @param activity
     * @param mSelectPath
     */
    public static void openImageChooseActivity(Activity activity, ArrayList<String> mSelectPath) {
        Intent intent = new Intent(activity, MultiImageSelectorActivity.class);
        // 是否显示拍摄图片
        intent.putExtra(MultiImageSelectorActivity.EXTRA_SHOW_CAMERA, true);
        // 最大可选择图片数量
        intent.putExtra(MultiImageSelectorActivity.EXTRA_SELECT_COUNT,9);
        // 选择模式
        intent.putExtra(MultiImageSelectorActivity.EXTRA_SELECT_MODE, MultiImageSelectorActivity.MODE_MULTI);
        // 默认选择
        if (mSelectPath != null && mSelectPath.size() > 0) {
            intent.putExtra(MultiImageSelectorActivity.EXTRA_DEFAULT_SELECTED_LIST, mSelectPath);
        }
        activity.startActivityForResult(intent, MultiImageSelectorActivity.REQUEST_CODE);
    }
    /****
     * 打开选择图片的页面
     *
     * @param activity
     * @param mSelectPath
     */
    public static void openImageChooseGongqiuActivity(Activity activity, ArrayList<String> mSelectPath) {
        Intent intent = new Intent(activity, MultiImageSelectorActivity.class);
        // 是否显示拍摄图片
        intent.putExtra(MultiImageSelectorActivity.EXTRA_SHOW_CAMERA, true);
        // 最大可选择图片数量
        intent.putExtra(MultiImageSelectorActivity.EXTRA_SELECT_COUNT,9);
        // 选择模式
        intent.putExtra(MultiImageSelectorActivity.EXTRA_SELECT_MODE, MultiImageSelectorActivity.MODE_MULTI);
        // 默认选择
        if (mSelectPath != null && mSelectPath.size() > 0) {
            intent.putExtra(MultiImageSelectorActivity.EXTRA_DEFAULT_SELECTED_LIST, mSelectPath);
        }
        activity.startActivityForResult(intent, MultiImageSelectorActivity.REQUEST_CODE);
    }

}
