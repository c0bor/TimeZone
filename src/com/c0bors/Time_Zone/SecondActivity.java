package com.c0bors.Time_Zone;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.util.Locale;
import java.util.TimeZone;

/**
 * Created by Oleksiy on 14.08.2015.
 */
public class SecondActivity extends Activity {


    GridView gridView;
    Button b2;
    ArrayAdapter<String> adapter;
    TimeZoneExt tme = new TimeZoneExt();
    String[] arrIds = new String[]{};
    String[] availId;
    EditText editText;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);

//        Locale locale = new Locale("ru");
//        Locale.setDefault(locale);
//        Configuration config = new Configuration();
//        config.locale = locale;
//        getBaseContext().getResources().updateConfiguration(config,
//                getBaseContext().getResources().getDisplayMetrics());
        editText = (EditText)findViewById(R.id.editText);
        b2 =(Button)findViewById(R.id.button2);

        arrIds = tme.TimeIds();
        adapter = new ArrayAdapter<String>(this, R.layout.item, R.id.tvText, arrIds);
        gridView = (GridView) findViewById(R.id.gridView);
        gridView.setAdapter(adapter);
        adjustGridView();


        b2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.button2) {
                    if(editText.getText().toString().equals("")) {
                        Toast.makeText(getApplicationContext(), "Please, input something in text box", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        try {
                            if (Integer.parseInt(editText.getText().toString()) >= -11 && Integer.parseInt(editText.getText().toString()) <= 12) {
                                availId = TimeZone.getAvailableIDs(Integer.parseInt(editText.getText().toString()) * 3600000);
                                FinishSecondActivity(availId[0]);
                            } else {
                                Toast.makeText(getApplicationContext(), "Please, input number in -11:12 range", Toast.LENGTH_SHORT).show();
                            }
                        }
                        catch(NumberFormatException nfe) {
                            Toast.makeText(getApplicationContext(), "trying to convert:"+editText.getText().toString()+" to integer failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View v, int position, long arg3) {
                FinishSecondActivity(arrIds[position]);

                //Toast.makeText(getApplicationContext(), arrIds[position].toString(), Toast.LENGTH_SHORT).show();
            }
        });


    }
    private void adjustGridView() {
        gridView.setNumColumns(GridView.AUTO_FIT);
        gridView.setColumnWidth(300);
        gridView.setVerticalSpacing(20);
        gridView.setHorizontalSpacing(10);
    }
    private void FinishSecondActivity(String ID){
        Intent intent = new Intent();
        intent.putExtra("ID", ID);
        setResult(RESULT_OK, intent);
        finish();
    }
}