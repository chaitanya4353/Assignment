package com.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                     // This method will be executed once the timer is over
                    startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                    // close this activity
                     overridePendingTransition(R.anim.enter, R.anim.exit);
                    finish();
            }
        }, SPLASH_TIME_OUT);

    }
}