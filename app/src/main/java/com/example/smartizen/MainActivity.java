package com.example.smartizen;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private long backPressedTime;
    private Toast backToast;
    private TabAdapter tabAdapter;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private Toolbar toolbar;
    boolean code = false;
    SharedPref sharedpref;
    private int[] tabIcon =
    {
        R.drawable.ic_google,
        R.drawable.ic_youtube,
        R.drawable.ic_twitter,
        R.drawable.ic_tbhid,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.main_toolbar);
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
        TextView toolbarText = (TextView) findViewById(R.id.toolbar_text);
        toolbarText.setText("Smartyzen");
        setSupportActionBar(toolbar);

        tabAdapter = new TabAdapter(getSupportFragmentManager());
        tabAdapter.addFragment(new GoogleFragment(), "Google");
        tabAdapter.addFragment(new YoutubeFragment(), "Youtube");
        tabAdapter.addFragment(new TwitterFragment(), "Twitter");
        tabAdapter.addFragment(new AntiHoaxFragment(), "Anti Hoax");
        viewPager.setAdapter(tabAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(tabIcon[0]);
        tabLayout.getTabAt(1).setIcon(tabIcon[1]);
        tabLayout.getTabAt(2).setIcon(tabIcon[2]);
        tabLayout.getTabAt(3).setIcon(tabIcon[3]);
    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();
        if (id==R.id.menu_theme)
        {
            Intent intent = new Intent(this, ThemeSet.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
        if (id==R.id.menu_region)
        {
            Intent intent = new Intent(this, RegionSet.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
        if (id==R.id.menu_about)
        {
            Intent intent = new Intent(this, AboutDev.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
        if (id==R.id.exit)
        {
            Toast.makeText(this, "Stay Smartyzen! C Ya Later.. ", Toast.LENGTH_SHORT).show();
            finishAndRemoveTask();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed()
    {
        if (backPressedTime + 2000 > System.currentTimeMillis())
        {
            backToast.cancel();
            super.onBackPressed();
            return;
        }
        else
        {
            backToast = Toast.makeText(getBaseContext(), "Press Back again to Exit", Toast.LENGTH_SHORT);
            backToast.show();
        }

        backPressedTime = System.currentTimeMillis();
    }
}
