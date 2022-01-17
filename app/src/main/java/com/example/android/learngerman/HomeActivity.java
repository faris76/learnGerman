package com.example.android.learngerman;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity extends AppCompatActivity {


    private View decorView;
    ImageButton logoutBtn;
    RelativeLayout greetings, numbers, family, days;
    Button greetingButton,numbersButton,familyButton,daysButton,bodyPartsButton
            , vegetablesButton ,fruitsButton,groceriesButton,clothesButton
            ,homeAppliancesButton,furnitureButton,phrasesButton;
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
        days = findViewById(R.id.daysAndMonthsTab);

        greetingButton = findViewById(R.id.greetings_btn);
        numbersButton = findViewById(R.id.numbers_btn);
        familyButton = findViewById(R.id.family_btn);
        daysButton = findViewById(R.id.days_btn);
        bodyPartsButton = findViewById(R.id.bodyParts_btn);
        vegetablesButton = findViewById(R.id.vegetable_btn);
        fruitsButton = findViewById(R.id.fruits_btn);
        groceriesButton = findViewById(R.id.grocery_btn);
        clothesButton= findViewById(R.id.clothes_btn);
        homeAppliancesButton= findViewById(R.id.homeAppliances_btn);
        furnitureButton = findViewById(R.id.furniture_btn);
        phrasesButton= findViewById(R.id.phrases_btn);


        logoutBtn.setOnClickListener(v -> logoutUser());

        greetingButton.setOnClickListener(v -> startActivity(new Intent(this,Greetings.class)));

        numbersButton.setOnClickListener(v -> startActivity(new Intent(this,Numbers.class)));

        familyButton.setOnClickListener(v -> startActivity(new Intent(this,Family.class)));

        daysButton.setOnClickListener(v -> startActivity(new Intent(this,DaysAndMonths.class)));

        bodyPartsButton.setOnClickListener(v -> startActivity(new Intent(this,BodyParts.class)));

        vegetablesButton.setOnClickListener(v -> startActivity(new Intent(this,Vegetables.class)));

        fruitsButton.setOnClickListener(v -> startActivity(new Intent(this,Fruits.class)));

        groceriesButton.setOnClickListener(v -> startActivity(new Intent(this,Groceries.class)));

        clothesButton.setOnClickListener(v -> startActivity(new Intent(this,Clothes.class)));

        homeAppliancesButton.setOnClickListener(v -> startActivity(new Intent(this,HomeAppliances.class)));

        furnitureButton.setOnClickListener(v -> startActivity(new Intent(this,Furniture.class)));

        phrasesButton.setOnClickListener(v -> startActivity(new Intent(this,Phrases.class)));

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
        days.setTranslationX(800);

        greetings.setAlpha(v);
        numbers.setAlpha(v);
        family.setAlpha(v);
        days.setAlpha(v);

        greetings.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        numbers.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(500).start();
        family.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(700).start();
        days.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(800).start();
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