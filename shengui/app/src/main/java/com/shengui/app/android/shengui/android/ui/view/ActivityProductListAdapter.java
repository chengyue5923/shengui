package com.shengui.app.android.shengui.android.ui.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.base.platform.utils.java.DateTools;
import com.base.view.adapter.BasePlatAdapter;
import com.shengui.app.android.shengui.R;
import com.shengui.app.android.shengui.models.ProductModel;

/**
 * Created by yanbo on 2016/7/20.
 */
public class ActivityProductListAdapter extends BasePlatAdapter<ProductModel> {
    Context mContext;
    public ActivityProductListAdapter(Context context) {
        super(context);
        mContext=context;
    }

    @Override
    public View getView(int position, View itemView, ViewGroup parent) {
        ViewHolder vh;
        ProductModel model = getItem(position);
        if (itemView == null) {
            vh = new ViewHolder();
            itemView = LayoutInflater.from(mContext).inflate(R.layout.view_activity_item, null);
            vh.priductTimeText = (TextView)itemView.findViewById(R.id.priductTimeText);
            vh.productTitleNameText = (TextView)itemView.findViewById(R.id.productTitleNameText);
            vh.productBuyText = (TextView)itemView.findViewById(R.id.productBuyText);
            vh.productBuyTypeText = (TextView)itemView.findViewById(R.id.productBuyTypeText);
            vh.detailTextView = (TextView)itemView.findViewById(R.id.detailTextView);
            vh.textView = (TextView)itemView.findViewById(R.id.textView);
            vh.texttelTextView = (TextView)itemView.findViewById(R.id.texttelTextView);
            vh.textAddressText = (TextView)itemView.findViewById(R.id.texttelTextView);
            vh.productImageView = (ImageView)itemView.findViewById(R.id.productImageView);
            itemView.setTag(vh);
        } else {
            vh = (ViewHolder) itemView.getTag();
        }

        return itemView;
    }
    class ViewHolder {
        TextView priductTimeText, productTitleNameText,productBuyText,productBuyTypeText,detailTextView,textView,texttelTextView,textAddressText;
        ImageView productImageView;
    }
}
