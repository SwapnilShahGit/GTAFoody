package com.example.swapnil.squareonemenu;

/**
 * Created by Swapnil on 5/28/2015.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class SquareOne extends Activity {
    String[] list_restaurants = { "A&W", "Amaya Express",
            "Basil Box", "Big Smoke Burger", "Bourbon Street Grill", "Burger King",
            "Charley's Steakery", "Chipotle", "Cinnabon",
            "Cultures", "Dairy Queen/Orange Julius", "Jimmy The Greek", "KFC", "Manchu Wok",
            "Mrs.Vanelli's", "New York Fries", "Shanghai 360", "Starbucks", "Su & Shi", "Sushi-Q",
            "Szechuan Express", "Taco Bell", "Teriyaki Experience", "Thai Express", "Villa Madina"};

    Integer[] imageId = {R.drawable.image, R.drawable.image2, R.drawable.image,R.drawable.image,
            R.drawable.image,R.drawable.image,R.drawable.image,R.drawable.image, R.drawable.image2,
            R.drawable.image,R.drawable.image,R.drawable.image,R.drawable.image,R.drawable.image,
            R.drawable.image, R.drawable.image2, R.drawable.image,R.drawable.image,R.drawable.image,
            R.drawable.image,R.drawable.image,R.drawable.image,R.drawable.image,
            R.drawable.image,R.drawable.image};


    ListView foodyListView;
    ArrayAdapter foodyAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        foodyListView = (ListView) findViewById(R.id.foodyListView);
        // this-The current activity context.
        // Second param is the resource Id for list layout row item
        // Third param is input array

        foodyAdapter = new CustomAdapter(this, list_restaurants, imageId);

        foodyListView = (ListView) findViewById(R.id.foodyListView);

        foodyListView.setAdapter(foodyAdapter);

        foodyListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String item = String.valueOf(parent.getItemAtPosition(position));
                        //Toast.makeText(MainActivity.this, item, Toast.LENGTH_LONG).show();
                        try {
                            Class item2 = Class.forName(item);
                            startActivity(new Intent(SquareOne.this, item2));
                        } catch (ClassNotFoundException e) {
                            return;
                        }
                    }
                    });


                };
    }
