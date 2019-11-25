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
        final Button food_btn1, food_btn2, food_btn3, food_btn4, food_btn5, food_btn6;



        //this is
        TextView txtclose;
        takeOrders.setContentView(R.layout.custompopup);
        txtclose = takeOrders.findViewById(R.id.txtclose);
        food_btn1 = (Button) takeOrders.findViewById(R.id.food_btn1);
        food_btn2 = (Button) takeOrders.findViewById(R.id.food_btn2);
        food_btn3 = (Button) takeOrders.findViewById(R.id.food_btn3);
        food_btn4 = (Button) takeOrders.findViewById(R.id.food_btn4);
        food_btn5 = (Button) takeOrders.findViewById(R.id.food_btn5);

        final ListView food_list;

        food_list = (ListView) takeOrders.findViewById(R.id.food_list);

        String[] foods = new String[] {};

        // Create a List from String Array elements
        final List<String> fruits_list = new ArrayList<String>(Arrays.asList(foods));

        // Create an ArrayAdapter from List
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>
                (this, android.R.layout.simple_list_item_1, fruits_list);
        food_list.setAdapter(arrayAdapter);

        food_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fruits_list.add("Lasagne");
                arrayAdapter.notifyDataSetChanged();
            }
        });

        food_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fruits_list.add("Sallad");
                arrayAdapter.notifyDataSetChanged();
            }
        });

        food_btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fruits_list.add("Hamburgare");
                arrayAdapter.notifyDataSetChanged();
            }
        });
        food_btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fruits_list.add("plankstek");
                arrayAdapter.notifyDataSetChanged();
            }
        });
        food_btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fruits_list.add("lax med potatis");
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
