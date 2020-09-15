package com.example.smartizen;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class ThemeSet extends AppCompatActivity
{

    SharedPref sharedpref;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme_set);
        Toolbar toolbar = findViewById(R.id.toolbartheme);
        setSupportActionBar(toolbar);

        RadioButton light = findViewById(R.id.light);
        RadioButton dark = findViewById(R.id.dark);
        RadioButton autotime = findViewById(R.id.autotime);
        RadioButton autosystem = findViewById(R.id.autosystem);

        sharedpref = new SharedPref(this);

        //int mode = AppCompatDelegate.getDefaultNightMode();
        if (sharedpref.loadLM()==true)
        {
            light.setChecked(true);
        }
        else if (sharedpref.loadDM()==true)
        {
            dark.setChecked(true);
        }
        else if (sharedpref.loadAM()==true)
        {
            autosystem.setChecked(true);
        }
        else if (sharedpref.loadTM()==true)
        {
            autotime.setChecked(true);
        }

        TextView toolbarText = (TextView) findViewById(R.id.toolbar_text_th);
        toolbarText.setText("Theme Settings");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    public void light(View v)
    {
        sharedpref.setloadLM(true);
        sharedpref.setloadDM(false);
        sharedpref.setloadAM(false);
        sharedpref.setloadTM(false);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        Toast.makeText(this, "Set to Light Mode", Toast.LENGTH_SHORT).show();
        onBackPressed();
    }

    public void dark(View v)
    {
        sharedpref.setloadLM(false);
        sharedpref.setloadDM(true);
        sharedpref.setloadAM(false);
        sharedpref.setloadTM(false);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        Toast.makeText(this, "Set to Dark Mode", Toast.LENGTH_SHORT).show();
        onBackPressed();
    }

    public void autosystem(View v)
    {
        sharedpref.setloadLM(false);
        sharedpref.setloadDM(false);
        sharedpref.setloadAM(true);
        sharedpref.setloadTM(false);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
        Toast.makeText(this, "Set by Device Theme", Toast.LENGTH_SHORT).show();
        onBackPressed();
    }

    public void autotime(View v)
    {
        sharedpref.setloadLM(false);
        sharedpref.setloadDM(false);
        sharedpref.setloadAM(false);
        sharedpref.setloadTM(true);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_AUTO);
        Toast.makeText(this, "Set by Time Cycle", Toast.LENGTH_SHORT).show();
        onBackPressed();
    }

    @Override
    public boolean onSupportNavigateUp()
    {
        onBackPressed();
        return true;
    }

}
