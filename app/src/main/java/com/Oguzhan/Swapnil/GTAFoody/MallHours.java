package com.Oguzhan.Swapnil.GTAFoody;

import android.app.Activity;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class MallHours extends Activity {

    private static ViewGroup webViewParentViewGroup;
    private static WebView mallHoursView;
    private static String placeholder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        if((mallHoursView != null) && (placeholder == MainActivity.URLVariable)){
            webViewParentViewGroup.removeView(mallHoursView);
            setContentView(R.layout.activity_mall_hours);

            webViewParentViewGroup = (ViewGroup) findViewById(R.id.secondViewGroup);
            webViewParentViewGroup.addView(this.mallHoursView);

        } else {

            setContentView(R.layout.activity_main);
            setContentView(R.layout.activity_mall_hours);
            mallHoursView = (WebView) this.findViewById(R.id.mallHoursView);
            mallHoursView.getSettings().setAppCacheMaxSize(5 * 1024 * 1024); // 5MB
            mallHoursView.getSettings().setAppCachePath(getApplicationContext().getCacheDir().getAbsolutePath());
            mallHoursView.getSettings().setAllowFileAccess(true);
            mallHoursView.getSettings().setAppCacheEnabled(true);
            mallHoursView.getSettings().setJavaScriptEnabled(true);
            mallHoursView.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT); // load online by default
            mallHoursView.getSettings().setJavaScriptEnabled(true);
            mallHoursView.getSettings().setBuiltInZoomControls(true);
            mallHoursView.getSettings().setDisplayZoomControls(false);
            mallHoursView.loadUrl(MainActivity.URLVariable);
            mallHoursView.setWebViewClient(new WebViewClient());
            if ( !isNetworkAvailable() ) { // loading offline
                mallHoursView.getSettings().setCacheMode( WebSettings.LOAD_CACHE_ELSE_NETWORK );
            }
            webViewParentViewGroup = (ViewGroup) findViewById(R.id.firstViewGroup);
            mallHoursView = (WebView) findViewById(R.id.mallHoursView);
            placeholder = MainActivity.URLVariable;





        }



    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService( CONNECTIVITY_SERVICE );
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    @Override
    public void onBackPressed() {
        if(mallHoursView.canGoBack()) {
            mallHoursView.goBack();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_mall_hours, menu);
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
