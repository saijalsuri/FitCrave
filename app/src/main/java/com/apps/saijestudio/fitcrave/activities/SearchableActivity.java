package com.apps.saijestudio.fitcrave.activities;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import com.apps.saijestudio.fitcrave.R;
import com.apps.saijestudio.fitcrave.asynctasks.WebSearchAsyncTask;
import com.apps.saijestudio.fitcrave.helpers.Constants;
import com.apps.saijestudio.fitcrave.utils.LoggingActivity;

//is automatically call when the search query is entered into the search widget on HomeFragment
public class SearchableActivity extends LoggingActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchable);

        //retrieve intent and associated query string entered by the user
        Intent intent = getIntent();
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);

            //enter extra search terms to be added to the query search to healthKeys array
            String[] healthKeys = new String[]{
                    Constants.KEY_HEALTHY
            };

            //method that generates the final search query i.e. healthyQuery
            String healthyQuery = createHealthyQuery(query, Constants.KEY_RECIPES, healthKeys);
            Log.d(TAG, "Prepared healthQuery");

            //TODO: create and then call service/methods to check database for query results first, then call websearch only if database returns null

            //create WebSearchAsyncTask object and initialize with context and RECIPE search category vars
            WebSearchAsyncTask webSearchTask = new WebSearchAsyncTask(this, Constants.CATEGORY_RECIPES, query);
            //execute asynctask
            webSearchTask.execute(healthyQuery);
            Log.d(TAG, "Created and executed WebSearchAsyncTask");

        }
    }

    //method to create final search query by appending additional terms from healthyKeys array
    public String createHealthyQuery(String userQuery, String searchCategory, String[] healthKeys) {
        String space = " ";
        String healthyQuery = userQuery + space + searchCategory;
        for (String key: healthKeys) {
            healthyQuery = healthyQuery + space + key;
        }
        return healthyQuery;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_searchable, menu);
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
