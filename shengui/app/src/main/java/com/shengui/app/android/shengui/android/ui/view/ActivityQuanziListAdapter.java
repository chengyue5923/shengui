package com.shengui.app.android.shengui.android.ui.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.base.view.adapter.BasePlatAdapter;
import com.bumptech.glide.Glide;
import com.shengui.app.android.shengui.R;
import com.shengui.app.android.shengui.android.ui.utilsview.CircleImageView;
import com.shengui.app.android.shengui.models.ProductModel;

/**
 * Created by yanbo on 2016/7/20.
 */
public class ActivityQuanziListAdapter extends BasePlatAdapter<ProductModel> {
    Context mContext;
    public ActivityQuanziListAdapter(Context context) {
        super(context);
        mContext=context;
    }

    @Override
    public View getView(int position, View itemView, ViewGroup parent) {
        final ViewHolder vh;
        ProductModel model = getItem(position);
        if (itemView == null) {
            vh = new ViewHolder();
            itemView = LayoutInflater.from(mContext).inflate(R.layout.view_activity_quanzi_item_item, null);
            vh.titlenameView = (TextView)itemView.findViewById(R.id.titlenameView);
            vh.typeText = (TextView)itemView.findViewById(R.id.typeText);
            vh.quanziPersonText = (TextView)itemView.findViewById(R.id.quanziPersonText);
            vh.tiezaiNumberText = (TextView)itemView.findViewById(R.id.tiezaiNumberText);
            vh.addressText = (TextView)itemView.findViewById(R.id.addressText);
            vh.itemSelectView = (ImageView)itemView.findViewById(R.id.itemSelectView);
            vh.personInfoIv = (CircleImageView)itemView.findViewById(R.id.personInfoIv);
            itemView.setTag(vh);
        } else {
            vh = (ViewHolder) itemView.getTag();
        }

        vh.itemSelectView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vh.itemSelectView.setImageDrawable(mContext.getResources().getDrawable(R.drawable.quanzi_list_select_view));
            }
        });
        Glide.with(mContext).load("").asBitmap().placeholder(R.drawable.default_pictures).into(vh.personInfoIv);
        return itemView;
    }
    class ViewHolder {
        TextView titlenameView,typeText,quanziPersonText,tiezaiNumberText,addressText;
        ImageView itemSelectView;
        CircleImageView personInfoIv;
    }
}
