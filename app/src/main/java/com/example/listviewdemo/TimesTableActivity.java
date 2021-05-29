package com.example.listviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.SeekBar;

public class TimesTableActivity extends AppCompatActivity {

    private static final String TAG = "TimesTableActivity";
    // widgets
    private SeekBar seekBarTimesTable;
    private ListView listTimesTable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_times_table);

        seekBarTimesTable = findViewById(R.id.seekBarTimesTable);
        seekBarTimesTable.setMax(20);
        seekBarTimesTable.setProgress(10);

        seekBarTimesTable.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                int min = 1, timesTable;

                if (progress < min){

                    timesTable = min;
                    seekBarTimesTable.setProgress(min);

                } else {

                    timesTable = progress;

                }

                Log.i("SeekBar value: ", Integer.toString(timesTable));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        listTimesTable = findViewById(R.id.listTimesTable);
    }
}