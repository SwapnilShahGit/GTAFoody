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


public class BurlingtonMall extends Activity {
    String[] list_restaurants = { "A&W", "Jimmy The Greek", "Thai Express", "New York Fries",
            "Taco Bell", "Mr.Sub", "Koya Japan", "Tim Hortons", "Sakura Ichiban Express",
            "Freshly Squeezed", "Rocky Mountain Chocolate Factory", "Kernels Popcorn"};

    Integer[] imageId = {R.drawable.image, R.drawable.image2,R.drawable.image,
            R.drawable.image2,R.drawable.image, R.drawable.image2,R.drawable.image,
            R.drawable.image2,R.drawable.image, R.drawable.image2,R.drawable.image,
            R.drawable.image2,};


    ListView burlingtonmallListView;
    ArrayAdapter burlingtonmallAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_square_one);


        burlingtonmallListView = (ListView) findViewById(R.id.burlingtonmallListView);
        // this-The current activity context.
        // Second param is the resource Id for list layout row item
        // Third param is input array

        burlingtonmallAdapter = new SquareOneCustomAdapter(this, list_restaurants, imageId);

        burlingtonmallListView = (ListView) findViewById(R.id.squareOneListView);

        burlingtonmallListView.setAdapter(burlingtonmallAdapter);

        burlingtonmallListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String NameOfRow = String.valueOf(parent.getItemAtPosition(position));
                        //Toast.makeText(MainActivity.this, item, Toast.LENGTH_LONG).show();
                        try {
                            String NameOfClassString = MainActivity.switchActivity(NameOfRow);
                            Class NameOfClass = Class.forName(NameOfClassString);
                            startActivity(new Intent(BurlingtonMall.this, NameOfClass));
                        }
                        catch (ClassNotFoundException e){
                            startActivity(new Intent(BurlingtonMall.this, Starbucks.class));
                        }
                    }
                });


    };
}
