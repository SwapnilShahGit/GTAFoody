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


public class YorkdaleMall extends Activity {
    String[] list_restaurants = { "A&W", "Amaya Express", "Big Smoke Burger", "Booster Juice",
    "Chipotle Mexican Grill", "DAVIDsTEA", "Espressamente illy", "Famoso Neapolitan Pizzeria",
    "Freshly Squeezed", "Godiva Chocolatier", "Holts Cafe", "Jamba Juice", "Jimmy The Greek",
    "Kernels Popcorn", "KFC", "La Paloma Gelateria & Cafe", "Mac's Sushi", "Manchu Wok",
    "MICHEL's Bakery Cafe", "MII Sandwich Store", "Milestone's Grill & Bar", "Moxie's Classic Grill"
    , "New York Fries", "Pickel Barrel Grand", "Purdys Chocolatier", "Second Cup", "Shanghai 360",
    "Starbucks", "Subway", "SU&SHI Noodle Bar", "Teavana", "Ten Ren's Tea Time",
            "Teriyaki Experience", "Thai Express", "Tim Hortons", "Villa Madina", "Yogen Fruz"};

    Integer[] imageId = {R.drawable.image, R.drawable.image,
            R.drawable.image, R.drawable.image2,
            R.drawable.image, R.drawable.image2,
            R.drawable.image, R.drawable.image2,
            R.drawable.image, R.drawable.image2,
            R.drawable.image, R.drawable.image2,
            R.drawable.image, R.drawable.image2,
            R.drawable.image, R.drawable.image2,
            R.drawable.image, R.drawable.image2,
            R.drawable.image, R.drawable.image2,
            R.drawable.image, R.drawable.image2,
            R.drawable.image, R.drawable.image2,
            R.drawable.image, R.drawable.image2,
            R.drawable.image, R.drawable.image2,
            R.drawable.image, R.drawable.image2,
            R.drawable.image, R.drawable.image2,
            R.drawable.image, R.drawable.image2,R.drawable.image, R.drawable.image2,
            R.drawable.image, R.drawable.image2,
            R.drawable.image, R.drawable.image2,


    };


    ListView yorkdaleListView;
    ArrayAdapter yorkdaleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yorkdale_mall);


        yorkdaleListView = (ListView) findViewById(R.id.yorkdaleListView);
        // this-The current activity context.
        // Second param is the resource Id for list layout row item
        // Third param is input array

        yorkdaleAdapter = new SquareOneCustomAdapter(this, list_restaurants, imageId);

        yorkdaleListView.setAdapter(yorkdaleAdapter);

        yorkdaleListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String NameOfRow = String.valueOf(parent.getItemAtPosition(position));
                        //Toast.makeText(MainActivity.this, item, Toast.LENGTH_LONG).show();
                        try {
                            String NameOfClassString = MainActivity.switchActivity(NameOfRow);
                            Class NameOfClass = Class.forName(NameOfClassString);
                            startActivity(new Intent(YorkdaleMall.this, NameOfClass));
                        }
                        catch (ClassNotFoundException e){
                            startActivity(new Intent(YorkdaleMall.this, Starbucks.class));
                        }
                    }
                });


    };
}
