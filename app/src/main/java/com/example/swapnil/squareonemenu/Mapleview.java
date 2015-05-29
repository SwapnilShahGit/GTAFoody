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


public class Mapleview extends Activity {
    String[] list_restaurants = { "Dairy Queen/Orange Julius", "Earls Kitchen & Bar",
            "Godiva Chocolatier", "Jugo Juice", "Kernels", "Purdy's Chocolates",
            "Sakura Ichiban Express", "Second Cup", "Starbucks", "Teavana",
            "Turtle Jack's Muskoka Grill", "A&W", "Cultures", "Extreme Pita", "Jimmy The Greek",
    " KFC/Taco Bell", "Manchu Wok", "Mr.Sub", "New York Fries", "Ruby Thai Kitchen",
            "Teriyaki Experience", "Tim Horton's", "Villa Madina", "Mediterranean", "Cuisine"};

    Integer[] imageId = {R.drawable.image, R.drawable.image2, R.drawable.image,R.drawable.image,
            R.drawable.image,R.drawable.image,R.drawable.image,R.drawable.image, R.drawable.image2,
            R.drawable.image,R.drawable.image,R.drawable.image,R.drawable.image,R.drawable.image,
            R.drawable.image, R.drawable.image2, R.drawable.image,R.drawable.image,R.drawable.image,
            R.drawable.image,R.drawable.image,R.drawable.image,R.drawable.image,
            R.drawable.image,R.drawable.image};


    ListView mapleviewListView;
    ArrayAdapter mapleviewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapleview);


        mapleviewListView = (ListView) findViewById(R.id.mapleviewListView);
        // this-The current activity context.
        // Second param is the resource Id for list layout row item
        // Third param is input array

        mapleviewAdapter = new SquareOneCustomAdapter(this, list_restaurants, imageId);

        mapleviewListView = (ListView) findViewById(R.id.mapleviewListView);

        mapleviewListView.setAdapter(mapleviewAdapter);

        mapleviewListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String NameOfRow = String.valueOf(parent.getItemAtPosition(position));
                        //Toast.makeText(MainActivity.this, item, Toast.LENGTH_LONG).show();
                        try {
                            String NameOfClassString = MainActivity.switchActivity(NameOfRow);
                            Class NameOfClass = Class.forName(NameOfClassString);
                            startActivity(new Intent(Mapleview.this, NameOfClass));
                        }
                        catch (ClassNotFoundException e){
                            startActivity(new Intent(Mapleview.this, Starbucks.class));
                        }
                    }
                });


    };
}
