package vcoach.example.com.vitalitycoach;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.SurfaceView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.Toast;

/**
 * Created by ASHWINI2 on 11/08/2017.
 */

public class VitAgeActivityShare extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vit_age_share);


    }



    public void backToChallenges(View view) {

        Intent i = new Intent(VitAgeActivityShare.this, ChallengesActivityPage.class);
        startActivity(i);

    }


    public void shareFB(View view){
        Intent intent = new Intent(this, SharingActivity.class);
        startActivity(intent);
    }

}

