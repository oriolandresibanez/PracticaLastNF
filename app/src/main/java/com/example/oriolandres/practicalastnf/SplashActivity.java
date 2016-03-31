package com.example.oriolandres.practicalastnf;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;



public class SplashActivity extends AppCompatActivity {


    private final int SPLASH_DISPLAY_LENGTH = 2000;


    @Override
    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_splash);



        Handler hnd = new Handler();
        hnd.postDelayed(new Runnable(){

            @Override
            public void run() {

                Intent mainIntent = new Intent(SplashActivity.this, MainActivity.class);
                SplashActivity.this.startActivity(mainIntent);
                SplashActivity.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}
