package vcoach.example.com.vitalitycoach;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.SurfaceView;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

/**
 * Created by ASHWINI2 on 11/08/2017.
 */

public class HealthyFoodActivity extends AppCompatActivity {
    VideoView simpleVideoView;
    DisplayMetrics dm;
    SurfaceView sur_View;
    private Session session;//global variable

    MediaController media_Controller;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        session = new Session(this.getApplicationContext());
        super.onCreate(savedInstanceState);
        {
            Log.d("Android: session", session.isVitageCompleted() + "");
            setContentView(R.layout.healthy_food);
        }

        //  Uri uri = Uri.parse("https://s3.ap-south-1.amazonaws.com/vitalitycoachbucket/IMG_4901.mp4");

    }

    public void startHealthyFoodVideo(View view) {
        Intent intent = new Intent(this, HealthyFoodVideoActivity.class);
        startActivity(intent);
    }
}