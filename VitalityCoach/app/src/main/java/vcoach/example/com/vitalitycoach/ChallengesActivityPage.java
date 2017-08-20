package vcoach.example.com.vitalitycoach;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import static java.security.AccessController.getContext;

/**
 * Created by ASHWINI2 on 18/07/2017.
 */

public class ChallengesActivityPage extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.challenges_activity_page);



//and now we set shared preference then use this like


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
}
