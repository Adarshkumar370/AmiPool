package com.amibros.amipool;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login extends AppCompatActivity implements GestureDetector.OnGestureListener {

    private GestureDetectorCompat detector;
    private Button loginButton;
    private EditText inputEmail;
    private EditText inputPassword;
    private TextView link_signup;
    private boolean exit = false;
    private FirebaseAuth mAuth;
// ...


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
        mAuth = FirebaseAuth.getInstance();
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
        String email = inputEmail.getText().toString().trim().toLowerCase();
        inputPassword = findViewById(R.id.input_password);
        String password = inputPassword.getText().toString().trim().toLowerCase();
        boolean checke = emailCheck(inputEmail.getText().toString());
        boolean checkp = passwordcheck(inputPassword.getText().toString());
        if (checke && checkp) {
            mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(getApplicationContext(), "Login Successful", Toast.LENGTH_SHORT).show(); // Replace with JSON READER
                        Intent map = new Intent(login.this, passengerScreen.class);
                        startActivity(map);
                    } else {
                        Toast.makeText(getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_LONG).show();
                    }
                }

            });

        }
    }

    private boolean emailCheck(String s) {
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