package com.example.android.learngerman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class SignupActivity extends AppCompatActivity {
    TextView backBtn,signUp;;
    RelativeLayout emailEditText,passEditText;
    FloatingActionButton fb,insta,twitter,linkedin;
    float v = 0;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        fb = findViewById(R.id.fb_fab);
        insta = findViewById(R.id.insta_fab);
        twitter = findViewById(R.id.twitter_fab);
        linkedin = findViewById(R.id.linkedin_fab);


        emailEditText = findViewById(R.id.email_et);
        passEditText = findViewById(R.id.pass_et);
        signUp = findViewById(R.id.signUp_btn);
        backBtn = findViewById(R.id.back_btn);


        backBtn.setOnClickListener(v ->{
            onBackPressed();
        });

        startAnimation();



    }

    private void startAnimation(){
        //for animation
        fb.setTranslationY(300);
        insta.setTranslationY(300);
        twitter.setTranslationY(300);
        linkedin.setTranslationY(300);

        fb.setAlpha(v);
        insta.setAlpha(v);
        twitter.setAlpha(v);
        linkedin.setAlpha(v);


        fb.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(400).start();
        insta.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(600).start();
        twitter.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(800).start();
        linkedin.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(1000).start();



        //###########################################################################################


        emailEditText.setTranslationX(800);
        passEditText.setTranslationX(800);
        signUp.setTranslationX(800);
        backBtn.setTranslationX(800);

        emailEditText.setAlpha(v);
        passEditText.setAlpha(v);
        signUp.setAlpha(v);
        backBtn.setAlpha(v);

        emailEditText.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        passEditText.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(500).start();
        signUp.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(700).start();
        backBtn.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(800).start();
    }
}