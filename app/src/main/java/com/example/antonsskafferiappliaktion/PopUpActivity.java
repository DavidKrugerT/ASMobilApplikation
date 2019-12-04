package com.example.antonsskafferiappliaktion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class PopUpActivity extends AppCompatActivity {
    final Order order = MainActivity.order;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup_activity);



        Button sendOrder_btn = findViewById(R.id.sendOrder_btn);

        final Button food_btn1 = findViewById(R.id.food_btn1);
        food_btn1.setText(MainActivity.menu.getTheFoodsAtPos(0).getName());
        final Button food_btn2 = findViewById(R.id.food_btn2);
        food_btn2.setText(MainActivity.menu.getTheFoodsAtPos(1).getName());
        final Button food_btn3 = findViewById(R.id.food_btn3);
        food_btn3.setText(MainActivity.menu.getTheFoodsAtPos(2).getName());
        final Button food_btn4 = findViewById(R.id.food_btn4);
        food_btn4.setText(MainActivity.menu.getTheFoodsAtPos(3).getName());
        final Button food_btn5 = findViewById(R.id.food_btn5);
        food_btn5.setText(MainActivity.menu.getTheFoodsAtPos(4).getName());
        final Button food_btn6 = findViewById(R.id.food_btn6);
        food_btn6.setText(MainActivity.menu.getTheFoodsAtPos(5).getName());
        final Button food_btn7 = findViewById(R.id.food_btn7);
        food_btn7.setText(MainActivity.menu.getTheFoodsAtPos(6).getName());
        final Button food_btn8 = findViewById(R.id.food_btn8);
        food_btn8.setText(MainActivity.menu.getTheFoodsAtPos(7).getName());
        final Button food_btn9 = findViewById(R.id.food_btn9);
        food_btn9.setText(MainActivity.menu.getTheFoodsAtPos(8).getName());
        final Button food_btn10 = findViewById(R.id.food_btn10);
        food_btn10.setText(MainActivity.menu.getTheFoodsAtPos(9).getName());



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
                HttpGetRequest httpGetRequest = new HttpGetRequest();
                httpGetRequest.execute();
                Dish dish = new Dish();
                dish.setPrice(5000);
                dish.setName(MainActivity.menu.getTheFoodsAtPos(0).getName());
                order.addDish(dish);
                arrayAdapter.notifyDataSetChanged();
            }
        });

        food_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dish dish = new Dish();
                dish.setPrice(5000);
                dish.setName(MainActivity.menu.getTheFoodsAtPos(1).getName());
                order.addDish(dish);
                arrayAdapter.notifyDataSetChanged();
            }
        });

        food_btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dish dish = new Dish();
                dish.setPrice(5000);
                dish.setName(MainActivity.menu.getTheFoodsAtPos(2).getName());
                order.addDish(dish);
                arrayAdapter.notifyDataSetChanged();
            }
        });
        food_btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dish dish = new Dish();
                dish.setPrice(5000);
                dish.setName(MainActivity.menu.getTheFoodsAtPos(3).getName());
                order.addDish(dish);
                arrayAdapter.notifyDataSetChanged();
            }
        });
        food_btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PopUpActivity.this, MainActivity.class);
                startActivity(intent);
                Dish dish = new Dish();
                dish.setPrice(5000);
                dish.setName(MainActivity.menu.getTheFoodsAtPos(4).getName());
                order.addDish(dish);
                arrayAdapter.notifyDataSetChanged();
            }
        });
        food_btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dish dish = new Dish();
                dish.setPrice(5000);
                dish.setName(MainActivity.menu.getTheFoodsAtPos(5).getName());
                order.addDish(dish);
                arrayAdapter.notifyDataSetChanged();
            }
        });
        food_btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dish dish = new Dish();
                dish.setPrice(5000);
                dish.setName(MainActivity.menu.getTheFoodsAtPos(6).getName());
                order.addDish(dish);
                arrayAdapter.notifyDataSetChanged();
            }
        });
        food_btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dish dish = new Dish();
                dish.setPrice(5000);
                dish.setName(MainActivity.menu.getTheFoodsAtPos(7).getName());
                order.addDish(dish);
                arrayAdapter.notifyDataSetChanged();
            }
        });
        food_btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dish dish = new Dish();
                dish.setPrice(5000);
                dish.setName(MainActivity.menu.getTheFoodsAtPos(8).getName());
                order.addDish(dish);
                arrayAdapter.notifyDataSetChanged();
            }
        });
        food_btn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dish dish = new Dish();
                dish.setPrice(5000);
                dish.setName(MainActivity.menu.getTheFoodsAtPos(9).getName());
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
                    Intent intent = new Intent(PopUpActivity.this, MainActivity.class);
                    startActivity(intent);
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
                    jsonObject.put("orderNumber", MainActivity.orderNumber);
                    jsonObject.put("tableNumber", order.getBordsNummer());
                    jsonObject.put("cookingTime", 50);


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
                MainActivity.orderNumber += 1;
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }


    }

    public static class HttpGetRequest extends AsyncTask<Void, Void, Void> {
        //Some url endpoint that you may have
        private String apiUrl = "http://10.250.117.145:8080/Project-WebApp/webresources/entity.menu";
        private String strXml;


        //String to place our result in
        //String result;
        //Instantiate new instance of our class
        //HttpGetRequest getRequest = new HttpGetRequest();
        //Perform the doInBackground method, passing in our url
        //result = getRequest.execute(myUrl).get();
        protected Void doInBackground(Void... voids) {

            try {
                URL url = new URL(apiUrl);
                HttpURLConnection conn;
                do {

                    conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestProperty("Accept", "application/json");
                } while (conn.getResponseCode() != 200);


                conn.setRequestMethod("GET");

                try {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    StringBuilder stringBuilder = new StringBuilder();
                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        stringBuilder.append(line).append("\n");
                    }
                    bufferedReader.close();
                    strXml = stringBuilder.toString();

                    System.out.println("Root elementhhhhhhhhhhhhhh :" + strXml);

                    //setData(strXml);
                } finally {
                    conn.disconnect();
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result){
            super.onPostExecute(result);
        }

        private String setData(String str){
            try{
                //String test = new String();
                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder = factory.newDocumentBuilder();
                Document doc = builder.parse(new InputSource(new StringReader(str)));
                doc.getDocumentElement().normalize();
                NodeList nodeList = doc.getElementsByTagName("menu");


                for (int temp = 0; temp < nodeList.getLength(); temp++){
                    Node node = nodeList.item(temp);
                    Menu menu = new Menu();
                    if(node.getNodeType() == Node.ELEMENT_NODE){
                        org.w3c.dom.Element element = (Element)node;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return str;
        }
    }



}
