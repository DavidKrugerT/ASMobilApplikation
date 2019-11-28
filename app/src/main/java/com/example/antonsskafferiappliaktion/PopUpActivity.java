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

public class PopUpActivity extends AppCompatActivity {

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


        sendOrder_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PostOrder postOrder = null;
                try {
                    postOrder = new PostOrder();
                    postOrder.execute(order.getDishes().get(0));
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        });
        }
    private class PostOrder extends AsyncTask<Dish, String, String> {
        URL url = new URL("http://10.250.119.122:8080/Project-WebApp/webresources/entity.dish/");
        //URL url = new URL("https://google.com");
        OutputStream out = null;
        String jsonBody;
        private PostOrder() throws MalformedURLException {
        }

        @Override
        protected String doInBackground(Dish... dishes) {
            try {
                jsonBody =
                        "{"
                                +"\"name\":"+"\""+dishes[0].getName()+"\","
                                +"\"price\""+":"+dishes[0].getPrice()+
                                "}";
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("POST");
                urlConnection.setRequestProperty("Content-Type", "application/json");

                out = new BufferedOutputStream(urlConnection.getOutputStream());
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out, "UTF-8"));
                writer.write(jsonBody);
                writer.flush();
                writer.close();
                out.close();

                urlConnection.connect();
                Log.d(this.getClass().toString(),jsonBody);
                Log.d(this.getClass().toString(),"responsecode: "+urlConnection.getResponseCode());
                /*HttpURLConnection conn;
                do {
                    conn = (HttpURLConnection) url.openConnection();
                }while(conn.getResponseCode() != 200);
                conn.setRequestMethod("POST");
                //conn.setRequestProperty("Content-Type", "application/json; utf-8");
                //conn.setRequestProperty("Accept", "application/json");
                //conn.setReadTimeout(10000);
                //conn.setConnectTimeout(15000);
                conn.setDoOutput(true);
                //conn.setDoInput(true);
                jsonBody =
                        "{"
                        +"name:"+dishes[0].getName()+","
                        +"price:"+dishes[0].getPrice()+
                        "}";
                OutputStream os = conn.getOutputStream();
                byte[] input = jsonBody.getBytes("utf-8");
                os.write(input,0,input.length);

                BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
                    StringBuilder response = new StringBuilder();
                    String responseline = null;
                    while((responseline = br.readLine())!=null)
                    {
                        response.append(responseline).append("\n");
                    }
                    br.close();
                    conn.disconnect();*/

            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }
    }

}
