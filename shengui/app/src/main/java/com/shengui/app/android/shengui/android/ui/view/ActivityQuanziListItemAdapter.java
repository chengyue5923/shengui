package com.shengui.app.android.shengui.android.ui.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.base.platform.utils.android.Logger;
import com.base.view.adapter.BasePlatAdapter;
import com.bumptech.glide.Glide;
import com.shengui.app.android.shengui.R;
import com.shengui.app.android.shengui.android.ui.utilsview.CircleImageView;
import com.shengui.app.android.shengui.models.ProductModel;

/**
 * Created by yanbo on 2016/7/20.
 */
public class ActivityQuanziListItemAdapter extends BasePlatAdapter<ProductModel> {
    Context mContext;
    public ActivityQuanziListItemAdapter(Context context) {
        super(context);
        mContext=context;
    }

    @Override
    public View getView(int position, View itemView, ViewGroup parent) {
        ViewHolder vh;
        ProductModel model = getItem(position);
        if (itemView == null) {
            vh = new ViewHolder();
            itemView = LayoutInflater.from(mContext).inflate(R.layout.view_activity_quanzi_item_item, null);
            vh.addressQuanziText=(TextView)itemView.findViewById(R.id.addressQuanziText);
            vh.QuanZiNameText=(TextView)itemView.findViewById(R.id.QuanZiNameText);
            vh.QuanzitypeText=(TextView)itemView.findViewById(R.id.QuanzitypeText);
            vh.NumberTextView=(TextView)itemView.findViewById(R.id.NumberTextView);
            vh.tiezaiNumberText=(TextView)itemView.findViewById(R.id.tiezaiNumberText);
            vh.textDetail=(TextView)itemView.findViewById(R.id.textDetail);
            vh.personInfoIv=(CircleImageView)itemView.findViewById(R.id.personInfoIv);
            itemView.setTag(vh);
        } else {
            vh = (ViewHolder) itemView.getTag();
        }
        try{
            Glide.with(mContext).load("http://img2.imgtn.bdimg.com/it/u=494039896,832500370&fm=21&gp=0.jpg").asBitmap().placeholder(R.drawable.default_pictures).into(vh.personInfoIv);
        }catch (Exception e){
            Logger.e("sd"+e.getMessage());
        }
        return itemView;
    }
    class ViewHolder {
        CircleImageView personInfoIv;
        TextView QuanZiNameText,QuanzitypeText,NumberTextView,tiezaiNumberText,addressQuanziText,textDetail;

    }
}
