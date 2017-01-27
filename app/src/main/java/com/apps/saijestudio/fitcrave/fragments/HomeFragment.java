package com.apps.saijestudio.fitcrave.fragments;

import android.app.SearchManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.SearchView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.apps.saijestudio.fitcrave.R;

//Handles the UI for MainActivity
public class HomeFragment extends Fragment {


    private String TAG = getClass().getSimpleName();

    //Checks if drawable is larger than window size and re-sizes it to fit
    private Drawable resize(Drawable image) {

        //Get image height and width
        Bitmap bitmap = ((BitmapDrawable) image).getBitmap();
        int bitmapWidth = bitmap.getWidth();
        int bitmapHeight = bitmap.getHeight();

        //Get screen height and width
        DisplayMetrics displaymetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        int screenWidth = displaymetrics.widthPixels;
        int screenHeight = displaymetrics.heightPixels;

        //Repeatedly half the image's dimensions till its fits in the screen
        while(bitmapWidth > screenWidth || bitmapHeight > screenHeight){
            bitmapWidth = (int) (bitmapWidth * 0.5);
            bitmapHeight = (int) (bitmapHeight * 0.5);
        }

        //Create new Drawable
        Bitmap bitmapResized = Bitmap.createScaledBitmap(bitmap,
                bitmapWidth, bitmapHeight, false);
        return new BitmapDrawable(getResources(), bitmapResized);
    }


    public static Fragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);

        //Get args and display to Textview
        int mNum = getArguments() != null ? getArguments().getInt("num") : 1;
        TextView fragInfo = (TextView)v.findViewById(R.id.fraginfo);
        fragInfo.setText("Fragment #" + mNum);

        //Extract imageView container for the search text drawable
        ImageView imageView = (ImageView) v.findViewById(R.id.search_text_img);
        imageView.setImageResource(0);

        //Get Drawable to be displayed and resize
        Drawable draw = getActivity().getResources().getDrawable(R.drawable.search_text);
        draw = resize(draw);

        //Set Drawable to imageView
        imageView.setImageDrawable(draw);

        Log.d(TAG, "Set resized bitmap to ImageView");

        // Get the SearchView and set the searchable configuration
        SearchManager searchManager = (SearchManager) getActivity().getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) v.findViewById(R.id.search_edittext);
        // Assumes current activity is the activity with search
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getActivity().getComponentName()));
        searchView.setIconifiedByDefault(false); // Do not iconify the widget; expand it by default

        Log.d(TAG, "Set SearchView details");
        //SEE MAINFEST FILE to see how search widget is linked to Searchable Activity

        return v;
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
