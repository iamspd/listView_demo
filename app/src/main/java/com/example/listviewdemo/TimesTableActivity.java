package com.example.listviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class TimesTableActivity extends AppCompatActivity {

    // constants
    private static final String TAG = "TimesTableActivity";

    // variables

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

                // Log.i("SeekBar value: ", Integer.toString(timesTable));
                generateTimesTable(timesTable);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        listTimesTable = findViewById(R.id.listTimesTable);

        generateTimesTable(10);

    }

    public void generateTimesTable(int timesTable){

        ArrayList<String> timesTableContent = new ArrayList<>();

        for (int i = 1; i <= 10; i++){

            timesTableContent.add(Integer.toString(i * timesTable));

        }

        ArrayAdapter<String> timesTableAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, timesTableContent);

        listTimesTable.setAdapter(timesTableAdapter);

    }
}