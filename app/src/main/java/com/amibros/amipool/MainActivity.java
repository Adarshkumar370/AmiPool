package com.amibros.amipool;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private ImageView logo;
    private TextView appname, motto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        logo = findViewById(R.id.Logo);
        appname = findViewById(R.id.ss_appname);
        motto = findViewById(R.id.motto);
        logo.setVisibility(View.INVISIBLE);
        appname.setVisibility(View.INVISIBLE);
        motto.setVisibility(View.INVISIBLE);
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Animation b = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
                logo.startAnimation(b);
                appname.startAnimation(b);
                motto.startAnimation(b);
            }
        }, 200);
    }
}