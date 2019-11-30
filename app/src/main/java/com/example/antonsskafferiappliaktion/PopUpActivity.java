package com.example.antonsskafferiappliaktion;

import androidx.appcompat.app.AppCompatActivity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class PopUpActivity extends AppCompatActivity {
    final Order order = new Order();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup_activity);

        Button sendOrder_btn = findViewById(R.id.sendOrder_btn);



        final Button food_btn1 = findViewById(R.id.food_btn1);
        final Button food_btn2 = findViewById(R.id.food_btn2);
        final Button food_btn3 = findViewById(R.id.food_btn3);
        final Button food_btn4 = findViewById(R.id.food_btn4);
        final Button food_btn5 = findViewById(R.id.food_btn5);

        //Listan som skrivs ut
        final ListView food_list = findViewById(R.id.food_list);
        //final Dish dish = new Dish();


        //Create an ArrayAdapter from List
        final ArrayAdapter<Dish> arrayAdapter = new ArrayAdapter<>
                (this, android.R.layout.simple_list_item_1, order.getDishes());
        food_list.setAdapter(arrayAdapter);

        food_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dish dish = new Dish();
                dish.setName("Lasange");
                dish.setPrice(5000);
                order.addDish(dish);
                arrayAdapter.notifyDataSetChanged();
            }
        });

        food_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dish dish = new Dish();
                dish.setName("Sallad");
                dish.setPrice(5000);
                order.addDish(dish);
                arrayAdapter.notifyDataSetChanged();
            }
        });

        food_btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dish dish = new Dish();
                dish.setName("Hamburgare");
                dish.setPrice(5000);
                order.addDish(dish);
                arrayAdapter.notifyDataSetChanged();
            }
        });
        food_btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dish dish = new Dish();
                dish.setName("Planka");
                dish.setPrice(5000);
                order.addDish(dish);
                arrayAdapter.notifyDataSetChanged();
            }
        });
        food_btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dish dish = new Dish();
                dish.setName("Lax med potatis");
                dish.setPrice(5000);
                order.addDish(dish);
                arrayAdapter.notifyDataSetChanged();
            }
        });


        sendOrder_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PostOrder postOrder = null;
                try {
                    postOrder = new PostOrder();
                    postOrder.execute();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        });
        }
    private class PostOrder extends AsyncTask<Void, Void, Void> {
        URL url = new URL("http://10.250.117.128:8080/Project-WebApp/webresources/entity.dish/");
        //URL url = new URL("https://google.com");
        JSONObject jsonObject;
        OutputStream out = null;
        List<Dish> dishes = new ArrayList<>();
        private PostOrder() throws MalformedURLException {
            dishes = order.getDishes();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            try {

                for(int i = 0; i < dishes.size(); i++) {
                    jsonObject = new JSONObject();
                    jsonObject.put("name", dishes.get(i).getName());
                    jsonObject.put("price", 5000);
                    jsonObject.put("orderNumber", 1);
                    //jsonObject.put("name", );
                    //jsonObject.put("name", dishes.get(i).getName());

                    HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                    urlConnection.setRequestMethod("POST");
                    urlConnection.setRequestProperty("Content-Type", "application/json");

                    out = new BufferedOutputStream(urlConnection.getOutputStream());
                    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out, "UTF-8"));
                    writer.write(jsonObject.toString());
                    writer.flush();
                    writer.close();
                    out.close();

                    urlConnection.connect();
                    //Log.d(this.getClass().toString(), jsonBody);
                    Log.d(this.getClass().toString(), "responsecode: " + urlConnection.getResponseCode());
                }

            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }


    }

}
