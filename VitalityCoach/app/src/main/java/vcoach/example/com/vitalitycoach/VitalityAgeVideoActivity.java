package vcoach.example.com.vitalitycoach;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.MediaController;
import android.widget.VideoView;

/**
 * Created by ASHWINI2 on 18/07/2017.
 */

public class VitalityAgeVideoActivity extends AppCompatActivity {

    private WebView mWebView;
    MediaController media_Controller;
    private Session session;//global variable
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vitality_age_video);
        VideoView view = (VideoView) findViewById(R.id.webView);
        String path = "android.resource://" + getPackageName() + "/" + R.raw.vitality_age;
        view.setVideoURI(Uri.parse(path));
        session = new Session(this.getApplicationContext());
        view.start();



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



