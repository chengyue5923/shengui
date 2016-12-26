package com.shengui.app.android.shengui.android.ui.view;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.shengui.app.android.shengui.android.ui.fragment.AllActivityFragment;
import com.shengui.app.android.shengui.android.ui.fragment.HotActivityFragment;
import com.shengui.app.android.shengui.android.ui.fragment.MineActivityFragment;
import com.shengui.app.android.shengui.android.ui.fragment.OrigizionActivityFragment;

/**
 * Created by User on 2016/7/21.
 */
public class HotMinePagerAdapter extends FragmentPagerAdapter {
    private String[] title;
    private HotActivityFragment wealthFragment;
    private OrigizionActivityFragment rightAndPointFragment;
    private AllActivityFragment rightFragment;
    private MineActivityFragment activityFragment;

    public HotMinePagerAdapter(FragmentManager fm, String[] title) {
        super(fm);
        this.title = title;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return wealthFragment == null ? new HotActivityFragment() : wealthFragment;

            case 1:
                return rightAndPointFragment == null ? new OrigizionActivityFragment() : rightAndPointFragment;

            case 2:
                return rightFragment == null ? new AllActivityFragment() : rightFragment;
            case 3:
                return activityFragment == null ? new MineActivityFragment() : activityFragment;

        }
        return null;
    }

    @Override
    public int getCount() {
        return title.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }
}
