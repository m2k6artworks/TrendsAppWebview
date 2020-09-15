package com.example.smartizen;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPref
{
    private SharedPreferences mySharedPref, mySharedPref2;

    public SharedPref(Context context)
    {
        mySharedPref = context.getSharedPreferences("temasmarty", Context.MODE_PRIVATE);
        mySharedPref2 = context.getSharedPreferences("regionsmarty", Context.MODE_PRIVATE);
    }

    //set & get region with boolean state
    public  void setloadWW(Boolean state)
    {
        SharedPreferences.Editor editor = mySharedPref2.edit();
        editor.putBoolean("Worldwide",state);
        editor.commit();
    }

    public Boolean loadWW()
    {
        Boolean state = mySharedPref2.getBoolean("Worldwide",true);
        return state;
    }

    public  void setloadBR(Boolean state)
    {
        SharedPreferences.Editor editor = mySharedPref2.edit();
        editor.putBoolean("Brazil",state);
        editor.commit();
    }

    public Boolean loadBR()
    {
        Boolean state = mySharedPref2.getBoolean("Brazil",false);
        return state;
    }

    public  void setloadCA(Boolean state)
{
    SharedPreferences.Editor editor = mySharedPref2.edit();
    editor.putBoolean("Canada",state);
    editor.commit();
}

    public Boolean loadCA()
    {
        Boolean state = mySharedPref2.getBoolean("Canada",false);
        return state;
    }

    public  void setloadEG(Boolean state)
    {
        SharedPreferences.Editor editor = mySharedPref2.edit();
        editor.putBoolean("Egypt",state);
        editor.commit();
    }

    public Boolean loadEG()
    {
        Boolean state = mySharedPref2.getBoolean("Egypt",false);
        return state;
    }

    public  void setloadFR(Boolean state)
    {
        SharedPreferences.Editor editor = mySharedPref2.edit();
        editor.putBoolean("France",state);
        editor.commit();
    }

    public Boolean loadFR()
    {
        Boolean state = mySharedPref2.getBoolean("France",false);
        return state;
    }

    public  void setloadDE(Boolean state)
    {
        SharedPreferences.Editor editor = mySharedPref2.edit();
        editor.putBoolean("Germany",state);
        editor.commit();
    }

    public Boolean loadDE()
    {
        Boolean state = mySharedPref2.getBoolean("Germany",false);
        return state;
    }

    public  void setloadIN(Boolean state)
    {
        SharedPreferences.Editor editor = mySharedPref2.edit();
        editor.putBoolean("India",state);
        editor.commit();
    }

    public Boolean loadIN()
    {
        Boolean state = mySharedPref2.getBoolean("India",false);
        return state;
    }

    public  void setloadID(Boolean state)
    {
        SharedPreferences.Editor editor = mySharedPref2.edit();
        editor.putBoolean("Indonesia",state);
        editor.commit();
    }

    public Boolean loadID()
    {
        Boolean state = mySharedPref2.getBoolean("Indonesia",false);
        return state;
    }

    public  void setloadIT(Boolean state)
    {
        SharedPreferences.Editor editor = mySharedPref2.edit();
        editor.putBoolean("Italy",state);
        editor.commit();
    }

    public Boolean loadIT()
    {
        Boolean state = mySharedPref2.getBoolean("Italy",false);
        return state;
    }

    public  void setloadJP(Boolean state)
    {
        SharedPreferences.Editor editor = mySharedPref2.edit();
        editor.putBoolean("Japan",state);
        editor.commit();
    }

    public Boolean loadJP()
    {
        Boolean state = mySharedPref2.getBoolean("Japan",false);
        return state;
    }

    public  void setloadMX(Boolean state)
    {
        SharedPreferences.Editor editor = mySharedPref2.edit();
        editor.putBoolean("Mexico",state);
        editor.commit();
    }

    public Boolean loadMX()
    {
        Boolean state = mySharedPref2.getBoolean("Mexico",false);
        return state;
    }

    public  void setloadNG(Boolean state)
    {
        SharedPreferences.Editor editor = mySharedPref2.edit();
        editor.putBoolean("Nigeria",state);
        editor.commit();
    }

    public Boolean loadNG()
    {
        Boolean state = mySharedPref2.getBoolean("Nigeria",false);
        return state;
    }

    public  void setloadPH(Boolean state)
    {
        SharedPreferences.Editor editor = mySharedPref2.edit();
        editor.putBoolean("Philiphines",state);
        editor.commit();
    }

    public Boolean loadPH()
    {
        Boolean state = mySharedPref2.getBoolean("Philiphines",false);
        return state;
    }

    public  void setloadRU(Boolean state)
    {
        SharedPreferences.Editor editor = mySharedPref2.edit();
        editor.putBoolean("Russia",state);
        editor.commit();
    }

    public Boolean loadRU()
    {
        Boolean state = mySharedPref2.getBoolean("Russia",false);
        return state;
    }

    public  void setloadKR(Boolean state)
    {
        SharedPreferences.Editor editor = mySharedPref2.edit();
        editor.putBoolean("Korea",state);
        editor.commit();
    }

    public Boolean loadKR()
    {
        Boolean state = mySharedPref2.getBoolean("Korea",false);
        return state;
    }

    public  void setloadTH(Boolean state)
    {
        SharedPreferences.Editor editor = mySharedPref2.edit();
        editor.putBoolean("Thailand",state);
        editor.commit();
    }

    public Boolean loadTH()
    {
        Boolean state = mySharedPref2.getBoolean("Thailand",false);
        return state;
    }

    public  void setloadTR(Boolean state)
    {
        SharedPreferences.Editor editor = mySharedPref2.edit();
        editor.putBoolean("Turkey",state);
        editor.commit();
    }

    public Boolean loadTR()
    {
        Boolean state = mySharedPref2.getBoolean("Turkey",false);
        return state;
    }

    public  void setloadUK(Boolean state)
    {
        SharedPreferences.Editor editor = mySharedPref2.edit();
        editor.putBoolean("United Kingdom",state);
        editor.commit();
    }

    public Boolean loadUK()
    {
        Boolean state = mySharedPref2.getBoolean("United Kingdom",false);
        return state;
    }

    public  void setloadUS(Boolean state)
    {
        SharedPreferences.Editor editor = mySharedPref2.edit();
        editor.putBoolean("United States",state);
        editor.commit();
    }

    public Boolean loadUS()
    {
        Boolean state = mySharedPref2.getBoolean("United States",false);
        return state;
    }

    public  void setloadVN(Boolean state)
    {
        SharedPreferences.Editor editor = mySharedPref2.edit();
        editor.putBoolean("Vietnam",state);
        editor.commit();
    }

    public Boolean loadVN()
    {
        Boolean state = mySharedPref2.getBoolean("Vietnam",false);
        return state;
    }
    //end of set region


    //set & get theme with boolean state
    public  void setloadLM(Boolean state)
    {
        SharedPreferences.Editor editor = mySharedPref.edit();
        editor.putBoolean("LightMode",state);
        editor.commit();
    }

    public Boolean loadLM()
    {
        Boolean state = mySharedPref.getBoolean("LightMode",false);
        return state;
    }


    public  void setloadDM(Boolean state)
    {
        SharedPreferences.Editor editor = mySharedPref.edit();
        editor.putBoolean("DarkMode",state);
        editor.commit();
    }

    public Boolean loadDM()
    {
        Boolean state = mySharedPref.getBoolean("DarkMode",false);
        return state;
    }


    public  void setloadAM(Boolean state)
    {
        SharedPreferences.Editor editor = mySharedPref.edit();
        editor.putBoolean("AutoMode",state);
        editor.commit();
    }

    public Boolean loadAM()
    {
        Boolean state = mySharedPref.getBoolean("AutoMode",true);
        return state;
    }


    public  void setloadTM(Boolean state)
    {
        SharedPreferences.Editor editor = mySharedPref.edit();
        editor.putBoolean("TimeMode",state);
        editor.commit();
    }

    public Boolean loadTM()
    {
        Boolean state = mySharedPref.getBoolean("TimeMode",false);
        return state;
    }
    //end of set region
}
