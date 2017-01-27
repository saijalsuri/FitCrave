package com.apps.saijestudio.fitcrave.viewadapters;


import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.FragmentPagerAdapter;

import java.util.List;


//basic adapter for fragments
//gets fragment based on position and gets total # of fragments
public class MainAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragments;
    public MainAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}