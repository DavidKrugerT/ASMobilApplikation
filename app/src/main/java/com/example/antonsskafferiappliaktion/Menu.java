package com.example.antonsskafferiappliaktion;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Menu {
    //List<Dish> tmpDishes = new ArrayList<>();
    private List<Integer> alreadyFetchedDishes = new ArrayList<>();

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    //private final Object Dish;
    private List<Dish> dishes = new ArrayList<Dish>();


    public void addFood(Dish food) {
        dishes.add(food);
    }


    public Dish getTheFoodsAtPos(int i) {
        return dishes.get(i);
    }

    public Menu() {

        HttpGetRequest httpGetRequest = new HttpGetRequest();
        httpGetRequest.execute();

    }
   class HttpGetRequest extends AsyncTask<Void, Void, Void> {
        //Some url endpoint that you may have
        private String apiUrl = "http://10.250.124.20:8080/Project-WebApp/webresources/entity.menu";
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
                    dishes = parser(strXml);

                   // System.out.println("Root elementhhhhhhhhhhhhhh :" + dishes);

                } finally {
                    conn.disconnect();
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            return null
                    ;
        }

        @Override
        protected void onPostExecute(Void result){
            super.onPostExecute(result);
        }

        /**
         *
         * @param str
         * @return
         * @throws JSONException
         */
        private List<Dish> parser(String str) throws JSONException {
            Menu menu = new Menu();
            List<Dish> tmpDishes = new ArrayList<>();
            JSONArray jArray = new JSONArray(str);
            for (int i = 0; i < jArray.length(); i++) {
                Dish tmpDish = new Dish();
                JSONObject jObject = jArray.getJSONObject(i);

                tmpDish.setName(jObject.getString("name"));
                tmpDish.setPrice(jObject.getDouble("price"));
                tmpDish.setCookingTime(jObject.getInt("cookingTime"));
                tmpDishes.add(tmpDish);

            }
            return tmpDishes;
        }
    }

}
