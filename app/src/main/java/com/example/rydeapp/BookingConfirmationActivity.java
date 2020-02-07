/* -----------------------------------
 * Put your student name and ID here
 * ----------------------------------- */

package com.example.rydeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.rydeapp.R;

public class BookingConfirmationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_confirmation);

        Intent intent=getIntent();
        Bundle bundle = intent.getExtras();

        String from = bundle.getString("from");
        String to = bundle.getString("to");

        TextView txtFrom = (TextView) findViewById(R.id.from);
        txtFrom.setText("From: " + from);

        TextView txtTo = (TextView) findViewById(R.id.to);
        txtTo.setText("To: " + to);

    }
}
