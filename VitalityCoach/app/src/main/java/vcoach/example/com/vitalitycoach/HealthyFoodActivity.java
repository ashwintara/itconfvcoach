package vcoach.example.com.vitalitycoach;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
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
    private SessionManager sessionManager;//global variable

    MediaController media_Controller;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        {
            setContentView(R.layout.healthy_food);
        }

        //  Uri uri = Uri.parse("https://s3.ap-south-1.amazonaws.com/vitalitycoachbucket/IMG_4901.mp4");

    }

    public void startHealthyFoodVideo(View view) {
        Intent i = new Intent(HealthyFoodActivity.this, VitAgeActivityShare.class);
        startActivity(i);
        new StartFlashTask().execute();
    }


    private class StartFlashTask extends AsyncTask<Void, Void, Void>{

        protected void onProgressUpdate(String... params) {
        }

        protected void onPostExecute(Long result) {
        }

        @Override
        protected Void doInBackground(Void... params) {
            Intent i;
            PackageManager manager = getPackageManager();
            i = manager.getLaunchIntentForPackage("air.HealthyFoodAndroid");
            i.addCategory(Intent.CATEGORY_LAUNCHER);
            startActivity(i);
            return null;
        }
    }
}