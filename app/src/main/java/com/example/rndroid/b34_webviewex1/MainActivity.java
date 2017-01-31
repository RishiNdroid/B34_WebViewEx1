package com.example.rndroid.b34_webviewex1;

import android.app.usage.NetworkStatsManager;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = (WebView) findViewById(R.id.webview);

        //A. To check whether user has internet acces or not
        ConnectivityManager manager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        //B. From Manager, Get network information
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();

        //C. Check If network is connected or not
        if(networkInfo == null || networkInfo.isConnected() == false){
            // means there is no INTERNET

        webView.loadData("<h1>NO INTERNET - CHECK AGAIN<h1>", "text/html", null);
            return;
        }

        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        //will make sure that onclicking any hyperlink,nex page will be loaded in your activity
        //Either you can give url, or can search in google
        webView.loadUrl("http://www.techpalle.com");
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //Ask webView if there are any previously navigated pages
        if(keyCode == KeyEvent.KEYCODE_BACK){
            //control comes back here if there is previious page
            webView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
