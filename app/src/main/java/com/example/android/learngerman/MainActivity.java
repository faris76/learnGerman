package com.example.android.learngerman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView logo,subLogo;
    Animation top,bottom;
    public final int SPLASH_SCREEN_WAIT_TIME = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

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
                Intent i = new Intent(MainActivity.this,HomeActivity.class);
                finish();
                startActivity(i);
            }
        }, SPLASH_SCREEN_WAIT_TIME);
    }
}