package com.example.swapnil.squareonemenu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {
    String[] list_restaurants = {"Burrito Bowl", "Amaya Express"};

    Integer[] imageId = {R.drawable.image, R.drawable.image2};


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
                new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String item = String.valueOf(parent.getItemAtPosition(position));
                        //Toast.makeText(MainActivity.this, item, Toast.LENGTH_LONG).show();
                        switch(item) {
                            case "Amaya Express":
                                startActivity(new Intent(MainActivity.this, Amaya_Express.class));
                                break;
                            case "A&W":
                                startActivity(new Intent(MainActivity.this, AW.class));
                                break;
                            case "Basil Box":
                                startActivity(new Intent(MainActivity.this, Basil_Box.class));
                                break;
                            case "Big Smoke Burger":
                                startActivity(new Intent(MainActivity.this, Big_Smoke_Burger.class));
                                break;
                            case "Bourbon Street Grill":
                                startActivity(new Intent(MainActivity.this, Bourbon_Street_Grill.class));
                                break;
                        }
                    }
                });
    }
}