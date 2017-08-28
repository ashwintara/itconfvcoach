package vcoach.example.com.vitalitycoach;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by ASHWINI2 on 18/07/2017.
 */

public class ChallengesActivityPage extends AppCompatActivity {
    private ProgressBar progressBar;
    private int progressStatus = 0;
    private TextView textView;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.challenges_activity_page);
        progressBar = (ProgressBar) findViewById(R.id.horizontalProgressBar);
        textView = (TextView) findViewById(R.id.textViewPoints);
         SharedPreferences sharedpreferences = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
         long vitPoints= sharedpreferences.getLong("vit_points",0);
            final long progressMeter=vitPoints/100;

                new Thread(new Runnable() {
            public void run() {
                while (progressStatus < progressMeter) {
                    progressStatus += 1;
                    // Update the progress bar and display the
                    //current value in the text view
                    handler.post(new Runnable() {
                        public void run() {
                            progressBar.setProgress(progressStatus);
                                textView.setText("Your Vitality Points: "+(progressStatus*100));
                        }
                    });
                    try {
                        // Sleep for 200 milliseconds.
                        Thread.sleep(12);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();


    }

    public void connectVitalityAgePage(View view) {

        Intent intent = new Intent(this, VitalityAgeActivity.class);
        startActivity(intent);
    }

    public void connectActiveRewardsPage(View view){
        Intent intent = new Intent(this, ActiveRewardsPage.class);
        startActivity(intent);
    }

    public void connectHealthyFood(View view) {
        Intent intent = new Intent(this, HealthyFoodActivity.class);
        startActivity(intent);
    }

    public void connectDashboardPage(View view) {

        Intent intent = new Intent(this, ProgressChartWithRewards.class);
        startActivity(intent);
    }
    public void connectLeaderboard(View view) {

        Intent intent = new Intent(this, Leaderboard.class);
        startActivity(intent);
    }






    public void updateSharedPrefsVitalityAge(){

    }


}
