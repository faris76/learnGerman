package com.example.android.learngerman;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignupActivity extends AppCompatActivity {
    TextView backBtn,signUp;;
    RelativeLayout emailEditText,passEditText;
    FloatingActionButton fb,insta,twitter,linkedin;
    EditText email_et,pass_et;
    float v = 0;

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
        setContentView(R.layout.activity_signup);

        //to remove navigation bar
        decorView = getWindow().getDecorView();
        decorView.setOnSystemUiVisibilityChangeListener(visibility -> {
            if (visibility == 0)
                decorView.setSystemUiVisibility(hideSystemBars());
        });

        // Initialization
        fb = findViewById(R.id.fb_fab);
        insta = findViewById(R.id.insta_fab);
        twitter = findViewById(R.id.twitter_fab);
        linkedin = findViewById(R.id.linkedin_fab);


        emailEditText = findViewById(R.id.email_et);
        passEditText = findViewById(R.id.pass_et);
        signUp = findViewById(R.id.signUp_btn);
        backBtn = findViewById(R.id.back_btn);

        email_et = findViewById(R.id.email_input);
        pass_et = findViewById(R.id.pass_input);


        backBtn.setOnClickListener(v ->{
            onBackPressed();
        });

        signUp.setOnClickListener(v ->{
            addUserWithEmail();
        });

        startAnimation();
    }


    private void addUserWithEmail(){
        FirebaseAuth mAuth;
        mAuth = FirebaseAuth.getInstance();

        String email = email_et.getText().toString();
        String password = pass_et.getText().toString();

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        // Sign in success, update UI with the signed-in user's information
                        clear();
                        Toast.makeText(getApplicationContext(), "User Added Successfully", Toast.LENGTH_SHORT).show();
                    } else {
                        // If sign in fails, display a message to the user.
                        Toast.makeText(getApplicationContext(), "Signup Failed", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    /**To clear All Edit Text Fields
     * in the activity after successful registration */
    private void clear(){
        email_et.setText("");
        pass_et.setText("");
    }


    /**This methode will handle animation */
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

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}