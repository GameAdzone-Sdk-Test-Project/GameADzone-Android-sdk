package com.example.androiddemo;

import android.app.Activity;
import android.os.Bundle;

import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
//import com.gamead
import com.sdk.gameadzone.*;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.Gravity;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Activity activity =null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        GameADzone.InitializeSDK(this,"YX11DX89WQLVT1T");
        MobileAds.initialize(this,"ca-app-pub-3940256099942544~3347511713");
//         MobileAds.initialize(​this​, ​"ca-app-pub-3940256099942544~3347511713"​);

        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        activity=this;

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setGravity(Gravity.CENTER);





        Button showBannerAD =new Button(getApplicationContext());
        showBannerAD.setText("Show Banner Ad");

        showBannerAD.setLayoutParams(new LinearLayout.LayoutParams
                (LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.MATCH_PARENT));

        layout.addView(showBannerAD);

        showBannerAD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getBaseContext(),"Clicked",Toast.LENGTH_SHORT).show();
                LinearLayout bannerLayout = new LinearLayout(getApplicationContext());
                bannerLayout.setLayoutParams(new LinearLayout.LayoutParams
                        (LinearLayout.LayoutParams.WRAP_CONTENT,
                                LinearLayout.LayoutParams.MATCH_PARENT));
               if(GameADzoneBanner.isLoaded())
               {
                   bannerLayout.addView(GameADzoneBanner.showView());   //how to add banner ad into your layout
               }

                layout.addView(bannerLayout);
            }
        });


        Button showInterstitial=new Button(getApplicationContext());
        showInterstitial.setText("Show Interstitial Ad");
        showInterstitial.setLayoutParams(new LinearLayout.LayoutParams
                (LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.MATCH_PARENT));
        layout.addView(showInterstitial);

        showInterstitial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getBaseContext(),"Clicked",Toast.LENGTH_SHORT).show();
                if(GameADzoneInterstitialAd.isLoaded())
                {
                    GameADzoneInterstitialAd.Show();

                }


            }
        });


        GameADzoneInterstitialAdListener.setInterstitialListener(new GameADzoneInterstitialAdListener.InterstitialListener() {
            @Override
            public void onInterstitialAdLoaded() {
                Log.v("GameAdzoneInterstitial","onInterstitialAdLoaded");
            }

            @Override
            public void onInterstitialFailedToLoad(int i) {
                Log.v("GameAdzoneInterstitial","onInterstitialFailedToLoad");
            }

            @Override
            public void onInterstitialAdOpened() {
                Log.v("GameAdzoneInterstitial","onInterstitialAdOpened");
            }

            @Override
            public void onInterstitialAdClosed() {
                Log.v("GameAdzoneInterstitial","onInterstitialAdClosed");
            }
        });

        Button showRectangleBanner=new Button(getApplicationContext());
        showRectangleBanner.setText("Show Rect Banner Ad");
        showRectangleBanner.setLayoutParams(new LinearLayout.LayoutParams
                (LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.MATCH_PARENT));
        layout.addView(showRectangleBanner);
        showRectangleBanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getBaseContext(),"Clicked",Toast.LENGTH_SHORT).show();
                LinearLayout rectBannerLayout = new LinearLayout(getApplicationContext());
                rectBannerLayout.setLayoutParams(new LinearLayout.LayoutParams
                        (LinearLayout.LayoutParams.WRAP_CONTENT,
                                LinearLayout.LayoutParams.MATCH_PARENT));
                if(GameADzoneRectangle.isLoaded())
                {

                    rectBannerLayout.addView(GameADzoneRectangle.loadView());

                }
                layout.addView(rectBannerLayout);


            }
        });



        Button moreApps=new Button(getApplicationContext());
        moreApps.setText("Show More Apps");

        moreApps.setLayoutParams(new LinearLayout.LayoutParams
                (LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.MATCH_PARENT));
        layout.addView(moreApps);
        moreApps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getBaseContext(),"Clicked",Toast.LENGTH_SHORT).show();
                GameADzoneMoreApp.Show();
            }
        });


        Button iconAd=new Button(getApplicationContext());
        iconAd.setText("Show IconAD");
        iconAd.setLayoutParams(new LinearLayout.LayoutParams
                (LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.MATCH_PARENT));
        layout.addView(iconAd);
        iconAd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getBaseContext(),"Clicked",Toast.LENGTH_SHORT).show();
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT,
                        FrameLayout.LayoutParams.WRAP_CONTENT);
                layoutParams.leftMargin = 100;
                layoutParams.topMargin = 100;
                layoutParams.width = 200;
                layoutParams.height = 200;
                layoutParams.gravity = Gravity.TOP | Gravity.LEFT;


                if(GameADzoneIconAd.isLoaded())
                {
                    layout.addView(GameADzoneIconAd.loadView(),layoutParams);

                }
            }
        });

        Button overlayAd=new Button(getApplicationContext());
        overlayAd.setText("Show Overlay Ad");

        Button b7=new Button(getApplicationContext());
        b7.setText("Hide BannerAd");

        Button b8=new Button(getApplicationContext());
        b8.setText("Hide RectBanner Ad");




        layout.setLayoutParams(new LinearLayout.LayoutParams
                (LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT));








        overlayAd.setLayoutParams(new LinearLayout.LayoutParams
                (LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.MATCH_PARENT));
        layout.addView(overlayAd);
        overlayAd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getBaseContext(),"Clicked",Toast.LENGTH_SHORT).show();
               if(GameADzoneOverlayAd.isLoaded())
               {
                   GameADzoneOverlayAd.Show();
               }

            }
        });
        b7.setLayoutParams(new LinearLayout.LayoutParams
                (LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.MATCH_PARENT));
        b8.setLayoutParams(new LinearLayout.LayoutParams
                (LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.MATCH_PARENT));











        layout.addView(b7);
        layout.addView(b8);

        setContentView(layout);







        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getBaseContext(),"Clicked",Toast.LENGTH_SHORT).show();
                GameADzoneBanner.Hidden();
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getBaseContext(),"Clicked",Toast.LENGTH_SHORT).show();
                GameADzoneRectangle.Hidden();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}