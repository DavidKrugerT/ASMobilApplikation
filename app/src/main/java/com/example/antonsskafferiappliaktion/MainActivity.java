package com.example.antonsskafferiappliaktion;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    Dialog takeOrders;
    Button test;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        takeOrders = new Dialog(this);

        Button button2schedule = (Button) findViewById(R.id.button2schedule);
        button2schedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, schduleActivity.class);
                startActivity(intent);
            }
        });

    }


    public void ShowPopup(View view) {
        final Button test;
        TextView txtclose;
        takeOrders.setContentView(R.layout.custompopup);
        txtclose = takeOrders.findViewById(R.id.txtclose);
        test = (Button) takeOrders.findViewById(R.id.test);

        final ListView food_list;

        food_list = (ListView) takeOrders.findViewById(R.id.food_list);

        String[] foods = new String[] {
                "Davve",
                "Dave"
        };

        // Create a List from String Array elements
        final List<String> fruits_list = new ArrayList<String>(Arrays.asList(foods));

        // Create an ArrayAdapter from List
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, fruits_list);

        food_list.setAdapter(arrayAdapter);

        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fruits_list.add("David");

                arrayAdapter.notifyDataSetChanged();

            }
        });



        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takeOrders.dismiss();
            }
        });
        takeOrders.show();
    }


}
