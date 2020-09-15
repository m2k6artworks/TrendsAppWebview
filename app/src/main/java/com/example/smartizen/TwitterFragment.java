package com.example.smartizen;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ProgressBar;


/**
 * A simple {@link Fragment} subclass.
 */
public class TwitterFragment extends Fragment
{

    public WebView wv;
    private ProgressBar progressBar;
    private FrameLayout frameBar;
    private SwipeRefreshLayout swipe;
    SharedPref sharedpref;


    public TwitterFragment() {
        // Required empty public constructor
    }

    @SuppressLint("RestrictedApi")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_twitter, container, false);
        final FloatingActionButton floatingActionButton = v.findViewById(R.id.fab);
        floatingActionButton.setAlpha(0.75f);
        floatingActionButton.setOnClickListener(new View.OnClickListener()
        {
            @SuppressLint("RestrictedApi")
            @Override
            public void onClick(View view)
            {
                String url = wv.getUrl();
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
                shareIntent.putExtra(Intent.EXTRA_TEXT, "Check this out!" + "\n" + "I got this info from Smartyzen App." + "\n\n" + url); // your above url
                startActivity(Intent.createChooser(shareIntent, "Share recent page link.."));
                floatingActionButton.setVisibility(View.VISIBLE);
            }
        });
        swipe = (SwipeRefreshLayout) v.findViewById(R.id.swipe);
        swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener()
        {
            @Override
            public void onRefresh()
            {
                wv.reload();
            }

        });
        swipe.setColorSchemeColors(Color.rgb(79, 195, 247));
        int mode = getContext().getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;
        if (mode == Configuration.UI_MODE_NIGHT_YES)
        {
            swipe.setProgressBackgroundColorSchemeColor(Color.rgb(53,53,53));
        }
        else if (mode == Configuration.UI_MODE_NIGHT_NO)
        {
            swipe.setProgressBackgroundColorSchemeColor(Color.rgb(241,241,241));
        }
        frameBar = (FrameLayout) v.findViewById(R.id.frameBar);
        progressBar = (ProgressBar) v.findViewById(R.id.progressBar);
        progressBar.setMax(100);
        wv = (WebView) v.findViewById(R.id.wv);
        WebSettings settings = wv.getSettings();
        settings.setAppCacheEnabled(true);
        settings.setJavaScriptEnabled(true);
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(false);
        settings.setLoadsImagesAutomatically(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setCacheMode( WebSettings.LOAD_DEFAULT);
        wv.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        wv.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        settings.setDomStorageEnabled(true);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        settings.setUseWideViewPort(true);
        settings.setSavePassword(true);
        settings.setSaveFormData(true);
        settings.setEnableSmoothTransition(true);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
            settings.setSafeBrowsingEnabled(true);
        }
        settings.setMediaPlaybackRequiresUserGesture(true);
        wv.setWebChromeClient(new WebChromeClient()
                              {
                                  public void  onProgressChanged(WebView view, int progress)
                                  {
                                      frameBar.setVisibility(View.VISIBLE);
                                      progressBar.setProgress(progress);

                                      if (progress == 100)
                                      {
                                          frameBar.setVisibility(View.GONE);
                                      }
                                      super.onProgressChanged(view, progress);
                                  }
                              }
        );
        wv.canGoBack();
        wv.goBack();
        wv.setWebViewClient(new WebViewClient()
        {
            @SuppressLint("RestrictedApi")
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl)
            {
                wv.loadUrl("file:///android_asset/error.html");
                wv.getSettings().setBuiltInZoomControls(false);
                floatingActionButton.setVisibility(View.GONE);

                swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh()
                    {
                        String url2 = wv.getUrl();
                        if (url2=="file:///android_asset/error.html")
                        {
                            wv.goBack();
                        }
                        else
                        {
                            wv.reload();
                        }

                    }
                });
            }

            public void onPageFinished(WebView view, String url)
            {
                swipe.setRefreshing(false);
            }

        });
        floatingActionButton.setVisibility(View.VISIBLE);
        sharedpref = new SharedPref(getContext());
        if (sharedpref.loadWW()==true)
        {
            wv.loadUrl("https://getdaytrends.com/");
        }
        else if (sharedpref.loadBR()==true)
        {
            wv.loadUrl("https://getdaytrends.com/brazil/");
        }
        else if (sharedpref.loadCA()==true)
        {
            wv.loadUrl("https://getdaytrends.com/canada/");
        }
        else if (sharedpref.loadEG()==true)
        {
            wv.loadUrl("https://getdaytrends.com/egypt/");
        }
        else if (sharedpref.loadFR()==true)
        {
            wv.loadUrl("https://getdaytrends.com/france/");
        }
        else if (sharedpref.loadDE()==true)
        {
            wv.loadUrl("https://getdaytrends.com/germany/");
        }
        else if (sharedpref.loadIN()==true)
        {
            wv.loadUrl("https://getdaytrends.com/india/");
        }
        else if (sharedpref.loadID()==true)
        {
            wv.loadUrl("https://getdaytrends.com/indonesia/");
        }
        else if (sharedpref.loadIT()==true)
        {
            wv.loadUrl("https://getdaytrends.com/italy/");
        }
        else if (sharedpref.loadJP()==true)
        {
            wv.loadUrl("https://getdaytrends.com/japan/");
        }
        else if (sharedpref.loadMX()==true)
        {
            wv.loadUrl("https://getdaytrends.com/mexico/");
        }
        else if (sharedpref.loadNG()==true)
        {
            wv.loadUrl("https://getdaytrends.com/nigeria/");
        }
        else if (sharedpref.loadPH()==true)
        {
            wv.loadUrl("https://getdaytrends.com/philippines/");
        }
        else if (sharedpref.loadRU()==true)
        {
            wv.loadUrl("https://getdaytrends.com/russia/");
        }
        else if (sharedpref.loadKR()==true)
        {
            wv.loadUrl("https://getdaytrends.com/korea/");
        }
        else if (sharedpref.loadTH()==true)
        {
            wv.loadUrl("https://getdaytrends.com/thailand/");
        }
        else if (sharedpref.loadTR()==true)
        {
            wv.loadUrl("https://getdaytrends.com/turkey/");
        }
        else if (sharedpref.loadUK()==true)
        {
            wv.loadUrl("https://getdaytrends.com/united-kingdom/");
        }
        else if (sharedpref.loadUS()==true)
        {
            wv.loadUrl("https://getdaytrends.com/united-states/");
        }
        else if (sharedpref.loadVN()==true)
        {
            wv.loadUrl("https://getdaytrends.com/vietnam/");
        }
        progressBar.setProgress(0);

        wv.setOnKeyListener(new View.OnKeyListener()
        {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event)
            {
                if (event.getAction() == KeyEvent.ACTION_DOWN)
                {
                    WebView wv = (WebView) v;
                    switch (keyCode)
                    {
                        case KeyEvent.KEYCODE_BACK:
                            if (wv.canGoBack())
                            {
                                wv.goBack();
                                return true;
                            }
                            break;
                    }
                }
                return false;
            }
        });
        return v;
    }
}
