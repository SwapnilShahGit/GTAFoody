package com.Oguzhan.Swapnil.GTAFoody;

import android.app.ActionBar;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.app.Activity;

public class Store_Menu extends Activity {
    private static ViewGroup webViewParentViewGroup;
    private static  WebView storemenuview;
    private static String placeholder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        if((storemenuview != null) && (placeholder == MainActivity.URLVariable)){
            webViewParentViewGroup.removeView(storemenuview);
            setContentView(R.layout.storemenuactivitynowebview);

            webViewParentViewGroup = (ViewGroup) findViewById(R.id.secondViewGroup);
            webViewParentViewGroup.addView(this.storemenuview);

        } else {

            setContentView(R.layout.activity_main);
            setContentView(R.layout.activity_store__menu);
            storemenuview = (WebView) this.findViewById(R.id.storemenuView);
            storemenuview.getSettings().setAppCacheMaxSize(5 * 1024 * 1024); // 5MB
            storemenuview.getSettings().setAppCachePath(getApplicationContext().getCacheDir().getAbsolutePath());
            storemenuview.getSettings().setAllowFileAccess(true);
            storemenuview.getSettings().setAppCacheEnabled(true);
            storemenuview.getSettings().setJavaScriptEnabled(true);
            storemenuview.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT); // load online by default
            storemenuview.getSettings().setJavaScriptEnabled(true);
            storemenuview.getSettings().setBuiltInZoomControls(true);
            storemenuview.getSettings().setDisplayZoomControls(false);
            storemenuview.loadUrl(MainActivity.URLVariable);
            storemenuview.setWebViewClient(new WebViewClient());
            if ( !isNetworkAvailable() ) { // loading offline
                storemenuview.getSettings().setCacheMode( WebSettings.LOAD_CACHE_ELSE_NETWORK );
            }
            webViewParentViewGroup = (ViewGroup) findViewById(R.id.firstViewGroup);
            storemenuview = (WebView) findViewById(R.id.storemenuView);
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
        if(storemenuview.canGoBack()) {
            storemenuview.goBack();
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_store__menu, menu);
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
