package com.example.swapnil.squareonemenu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {
    String[] list_restaurants = {"Square One", "Mapleview", "Burlington Mall", "Eaton Centre",
            "Sherway Gardens", "Yorkdale Mall", "Erin Mills Centre"};

    Integer[] imageId = {R.drawable.image, R.drawable.image2, R.drawable.image,R.drawable.image,R.drawable.image,R.drawable.image,R.drawable.image,};


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
                        //switchActivity(MainActivity.class, item);
                        switch (item) {
                            case "Square One":
                                startActivity(new Intent(MainActivity.this, SquareOne.class));
                                break;
                            case "Mapleview":
                                startActivity(new Intent(MainActivity.this, Mapleview.class));
                                break;
                            case "Erin Mills Centre":
                                startActivity(new Intent(MainActivity.this,
                                        ErinMillsTownCentre.class));
                                break;
                            case "Burlington Mall":
                                startActivity(new Intent(MainActivity.this,
                                        BurlingtonMall.class));
                                break;
                            case "Eaton Centre":
                                startActivity(new Intent(MainActivity.this,
                                        EatonCentre.class));
                                break;
                            case "Sherway Gardens":
                                startActivity(new Intent(MainActivity.this,
                                        SherwayGardens.class));
                                break;
                            case "Yorkdale Mall":
                                startActivity(new Intent(MainActivity.this,
                                        YorkdaleMall.class));
                                break;
                        }
                    }

                    ;
                });
    }

    public void switchActivity(class classname, char item){

    }
}