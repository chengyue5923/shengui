package com.shengui.app.android.shengui.android.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.base.platform.utils.android.Logger;
import com.base.platform.utils.android.ToastTool;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.shengui.app.android.shengui.R;
import com.shengui.app.android.shengui.android.ui.activity.activity.image.ImagPagerUtil;
import com.shengui.app.android.shengui.android.ui.dialog.ShareInvationPopUpDialog;
import com.shengui.app.android.shengui.android.ui.dialog.ShareOtherPopUpDialog;
import com.shengui.app.android.shengui.android.ui.dialog.SharePopUpDialog;
import com.shengui.app.android.shengui.android.ui.dialog.ShareRemovePopUpDialog;
import com.shengui.app.android.shengui.android.ui.dialog.ShareReportPopUpDialog;
import com.shengui.app.android.shengui.models.ProductModel;

import java.util.ArrayList;
import java.util.List;

public class Fragment1 extends Fragment {
    private RecyclerView mRecyclerView;
    private List<ProductModel> mDatas;
    SharePopUpDialog PopUpDialogs;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1, container, false);
        PopUpDialogs = new SharePopUpDialog(getActivity());
        PopUpDialogs.setDialogListener(new SharePopUpDialog.DialogShareListener() {
            @Override
            public void onclickShareItem(int flags) {
                Logger.e("flagesss" + flags);
                if (flags == 0) {
                    ToastTool.show("已收藏");
                } else if (flags == 1) {
                    ShareOtherPopUpDialog();
                } else if (flags == 2) {
                    ShareReportPopUpDialog();
                } else if (flags == 3) {
                    ShareRemovePopUpDialog();
                } else if (flags == 4) {
                    ShareJinghuaPopUpDialog();
                } else if (flags == 5) {
                    ToastTool.show("已置顶");
                }

            }
        });
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycle);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        initdata();
        mRecyclerView.setAdapter(new MyAdapter(mDatas));
        return view;
    }
    private void initdata() {
        mDatas = new ArrayList<ProductModel>();
        for (int i = 0; i < 15; i++) {
            mDatas.add(new ProductModel());
        }
    }
    //分享举报收藏弹窗
    public void SharePopUpDialog() {   //弹框
        FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
        PopUpDialogs.show(fragmentTransaction, "SharePopUpDialog");
    }

    //分享弹窗
    public void ShareOtherPopUpDialog() {   //弹框
        ShareOtherPopUpDialog PopUpDialogs = new ShareOtherPopUpDialog(getActivity());
        FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
        PopUpDialogs.show(fragmentTransaction, "SharePopUpDialog");
    }

    //举报弹窗
    public void ShareReportPopUpDialog() {   //弹框
        ShareReportPopUpDialog PopUpDialogs = new ShareReportPopUpDialog(getActivity());
        FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
        PopUpDialogs.show(fragmentTransaction, "SharePopUpDialog");
    }

    //移动弹窗
    public void ShareRemovePopUpDialog() {   //弹框
        ShareRemovePopUpDialog PopUpDialogs = new ShareRemovePopUpDialog(getActivity());
        FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
        PopUpDialogs.show(fragmentTransaction, "SharePopUpDialog");
    }

    //精华弹窗
    public void ShareJinghuaPopUpDialog() {   //弹框
        ShareInvationPopUpDialog PopUpDialogs = new ShareInvationPopUpDialog(getActivity());
        FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
        PopUpDialogs.show(fragmentTransaction, "SharePopUpDialog");
    }


    //adapter

    class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
        private List<ProductModel> mDatas;

        //创建构造参数，用来接受数据集
        public MyAdapter(List<ProductModel> datas) {
            this.mDatas = datas;
            initImageLoader();
        }
        public void initImageLoader() {
            // This configuration tuning is custom. You can tune every option, you
            // may tune some of them,
            // or you can create default configuration by
            // ImageLoaderConfiguration.createDefault(this);
            // method.
            ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
                    getActivity().getApplicationContext()).threadPriority(Thread.NORM_PRIORITY - 2)
                    .denyCacheImageMultipleSizesInMemory()
                    .diskCacheFileNameGenerator(new Md5FileNameGenerator())
                    .tasksProcessingOrder(QueueProcessingType.LIFO)
                    .writeDebugLogs() // Remove for release app
                    .build();
            // Initialize ImageLoader with configuration.
            ImageLoader.getInstance().init(config);
        }
        //创建ViewHolder
        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            //加载布局文件，记得传入parent而不是null
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.view_activity_tie_zi_item, parent, false);
            MyViewHolder viewHolder = new MyViewHolder(view);
            return viewHolder;
        }

        //绑定ViewHolder
        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            //将数据填充到具体的view中
//            holder.priductTimeText.setText(mDatas.get(position));
            final List<String> picList = new ArrayList<>();
            picList.add("http://img.ivsky.com/img/bizhi/pre/201601/27/february_2016-001.jpg");
            picList.add("http://img.ivsky.com/img/bizhi/pre/201601/27/february_2016-002.jpg");
            picList.add("http://img.ivsky.com/img/bizhi/pre/201601/27/february_2016-003.jpg");
            picList.add("http://img.ivsky.com/img/bizhi/pre/201601/27/february_2016-004.jpg");
            picList.add("http://img.ivsky.com/img/tupian/pre/201511/16/chongwugou.jpg");
            final String content ="用户分享测试测试分享图片";

            //点击缩略图看大图
            holder.imagesListView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ImagPagerUtil imagPagerUtil = new ImagPagerUtil(getActivity(), picList);
                    imagPagerUtil.setContentText(content);
                    imagPagerUtil.show();
                }
            });
            holder.shareText.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SharePopUpDialog();
                }
            });
        }


        @Override
        public int getItemCount() {
            return mDatas.size();
        }


    }
    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView priductTimeText, productTitleNameText,productBuyText,productBuyTypeText,detailTextView,textView,texttelTextView,textAddressText;
        ImageView productImageView,shareText;
        RelativeLayout imagesListView;

        public MyViewHolder(View itemView) {
            super(itemView);
           priductTimeText = (TextView)itemView.findViewById(R.id.priductTimeText);
           imagesListView=(RelativeLayout)itemView.findViewById(R.id.imagesListView);
           shareText=(ImageView)itemView.findViewById(R.id.shareText);

        }
    }
}
