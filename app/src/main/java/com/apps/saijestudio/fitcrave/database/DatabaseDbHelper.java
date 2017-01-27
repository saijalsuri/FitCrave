package com.apps.saijestudio.fitcrave.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.apps.saijestudio.fitcrave.database.DatabaseContract.RecipeSearch;
import com.apps.saijestudio.fitcrave.database.DatabaseContract.GrocerySearch;
import com.apps.saijestudio.fitcrave.database.DatabaseContract.RestaurantSearch;
import com.apps.saijestudio.fitcrave.database.DatabaseContract.VideoSearch;
import com.apps.saijestudio.fitcrave.database.DatabaseContract.UserInfo;

public class DatabaseDbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Fitcrave.db";
    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ",";
    private static final String SQL_CREATE_RECIPE_TABLE_ENTRIES =
                "CREATE TABLE " + RecipeSearch.TABLE_NAME + " (" +
                    RecipeSearch._ID + " INTEGER PRIMARY KEY," +
                    RecipeSearch.COLUMN_NAME_SEARCH_ID + TEXT_TYPE + COMMA_SEP +
                    RecipeSearch.COLUMN_NAME_IMAGE_URI + TEXT_TYPE + COMMA_SEP +
                    RecipeSearch.COLUMN_NAME_PAGE_TITLE + TEXT_TYPE + COMMA_SEP +
                    RecipeSearch.COLUMN_NAME_WEBPAGE_URL + TEXT_TYPE + COMMA_SEP +
                    RecipeSearch.COLUMN_NAME_SEARCH_TAGS + TEXT_TYPE + COMMA_SEP +
                    RecipeSearch.COLUMN_NAME_DATESTAMP + TEXT_TYPE + COMMA_SEP +")";

    private static final String SQL_DELETE_RECIPE_ENTRIES =
            "DROP TABLE IF EXISTS " + RecipeSearch.TABLE_NAME;

    private static final String SQL_CREATE_GROCERY_TABLE_ENTRIES =
            "CREATE TABLE " + GrocerySearch.TABLE_NAME + " (" +
                    GrocerySearch._ID + " INTEGER PRIMARY KEY," +
                    GrocerySearch.COLUMN_NAME_SEARCH_ID + TEXT_TYPE + COMMA_SEP +
                    GrocerySearch.COLUMN_NAME_IMAGE_URI + TEXT_TYPE + COMMA_SEP +
                    GrocerySearch.COLUMN_NAME_PAGE_TITLE + TEXT_TYPE + COMMA_SEP +
                    GrocerySearch.COLUMN_NAME_WEBPAGE_URL + TEXT_TYPE + COMMA_SEP +
                    GrocerySearch.COLUMN_NAME_SEARCH_TAGS + TEXT_TYPE + COMMA_SEP +
                    GrocerySearch.COLUMN_NAME_DATESTAMP + TEXT_TYPE + COMMA_SEP +")";

    private static final String SQL_DELETE_GROCERY_ENTRIES =
            "DROP TABLE IF EXISTS " + GrocerySearch.TABLE_NAME;

    private static final String SQL_CREATE_RESTAURANT_TABLE_ENTRIES =
            "CREATE TABLE " + RestaurantSearch.TABLE_NAME + " (" +
                    RestaurantSearch._ID + " INTEGER PRIMARY KEY," +
                    RestaurantSearch.COLUMN_NAME_SEARCH_ID + TEXT_TYPE + COMMA_SEP +
                    RestaurantSearch.COLUMN_NAME_IMAGE_URI + TEXT_TYPE + COMMA_SEP +
                    RestaurantSearch.COLUMN_NAME_PAGE_TITLE + TEXT_TYPE + COMMA_SEP +
                    RestaurantSearch.COLUMN_NAME_WEBPAGE_URL + TEXT_TYPE + COMMA_SEP +
                    RestaurantSearch.COLUMN_NAME_SEARCH_TAGS + TEXT_TYPE + COMMA_SEP +
                    RestaurantSearch.COLUMN_NAME_DATESTAMP + TEXT_TYPE + COMMA_SEP +")";

    private static final String SQL_DELETE_RESTAURANT_ENTRIES =
            "DROP TABLE IF EXISTS " + RestaurantSearch.TABLE_NAME;
    private static final String SQL_CREATE_VIDEO_TABLE_ENTRIES =
            "CREATE TABLE " + VideoSearch.TABLE_NAME + " (" +
                    VideoSearch._ID + " INTEGER PRIMARY KEY," +
                    VideoSearch.COLUMN_NAME_SEARCH_ID + TEXT_TYPE + COMMA_SEP +
                    VideoSearch.COLUMN_NAME_IMAGE_URI + TEXT_TYPE + COMMA_SEP +
                    VideoSearch.COLUMN_NAME_PAGE_TITLE + TEXT_TYPE + COMMA_SEP +
                    VideoSearch.COLUMN_NAME_WEBPAGE_URL + TEXT_TYPE + COMMA_SEP +
                    VideoSearch.COLUMN_NAME_SEARCH_TAGS + TEXT_TYPE + COMMA_SEP +
                    VideoSearch.COLUMN_NAME_DATESTAMP + TEXT_TYPE + COMMA_SEP +")";

    private static final String SQL_DELETE_VIDEO_ENTRIES =
            "DROP TABLE IF EXISTS " + RecipeSearch.TABLE_NAME;

    private static final String SQL_CREATE_USERINFO_TABLE_ENTRIES =
            "CREATE TABLE " + UserInfo.TABLE_NAME + " (" +
                    UserInfo._ID + " INTEGER PRIMARY KEY," +
                    UserInfo.COLUMN_NAME_USER_ID + TEXT_TYPE + COMMA_SEP +
                    UserInfo.COLUMN_NAME_USERNAME + TEXT_TYPE + COMMA_SEP +
                    UserInfo.COLUMN_NAME_EMAIL + TEXT_TYPE + COMMA_SEP +
                    UserInfo.COLUMN_NAME_PASSWORD + TEXT_TYPE + COMMA_SEP +
                    UserInfo.COLUMN_NAME_DIETARY_RESTRICTIONS + TEXT_TYPE + COMMA_SEP +
                    UserInfo.COLUMN_NAME_ALLERGIES + TEXT_TYPE + COMMA_SEP +
                    UserInfo.COLUMN_NAME_FRIENDS + TEXT_TYPE + COMMA_SEP + ")";

    private static final String SQL_DELETE_USERINFO_ENTRIES =
            "DROP TABLE IF EXISTS " + RecipeSearch.TABLE_NAME;

    public DatabaseDbHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db){
        db.execSQL(SQL_CREATE_RECIPE_TABLE_ENTRIES);
        db.execSQL(SQL_CREATE_GROCERY_TABLE_ENTRIES);
        db.execSQL(SQL_CREATE_RESTAURANT_TABLE_ENTRIES);
        db.execSQL(SQL_CREATE_VIDEO_TABLE_ENTRIES);
        db.execSQL(SQL_CREATE_USERINFO_TABLE_ENTRIES);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_RECIPE_ENTRIES);
        db.execSQL(SQL_DELETE_GROCERY_ENTRIES);
        db.execSQL(SQL_DELETE_RESTAURANT_ENTRIES);
        db.execSQL(SQL_DELETE_VIDEO_ENTRIES);
        db.execSQL(SQL_DELETE_USERINFO_ENTRIES);
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

}
