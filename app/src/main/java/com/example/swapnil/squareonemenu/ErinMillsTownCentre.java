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

    ListView erinmillstowncentreListView;
    ArrayAdapter erinmillstowncentreAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_erin_mills_town_centre);


        erinmillstowncentreListView = (ListView) findViewById(R.id.erinmillstowncentreListView);
        // this-The current activity context.
        // Second param is the resource Id for list layout row item
        // Third param is input array

        erinmillstowncentreAdapter = new SquareOne.SquareOneCustomAdapter(this, list_restaurants, imageId);

        erinmillstowncentreListView = (ListView) findViewById(R.id.erinmillstowncentreListView);

        erinmillstowncentreListView.setAdapter(erinmillstowncentreAdapter);

        erinmillstowncentreListView.setOnItemClickListener(
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
                            startActivity(new Intent(ErinMillsTownCentre.this, MainActivity.class));
                        }
                    }
                });


    };

    public static class ErinMillsTownCentreCustomAdapter extends ArrayAdapter<String>{

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
        ErinMillsTownCentreCustomAdapter(Context context, String[] restaurants, Integer[] images) {

            super(context, R.layout.erinmillstowncentrecustomrow, restaurants);
            font= Typeface.createFromAsset(context.getAssets(), "Roboto-Regular.ttf");
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater squareOneInflater = LayoutInflater.from(getContext());
            View customView = squareOneInflater.inflate(R.layout.erinmillstowncentrecustomrow, parent, false);

            String singleFoodItem = getItem(position);

            TextView erinmillstowncentreText = (TextView) customView.findViewById(R.id.erinmillstowncentrePlaceText);


            ImageView erinmillstowncentreImage = (ImageView) customView.findViewById(R.id.erinmillstowncentrePlaceImage); //buckysImage is after the .id


            erinmillstowncentreText.setText(singleFoodItem);
            erinmillstowncentreText.setTypeface(font);

            erinmillstowncentreImage.setImageResource(imageId[position]);
            return customView;
        }
    }
}
