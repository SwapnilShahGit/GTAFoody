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

    Integer[] imageId = {R.drawable.image, R.drawable.image2, R.drawable.image, R.drawable.image, R.drawable.image, R.drawable.image, R.drawable.image,};


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
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                        String NameOfRow = String.valueOf(parent.getItemAtPosition(position));
                        //Toast.makeText(MainActivity.this, item, Toast.LENGTH_LONG).show();

                        try {
                            String NameOfClassString = switchActivity(NameOfRow);
                            Class NameOfClass = Class.forName(NameOfClassString);
                            startActivity(new Intent(MainActivity.this, NameOfClass));
                        }
                        catch (ClassNotFoundException e){
                            startActivity(new Intent(MainActivity.this, Starbucks.class));
                        }


                    }

                    ;
                });
    }


    public String switchActivity(String item) {

                switch (item) {
                    case "Square One":
                        return "com.example.swapnil.squareonemenu.SquareOne";
                    case "Mapleview":
                        return "com.example.swapnil.squareonemenu.Mapleview";
                    case "Burlington Mall":
                        return "com.example.swapnil.squareonemenu.BurlingtonMall";
                    }
                return "KFC";
            }

}