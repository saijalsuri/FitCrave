package com.apps.saijestudio.fitcrave.asynctasks;

import android.content.Intent;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import com.apps.saijestudio.fitcrave.activities.ResultsActivity;
import com.apps.saijestudio.fitcrave.helpers.Constants;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.customsearch.Customsearch;
import com.google.api.services.customsearch.model.Result;
import com.google.api.services.customsearch.model.Search;

import java.io.IOException;
import java.util.List;

    //AsyncTask that performs Websearch on given query for a given category
    public class WebSearchAsyncTask extends AsyncTask<String, Void, Bundle> {


        private Context context;
        private String category;
        private String query;

        //constructor for context and category vars
        public WebSearchAsyncTask(Context context, String category, String query) {
            this.context = context;
            this.category = category;
            this.query = query;
        }

        @Override
        protected Bundle doInBackground(String... healthQuery) {
            return getQueryResults(category, healthQuery[0]);
        }

        //method that returns query results in a bundle
        private Bundle getQueryResults(String category, String healthQuery) {

            String searchEngine = ChooseEngine(category);
            return doWebSearch(healthQuery, searchEngine);
        }

        //method that returns suitable search engine to perform search based on algorithm that monitors query limits for each api
        private String ChooseEngine(String action) {
            String searchEngine;
            //TODO: implement algorithm to choose the appropriate searchEngine to use for the query
            switch (action) {
                case Constants.CATEGORY_RECIPES:
                    searchEngine = Constants.ENGINE_GOOGLE;
                    break;
                default:
                    searchEngine = Constants.ENGINE_GOOGLE;
                    break;
            }
            return searchEngine;
        }

        //method that performs search on given search engine and returns results in a bundle
        private Bundle doWebSearch(String healthyQuery, String searchEngine) {
            switch (searchEngine) {
                case Constants.ENGINE_GOOGLE:
                    List<Result> resultList;
                    Bundle resultsBundle = new Bundle();

                    //TODO: Find a safer place to store API key and Search Engine ID

                    final String API_KEY = "AIzaSyBy52xDXH9KCBXKWG97Q1aADPI8Vpg35cU";
                    final String SEARCH_ENGINE_ID = "010247139068061476008:nirffa__hou";

                    try {

                        HttpTransport httpTransport = new NetHttpTransport();
                        JsonFactory jsonFactory = new JacksonFactory();

                        //Java method included as part of Google CustomSearch API
                        Customsearch customsearch = new Customsearch(httpTransport, jsonFactory, null);
                        Customsearch.Cse.List list = customsearch.cse().list(healthyQuery);
                        list.setKey(API_KEY);
                        list.setCx(SEARCH_ENGINE_ID);
                        list.setQ(healthyQuery);

                        Search results = list.execute();
                        resultList = results.getItems();
                        int index = 0;

                        //iterate through results and extract relevant data to store in bundle
                        if (resultList != null && resultList.size() > 0) {

                            resultsBundle.putString(Constants.BUNDLE_HEALTHQUERY, healthyQuery);
                            resultsBundle.putString(Constants.BUNDLE_QUERY, query);
                            for (Result result : resultList) {
                                Log.v(Constants.BUNDLE_RESULT, result.toString());
                                String title = result.getTitle();
                                String snippet = result.getSnippet();
                                String link = result.getDisplayLink();
                                String url = result.getLink();

                                resultsBundle.putString(Constants.BUNDLE_RESULT + index, result.toString());
                                resultsBundle.putString(Constants.BUNDLE_TITLE + index, title);
                                resultsBundle.putString(Constants.BUNDLE_SNIPPET + index, snippet);
                                resultsBundle.putString(Constants.BUNDLE_LINK + index, link);
                                resultsBundle.putString(Constants.BUNDLE_URL + index, url);

                                index++;
                            }

                            resultsBundle.putInt(Constants.BUNDLE_COUNT, index);
                            resultsBundle.putString(Constants.BUNDLE_TOAST, "");

                        } else {

                            //If resultList is empty store a toast message to be displayed to the user
                            resultsBundle.putString(Constants.BUNDLE_TOAST, Constants.BUNDLE_TOAST_VALUE);
                        }

                    } catch (IOException e) {
                        Log.e("IO Exception", e.toString());
                        //If exception store a toast message to be displayed to the user
                        resultsBundle.putString(Constants.BUNDLE_TOAST, Constants.BUNDLE_TOAST_VALUE);
                    }

                    return resultsBundle;

                //TODO: implement API for other search engines
                default:
                    Log.e("doWebSearch", "search engine does not equal ENGINE_GOOGLE");
                    return null;
            }
        }

        @Override
        protected void onPostExecute(Bundle resultBundle) {

            //create Intent to launch ResultsActivity, store resultBundle as an extra and launch the intent
            Intent intent = new Intent(context, ResultsActivity.class);
            intent.putExtra(Constants.EXTRA_RESULTS, resultBundle);
            context.startActivity(intent);
        }
 }

