package com.example.smartizen;

import com.plattysoft.leonids.ParticleSystem;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.TextView;

import java.util.Calendar;

public class AboutDev extends AppCompatActivity {
    Calendar born = Calendar.getInstance();
    Calendar today = Calendar.getInstance();
    int age2;

    Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_dev);
        Toolbar toolbar = findViewById(R.id.toolbarabout);
        setSupportActionBar(toolbar);

        TextView toolbarText = (TextView) findViewById(R.id.toolbar_text);
        toolbarText.setText("About Dev's");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        born.set(2001, Calendar.NOVEMBER, 14);
        TextView textView1 = (TextView)findViewById(R.id.tv1);
        int age = today.get(Calendar.YEAR) - born.get(Calendar.YEAR);
        if (today.get(Calendar.DAY_OF_YEAR) < born.get(Calendar.DAY_OF_YEAR))
        {
            age--;
        }
        age2 = new Integer(age);
        textView1.setText("Muhammad Zidan Khalil Gibran" + "\n" + "a.k.a" + "\n" + "M  2  K  6" + "\n\n" + age2 + " years old");
        if (today.get(Calendar.DAY_OF_MONTH) == born.get(Calendar.DAY_OF_MONTH))
        {
            if (today.get(Calendar.MONTH) == born.get(Calendar.MONTH))
            {
                TextView textView = (TextView) findViewById(R.id.tv);
                textView.setText("Today is Dev's Birthday");
                final View emitter = findViewById(R.id.emiter);
                ViewTreeObserver obs = emitter.getViewTreeObserver();
                obs.addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
                    @Override
                    public boolean onPreDraw() {
                        new ParticleSystem(AboutDev.this, 8, R.drawable.animated_confetti, 9999)
                                .setSpeedModuleAndAngleRange(0f, 0.2f, 0, 180)
                                .setRotationSpeed(144)
                                .setAcceleration(0.000099f, 90)
                                .oneShot(emitter, 1);
                        return true;
                    }
                });
            }
        }
    }

    @Override
    public boolean onSupportNavigateUp()
    {
        onBackPressed();
        return true;
    }

    public void wa (View view)
    {
        Calendar born = Calendar.getInstance();
        Calendar today = Calendar.getInstance();
        born.set(2001, Calendar.NOVEMBER, 14);
        if (today.get(Calendar.DAY_OF_MONTH) == born.get(Calendar.DAY_OF_MONTH))
        {
            uri = Uri.parse("https://wa.me/6289609499004?text=Hello%20Gibran!%20Happy%20"+age2+"%20Birthday!");
        }
        else
        {
            uri = Uri.parse("https://wa.me/6289609499004?text=Hello%20Gibran!");
        }
        Intent it = new Intent (Intent.ACTION_VIEW, uri);
        startActivity(it);
    }

    public void ig (View view)
    {
        uri = Uri.parse("http://instagram.com/_u/m2k6.artworks");
        Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);

        likeIng.setPackage("com.instagram.android");

        try
        {
            startActivity(likeIng);
        }
        catch (ActivityNotFoundException e)
        {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/_u/m2k6.artworks")));
        }
    }

    public void email (View view)
    {
        Calendar born = Calendar.getInstance();
        Calendar today = Calendar.getInstance();
        born.set(2001, Calendar.NOVEMBER, 14);
        Intent intent = new Intent(Intent.ACTION_SEND);
        String[] recipients={"zidangibran14@gmail.com"};
        intent.putExtra(Intent.EXTRA_EMAIL, recipients);
        intent.putExtra(Intent.EXTRA_SUBJECT,"Greetings");
        if (today.get(Calendar.DAY_OF_MONTH) == born.get(Calendar.DAY_OF_MONTH))
        {
            intent.putExtra(Intent.EXTRA_TEXT, "Hello Gibran! <br> Happy "+ age2 +" Birthday!");
        }
        else
        {
            intent.putExtra(Intent.EXTRA_TEXT, "Hello Gibran!");
        }
        intent.setType("text/html");
        intent.setPackage("com.google.android.gm");
        startActivity(Intent.createChooser(intent, "Send mail"));
    }
}
