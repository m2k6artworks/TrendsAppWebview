package com.example.smartizen;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.content.IntentCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;

public class CekActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPref sharedpref;
        sharedpref = new SharedPref(this);

        if (sharedpref.loadLM()==true)
        {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
        else if (sharedpref.loadDM()==true)
        {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }
        else if (sharedpref.loadAM()==true)
        {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
        }
        else if (sharedpref.loadTM()==true)
        {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_AUTO);
        }

        int SplashDuration = 1000;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(CekActivity.this, SplashActivity.class);
                startActivity(i);
                finish();
            }

        }, SplashDuration);
    }
}
