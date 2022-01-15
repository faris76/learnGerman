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

public class LoginActivity extends AppCompatActivity {
    TextView forgotPassword,login,signUp;
    RelativeLayout emailEditText,passEditText;
    FloatingActionButton fb,insta,twitter,linkedin;
    EditText emailEt,passEt;
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
        setContentView(R.layout.activity_login);

        //to remove navigation bar
        decorView = getWindow().getDecorView();
        decorView.setOnSystemUiVisibilityChangeListener(visibility -> {
            if (visibility == 0)
                decorView.setSystemUiVisibility(hideSystemBars());
        });

        /**check if the user is currently logged in or not*/
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            // User is signed in
            Intent i = new Intent(LoginActivity.this,HomeActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(i);
        }

        fb = findViewById(R.id.fb_fab);
        insta = findViewById(R.id.insta_fab);
        twitter = findViewById(R.id.twitter_fab);
        linkedin = findViewById(R.id.linkedin_fab);

        forgotPassword = findViewById(R.id.forgot_pass);
        login = findViewById(R.id.login_btn);
        emailEditText = findViewById(R.id.email_et);
        passEditText = findViewById(R.id.pass_et);
        signUp = findViewById(R.id.signUp);

        emailEt = findViewById(R.id.username_input);
        passEt = findViewById(R.id.pass);

        // Click Listeners
        signUp.setOnClickListener(v ->{
            startActivity(new Intent(this,SignupActivity.class));
        });

        login.setOnClickListener(v ->{
            loginUser();
        });

        startAnimation();
    }

    private void loginUser(){
        FirebaseAuth mAuth;
        mAuth = FirebaseAuth.getInstance();

        String email = emailEt.getText().toString();
        String password = passEt.getText().toString();

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            finish();
                            startActivity(new Intent(getApplicationContext(),HomeActivity.class));
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(getApplicationContext(), "failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
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