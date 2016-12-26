package com.shengui.app.android.shengui.android.ui.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.base.platform.utils.android.Logger;
import com.base.view.adapter.BasePlatAdapter;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.shengui.app.android.shengui.R;
import com.shengui.app.android.shengui.android.ui.activity.activity.image.ImagPagerUtil;
import com.shengui.app.android.shengui.android.ui.dialog.SharePopUpDialog;
import com.shengui.app.android.shengui.models.ProductModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yanbo on 2016/7/20.
 */
public class ActivityTieziListAdapter extends BasePlatAdapter<ProductModel> {
    final Context mContext;
    public ActivityTieziListAdapter(Context context) {
        super(context);
        mContext=context;
        initImageLoader();
    }

    @Override
    public View getView(int position, View itemView, ViewGroup parent) {
        ViewHolder vh;
        ProductModel model = getItem(position);
        if (itemView == null) {
            vh = new ViewHolder();
            itemView = LayoutInflater.from(mContext).inflate(R.layout.view_activity_tie_zi_item, null);
            vh.priductTimeText = (TextView)itemView.findViewById(R.id.priductTimeText);
            vh.imagesListView=(RelativeLayout)itemView.findViewById(R.id.imagesListView);
            vh.shareText=(ImageView)itemView.findViewById(R.id.shareText);
            itemView.setTag(vh);
        } else {
            vh = (ViewHolder) itemView.getTag();
        }
        final List<String> picList = new ArrayList<>();
        picList.add("http://img.ivsky.com/img/bizhi/pre/201601/27/february_2016-001.jpg");
        picList.add("http://img.ivsky.com/img/bizhi/pre/201601/27/february_2016-002.jpg");
        picList.add("http://img.ivsky.com/img/bizhi/pre/201601/27/february_2016-003.jpg");
        picList.add("http://img.ivsky.com/img/bizhi/pre/201601/27/february_2016-004.jpg");
        picList.add("http://img.ivsky.com/img/tupian/pre/201511/16/chongwugou.jpg");
        final String content ="用户分享测试测试分享图片";

        //点击缩略图看大图
        vh.imagesListView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImagPagerUtil imagPagerUtil = new ImagPagerUtil(mContext, picList);
                imagPagerUtil.setContentText(content);
                imagPagerUtil.show();
            }
        });
        vh.shareText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogListener.onclickConfirm();
            }
        });
        return itemView;
    }
    private DialogListener dialogListener;
    public void setDialogListener(DialogListener dialogListener) {
        this.dialogListener = dialogListener;
    }



    public interface DialogListener{
        void onclickConfirm();
    }
    class ViewHolder {
        TextView priductTimeText, productTitleNameText,productBuyText,productBuyTypeText,detailTextView,textView,texttelTextView,textAddressText;
        ImageView productImageView,shareText;
        RelativeLayout imagesListView;
    }
    public void initImageLoader() {
        // This configuration tuning is custom. You can tune every option, you
        // may tune some of them,
        // or you can create default configuration by
        // ImageLoaderConfiguration.createDefault(this);
        // method.
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
                context.getApplicationContext()).threadPriority(Thread.NORM_PRIORITY - 2)
                .denyCacheImageMultipleSizesInMemory()
                .diskCacheFileNameGenerator(new Md5FileNameGenerator())
                .tasksProcessingOrder(QueueProcessingType.LIFO)
                .writeDebugLogs() // Remove for release app
                .build();
        // Initialize ImageLoader with configuration.
        ImageLoader.getInstance().init(config);
    }
}
