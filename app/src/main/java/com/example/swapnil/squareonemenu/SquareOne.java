package com.example.swapnil.squareonemenu;

/**
 * Created by Swapnil on 5/28/2015.
 */

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


public class    SquareOne extends Activity {
    String[] list_restaurants = { "A&W", "Amaya Express",
            "Basil Box", "Big Smoke Burger", "Bourbon Street Grill", "Burger King",
            "Charley's Steakery", "Chipotle", "Cinnabon",
            "Cultures", "Dairy Queen", "Orange Julius", "Jimmy The Greek", "KFC", "Manchu Wok",
            "Mrs.Vanelli's", "New York Fries", "Shanghai 360", "Starbucks", "Su & Shi", "Sushi-Q",
            "Szechuan Express", "Taco Bell", "Teriyaki Experience", "Thai Express", "Villa Madina"};

    Integer[] imageId = {R.drawable.image, R.drawable.image2, R.drawable.image,R.drawable.image,
            R.drawable.image,R.drawable.image,R.drawable.image,R.drawable.image, R.drawable.image2,
            R.drawable.image,R.drawable.image,R.drawable.image,R.drawable.image,R.drawable.image,
            R.drawable.image, R.drawable.image2, R.drawable.image,R.drawable.image,R.drawable.image,
            R.drawable.image,R.drawable.image,R.drawable.image,R.drawable.image,
            R.drawable.image,R.drawable.image};


    ListView squareOneListView;
    ArrayAdapter squareOneAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_square_one);


        squareOneListView = (ListView) findViewById(R.id.squareOneListView);
        // this-The current activity context.
        // Second param is the resource Id for list layout row item
        // Third param is input array

        squareOneAdapter = new SquareOneCustomAdapter(this, list_restaurants, imageId);

        squareOneListView = (ListView) findViewById(R.id.squareOneListView);

        squareOneListView.setAdapter(squareOneAdapter);

        squareOneListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String NameOfRow = String.valueOf(parent.getItemAtPosition(position));
                        //Toast.makeText(MainActivity.this, item, Toast.LENGTH_LONG).show();
                        try {
                            String NameOfClassString = MainActivity.switchActivity(NameOfRow);
                            Class NameOfClass = Class.forName(NameOfClassString);
                            startActivity(new Intent(SquareOne.this, NameOfClass));
                        }
                        catch (ClassNotFoundException e){
                            startActivity(new Intent(SquareOne.this, MainActivity.class));
                        }
                    }
                    });


                };

    static class SquareOneCustomAdapter extends ArrayAdapter<String> {

        Integer[] imageId = {R.drawable.aw, R.drawable.amaya, R.drawable.image3,
                R.drawable.bigsmokeburger,
                R.drawable.image3,R.drawable.image3,R.drawable.image3,R.drawable.image3, R.drawable.image3,
                R.drawable.image3,R.drawable.image3,R.drawable.image3,R.drawable.image3,R.drawable.image3,
                R.drawable.image3, R.drawable.image3, R.drawable.image3,R.drawable.image3,R.drawable.image3,
                R.drawable.image3,R.drawable.image3,R.drawable.image3,R.drawable.image3,
                R.drawable.image3,R.drawable.image3, R.drawable.image3,R.drawable.image3,
                R.drawable.image3,R.drawable.image3, R.drawable.image3,R.drawable.image3,
                R.drawable.image3,R.drawable.image3, R.drawable.image3,R.drawable.image3,
                R.drawable.image3,R.drawable.image3};

        Typeface font;
        SquareOneCustomAdapter(Context context, String[] restaurants, Integer[] images) {

            super(context, R.layout.squareonecustomrow, restaurants);
            font= Typeface.createFromAsset(context.getAssets(), "Roboto-Regular.ttf");
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater squareOneInflater = LayoutInflater.from(getContext());
            View customView = squareOneInflater.inflate(R.layout.squareonecustomrow, parent, false);

            String singleFoodItem = getItem(position);

            TextView squareOneText = (TextView) customView.findViewById(R.id.squareOnePlaceText);


            ImageView squareOneImage = (ImageView) customView.findViewById(R.id.squareOnePlaceImage); //buckysImage is after the .id


            squareOneText.setText(singleFoodItem);
            squareOneText.setTypeface(font);

            squareOneImage.setImageResource(imageId[position]);
            return customView;
        }
    }
}
