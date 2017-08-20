package vcoach.example.com.vitalitycoach;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by ASHWINI2 on 09/08/2017.
 */

public class Session {

    private SharedPreferences prefs;

    public boolean vitageCompleted;

    public Session(Context cntx) {
        // TODO Auto-generated constructor stub
        prefs = PreferenceManager.getDefaultSharedPreferences(cntx);
    }

    public void setusename(String usename) {
        prefs.edit().putString("usename", usename).commit();
    }

    public String getusename() {
        String usename = prefs.getString("usename","Wayde");
        return usename;
    }


    public boolean isVitageCompleted() {
        return vitageCompleted;
    }

    public void setVitageCompleted(boolean vitageCompleted) {
        this.vitageCompleted = vitageCompleted;
    }

}