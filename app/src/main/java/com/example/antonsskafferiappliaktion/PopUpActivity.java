package com.example.antonsskafferiappliaktion;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class PopUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup_activity);

        final Button food_btn1 = findViewById(R.id.food_btn1);
        final Button food_btn2 = findViewById(R.id.food_btn2);
        final Button food_btn3 = findViewById(R.id.food_btn3);
        final Button food_btn4 = findViewById(R.id.food_btn4);
        final Button food_btn5 = findViewById(R.id.food_btn5);

        //Listan som skrivs ut
        final ListView food_list = findViewById(R.id.food_list);
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


        }
}
