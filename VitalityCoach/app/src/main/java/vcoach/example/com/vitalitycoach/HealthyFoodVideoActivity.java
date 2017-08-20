package vcoach.example.com.vitalitycoach;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.WebView;
import android.widget.MediaController;
import android.widget.VideoView;

/**
 * Created by ASHWINI2 on 11/08/2017.
 */

public class HealthyFoodVideoActivity  extends AppCompatActivity {

    private WebView mWebView;
    MediaController media_Controller;
    private Session session;//global variable
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vitality_age_video);
        VideoView view = (VideoView) findViewById(R.id.webView);
        String path = "android.resource://" + getPackageName() + "/" + R.raw.healthyfoodchallenge;
        view.setVideoURI(Uri.parse(path));
        session = new Session(this.getApplicationContext()); //in oncreate
        view.start();




    /*    mWebView = (WebView) findViewById(R.id.webView);
        mWebView.getSettings().setPluginState(WebSettings.PluginState.ON);
        mWebView.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        mWebView.setBackgroundColor(Color.parseColor("#000000"));
        mWebView.loadUrl("file:///android_asset/index.html");*/

        view.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

            @Override
            public void onCompletion(MediaPlayer mp) {
                // TODO Auto-generated method stub
                finish();
                session.setVitageCompleted(true);
                Log.d("Android: session",session.isVitageCompleted()+"");
                Intent newActivity = new Intent(getApplicationContext(), VitAgeActivityShare.class);
                startActivity(newActivity);
                //write your code after complete video play
            }
        });
    }

}
   /*
        mWebView = (WebView)findViewById(R.id.webView);
       // mWebView.setWebViewClient(new WebViewClient());
        mWebView.setWebChromeClient(new WebChromeClient());
        mWebView.getSettings().setAllowFileAccess(true);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.getSettings().setDomStorageEnabled(true);
        mWebView.getSettings().setPluginState(WebSettings.PluginState.ON);
        mWebView.loadUrl("file:///android_asset/index.html");*/
       /* WebSettings webSettings=mWebView.getSettings();
        mWebView.setWebChromeClient(new WebChromeClient());
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setPluginState(WebSettings.PluginState.ON);
        webSettings.setAllowFileAccess(true);
        mWebView.getSettings().setAppCacheMaxSize( 10 * 1024 * 1024 );
        mWebView.getSettings().setAppCachePath(getApplicationContext().getCacheDir().getAbsolutePath() );
        mWebView.getSettings().setAllowFileAccess( true );
        mWebView.getSettings().setAppCacheEnabled( true );
        mWebView.getSettings().setCacheMode( WebSettings.LOAD_DEFAULT );*/
//

      /*  mWebView.postDelayed(new Runnable() {

            @Override
            public void run()
    {*/

//        }, 500);



