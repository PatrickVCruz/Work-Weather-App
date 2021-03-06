package com.example.windows10.work_weather;

import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class DataScreen extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_screen);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/Futura Medium.ttf");
        Database database = new Database(this);
        Double databaseAverage = database.getRoomAverage();
        int databaseShiftNumber = database.getShiftNumber();
        String databaseDay = database.getDay();

        TextView screenAverage = (TextView)findViewById(R.id.idScreen);
        TextView screenShift = (TextView)findViewById(R.id.shiftView);
        TextView screenDay = (TextView)findViewById(R.id.textView3);

        screenShift.setTypeface(typeface);
        screenAverage.setTypeface(typeface);
        screenDay.setTypeface(typeface);

        screenAverage.setText(String.format("Current Average: %s", String.valueOf(databaseAverage)));
        screenShift.setText(String.format("Current Shift: %s", String.valueOf(databaseShiftNumber)));
        screenDay.setText(String.format("Current Day: %s", String.valueOf(databaseDay)));

        Log.d("BB","Shift number: "+  +database.getShiftNumber()+ " in Main Activity "+ " Receiver");
    }


}