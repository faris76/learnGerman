package com.example.android.learngerman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView logo,subLogo;
    Animation top,bottom;
    public final int SPLASH_SCREEN_WAIT_TIME = 3000;
    private View decorView;

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus){
            decorView.setSystemUiVisibility(hideSystemBars());
        }
    }

    private int hideSystemBars(){
        return View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //to remove navigation bar
        decorView = getWindow().getDecorView();
        decorView.setOnSystemUiVisibilityChangeListener(visibility -> {
            if (visibility == 0)
                decorView.setSystemUiVisibility(hideSystemBars());
        });

        //initializing
        logo = findViewById(R.id.logo);
        subLogo = findViewById(R.id.subLogo);
        top = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.main_logo_animation);
        bottom = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.sub_logo_animation);

        //Setting Animation
        logo.setAnimation(top);
        subLogo.setAnimation(bottom);

        //For Splash Screen
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(MainActivity.this,LoginActivity.class);
                finish();
                startActivity(i);
            }
        }, SPLASH_SCREEN_WAIT_TIME);
    }
}