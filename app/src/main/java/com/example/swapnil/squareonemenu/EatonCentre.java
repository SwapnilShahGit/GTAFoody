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


public class EatonCentre extends Activity {
    String[] list_restaurants = { "A&W", "Akashiro by SUSHI Q", "Amaya Express",
            "Aroma Espresso Bar", "Big Smoke Burger", "Bourbon Street Grill", "Crepe Delicious",
    "Froshberg Gelato", "Extreme Pita", "Fast Fresh Foods", "Jimmy The Greek", "KFC",
            "Liberty Noodle", "McDonald's", "Mucho Burrito", "New York Fries", "Ruby Thai Kitchen",
    "Shanghai 360", "Sbarro", "Subway", "Szechuan Express", "Teriyaki Experience", "Thai Express",
    "Tim Hortons", "Urban Herbivore", "Villa Madina"};

    Integer[] imageId = {R.drawable.image, R.drawable.image2, R.drawable.image, R.drawable.image2,
            R.drawable.image, R.drawable.image2,R.drawable.image, R.drawable.image2,
            R.drawable.image, R.drawable.image2,R.drawable.image, R.drawable.image2,
            R.drawable.image, R.drawable.image2,R.drawable.image, R.drawable.image2,
            R.drawable.image, R.drawable.image2,R.drawable.image, R.drawable.image2,
            R.drawable.image, R.drawable.image2,R.drawable.image, R.drawable.image2,
            R.drawable.image, R.drawable.image2,};


    ListView eatoncentreListView;
    ArrayAdapter eatoncentreAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_square_one);


        eatoncentreListView = (ListView) findViewById(R.id.eatoncentreListView);
        // this-The current activity context.
        // Second param is the resource Id for list layout row item
        // Third param is input array

        eatoncentreAdapter = new SquareOneCustomAdapter(this, list_restaurants, imageId);

        eatoncentreListView = (ListView) findViewById(R.id.squareOneListView);

        eatoncentreListView.setAdapter(eatoncentreAdapter);

        eatoncentreListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String NameOfRow = String.valueOf(parent.getItemAtPosition(position));
                        //Toast.makeText(MainActivity.this, item, Toast.LENGTH_LONG).show();
                        try {
                            String NameOfClassString = MainActivity.switchActivity(NameOfRow);
                            Class NameOfClass = Class.forName(NameOfClassString);
                            startActivity(new Intent(EatonCentre.this, NameOfClass));
                        }
                        catch (ClassNotFoundException e){
                            startActivity(new Intent(EatonCentre.this, Starbucks.class));
                        }
                    }
                });


    };
}
