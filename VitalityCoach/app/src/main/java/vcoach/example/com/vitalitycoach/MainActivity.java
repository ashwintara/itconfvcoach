package vcoach.example.com.vitalitycoach;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.challenges_toolbar);
        setSupportActionBar(myToolbar);

    }

    public void savePreferences(View view){


    }


    /** Called when the user taps the Send button */
    public void sendMessage(View view) {
        Intent intent = new Intent(this, ChallengesActivityPage.class);
        startActivity(intent);
    }

   /* public void startService(View view) {
        startService(new Intent(getBaseContext(), FacebookIntegrationService.class));
    }

    // Method to stop the service
    public void stopService(View view) {
        stopService(new Intent(getBaseContext(), FacebookIntegrationService.class));
    }*/


 //  image.setImageResource(R.drawable.dsada)
}
