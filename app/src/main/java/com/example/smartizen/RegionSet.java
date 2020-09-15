package com.example.smartizen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class RegionSet extends AppCompatActivity
{

    SharedPref sharedpref;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_region_set);
        Toolbar toolbar = findViewById(R.id.toolbarthemer);
        setSupportActionBar(toolbar);

        RadioButton ww = findViewById(R.id.worldwide);
        RadioButton br = findViewById(R.id.brazil);
        RadioButton ca = findViewById(R.id.canada);
        RadioButton eg = findViewById(R.id.egypt);
        RadioButton fr = findViewById(R.id.france);
        RadioButton de = findViewById(R.id.germany);
        RadioButton in = findViewById(R.id.india);
        RadioButton id = findViewById(R.id.indonesia);
        RadioButton it = findViewById(R.id.italy);
        RadioButton jp = findViewById(R.id.japan);
        RadioButton mx = findViewById(R.id.mexico);
        RadioButton ng = findViewById(R.id.nigeria);
        RadioButton ph = findViewById(R.id.philiphines);
        RadioButton ru = findViewById(R.id.russia);
        RadioButton kr = findViewById(R.id.southkorea);
        RadioButton th = findViewById(R.id.thailand);
        RadioButton tr = findViewById(R.id.turkey);
        RadioButton uk = findViewById(R.id.unitedkingdom);
        RadioButton us = findViewById(R.id.unitedstates);
        RadioButton vn = findViewById(R.id.vietnam);

        sharedpref = new SharedPref(this);

        //int mode = AppCompatDelegate.getDefaultNightMode();
        if (sharedpref.loadWW()==true)
        {
            ww.setChecked(true);
        }
        else if (sharedpref.loadBR()==true)
        {
            br.setChecked(true);
        }
        else if (sharedpref.loadCA()==true)
        {
            ca.setChecked(true);
        }
        else if (sharedpref.loadEG()==true)
        {
            eg.setChecked(true);
        }
        else if (sharedpref.loadFR()==true)
        {
            fr.setChecked(true);
        }
        else if (sharedpref.loadDE()==true)
        {
            de.setChecked(true);
        }
        else if (sharedpref.loadIN()==true)
        {
            in.setChecked(true);
        }
        else if (sharedpref.loadID()==true)
        {
            id.setChecked(true);
        }
        else if (sharedpref.loadIT()==true)
        {
            it.setChecked(true);
        }
        else if (sharedpref.loadJP()==true)
        {
            jp.setChecked(true);
        }
        else if (sharedpref.loadMX()==true)
        {
            mx.setChecked(true);
        }
        else if (sharedpref.loadNG()==true)
        {
            ng.setChecked(true);
        }
        else if (sharedpref.loadPH()==true)
        {
            ph.setChecked(true);
        }
        else if (sharedpref.loadRU()==true)
        {
            ru.setChecked(true);
        }
        else if (sharedpref.loadKR()==true)
        {
            kr.setChecked(true);
        }
        else if (sharedpref.loadTH()==true)
        {
            th.setChecked(true);
        }
        else if (sharedpref.loadTR()==true)
        {
            tr.setChecked(true);
        }
        else if (sharedpref.loadUK()==true)
        {
            uk.setChecked(true);
        }
        else if (sharedpref.loadUS()==true)
        {
            us.setChecked(true);
        }
        else if (sharedpref.loadVN()==true)
        {
            vn.setChecked(true);
        }

        TextView toolbarText = (TextView) findViewById(R.id.toolbar_text_tr);
        TextView info = (TextView) findViewById(R.id.info);
        //info.setText("Picked from Wikipedia \n 'List of countries by number of Internet Users in 2017'");
        info.setText("Choose default Region for Trending Info");
        toolbarText.setText("Region Settings");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    public void worldwide(View v)
    {
        sharedpref.setloadWW(true);
        sharedpref.setloadBR(false);
        sharedpref.setloadCA(false);
        sharedpref.setloadEG(false);
        sharedpref.setloadFR(false);
        sharedpref.setloadDE(false);
        sharedpref.setloadIN(false);
        sharedpref.setloadID(false);
        sharedpref.setloadIT(false);
        sharedpref.setloadJP(false);
        sharedpref.setloadMX(false);
        sharedpref.setloadNG(false);
        sharedpref.setloadPH(false);
        sharedpref.setloadRU(false);
        sharedpref.setloadKR(false);
        sharedpref.setloadTH(false);
        sharedpref.setloadTR(false);
        sharedpref.setloadUK(false);
        sharedpref.setloadUS(false);
        sharedpref.setloadVN(false);
        Toast.makeText(this, "Set to Worldwide", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    public void brazil(View v)
    {
        sharedpref.setloadWW(false);
        sharedpref.setloadBR(true);
        sharedpref.setloadCA(false);
        sharedpref.setloadEG(false);
        sharedpref.setloadFR(false);
        sharedpref.setloadDE(false);
        sharedpref.setloadIN(false);
        sharedpref.setloadID(false);
        sharedpref.setloadIT(false);
        sharedpref.setloadJP(false);
        sharedpref.setloadMX(false);
        sharedpref.setloadNG(false);
        sharedpref.setloadPH(false);
        sharedpref.setloadRU(false);
        sharedpref.setloadKR(false);
        sharedpref.setloadTH(false);
        sharedpref.setloadTR(false);
        sharedpref.setloadUK(false);
        sharedpref.setloadUS(false);
        sharedpref.setloadVN(false);
        Toast.makeText(this, "Set Region to Brazil", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    public void canada(View v)
    {
        sharedpref.setloadWW(false);
        sharedpref.setloadBR(false);
        sharedpref.setloadCA(true);
        sharedpref.setloadEG(false);
        sharedpref.setloadFR(false);
        sharedpref.setloadDE(false);
        sharedpref.setloadIN(false);
        sharedpref.setloadID(false);
        sharedpref.setloadIT(false);
        sharedpref.setloadJP(false);
        sharedpref.setloadMX(false);
        sharedpref.setloadNG(false);
        sharedpref.setloadPH(false);
        sharedpref.setloadRU(false);
        sharedpref.setloadKR(false);
        sharedpref.setloadTH(false);
        sharedpref.setloadTR(false);
        sharedpref.setloadUK(false);
        sharedpref.setloadUS(false);
        sharedpref.setloadVN(false);
        Toast.makeText(this, "Set Region to Canada", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    public void egypt(View v)
    {
        sharedpref.setloadWW(false);
        sharedpref.setloadBR(false);
        sharedpref.setloadCA(false);
        sharedpref.setloadEG(true);
        sharedpref.setloadFR(false);
        sharedpref.setloadDE(false);
        sharedpref.setloadIN(false);
        sharedpref.setloadID(false);
        sharedpref.setloadIT(false);
        sharedpref.setloadJP(false);
        sharedpref.setloadMX(false);
        sharedpref.setloadNG(false);
        sharedpref.setloadPH(false);
        sharedpref.setloadRU(false);
        sharedpref.setloadKR(false);
        sharedpref.setloadTH(false);
        sharedpref.setloadTR(false);
        sharedpref.setloadUK(false);
        sharedpref.setloadUS(false);
        sharedpref.setloadVN(false);
        Toast.makeText(this, "Set Region to Egypt", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    public void france(View v)
    {
        sharedpref.setloadWW(false);
        sharedpref.setloadBR(false);
        sharedpref.setloadCA(false);
        sharedpref.setloadEG(false);
        sharedpref.setloadFR(true);
        sharedpref.setloadDE(false);
        sharedpref.setloadIN(false);
        sharedpref.setloadID(false);
        sharedpref.setloadIT(false);
        sharedpref.setloadJP(false);
        sharedpref.setloadMX(false);
        sharedpref.setloadNG(false);
        sharedpref.setloadPH(false);
        sharedpref.setloadRU(false);
        sharedpref.setloadKR(false);
        sharedpref.setloadTH(false);
        sharedpref.setloadTR(false);
        sharedpref.setloadUK(false);
        sharedpref.setloadUS(false);
        sharedpref.setloadVN(false);
        Toast.makeText(this, "Set Region to France", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    public void germany(View v)
    {
        sharedpref.setloadWW(false);
        sharedpref.setloadBR(false);
        sharedpref.setloadCA(false);
        sharedpref.setloadEG(false);
        sharedpref.setloadFR(false);
        sharedpref.setloadDE(true);
        sharedpref.setloadIN(false);
        sharedpref.setloadID(false);
        sharedpref.setloadIT(false);
        sharedpref.setloadJP(false);
        sharedpref.setloadMX(false);
        sharedpref.setloadNG(false);
        sharedpref.setloadPH(false);
        sharedpref.setloadRU(false);
        sharedpref.setloadKR(false);
        sharedpref.setloadTH(false);
        sharedpref.setloadTR(false);
        sharedpref.setloadUK(false);
        sharedpref.setloadUS(false);
        sharedpref.setloadVN(false);
        Toast.makeText(this, "Set Region to Germany", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    public void india(View v)
    {
        sharedpref.setloadWW(false);
        sharedpref.setloadBR(false);
        sharedpref.setloadCA(false);
        sharedpref.setloadEG(false);
        sharedpref.setloadFR(false);
        sharedpref.setloadDE(false);
        sharedpref.setloadIN(true);
        sharedpref.setloadID(false);
        sharedpref.setloadIT(false);
        sharedpref.setloadJP(false);
        sharedpref.setloadMX(false);
        sharedpref.setloadNG(false);
        sharedpref.setloadPH(false);
        sharedpref.setloadRU(false);
        sharedpref.setloadKR(false);
        sharedpref.setloadTH(false);
        sharedpref.setloadTR(false);
        sharedpref.setloadUK(false);
        sharedpref.setloadUS(false);
        sharedpref.setloadVN(false);
        Toast.makeText(this, "Set Region to India", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    public void indonesia(View v)
    {
        sharedpref.setloadWW(false);
        sharedpref.setloadBR(false);
        sharedpref.setloadCA(false);
        sharedpref.setloadEG(false);
        sharedpref.setloadFR(false);
        sharedpref.setloadDE(false);
        sharedpref.setloadIN(false);
        sharedpref.setloadID(true);
        sharedpref.setloadIT(false);
        sharedpref.setloadJP(false);
        sharedpref.setloadMX(false);
        sharedpref.setloadNG(false);
        sharedpref.setloadPH(false);
        sharedpref.setloadRU(false);
        sharedpref.setloadKR(false);
        sharedpref.setloadTH(false);
        sharedpref.setloadTR(false);
        sharedpref.setloadUK(false);
        sharedpref.setloadUS(false);
        sharedpref.setloadVN(false);
        Toast.makeText(this, "Set Region to Indonesia", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    public void italy(View v)
    {
        sharedpref.setloadWW(false);
        sharedpref.setloadBR(false);
        sharedpref.setloadCA(false);
        sharedpref.setloadEG(false);
        sharedpref.setloadFR(false);
        sharedpref.setloadDE(false);
        sharedpref.setloadIN(false);
        sharedpref.setloadID(false);
        sharedpref.setloadIT(true);
        sharedpref.setloadJP(false);
        sharedpref.setloadMX(false);
        sharedpref.setloadNG(false);
        sharedpref.setloadPH(false);
        sharedpref.setloadRU(false);
        sharedpref.setloadKR(false);
        sharedpref.setloadTH(false);
        sharedpref.setloadTR(false);
        sharedpref.setloadUK(false);
        sharedpref.setloadUS(false);
        sharedpref.setloadVN(false);
        Toast.makeText(this, "Set Region to Italy", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    public void japan(View v)
    {
        sharedpref.setloadWW(false);
        sharedpref.setloadBR(false);
        sharedpref.setloadCA(false);
        sharedpref.setloadEG(false);
        sharedpref.setloadFR(false);
        sharedpref.setloadDE(false);
        sharedpref.setloadIN(false);
        sharedpref.setloadID(false);
        sharedpref.setloadIT(false);
        sharedpref.setloadJP(true);
        sharedpref.setloadMX(false);
        sharedpref.setloadNG(false);
        sharedpref.setloadPH(false);
        sharedpref.setloadRU(false);
        sharedpref.setloadKR(false);
        sharedpref.setloadTH(false);
        sharedpref.setloadTR(false);
        sharedpref.setloadUK(false);
        sharedpref.setloadUS(false);
        sharedpref.setloadVN(false);
        Toast.makeText(this, "Set Region to Japan", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    public void mexico(View v)
    {
        sharedpref.setloadWW(false);
        sharedpref.setloadBR(false);
        sharedpref.setloadCA(false);
        sharedpref.setloadEG(false);
        sharedpref.setloadFR(false);
        sharedpref.setloadDE(false);
        sharedpref.setloadIN(false);
        sharedpref.setloadID(false);
        sharedpref.setloadIT(false);
        sharedpref.setloadJP(false);
        sharedpref.setloadMX(true);
        sharedpref.setloadNG(false);
        sharedpref.setloadPH(false);
        sharedpref.setloadRU(false);
        sharedpref.setloadKR(false);
        sharedpref.setloadTH(false);
        sharedpref.setloadTR(false);
        sharedpref.setloadUK(false);
        sharedpref.setloadUS(false);
        sharedpref.setloadVN(false);
        Toast.makeText(this, "Set Region to Mexico", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    public void nigeria(View v)
    {
        sharedpref.setloadWW(false);
        sharedpref.setloadBR(false);
        sharedpref.setloadCA(false);
        sharedpref.setloadEG(false);
        sharedpref.setloadFR(false);
        sharedpref.setloadDE(false);
        sharedpref.setloadIN(false);
        sharedpref.setloadID(false);
        sharedpref.setloadIT(false);
        sharedpref.setloadJP(false);
        sharedpref.setloadMX(false);
        sharedpref.setloadNG(true);
        sharedpref.setloadPH(false);
        sharedpref.setloadRU(false);
        sharedpref.setloadKR(false);
        sharedpref.setloadTH(false);
        sharedpref.setloadTR(false);
        sharedpref.setloadUK(false);
        sharedpref.setloadUS(false);
        sharedpref.setloadVN(false);
        Toast.makeText(this, "Set Region to Nigeria", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    public void philiphines(View v)
    {
        sharedpref.setloadWW(false);
        sharedpref.setloadBR(false);
        sharedpref.setloadCA(false);
        sharedpref.setloadEG(false);
        sharedpref.setloadFR(false);
        sharedpref.setloadDE(false);
        sharedpref.setloadIN(false);
        sharedpref.setloadID(false);
        sharedpref.setloadIT(false);
        sharedpref.setloadJP(false);
        sharedpref.setloadMX(false);
        sharedpref.setloadNG(false);
        sharedpref.setloadPH(true);
        sharedpref.setloadRU(false);
        sharedpref.setloadKR(false);
        sharedpref.setloadTH(false);
        sharedpref.setloadTR(false);
        sharedpref.setloadUK(false);
        sharedpref.setloadUS(false);
        sharedpref.setloadVN(false);
        Toast.makeText(this, "Set Region to Philiphines", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    public void russia(View v)
    {
        sharedpref.setloadWW(false);
        sharedpref.setloadBR(false);
        sharedpref.setloadCA(false);
        sharedpref.setloadEG(false);
        sharedpref.setloadFR(false);
        sharedpref.setloadDE(false);
        sharedpref.setloadIN(false);
        sharedpref.setloadID(false);
        sharedpref.setloadIT(false);
        sharedpref.setloadJP(false);
        sharedpref.setloadMX(false);
        sharedpref.setloadNG(false);
        sharedpref.setloadPH(false);
        sharedpref.setloadRU(true);
        sharedpref.setloadKR(false);
        sharedpref.setloadTH(false);
        sharedpref.setloadTR(false);
        sharedpref.setloadUK(false);
        sharedpref.setloadUS(false);
        sharedpref.setloadVN(false);
        Toast.makeText(this, "Set Region to Russia", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    public void southkorea(View v)
    {
        sharedpref.setloadWW(false);
        sharedpref.setloadBR(false);
        sharedpref.setloadCA(false);
        sharedpref.setloadEG(false);
        sharedpref.setloadFR(false);
        sharedpref.setloadDE(false);
        sharedpref.setloadIN(false);
        sharedpref.setloadID(false);
        sharedpref.setloadIT(false);
        sharedpref.setloadJP(false);
        sharedpref.setloadMX(false);
        sharedpref.setloadNG(false);
        sharedpref.setloadPH(false);
        sharedpref.setloadRU(false);
        sharedpref.setloadKR(true);
        sharedpref.setloadTH(false);
        sharedpref.setloadTR(false);
        sharedpref.setloadUK(false);
        sharedpref.setloadUS(false);
        sharedpref.setloadVN(false);
        Toast.makeText(this, "Set Region to South Korea", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    public void thailand(View v)
    {
        sharedpref.setloadWW(false);
        sharedpref.setloadBR(false);
        sharedpref.setloadCA(false);
        sharedpref.setloadEG(false);
        sharedpref.setloadFR(false);
        sharedpref.setloadDE(false);
        sharedpref.setloadIN(false);
        sharedpref.setloadID(false);
        sharedpref.setloadIT(false);
        sharedpref.setloadJP(false);
        sharedpref.setloadMX(false);
        sharedpref.setloadNG(false);
        sharedpref.setloadPH(false);
        sharedpref.setloadRU(false);
        sharedpref.setloadKR(false);
        sharedpref.setloadTH(true);
        sharedpref.setloadTR(false);
        sharedpref.setloadUK(false);
        sharedpref.setloadUS(false);
        sharedpref.setloadVN(false);
        Toast.makeText(this, "Set Region to Thailand", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    public void turkey(View v)
    {
        sharedpref.setloadWW(false);
        sharedpref.setloadBR(false);
        sharedpref.setloadCA(false);
        sharedpref.setloadEG(false);
        sharedpref.setloadFR(false);
        sharedpref.setloadDE(false);
        sharedpref.setloadIN(false);
        sharedpref.setloadID(false);
        sharedpref.setloadIT(false);
        sharedpref.setloadJP(false);
        sharedpref.setloadMX(false);
        sharedpref.setloadNG(false);
        sharedpref.setloadPH(false);
        sharedpref.setloadRU(false);
        sharedpref.setloadKR(false);
        sharedpref.setloadTH(false);
        sharedpref.setloadTR(true);
        sharedpref.setloadUK(false);
        sharedpref.setloadUS(false);
        sharedpref.setloadVN(false);
        Toast.makeText(this, "Set Region to Turkey", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    public void unitedkingdom(View v)
    {
        sharedpref.setloadWW(false);
        sharedpref.setloadBR(false);
        sharedpref.setloadCA(false);
        sharedpref.setloadEG(false);
        sharedpref.setloadFR(false);
        sharedpref.setloadDE(false);
        sharedpref.setloadIN(false);
        sharedpref.setloadID(false);
        sharedpref.setloadIT(false);
        sharedpref.setloadJP(false);
        sharedpref.setloadMX(false);
        sharedpref.setloadNG(false);
        sharedpref.setloadPH(false);
        sharedpref.setloadRU(false);
        sharedpref.setloadKR(false);
        sharedpref.setloadTH(false);
        sharedpref.setloadTR(false);
        sharedpref.setloadUK(true);
        sharedpref.setloadUS(false);
        sharedpref.setloadVN(false);
        Toast.makeText(this, "Set Region to United Kingdom", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    public void unitedstates(View v)
    {
        sharedpref.setloadWW(false);
        sharedpref.setloadBR(false);
        sharedpref.setloadCA(false);
        sharedpref.setloadEG(false);
        sharedpref.setloadFR(false);
        sharedpref.setloadDE(false);
        sharedpref.setloadIN(false);
        sharedpref.setloadID(false);
        sharedpref.setloadIT(false);
        sharedpref.setloadJP(false);
        sharedpref.setloadMX(false);
        sharedpref.setloadNG(false);
        sharedpref.setloadPH(false);
        sharedpref.setloadRU(false);
        sharedpref.setloadKR(false);
        sharedpref.setloadTH(false);
        sharedpref.setloadTR(false);
        sharedpref.setloadUK(false);
        sharedpref.setloadUS(true);
        sharedpref.setloadVN(false);
        Toast.makeText(this, "Set Region to United States", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    public void vietnam(View v)
    {
        sharedpref.setloadWW(false);
        sharedpref.setloadBR(false);
        sharedpref.setloadCA(false);
        sharedpref.setloadEG(false);
        sharedpref.setloadFR(false);
        sharedpref.setloadDE(false);
        sharedpref.setloadIN(false);
        sharedpref.setloadID(false);
        sharedpref.setloadIT(false);
        sharedpref.setloadJP(false);
        sharedpref.setloadMX(false);
        sharedpref.setloadNG(false);
        sharedpref.setloadPH(false);
        sharedpref.setloadRU(false);
        sharedpref.setloadKR(false);
        sharedpref.setloadTH(false);
        sharedpref.setloadTR(false);
        sharedpref.setloadUK(false);
        sharedpref.setloadUS(false);
        sharedpref.setloadVN(true);
        Toast.makeText(this, "Set Region to Vietnam", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }


    @Override
    public boolean onSupportNavigateUp()
    {
        onBackPressed();
        return true;
    }

}
