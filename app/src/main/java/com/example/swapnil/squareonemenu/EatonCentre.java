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


public class EatonCentre extends Activity {
    String[] list_restaurants = { "A&W", "Akashiro by SUSHI Q", "Amaya Express",
            "Aroma Espresso Bar", "Big Smoke Burger", "Bourbon Street Grill", "Crepe Delicious",
    "Froshberg Gelato", "Extreme Pita", "Fast Fresh Foods", "Jimmy The Greek", "KFC",
            "Liberty Noodle", "McDonald's", "Mucho Burrito", "New York Fries", "Ruby Thai Kitchen",
    "Shanghai 360", "Sbarro", "Subway", "Szechuan Express", "Teriyaki Experience", "Thai Express",
    "Tim Hortons", "Urban Herbivore", "Villa Madina"};

    Integer[] imageId = {R.drawable.image, R.drawable.image2, R.drawable.image, R.drawable.image2,
            R.drawable.image, R.drawable.image2,R.drawable.image, R.drawable.image2,
            R.drawable.image, R.drawable.image2,R.drawable.image, R.drawable.image2,
            R.drawable.image, R.drawable.image2,R.drawable.image, R.drawable.image2,
            R.drawable.image, R.drawable.image2,R.drawable.image, R.drawable.image2,
            R.drawable.image, R.drawable.image2,R.drawable.image, R.drawable.image2,
            R.drawable.image, R.drawable.image2,};


    ListView eatoncentreListView;
    ArrayAdapter eatoncentreAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_square_one);


        eatoncentreListView = (ListView) findViewById(R.id.eatoncentreListView);
        // this-The current activity context.
        // Second param is the resource Id for list layout row item
        // Third param is input array

        eatoncentreAdapter = new SquareOne.SquareOneCustomAdapter(this, list_restaurants, imageId);

        eatoncentreListView = (ListView) findViewById(R.id.squareOneListView);

        eatoncentreListView.setAdapter(eatoncentreAdapter);

        eatoncentreListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String NameOfRow = String.valueOf(parent.getItemAtPosition(position));
                        //Toast.makeText(MainActivity.this, item, Toast.LENGTH_LONG).show();
                        try {
                            String NameOfClassString = MainActivity.switchActivity(NameOfRow);
                            Class NameOfClass = Class.forName(NameOfClassString);
                            startActivity(new Intent(EatonCentre.this, NameOfClass));
                        }
                        catch (ClassNotFoundException e){
                            startActivity(new Intent(EatonCentre.this, MainActivity.class));
                        }
                    }
                });


    };

    public static class EatonCentreCustomAdapter extends ArrayAdapter<String>{

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
        EatonCentreCustomAdapter(Context context, String[] restaurants, Integer[] images) {

            super(context, R.layout.eatoncentrecustomrow, restaurants);
            font= Typeface.createFromAsset(context.getAssets(), "Roboto-Regular.ttf");
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater squareOneInflater = LayoutInflater.from(getContext());
            View customView = squareOneInflater.inflate(R.layout.eatoncentrecustomrow, parent, false);

            String singleFoodItem = getItem(position);

            TextView eatoncentreText = (TextView) customView.findViewById(R.id.eatoncentrePlaceText);


            ImageView eatoncentreImage = (ImageView) customView.findViewById(R.id.eatoncentrePlaceImage); //buckysImage is after the .id


            eatoncentreText.setText(singleFoodItem);
            eatoncentreText.setTypeface(font);

            eatoncentreImage.setImageResource(imageId[position]);
            return customView;
        }
    }
}
