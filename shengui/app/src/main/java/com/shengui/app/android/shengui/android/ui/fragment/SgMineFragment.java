package com.shengui.app.android.shengui.android.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shengui.app.android.shengui.R;

import butterknife.ButterKnife;

/**
 * Created by yanbo on 16-7-11.
 */
public class SgMineFragment extends Fragment  {




    public static SgMineFragment newInstance() {
        SgMineFragment squareFragmentV2 = new SgMineFragment();
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
