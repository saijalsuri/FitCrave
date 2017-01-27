package com.apps.saijestudio.fitcrave.activities;

import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;
import android.app.Fragment;

import com.apps.saijestudio.fitcrave.fragments.FeedFragment;
import com.apps.saijestudio.fitcrave.fragments.HomeFragment;
import com.apps.saijestudio.fitcrave.fragments.ProfileFragment;
import com.apps.saijestudio.fitcrave.R;
import com.apps.saijestudio.fitcrave.helpers.Constants;
import com.apps.saijestudio.fitcrave.utils.LoggingActivity;
import com.apps.saijestudio.fitcrave.viewadapters.MainAdapter;


public class MainActivity extends LoggingActivity {


    //define viewpager for swiping fragments
    ViewPager viewPager;

    //
    private List<Fragment> fragments = getFragments();
    MainAdapter myAdapter;

    //Initialize list of fragments to add to viewPager and create instances of swipe fragments
    private List<Fragment> getFragments(){
        int i;
        List<Fragment> fragments = new ArrayList<>();

        //add new fragments here
        fragments.add(Constants.TAG_PROFILE_FRAGMENT, ProfileFragment.newInstance());
        fragments.add(Constants.TAG_HOME_FRAGMENT, HomeFragment.newInstance());
        fragments.add(Constants.TAG_FEED_FRAGMENT, FeedFragment.newInstance());

        //add arguments to fragments
        for(i=0; i<fragments.size(); i++) {
            Bundle args = new Bundle();
            args.putInt(Constants.FRAG_ARGS_POSTION, i);
            fragments.get(i).setArguments(args);
        }

        Log.d(TAG, "Fragments Created");
        return fragments;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize new adapter object using fragments list created above
        myAdapter = new MainAdapter(getFragmentManager(), fragments);

        //set myAdapter for viewpager
        viewPager = (ViewPager) findViewById(R.id.frag_pager);
        viewPager.setAdapter(myAdapter);

        //set HomeFragment (middle Fragment) as the first fragment to show on launch of MainActivity
        viewPager.setCurrentItem(Constants.TAG_HOME_FRAGMENT);

        Log.d(TAG, "Adapter set using fragments");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
