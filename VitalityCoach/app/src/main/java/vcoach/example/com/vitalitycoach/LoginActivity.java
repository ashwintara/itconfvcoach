package vcoach.example.com.vitalitycoach;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by ASHWINI2 on 18/07/2017.
 */

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen);
    }

    /** Called when the user taps the Send button */
    public void connectMainPage(View view) {
        validateLogin(view);

    }

    public void validateLogin(View view){
        EditText textUsername= (EditText) findViewById(R.id.textUsername);
        EditText textPassword= (EditText) findViewById(R.id.textPassword);
        if(!(textPassword.getText().toString().equals("itconf") && textUsername.getText().toString().equals("itconf"))) {
            Toast.makeText(LoginActivity.this, "Wrong Username/Password. Please try again!", Toast.LENGTH_LONG).show();
            Log.i("Info", textPassword.getText().toString());
            Log.i("Info", textUsername.getText().toString());
        }
        else{
            Intent intent = new Intent(this, MainActivity.class);
            setinitialSharedPres();
            startActivity(intent);
        }

    }
    public void setinitialSharedPres(){
        SharedPreferences sharedpreferences = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putBoolean("vit_age_completed", false); // Storing boolean - true/false
        editor.putBoolean("hf_completed", false); // Storing boolean - true/false
        editor.putLong("vit_points", 5000); // Storing long
        editor.commit();
    }



}
