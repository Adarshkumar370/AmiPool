package com.amibros.amipool;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener{
    private ImageView logo;
    private TextView appname, tagLine;
    private Button next;
    private GestureDetectorCompat detector;

    public void init() {

        next = findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, login.class);
                startActivity(intent);
                overridePendingTransition(R.anim.enter, R.anim.exit);
            }
        });

        next.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        v.getBackground().setColorFilter(0x0d544e, PorterDuff.Mode.CLEAR);
                        v.invalidate();
                        break;
                    }
                    case MotionEvent.ACTION_UP: {
                        v.getBackground().clearColorFilter();
                        v.invalidate();
                        break;
                    }
                }

                return false;
                }
        });

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        logo = findViewById(R.id.Logo);
        appname = findViewById(R.id.ss_appname);
        tagLine = findViewById(R.id.tagLine);
        next = findViewById(R.id.next);
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Animation b = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
                logo.startAnimation(b);
            }
        }, 200);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Animation b = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
                appname.startAnimation(b);
                tagLine.startAnimation(b);
            }
        }, 1000);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Animation b = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
                next.startAnimation(b);
                init();
            }
        }, 1200);

        detector = new GestureDetectorCompat(this, this);

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
            Intent intent = new Intent(MainActivity.this, login.class);
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

}