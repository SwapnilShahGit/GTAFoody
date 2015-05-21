package com.example.swapnil.squareonemenu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Hashtable;



public class MainActivity extends Activity {


    private String[] monthsArray = { "A&W", "Amaya Express",
            "Basil Box", "Big Smoke Burger", "Bourbon Street Grill", "Burger King",
            "Charley's Steakery", "Chipotle", "Cinnabon",
            "Cultures", "Dairy Queen/Orange Julius", "Jimmy The Greek", "KFC", "Manchu Wok",
            "Mrs.Vanelli's", "New York Fries", "Shanghai 360", "Starbucks", "Su & Shi", "Sushi-Q",
            "Szechuan Express", "Taco Bell", "Teriyaki Experience", "Thai Express", "Villa Madina"};

    private Hashtable<String, String> foodTable  = new Hashtable<String, String>();
    

    private ListView monthsListView;
    private ArrayAdapter arrayAdapter;



    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        monthsListView = (ListView) findViewById(R.id.months_list);

        // this-The current activity context.
        // Second param is the resource Id for list layout row item
        // Third param is input array
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, monthsArray);
        monthsListView.setAdapter(arrayAdapter);

        monthsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = ((TextView)view).getText().toString();

                //Toast.makeText(getBaseContext(), item, Toast.LENGTH_LONG).show();

                startActivity(new Intent(MainActivity.this, chipotle.class));
            }
        });
    }
}
