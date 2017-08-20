package vcoach.example.com.vitalitycoach;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by ASHWINI2 on 10/08/2017.
 */

public class ProgressChartWithRewards extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.progress_chart_1);
        Snackbar mySnackBar = Snackbar.make(findViewById(R.id.constraintLayout), R.string.ar_Badge,
                Snackbar.LENGTH_LONG);
        mySnackBar.show();
    }
}