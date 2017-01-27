package com.apps.saijestudio.fitcrave.helpers;


public class Constants {


    //SplashScreen total time in milliseconds
    public static final int SPLASH_TIME_OUT = 3000;

    //Fragment Ids
    public static final int TAG_PROFILE_FRAGMENT = 0;
    public static final int TAG_HOME_FRAGMENT = 1;
    public static final int TAG_FEED_FRAGMENT = 2;

    //Bundle Data Keys
    public static final String BUNDLE_QUERY = "com.apps.saijestudio.fitcrave.constants.extras.QUERY";
    public static final String BUNDLE_HEALTHQUERY = "com.apps.saijestudio.fitcrave.constants.extras.HEALTHQUERY";
    public static final String BUNDLE_RESULT = "Result: ";
    public static final String BUNDLE_TITLE = "Title: ";
    public static final String BUNDLE_SNIPPET = "Snippet: ";
    public static final String BUNDLE_LINK = "Link: ";
    public static final String BUNDLE_URL = "Url: ";
    public static final String BUNDLE_COUNT = "Count: ";
    public static final String BUNDLE_TOAST = "Toast: ";

    public static final String BUNDLE_TOAST_VALUE = "The search query entered has no results!";
    public static final String EXTRA_RESULTS = "SEARCH QUERY RESULTS";

    //WebSearch Categories
    public static final String CATEGORY_RECIPES = "com.apps.saijestudio.fitcrave.constants.category.RECIPES";
    public static final String CATEGORY_GROCERY = "com.apps.saijestudio.fitcrave.constants.category.GROCERY";
    public static final String CATEGORY_RESTAURANTS = "com.apps.saijestudio.fitcrave.constants.category.RESTAURANTS";
    public static final String CATEGORY_VIDEOS = "com.apps.saijestudio.fitcrave.constants.category.VIDEOS";

    //Pager Titles i.e. Search Categories
    public static final String PAGER_RECIPES = "Recipes";
    public static final String PAGER_GROCERY = "Grocery Haul";
    public static final String PAGER_RESTAURANTS = "Restaurant";
    public static final String PAGER_VIDEOS = "Videos";

    //Fragment Argument Page position
    public static final String FRAG_ARGS_POSTION = "page_position";

    //Health Keys
    public static final String KEY_HEALTHY = "healthy";
    public static final String KEY_RECIPES = "recipes";

    public static final String LOADING = "Loading...";
    public static final String URL = "Url";

    //Results Pager Tab Count
    public static final int PAGER_TAB_COUNT = 4;

    //Pager Tab Ids (position + 1) --> position starts at 0
    public static final int RECIPE_ID = 1;
    public static final int GROCERY_ID = 2;
    public static final int RESTAURANTS_ID = 3;
    public static final int VIDEOS_ID = 4;



    public static final String WEBVIEW_ERROR = "WebView loading Error: ";
    //Search Engines
    public static final String ENGINE_GOOGLE = "http://www.google.com";
    public static final String ENGINE_BING = "http://www.bing.com/";
    public static final String ENGINE_YAHOO = "http://www.yahoo.com";

}
