package vcoach.example.com.vitalitycoach;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.challenges_toolbar);
        setSupportActionBar(myToolbar);
        SharedPreferences sharedpreferences = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putBoolean("vit_age_completed", false); // Storing boolean - true/false
        editor.putBoolean("hf_completed", false); // Storing boolean - true/false
        editor.putLong("vit_points", 10000); // Storing long
        editor.commit();
    }

    /** Called when the user taps the Send button */
    public void sendMessage(View view) {
        Intent intent = new Intent(this, ChallengesActivityPage.class);
        startActivity(intent);
    }

}
