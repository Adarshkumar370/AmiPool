package com.amibros.amipool;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

public class Select_View extends AppCompatActivity {
    private Button driver;
    private Button passenger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select__view);
        driver = findViewById(R.id.Driver);
        passenger = findViewById(R.id.passenger);
    }

    public void driver() {
        Intent intent = new Intent(Select_View.this, driver_activity.class);
        startActivity(intent);
    }

    public void setpassenger() {
        Intent intent = new Intent(Select_View.this, passengerScreen.class);
        startActivity(intent);
    }
}