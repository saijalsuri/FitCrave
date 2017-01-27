package com.apps.saijestudio.fitcrave.database;

import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;

public final class DatabaseContract {

    /**
     * The "Content authority" is a name for the entire content
     * provider, similar to the relationship between a domain name and
     * its website.
     */
    public static final String CONTENT_AUTHORITY =
            "com.apps.saijestudio.fitcrave.db";

    /**
     * Use CONTENT_AUTHORITY to create the base of all URI's that apps
     * will use to contact the content provider.
     */

    public static final Uri BASE_CONTENT_URI =
            Uri.parse("content://"
                    + CONTENT_AUTHORITY);


    /**
     * Possible paths (appended to base content URI for possible
     * URI's),
     */
    public static final String PATH_RECIPE =
            RecipeSearch.TABLE_NAME;

    public static final String PATH_GROCERY =
            GrocerySearch.TABLE_NAME;

    public static final String PATH_RESTAURANT =
            RestaurantSearch.TABLE_NAME;

    public static final String PATH_VIDEO =
            VideoSearch.TABLE_NAME;

    public static final String PATH_USER =
            VideoSearch.TABLE_NAME;




    /* Inner classes defining tables  */

    // Recipe Search Table
    public static final class RecipeSearch implements BaseColumns{

        /**
         * Use BASE_CONTENT_URI to create the unique URI for Table
         * that apps will use to contact the content provider.
         */
        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon().appendPath(PATH_RECIPE).build();

        /**
         * When the Cursor returned for a given URI by the
         * ContentProvider contains 0..x items.
         */
        public static final String CONTENT_ITEMS_TYPE =
                "vnd.android.cursor.dir/"
                        + CONTENT_AUTHORITY
                        + "/"
                        + PATH_RECIPE;

        /**
         * When the Cursor returned for a given URI by the
         * ContentProvider contains 1 item.
         */
        public static final String CONTENT_ITEM_TYPE =
                "vnd.android.cursor.item/"
                        + CONTENT_AUTHORITY
                        + "/"
                        + PATH_RECIPE;

        /**
         * Name of the database table.
         */
        public static final String TABLE_NAME = "recipe_search";

        /**
         * Columns to store Data.
         */
        public static final String COLUMN_NAME_SEARCH_ID = "search_id";
        public static final String COLUMN_NAME_IMAGE_URI = "image_uri";
        public static final String COLUMN_NAME_PAGE_TITLE = "page_title";
        public static final String COLUMN_NAME_WEBPAGE_URL = "webpage_url";
        public static final String COLUMN_NAME_SEARCH_TAGS = "search_tags";
        public static final String COLUMN_NAME_DATESTAMP = "datestamp";




    }

    // Grocery Haul Table
    public static abstract class GrocerySearch implements BaseColumns{

        /**
         * Use BASE_CONTENT_URI to create the unique URI for Table
         * that apps will use to contact the content provider.
         */
        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon().appendPath(PATH_GROCERY).build();

        /**
         * When the Cursor returned for a given URI by the
         * ContentProvider contains 0..x items.
         */
        public static final String CONTENT_ITEMS_TYPE =
                "vnd.android.cursor.dir/"
                        + CONTENT_AUTHORITY
                        + "/"
                        + PATH_GROCERY;

        /**
         * When the Cursor returned for a given URI by the
         * ContentProvider contains 1 item.
         */
        public static final String CONTENT_ITEM_TYPE =
                "vnd.android.cursor.item/"
                        + CONTENT_AUTHORITY
                        + "/"
                        + PATH_GROCERY;
        /**
         * Name of the database table.
         */
        public static final String TABLE_NAME = "grocery_haul_search";
        /**
         * Columns to store Data of each Acronym Expansion.
         */
        public static final String COLUMN_NAME_SEARCH_ID = "search_id";
        public static final String COLUMN_NAME_IMAGE_URI = "image_uri";
        public static final String COLUMN_NAME_PAGE_TITLE = "page_title";
        public static final String COLUMN_NAME_WEBPAGE_URL = "webpage_url";
        public static final String COLUMN_NAME_SEARCH_TAGS = "search_tags";
        public static final String COLUMN_NAME_DATESTAMP = "datestamp";


    }

    // Restaurant Search Table
    public static final class RestaurantSearch implements BaseColumns{

        /**
         * Use BASE_CONTENT_URI to create the unique URI for Acronym
         * Table that apps will use to contact the content provider.
         */
        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon()
                        .appendPath(PATH_RESTAURANT).build();

