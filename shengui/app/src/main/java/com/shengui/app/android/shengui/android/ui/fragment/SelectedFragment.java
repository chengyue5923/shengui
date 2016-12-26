package com.shengui.app.android.shengui.android.ui.fragment;


import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.shengui.app.android.shengui.R;

import butterknife.ButterKnife;

/**
 * Created by yanbo on 16-7-11.
 */
public class SelectedFragment extends Fragment  {




    public static SelectedFragment newInstance() {
        SelectedFragment squareFragmentV2 = new SelectedFragment();
        return squareFragmentV2;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_select_page, container,
                false);
        ButterKnife.bind(this, view);

        return view;
    }
}
