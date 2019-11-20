package com.example.antonsskafferiappliaktion;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Dialog takeOrders;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        takeOrders = new Dialog(this);
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
