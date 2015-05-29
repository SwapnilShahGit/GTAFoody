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


public class SherwayGardens extends Activity {
    String[] list_restaurants = { "Bento", "Caribbean Queen", "Crepe Delicious", "Cultures",
            "Famous Wok", "Hero Burger", "Jimmy The Greek", "McDonald's", "Michel's Baguette",
    "New York Fries", "Subway", "Taco Bell", "KFC", "Teriyaki Experience", "Thai Express",
    "Tim Hortons", "Villa Madina"};

    Integer[] imageId = {R.drawable.image, R.drawable.image2, R.drawable.image, R.drawable.image2,
            R.drawable.image, R.drawable.image2,
            R.drawable.image, R.drawable.image2,
            R.drawable.image, R.drawable.image2,
            R.drawable.image, R.drawable.image2,
            R.drawable.image, R.drawable.image2,
            R.drawable.image, R.drawable.image2,
            R.drawable.image, R.drawable.image2,
            R.drawable.image, R.drawable.image2,};
    ListView sherwaygardensListView;
    ArrayAdapter sherwargaydensAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sherway_gardens);


        sherwaygardensListView = (ListView) findViewById(R.id.sherwaygardensListView);
        // this-The current activity context.
        // Second param is the resource Id for list layout row item
        // Third param is input array

        sherwargaydensAdapter = new SquareOneCustomAdapter(this, list_restaurants, imageId);

        sherwaygardensListView = (ListView) findViewById(R.id.sherwaygardensListView);

        sherwaygardensListView.setAdapter(sherwargaydensAdapter);

        sherwaygardensListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String NameOfRow = String.valueOf(parent.getItemAtPosition(position));
                        //Toast.makeText(MainActivity.this, item, Toast.LENGTH_LONG).show();
                        try {
                            String NameOfClassString = MainActivity.switchActivity(NameOfRow);
                            Class NameOfClass = Class.forName(NameOfClassString);
                            startActivity(new Intent(SherwayGardens.this, NameOfClass));
                        }
                        catch (ClassNotFoundException e){
                            startActivity(new Intent(SherwayGardens.this, Starbucks.class));
                        }
                    }
                });


    };
}
