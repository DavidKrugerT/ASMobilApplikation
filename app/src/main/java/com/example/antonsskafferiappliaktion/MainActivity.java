package com.example.antonsskafferiappliaktion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.snackbar.Snackbar;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    //Dialog tableStatus;
    public static Order order;
    public static Menu menu = new Menu();
    public static int orderNumber;
    public static List<Integer> finishedOrders = new ArrayList<>();
    public static Button popTableButton;
    private Timer timer = new Timer();
    private List<Integer> tableOrderReady = new ArrayList<>();
    ListView listOrderReadyV;
    ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        MyTimerTask timerTask = new MyTimerTask();
        timer.schedule(timerTask, 2000, 3000);

        arrayAdapter = new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,tableOrderReady);

        orderNumber = 0;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //tableStatus = new Dialog(this);

        Button button2schedule = findViewById(R.id.button2schedule);
        button2schedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, schduleActivity.class);
                startActivity(intent);
            }
        });
        Button tableButton1 = findViewById(R.id.popUp_btn1);
        Button tableButton2 = findViewById(R.id.popUp_btn2);
        Button tableButton3 = findViewById(R.id.popUp_btn3);
        Button tableButton4 = findViewById(R.id.popUp_btn4);
        Button tableButton5 = findViewById(R.id.popUp_btn5);
        Button tableButton6 = findViewById(R.id.popUp_btn6);
        //updateTableStatus = findViewById(R.id.updateTableStatus);
        listOrderReadyV = findViewById(R.id.listOrderReadyView);
        Button popTableButton = findViewById(R.id.popDeliveredTableButton);

        popTableButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tableOrderReady.remove(0);
                arrayAdapter.notifyDataSetChanged();
            }
        });
        //Knapp Bord öppnar PopUpActivity
        tableButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                order= new Order();
                order.setBordsNummer(1);
                Intent intent = new Intent(MainActivity.this, PopUpActivity.class);
                startActivity(intent);
            }
        });
        tableButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                order = new Order();
                order.setBordsNummer(2);
                Intent intent = new Intent(MainActivity.this, PopUpActivity.class);
                startActivity(intent);
            }
        });
        tableButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                order = new Order();
                order.setBordsNummer(3);
                Intent intent = new Intent(MainActivity.this, PopUpActivity.class);
                startActivity(intent);
            }
        });
        tableButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                order = new Order();
                order.setBordsNummer(4);
                Intent intent = new Intent(MainActivity.this, PopUpActivity.class);
                startActivity(intent);
            }
        });
        tableButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                order = new Order();
                order.setBordsNummer(5);
                Intent intent = new Intent(MainActivity.this, PopUpActivity.class);
                startActivity(intent);
            }
        });
        tableButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                order = new Order();
                order.setBordsNummer(6);
                Intent intent = new Intent(MainActivity.this, PopUpActivity.class);
                startActivity(intent);
            }
        });
    }

        class MyTimerTask extends TimerTask {
            @Override
            public void run() {
                try {
                    CheckForFinishedDishes checkForFinishedDishes = new CheckForFinishedDishes();
                    checkForFinishedDishes.execute();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        }

        class CheckForFinishedDishes extends AsyncTask<Void, Void, Void> {
            URL url = new URL("http://10.250.119.132:8080/Project-WebApp/webresources/entity.dish/");
            InputStream in = null;
            String tables="";
            CheckForFinishedDishes() throws MalformedURLException {
            }

            @Override
            protected Void doInBackground(Void... voids) {
                try {
                    String jsonString = getAllFromApi();
                    JSONArray jsonArray = new JSONArray(jsonString);
                    for(int i = 0; i < jsonArray.length(); i++){
                        JSONObject dish = jsonArray.getJSONObject(i);
                        if(dish.getBoolean("done") && !finishedOrders.contains(dish.getInt("orderNumber"))){
                            finishedOrders.add(dish.getInt("orderNumber"));
                            tableOrderReady.add(dish.getInt("tableNumber"));
                            System.out.println("------------tableNumber---------------"+dish.getString("tableNumber"));
                        }

                    }
                } catch (IOException | JSONException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                for(Integer i : tableOrderReady){
                    tables = tables +", "+ i.toString();
                }
                Toast toast = Toast.makeText(MainActivity.this, "Food is ready for tables:"+tables, Toast.LENGTH_LONG);
                toast.show();
                listOrderReadyV.setAdapter(arrayAdapter);
                arrayAdapter.notifyDataSetChanged();
                super.onPostExecute(aVoid);
            }

            private String getAllFromApi() throws IOException {
                HttpURLConnection conn = (HttpURLConnection)url.openConnection();
                conn.setRequestProperty("Accept","application/json");

                System.out.println("---------------------------------"+conn.getResponseCode());
                conn.setRequestMethod("GET");
                in = new BufferedInputStream(conn.getInputStream());
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                String line;
                StringBuilder sb = new StringBuilder();
                while ((line = reader.readLine()) != null){
                    sb.append(line).append("\n");
                }
                reader.close();
                System.out.println(sb.toString());
                return sb.toString();
            }
        }

}
