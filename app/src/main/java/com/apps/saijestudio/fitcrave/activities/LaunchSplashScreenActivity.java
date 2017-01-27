package com.apps.saijestudio.fitcrave.activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.ImageView;

import com.apps.saijestudio.fitcrave.R;
import com.apps.saijestudio.fitcrave.helpers.Constants;
import com.apps.saijestudio.fitcrave.utils.LoggingActivity;

public class LaunchSplashScreenActivity extends LoggingActivity {


    //Checks if drawable is larger than window size and re-sizes it to fit
    private Drawable resize(Drawable image) {

        //Get image height and width
        Bitmap bitmap = ((BitmapDrawable) image).getBitmap();
        int bitmapWidth = bitmap.getWidth();
        int bitmapHeight = bitmap.getHeight();

        //Get screen height and width
        DisplayMetrics displaymetrics = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
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

        Log.d(TAG, "resize(() - Returning Resized Bitmap");

        return new BitmapDrawable(getResources(), bitmapResized);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launchscreen);

        //Extract imageView container for the logo drawable
        ImageView imageView = (ImageView) findViewById(R.id.logo);
        imageView.setImageResource(0);

        //Get Drawable to be displayed and resize
        Drawable draw = getResources().getDrawable(R.drawable.fitcrave_launch_pg_small);
        draw = resize(draw);

        //Set Drawable to imageView
        imageView.setImageDrawable(draw);

        Log.d(TAG, "set new resized drawable as imageView");


        //Create Runnable launching MainActivity to be posted to Handler
        // after delay of SPLASH_TIME_OUT
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.d(TAG, "Launching MainActivity");
                Intent i = new Intent(LaunchSplashScreenActivity.this, MainActivity.class);
                startActivity(i);

                //Finish SplashScreenActivity after launching MainActivity to remove
                // from Activity back stack
                finish();

            }
        }, Constants.SPLASH_TIME_OUT);

    }

    @Override
    protected void onDestroy() {

        super.onDestroy();

    }

}
