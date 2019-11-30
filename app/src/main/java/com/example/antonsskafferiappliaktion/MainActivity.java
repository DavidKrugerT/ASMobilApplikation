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

public class MainActivity extends AppCompatActivity {

    //Dialog takeOrders;
    public static Order order = new Order();
    public static Menu menu = new Menu();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //final Menu menu = new Menu();

        //KNAPP TILL schduleActivity
        //-----------------------------------------------
        //-----------------------------------------------
        Button button2schedule = findViewById(R.id.button2schedule);
        button2schedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, schduleActivity.class);
                startActivity(intent);
            }
        });
        //-----------------------------------------------
        //-----------------------------------------------

        Button popUp_btn1 = findViewById(R.id.popUp_btn1);
        Button popUp_btn2 = findViewById(R.id.popUp_btn2);
        Button popUp_btn3 = findViewById(R.id.popUp_btn3);
        Button popUp_btn4 = findViewById(R.id.popUp_btn4);
        Button popUp_btn5 = findViewById(R.id.popUp_btn5);
        Button popUp_btn6 = findViewById(R.id.popUp_btn6);

        //Knapp Bord 1 öppnar PopUpActivity
        popUp_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                order.setBordsNummer(1);
                Intent intent = new Intent(MainActivity.this, PopUpActivity.class);
                startActivity(intent);
            }
        });
        //Knapp Bord 2 öppnar PopUpActivity
        popUp_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                order.setBordsNummer(2);
                Intent intent = new Intent(MainActivity.this, PopUpActivity.class);
                startActivity(intent);
            }
        });
        //Knapp Bord 3 öppnar PopUpActivity
        popUp_btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                order.setBordsNummer(3);
                Intent intent = new Intent(MainActivity.this, PopUpActivity.class);
                startActivity(intent);
            }
        });
        //Knapp Bord 4 öppnar PopUpActivity
        popUp_btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                order.setBordsNummer(4);
                Intent intent = new Intent(MainActivity.this, PopUpActivity.class);
                startActivity(intent);
            }
        });
        //Knapp Bord 5 öppnar PopUpActivity
        popUp_btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                order.setBordsNummer(5);
                Intent intent = new Intent(MainActivity.this, PopUpActivity.class);
                startActivity(intent);
            }
        });
        //Knapp Bord 6 öppnar PopUpActivity
        popUp_btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                order.setBordsNummer(6);
                Intent intent = new Intent(MainActivity.this, PopUpActivity.class);
                startActivity(intent);
            }
        });



    }

    /*public void ShowPopup(View view) {
        takeOrders.setContentView(R.layout.custompopup);
        TextView txtclose = takeOrders.findViewById(R.id.txtclose);

        final Button food_btn1 = takeOrders.findViewById(R.id.food_btn1);
        final Button food_btn2 = takeOrders.findViewById(R.id.food_btn2);
        final Button food_btn3 = takeOrders.findViewById(R.id.food_btn3);
        final Button food_btn4 = takeOrders.findViewById(R.id.food_btn4);
        final Button food_btn5 = takeOrders.findViewById(R.id.food_btn5);

        //Listan som skrivs ut
        final ListView food_list= takeOrders.findViewById(R.id.food_list);
        //final Dish dish = new Dish();
        final Order order = new Order();

        //Create an ArrayAdapter from List
        final ArrayAdapter<Dish> arrayAdapter = new ArrayAdapter<>
                (this, android.R.layout.simple_list_item_1, order.getDishes());
        food_list.setAdapter(arrayAdapter);

        food_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dish dish = new Dish();
                dish.setName("Lasange");
                dish.setPrice("5000");
                order.addDish(dish);
                arrayAdapter.notifyDataSetChanged();
            }
        });

        food_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dish dish = new Dish();
                dish.setName("Sallad");
                dish.setPrice("4000");
                order.addDish(dish);
                arrayAdapter.notifyDataSetChanged();
            }
        });

        food_btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dish dish = new Dish();
                dish.setName("Hamburgare");
                dish.setPrice("6000");
                order.addDish(dish);
                arrayAdapter.notifyDataSetChanged();
            }
        });
        food_btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dish dish = new Dish();
                dish.setName("Planka");
                dish.setPrice("5000");
                order.addDish(dish);
                arrayAdapter.notifyDataSetChanged();
            }
        });
        food_btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dish dish = new Dish();
                dish.setName("Lax med potatis");
                dish.setPrice("5000");
                order.addDish(dish);
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
    }*/
}
