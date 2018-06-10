package com.amibros.amipool;

import android.content.Intent;
import android.os.Handler;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class login extends AppCompatActivity implements GestureDetector.OnGestureListener {

    private GestureDetectorCompat detector;
    private Button loginButton;
    private EditText inputEmail;
    private EditText inputPassword;
    private TextView link_signup;
    private boolean exit = false;

    public void init() {

        link_signup = findViewById(R.id.link_signup);
        link_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(login.this, signup.class);
                startActivity(intent);
                overridePendingTransition(R.anim.enter, R.anim.exit);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        detector = new GestureDetectorCompat(this, this);
        init();
    }

    @Override
    public void onBackPressed() {
        if (exit) {
            finish(); // finish activity
        } else {
            Toast.makeText(this, "Press Back again to Exit.",
                    Toast.LENGTH_SHORT).show();
            exit = true;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    exit = false;
                }
            }, 3 * 1000);

        }

    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        if (e1.getX() - e2.getX() > 50) {
            Intent intent = new Intent(login.this, signup.class);
            startActivity(intent);
            overridePendingTransition(R.anim.enter, R.anim.exit);
            return true;
        }
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        detector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    /**
     * Login Check method is used to verify the login credentials of the user.
     * Two separate method emailCheck and passwordCheck
     */
    public void loginCheck(View view) {
        loginButton = findViewById(R.id.btn_signup);
        inputEmail = findViewById(R.id.input_email);
        inputPassword = findViewById(R.id.input_password);
        boolean checke = emailCheck(inputEmail.getText().toString());
        boolean checkp = passwordcheck(inputPassword.getText().toString());
        if (checke && checkp)
            Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show(); // Replace with JSON READER
        else
            Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show();// error msg float window
    }

    private final boolean emailCheck(String s) {
        s = s.toLowerCase();
        s = s.trim();
        boolean d = false;
        CharSequence c = s;
        boolean b = android.util.Patterns.EMAIL_ADDRESS.matcher(c).matches();// checking for a valid email
        if (s.endsWith("@amity.edu") || s.endsWith("@student.amity.edu"))
            d = true;

            /*
            More code needed to show error msg on the user screen
             */


        if (s != "" && b && d)

            return true;
        else {
            inputEmail.setError("Wrong Email ");
            inputEmail.requestFocus();
            return false;


        }
    }

    private final boolean passwordcheck(String p) { /*
            replace it later with proper logic
            */

        if (p.length() > 4)
            return true;
        else {
            inputPassword.setError("Wrong Password");

            inputPassword.requestFocus();
            return false;

                   /*
                replace it later with proper logic
                */
        }

    }

}