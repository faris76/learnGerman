package com.example.android.learngerman;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity extends AppCompatActivity {


    private View decorView;
    ImageButton logoutBtn;
    RelativeLayout greetings, numbers, family, phrases;
    Button greetingButton;
    float v = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_home);

        //to remove navigation bar
        decorView = getWindow().getDecorView();
        decorView.setOnSystemUiVisibilityChangeListener(visibility -> {
            if (visibility == 0)
                decorView.setSystemUiVisibility(hideSystemBars());
        });

        logoutBtn = findViewById(R.id.logout_btn);
        greetings = findViewById(R.id.greetingsTab);
        numbers = findViewById(R.id.numbersTab);
        family = findViewById(R.id.familyTab);
        phrases = findViewById(R.id.phrasesTab);

        greetingButton = findViewById(R.id.greetings_btn);


        logoutBtn.setOnClickListener(v -> {
            logoutUser();
        });

        greetingButton.setOnClickListener(v ->{
            startActivity(new Intent(this,Greetings.class));
        });

        startAnimation();
    }


    private void logoutUser() {
        FirebaseAuth.getInstance().signOut();
        finish();
        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
    }


    private void startAnimation() {
        greetings.setTranslationX(800);
        numbers.setTranslationX(800);
        family.setTranslationX(800);
        phrases.setTranslationX(800);

        greetings.setAlpha(v);
        numbers.setAlpha(v);
        family.setAlpha(v);
        phrases.setAlpha(v);

        greetings.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        numbers.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(500).start();
        family.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(700).start();
        phrases.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(800).start();
    }


    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            decorView.setSystemUiVisibility(hideSystemBars());
        }
    }

    private int hideSystemBars() {
        return View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
    }
}