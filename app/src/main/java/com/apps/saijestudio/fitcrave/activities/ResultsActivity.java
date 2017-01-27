package com.apps.saijestudio.fitcrave.activities;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.apps.saijestudio.fitcrave.R;
import com.apps.saijestudio.fitcrave.utils.LoggingActivity;
import com.apps.saijestudio.fitcrave.viewadapters.ResultTabsPagerAdapter;

//Activity that displays the search query results
public class ResultsActivity extends LoggingActivity {


    //Custom FragmentPagerAdapter to display the category tabs
    ResultTabsPagerAdapter mTabsPagerAdapter;
    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        //set the custom TabsPagerAdapter i.e. ResultsTabsPagerAdapter (see in viewAdapters pkg) as the ViewPager
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mTabsPagerAdapter = new ResultTabsPagerAdapter(getFragmentManager(), getApplicationContext());
        mViewPager.setAdapter(mTabsPagerAdapter);
        mViewPager.setCurrentItem(0);

        Log.d(TAG, "Set custom adapter for result catergory pager");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_results, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}


