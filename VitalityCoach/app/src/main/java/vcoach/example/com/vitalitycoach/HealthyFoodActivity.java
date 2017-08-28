package vcoach.example.com.vitalitycoach;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.SurfaceView;
import android.view.View;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

/**
 * Created by ASHWINI2 on 11/08/2017.
 */

public class HealthyFoodActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        {
            setContentView(R.layout.healthy_food);
        }
    }

    public void startHealthyFoodVideo(View view) {
        Intent i = new Intent(HealthyFoodActivity.this, VitAgeActivityShare.class);
        updateSharedPrefsHF();
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

    public void updateSharedPrefsHF() {
        SharedPreferences sharedpreferences = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
        Boolean isHealthyFoodCompleted = sharedpreferences.getBoolean("hf_completed", false);
        {
            if (!isHealthyFoodCompleted) {
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putBoolean("hf_completed", true); // Storing boolean - true/false

                long vitPoints = sharedpreferences.getLong("vit_points", 0);
                long newVitPoints = vitPoints + 2500;
                //update vitality points
                editor.putLong("vit_points", newVitPoints); // Storing long
                editor.commit();
            }

        }
    }
}