        /**
         * When the Cursor returned for a given URI by the
         * ContentProvider contains 0..x items.
         */
        public static final String CONTENT_ITEMS_TYPE =
                "vnd.android.cursor.dir/"
                        + CONTENT_AUTHORITY
                        + "/"
                        + PATH_RESTAURANT;

        /**
         * When the Cursor returned for a given URI by the
         * ContentProvider contains 1 item.
         */
        public static final String CONTENT_ITEM_TYPE =
                "vnd.android.cursor.item/"
                        + CONTENT_AUTHORITY
                        + "/"
                        + PATH_RESTAURANT;

        /**
         * Name of the database table.
         */
        public static final String TABLE_NAME = "restaurant_search";

        /**
         * Columns to store Data of each Acronym Expansion.
         */
        public static final String COLUMN_NAME_SEARCH_ID = "search_id";
        public static final String COLUMN_NAME_IMAGE_URI = "image_uri";
        public static final String COLUMN_NAME_PAGE_TITLE = "page_title";
        public static final String COLUMN_NAME_WEBPAGE_URL = "webpage_url";
        public static final String COLUMN_NAME_SEARCH_TAGS = "search_tags";
        public static final String COLUMN_NAME_DATESTAMP = "datestamp";

    }

    // Video Search Table
    public static abstract class VideoSearch implements BaseColumns{


        /**
         * Use BASE_CONTENT_URI to create the unique URI for Acronym
         * Table that apps will use to contact the content provider.
         */
        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon()
                        .appendPath(PATH_VIDEO).build();

        /**
         * When the Cursor returned for a given URI by the
         * ContentProvider contains 0..x items.
         */
        public static final String CONTENT_ITEMS_TYPE =
                "vnd.android.cursor.dir/"
                        + CONTENT_AUTHORITY
                        + "/"
                        + PATH_VIDEO;

        /**
         * When the Cursor returned for a given URI by the
         * ContentProvider contains 1 item.
         */
        public static final String CONTENT_ITEM_TYPE =
                "vnd.android.cursor.item/"
                        + CONTENT_AUTHORITY
                        + "/"
                        + PATH_VIDEO;

        /**
         * Name of the database table.
         */
        public static final String TABLE_NAME = "video_search";

        /**
         * Columns to store Data of each Acronym Expansion.
         */
        public static final String COLUMN_NAME_SEARCH_ID = "search_id";
        public static final String COLUMN_NAME_IMAGE_URI = "image_uri";
        public static final String COLUMN_NAME_PAGE_TITLE = "page_title";
        public static final String COLUMN_NAME_WEBPAGE_URL = "webpage_url";
        public static final String COLUMN_NAME_SEARCH_TAGS = "search_tags";
        public static final String COLUMN_NAME_DATESTAMP = "datestamp";


    }

    // User Table
    public static abstract class UserInfo implements BaseColumns {

        /**
         * Use BASE_CONTENT_URI to create the unique URI for Acronym
         * Table that apps will use to contact the content provider.
         */
        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon()
                        .appendPath(PATH_USER).build();

        /**
         * When the Cursor returned for a given URI by the
         * ContentProvider contains 0..x items.
         */
        public static final String CONTENT_ITEMS_TYPE =
                "vnd.android.cursor.dir/"
                        + CONTENT_AUTHORITY
                        + "/"
                        + PATH_USER;

        /**
         * When the Cursor returned for a given URI by the
         * ContentProvider contains 1 item.
         */
        public static final String CONTENT_ITEM_TYPE =
                "vnd.android.cursor.item/"
                        + CONTENT_AUTHORITY
                        + "/"
                        + PATH_USER;

        /**
         * Name of the database table.
         */
         public static final String TABLE_NAME="user_info";

        /**
         * Columns to store Data of each Acronym Expansion.
         */
        public static final String COLUMN_NAME_USER_ID = "user_id";
        public static final String COLUMN_NAME_USERNAME ="username";
        public static final String COLUMN_NAME_EMAIL = "email";
        public static final String COLUMN_NAME_PASSWORD = "passwords";
        public static final String COLUMN_NAME_DIETARY_RESTRICTIONS = "dietary_restrictions";
        public static final String COLUMN_NAME_ALLERGIES = "allergies";
        public static final String COLUMN_NAME_FRIENDS = "friends";


    }
}
