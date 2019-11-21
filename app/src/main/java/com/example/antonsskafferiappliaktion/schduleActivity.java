package com.example.antonsskafferiappliaktion;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;

public class schduleActivity extends AppCompatActivity {

    CalendarView calendarView;
    TextView myDate;

    TextView sparadNamn;
    TextView sparadTid;
    TextView sparadDatum;

    String name, tid, datum;

    EditText nameInput;

    EditText tidInput;

    Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schdule);

        calendarView = (CalendarView) findViewById(R.id.calendarView);
        myDate = (TextView) findViewById(R.id.myDate);
        nameInput = (EditText) findViewById(R.id.nameInput);
        tidInput = (EditText) findViewById(R.id.tidInput);
        saveButton = (Button) findViewById(R.id.saveButton);

        sparadNamn = (TextView) findViewById(R.id.sparadNamn);
        sparadTid = (TextView) findViewById(R.id.sparadTid);
        sparadDatum = (TextView) findViewById(R.id.sparadDatum);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String date = year + "/" + month + "/" + dayOfMonth;
                myDate.setText(date);
                datum = date;
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = nameInput.getText().toString();
                tid = tidInput.getText().toString();

                sparadDatum.setText(datum);



                sparadNamn.setText(name);

                sparadTid.setText(tid);

            }
        });

    }

}
