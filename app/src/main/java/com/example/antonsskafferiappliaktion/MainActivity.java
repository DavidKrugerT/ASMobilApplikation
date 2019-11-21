package com.example.antonsskafferiappliaktion;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    Dialog takeOrders;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        takeOrders = new Dialog(this);

        //Button button2schedule;

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
        TextView txtclose;
        takeOrders.setContentView(R.layout.custompopup);
        txtclose = takeOrders.findViewById(R.id.txtclose);
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takeOrders.dismiss();
            }
        });
        takeOrders.show();
    }


}
