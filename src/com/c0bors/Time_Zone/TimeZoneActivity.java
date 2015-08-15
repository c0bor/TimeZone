package com.c0bors.Time_Zone;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.util.Locale;
import java.util.TimeZone;

public class TimeZoneActivity extends Activity{
    /**
     * Called when the activity is first created.
     */
    Button b1;
    TextClock textClock;
    TextView textView,textView2 ;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
//        Locale locale = new Locale("ru");
//        Locale.setDefault(locale);
//        Configuration config = new Configuration();
//        config.locale = locale;
//        getBaseContext().getResources().updateConfiguration(config,
//                getBaseContext().getResources().getDisplayMetrics());
        textClock = (TextClock) findViewById(R.id.textClock2);
        textView = (TextView)findViewById(R.id.textView);
        textView2 = (TextView)findViewById(R.id.textView2);
        textView.setText(TimeZone.getDefault().getDisplayName(new Locale("en")));
        textView2.setText(TimeZone.getDefault().getDisplayName(new Locale("en")));
        b1 = (Button)findViewById(R.id.button1);

        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.button1) {
                    button1Click();
                }
            }
        });
    }
    private void button1Click(){
        startActivityForResult(new Intent("com.c0bors.SecondActivity"), 1);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data == null) {return;}
        String ID = data.getStringExtra("ID");
        textClock = (TextClock) findViewById(R.id.textClock2);
        //analogClock = (AnalogClock) findViewById(R.id.analogClock2);
        textClock.setTimeZone(ID);
        TZtext(ID);

    }
    private void TZtext(String ID){

        textView.setText(TimeZone.getTimeZone(ID).getDisplayName(new Locale("en")));
    }
}
