package com.example.android.learngerman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class LoginActivity extends AppCompatActivity {
    TextView forgotPassword,login,signUp;
    RelativeLayout emailEditText,passEditText;
    FloatingActionButton fb,insta,twitter,linkedin;
    float v = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        fb = findViewById(R.id.fb_fab);
        insta = findViewById(R.id.insta_fab);
        twitter = findViewById(R.id.twitter_fab);
        linkedin = findViewById(R.id.linkedin_fab);

        forgotPassword = findViewById(R.id.forgot_pass);
        login = findViewById(R.id.login_btn);
        emailEditText = findViewById(R.id.email_et);
        passEditText = findViewById(R.id.pass_et);
        signUp = findViewById(R.id.signUp);


        // Click Listeners
        signUp.setOnClickListener(v ->{
            startActivity(new Intent(this,SignupActivity.class));
        });

        startAnimation();
    }

    private void startAnimation(){
        //for animation
        fb.setTranslationY(300);
        insta.setTranslationY(300);
        twitter.setTranslationY(300);
        linkedin.setTranslationY(300);
        signUp.setTranslationY(300);

        fb.setAlpha(v);
        insta.setAlpha(v);
        twitter.setAlpha(v);
        linkedin.setAlpha(v);
        signUp.setAlpha(v);


        fb.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(400).start();
        insta.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(600).start();
        twitter.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(800).start();
        linkedin.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(1000).start();
        signUp.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(1000).start();



        //###########################################################################################

        forgotPassword.setTranslationX(800);
        login.setTranslationX(800);
        emailEditText.setTranslationX(800);
        passEditText.setTranslationX(800);


        forgotPassword.setAlpha(v);
        login.setAlpha(v);
        emailEditText.setAlpha(v);
        passEditText.setAlpha(v);


        emailEditText.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        passEditText.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(500).start();
        forgotPassword.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(500).start();
        login.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(800).start();

    }
}