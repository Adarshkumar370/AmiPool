package com.amibros.amipool;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class splash_screen extends AppCompatActivity {
    private ImageView logo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.startup_screen);
//        logo= findViewById(R.id.Logo);
//        Animation b=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.move);
//        logo.startAnimation(b);

    }
}