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


public class ErinMillsTownCentre extends Activity {
    String[] list_restaurants = { "A&W", "Bourbon Street Grill", "Dairy Queen", "Fit for Life",
            "Fresh East", "Hero Burgers", "Jimmy The Greek", "KFC", "Mac's Sushi", "New York Fries",
    "Starbucks Coffee", "Subway", "Taco Bell", "KFC", "Teriyaki Experience", "Thai Express",
            "Tim Horton's", "Tim Horton's/Wendy's"};

    Integer[] imageId = {R.drawable.image, R.drawable.image2,R.drawable.image,
            R.drawable.image2,R.drawable.image, R.drawable.image2,R.drawable.image,
            R.drawable.image2,R.drawable.image, R.drawable.image2,R.drawable.image,
            R.drawable.image2,R.drawable.image, R.drawable.image2,R.drawable.image,
            R.drawable.image2,R.drawable.image, R.drawable.image};


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
                        String NameOfRow = String.valueOf(parent.getItemAtPosition(position));
                        //Toast.makeText(MainActivity.this, item, Toast.LENGTH_LONG).show();
                        try {
                            String NameOfClassString = MainActivity.switchActivity(NameOfRow);
                            Class NameOfClass = Class.forName(NameOfClassString);
                            startActivity(new Intent(ErinMillsTownCentre.this, NameOfClass));
                        }
                        catch (ClassNotFoundException e){
                            startActivity(new Intent(ErinMillsTownCentre.this, Starbucks.class));
                        }
                    }
                });


    };
}