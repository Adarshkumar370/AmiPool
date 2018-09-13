package com.amibros.amipool;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

public class passenger_activity extends AppCompatActivity {
    private TextView titleBar;
    private TextView source;
    private TextView destination;
    private TextView gateNo;
    private TextView leavingTime;
    private TextView phoneNo;
    private Button confirm;
    private Button cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.passenger_activity);
        titleBar = findViewById(R.id.found_status);
        source = findViewById(R.id.Source);
        destination = findViewById(R.id.Destination);
        source.setText("Amity University");
        gateNo = findViewById(R.id.text_box_container_gate_number);
        leavingTime = findViewById(R.id.leaving_time);
        phoneNo = findViewById(R.id.phone_number_value);
        confirm = findViewById(R.id.btn_confirm);
        cancel = findViewById(R.id.btn_cancel);


    }
}
