package com.apps.saijestudio.fitcrave.utils;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

/**
 * This abstract class extends the Activity class and overrides
 * callbacks for logging events.
 */
public abstract class LoggingActivity extends Activity {

    protected final String TAG = getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState != null) {
            Log.d(TAG, "onCreate(): activity re-created");
        } else {
            Log.d(TAG, "onCreate(): activity created");
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart(): activity becoming visible");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,
                "onResume(): the activity resuming visibility");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,
                "onPause(): another activity takes focus");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,
                "onStop(): activity no longer visible i.e. onStop() is called");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart(): activity restarting");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy(): activity is being destroyed");
    }

}
