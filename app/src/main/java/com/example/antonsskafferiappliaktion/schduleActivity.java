package com.example.antonsskafferiappliaktion;

import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class schduleActivity extends AppCompatActivity implements OnItemSelectedListener {

    CalendarView calendarView;
    TextView myDate;

    TextView sparadNamn;
    TextView sparadTid;
    TextView sparadDatum;

    Schedule schedule = new Schedule();

    EditText nameInput;

    Button saveButton;

    CheckBox lunch;
    CheckBox kvell;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schdule);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.names, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(this);


        calendarView = (CalendarView) findViewById(R.id.calendarView);
        myDate = (TextView) findViewById(R.id.myDate);

        saveButton = (Button) findViewById(R.id.saveButton);

        sparadNamn = (TextView) findViewById(R.id.sparadNamn);
        sparadTid = (TextView) findViewById(R.id.sparadTid);
        sparadDatum = (TextView) findViewById(R.id.sparadDatum);

        lunch = (CheckBox) findViewById(R.id.lunch);
        kvell = (CheckBox) findViewById(R.id.kvell);

        lunch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                schedule.setTid("Lunch");
            }
        });

        kvell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                schedule.setTid("Kväll");
            }
        });

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String date = year + "/" + month + "/" + dayOfMonth;
                myDate.setText(date);
                schedule.setDatum(date);
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sparadDatum.setText(schedule.getDatum());
                sparadNamn.setText(schedule.getName());
                sparadTid.setText(schedule.getTid());

            }
        });

    }

    /*private class GetPerson extends AsyncTask<Void, Void, Void> {
        private String apiUrl = "";
        private String strXml;

        @Override
        protected Void doInBackground(Void... voids) {
            return null;
        }
    }*/

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        schedule.setName(parent.getItemAtPosition(position).toString());
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
