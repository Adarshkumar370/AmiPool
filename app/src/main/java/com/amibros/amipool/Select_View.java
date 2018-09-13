package com.amibros.amipool;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Select_View extends AppCompatActivity {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("message");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select__view);

    }

    public void setDriver(View view) {
        Intent intent = new Intent(this, driver_activity.class);
        startActivity(intent);
        myRef.setValue("Hello, World!");
    }

    public void setPassenger(View view) {
        Intent intent1 = new Intent(this, passengerScreen.class);
        startActivity(intent1);
    }
}