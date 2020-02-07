/* -----------------------------------
 * Put your student name and ID here
 * ----------------------------------- */
package com.example.rydeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String username;
    private String phoneNumber;
    private double distance;
    private String from;
    private String to;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent=getIntent();
        Bundle bundle = intent.getExtras();

        username = bundle.getString("username");
        phoneNumber = bundle.getString("phoneNumber");

        TextView txtWelMes = (TextView) findViewById(R.id.welMes);
        txtWelMes.setText("Hello " + username);

        Spinner fromSpinner = (Spinner) findViewById(R.id.fromLoc);
        from = fromSpinner.getSelectedItem().toString();

        Spinner toSpinner = (Spinner) findViewById(R.id.ToLoc);
        to = toSpinner.getSelectedItem().toString();

        if(from.equals("Union Station")) {
            if(to.equals("Pearson Airport")) {
                distance = 22.5;
            } else if(to.equals("Eaton Center")) {
                distance = 1.3;
            }
        }
    }

    public void PoolCaculate(View view) {
        pool poolcar = new pool();
        poolcar.setDistance(distance);
        poolcar.PricePerKmCalculate();
        poolcar.DistanceChargeCalculate();
        poolcar.TotalPriceCalculator();
    }

    public void DirectCaculate(View view) {
        direct directcar = new direct();
        directcar.setDistance(distance);
        directcar.PricePerKmCalculate();
        directcar.DistanceChargeCalculate();
        directcar.TotalPriceCalculator();
    }

    public void sendResult() {
        Intent confirmIntent = new Intent(this, BookingConfirmationActivity.class);

        Bundle intentBundle = new Bundle();


        confirmIntent.putExtras(intentBundle);
        intentBundle.putString("from", from);
        intentBundle.putString("to", to);

        startActivity(confirmIntent);
    }
}
