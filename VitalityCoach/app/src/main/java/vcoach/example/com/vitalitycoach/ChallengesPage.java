package vcoach.example.com.vitalitycoach;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by ASHWINI2 on 16/07/2017.
 */

public class ChallengesPage extends AppCompatActivity {
    ListView userList;
    VitAgeCustomAdapter userAdapter;
    HealthyFoodCustomAdapter healthyFoodAdapter;
    ActiveRewardsCustomAdapter activeRewardsAdapter;
    ArrayList<User> vitAgeChallenge = new ArrayList<User>();
    ArrayList<User> healthyFoodChallenge = new ArrayList<User>();
    ArrayList<User> activeRewardsChallenge = new ArrayList<User>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.challenge_page);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.challenges_toolbar);

        setSupportActionBar(myToolbar);
        getSupportActionBar().setSubtitle("Your personal Coach for all Vitality Challenges!");
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);




        ImageView yourProgress = (ImageView) findViewById(R.id.yourProgress);
        yourProgress.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent newActivity = new Intent(getApplicationContext(), ProgressChartNoRewards.class);
                startActivity(newActivity);
            }
        });

        /**
         * add item in arraylist
         */
        vitAgeChallenge.add(new User("Vitality Age Challenge", "2500 Points", "Earn Vitality points for completing you Vitality Age and activate 15% of your Healthy food"));
        healthyFoodChallenge.add(new User("Healthy Food Challenge", "25% and 10% OFF at PNP or WW", "Activate your Healthy food benefit and earn heavy cashbacks! Play our Healthy food game to understand benefit more"));
        activeRewardsChallenge.add(new User("Active Rewards Challenge", "Get Active,Get Rewarded!", "Activate Vitality Active Rewards and get a personalised fitness goal"));
        /**
         * set item into adapter
         */
        userAdapter = new VitAgeCustomAdapter(ChallengesPage.this, R.layout.row, vitAgeChallenge);
        userList = (ListView) findViewById(R.id.vitAgeList);
        userList.setItemsCanFocus(false);
        userList.setAdapter(userAdapter);


        healthyFoodAdapter = new HealthyFoodCustomAdapter(ChallengesPage.this, R.layout.healthy_food_row, healthyFoodChallenge);
        userList = (ListView) findViewById(R.id.healthyFoodList);
        userList.setItemsCanFocus(false);
        userList.setAdapter(healthyFoodAdapter);


        activeRewardsAdapter = new ActiveRewardsCustomAdapter(ChallengesPage.this, R.layout.active_rewards_row, activeRewardsChallenge);
        userList = (ListView) findViewById(R.id.activeRewardsList);
        userList.setItemsCanFocus(false);
        userList.setAdapter(activeRewardsAdapter);

    }

}
