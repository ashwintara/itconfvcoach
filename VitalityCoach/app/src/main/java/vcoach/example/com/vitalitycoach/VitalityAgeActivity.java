package vcoach.example.com.vitalitycoach;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.SurfaceView;
import android.view.View;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import static android.R.attr.duration;

/**
 * Created by ASHWINI2 on 15/07/2017.
 */

public class VitalityAgeActivity extends AppCompatActivity {
    VideoView simpleVideoView;
    DisplayMetrics dm;
    SurfaceView sur_View;
    private Session session;//global variable

    MediaController media_Controller;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        session = new Session(this.getApplicationContext());
        super.onCreate(savedInstanceState);
        if(session.isVitageCompleted()) {
            Log.d("Android: sessionc",session.isVitageCompleted()+"");
            setContentView(R.layout.vit_age_share);
        }else{
            Log.d("Android: session",session.isVitageCompleted()+"");
            setContentView(R.layout.vitality_age);
        }

     //  Uri uri = Uri.parse("https://s3.ap-south-1.amazonaws.com/vitalitycoachbucket/IMG_4901.mp4");

    }

    public void startVitalityAgeVideo(View view){
        Intent intent = new Intent(this, VitalityAgeVideoActivity.class);
        startActivity(intent);
    }


    /* VideoView videoView = (VideoView)findViewById(R.id.VideoView);*/
    /** Called when the activity is first created. */
    /** Called when the user taps the Send button */


}


