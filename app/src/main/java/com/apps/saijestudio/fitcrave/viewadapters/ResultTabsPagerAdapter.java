package com.apps.saijestudio.fitcrave.viewadapters;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v13.app.FragmentPagerAdapter;

import com.apps.saijestudio.fitcrave.fragments.ResultFragment;
import com.apps.saijestudio.fitcrave.helpers.Constants;

//ResultTabsPagerAdapter sets the tabs pager that displays each category of results and makes it swipe-able
public class ResultTabsPagerAdapter extends FragmentPagerAdapter{

    Context mContext;

    //constructor
    public ResultTabsPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {

        //create ResultFragment instance regardless of position
        Fragment fragment = ResultFragment.newInstance();

        // Attach some data to the fragment
        // that we'll use to populate our fragment layouts
        Bundle args = new Bundle();
        args.putInt(Constants.FRAG_ARGS_POSTION, position + 1);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public int getCount() {

        //return number of pages/tabs
        return Constants.PAGER_TAB_COUNT;
    }

    //get page title i.e, result category based on given position
    @Override
    public CharSequence getPageTitle(int position) {
        CharSequence pageTitle;
        switch (position) {
            case 0:
                pageTitle = Constants.PAGER_RECIPES;
                break;
            case 1:
                pageTitle = Constants.PAGER_GROCERY;
                break;
            case 2:
                pageTitle = Constants.PAGER_RESTAURANTS;
                break;
            case 3:
                pageTitle = Constants.PAGER_VIDEOS;
                break;
            default:
                pageTitle = (Constants.FRAG_ARGS_POSTION + (position + 1));
                break;
        }
        return pageTitle;
    }
}

