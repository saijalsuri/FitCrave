package com.apps.saijestudio.fitcrave.activities;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.view.Menu;
import android.view.MenuItem;
import com.apps.saijestudio.fitcrave.R;
import com.apps.saijestudio.fitcrave.helpers.Constants;
import com.apps.saijestudio.fitcrave.utils.LoggingActivity;

//Displays webView when List item is clicked in ResultsActivity
public class ResultItemDetailWebActivity extends LoggingActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_item_detail_web);

        //extract result info from intent extras
        final String title = getIntent().getStringExtra(Constants.BUNDLE_TITLE);
        String link = getIntent().getStringExtra(Constants.BUNDLE_LINK);
        String url = getIntent().getStringExtra(Constants.BUNDLE_URL);

        //extract textviews and set link and titleView text
        final TextView titleView = (TextView)findViewById(R.id.title);
        TextView linkView = (TextView)findViewById(R.id.link);
        final ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);
        linkView.setText(link);
        titleView.setText(Constants.LOADING);

        //extract webView
        WebView resultWebview = (WebView) findViewById(R.id.webview);
        Log.e(Constants.URL, url);

        Log.d(TAG, "Starting webView Customization");
        //webView settings
        resultWebview.getSettings().setJavaScriptEnabled(true);
        resultWebview.getSettings().setUseWideViewPort(false);
        resultWebview.getSettings().setSupportZoom(true);
        resultWebview.getSettings().setLoadWithOverviewMode(true);

        //initialize webView client to display error msg if any
        resultWebview.setWebViewClient(new WebViewClient() {
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                Log.e(Constants.WEBVIEW_ERROR, description + ": " + failingUrl);
            }
        });
        Log.d(TAG, "Initialized WebClient");
        //initialize webView ChromeClient to display webpage loading progress to progressBar
        resultWebview.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress) {
                //if webpage has loaded then set title Textview to webpage title and progressBar to complete
                if(progress == 100) {
                    titleView.setText(title);
                    progressBar.setProgress(progress * 100);
                }

                //else set webpage title to Loading and update progressBar
                else {
                    titleView.setText(Constants.LOADING);
                    progressBar.setProgress(progress);
                }
            }
        });
        Log.d(TAG, "Initialized Chrome Client");

        //load webpage url to Webview
        resultWebview.loadUrl(url);
        Log.d(TAG, "Load url in webview");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_result_item_detail_web_view, menu);
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