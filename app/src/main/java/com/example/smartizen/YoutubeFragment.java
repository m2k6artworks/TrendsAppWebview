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
public class YoutubeFragment extends Fragment
{
    public WebView wv;
    private ProgressBar progressBar;
    private FrameLayout frameBar;
    private SwipeRefreshLayout swipe;
    SharedPref sharedpref;

    public YoutubeFragment() {
        // Required empty public constructor
    }

    @SuppressLint("RestrictedApi")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_youtube, container, false);
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
        swipe.setColorSchemeColors(Color.rgb(255, 0, 0));
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
            wv.loadUrl("https://www.youtube.com/playlist?list=PLrEnWoR732-BHrPp_Pm8_VleD68f9s14-");
        }
        else if (sharedpref.loadBR()==true)
        {
            wv.loadUrl("https://www.youtube.com/feed/trending?gl=BR&hl=br");
        }
        else if (sharedpref.loadCA()==true)
        {
            wv.loadUrl("https://www.youtube.com/feed/trending?gl=CA&hl=ca");
        }
        else if (sharedpref.loadEG()==true)
        {
            wv.loadUrl("https://www.youtube.com/feed/trending?gl=EG&hl=eg");
        }
        else if (sharedpref.loadFR()==true)
        {
            wv.loadUrl("https://www.youtube.com/feed/trending?gl=FR&hl=fr");
        }
        else if (sharedpref.loadDE()==true)
        {
            wv.loadUrl("https://www.youtube.com/feed/trending?gl=DE&hl=de");
        }
        else if (sharedpref.loadIN()==true)
        {
            wv.loadUrl("https://www.youtube.com/feed/trending?gl=IN&hl=in");
        }
        else if (sharedpref.loadID()==true)
        {
            wv.loadUrl("https://www.youtube.com/feed/trending?gl=ID&hl=id");
        }
        else if (sharedpref.loadIT()==true)
        {
            wv.loadUrl("https://www.youtube.com/feed/trending?gl=IT&hl=it");
        }
        else if (sharedpref.loadJP()==true)
        {
            wv.loadUrl("https://www.youtube.com/feed/trending?gl=JP&hl=jp");
        }
        else if (sharedpref.loadMX()==true)
        {
            wv.loadUrl("https://www.youtube.com/feed/trending?gl=MX&hl=mx");
        }
        else if (sharedpref.loadNG()==true)
        {
            wv.loadUrl("https://www.youtube.com/feed/trending?gl=NG&hl=ng");
        }
        else if (sharedpref.loadPH()==true)
        {
            wv.loadUrl("https://www.youtube.com/feed/trending?gl=PH&hl=ph");
        }
        else if (sharedpref.loadRU()==true)
        {
            wv.loadUrl("https://www.youtube.com/feed/trending?gl=RU&hl=ru");
        }
        else if (sharedpref.loadKR()==true)
        {
            wv.loadUrl("https://www.youtube.com/feed/trending?gl=KR&hl=kr");
        }
        else if (sharedpref.loadTH()==true)
        {
            wv.loadUrl("https://www.youtube.com/feed/trending?gl=TH&hl=th");
        }
        else if (sharedpref.loadTR()==true)
        {
            wv.loadUrl("https://www.youtube.com/feed/trending?gl=TR&hl=tr");
        }
        else if (sharedpref.loadUK()==true)
        {
            wv.loadUrl("https://www.youtube.com/feed/trending?gl=GB&hl=gb");
        }
        else if (sharedpref.loadUS()==true)
        {
            wv.loadUrl("https://www.youtube.com/feed/trending?gl=US&hl=us");
        }
        else if (sharedpref.loadVN()==true)
        {
            wv.loadUrl("https://www.youtube.com/feed/trending?gl=VN&hl=vn");
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
