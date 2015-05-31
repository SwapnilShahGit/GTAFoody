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


public class YorkdaleMall extends Activity {
    String[] list_restaurants = { "A&W", "Amaya Express", "Big Smoke Burger", "Booster Juice",
    "Chipotle Mexican Grill", "DAVIDsTEA", "Espressamente illy", "Famoso Neapolitan Pizzeria",
    "Freshly Squeezed", "Godiva Chocolatier", "Holts Cafe", "Jamba Juice", "Jimmy The Greek",
    "Kernels Popcorn", "KFC", "La Paloma Gelateria & Cafe", "Mac's Sushi", "Manchu Wok",
    "MICHEL's Bakery Cafe", "MII Sandwich Store", "Milestone's Grill & Bar", "Moxie's Classic Grill"
    , "New York Fries", "Pickel Barrel Grand", "Purdys Chocolatier", "Second Cup", "Shanghai 360",
    "Starbucks", "Subway", "SU&SHI Noodle Bar", "Teavana", "Ten Ren's Tea Time",
            "Teriyaki Experience", "Thai Express", "Tim Hortons", "Villa Madina", "Yogen Fruz"};

    Integer[] imageId = {R.drawable.image, R.drawable.image,
            R.drawable.image, R.drawable.image2,
            R.drawable.image, R.drawable.image2,
            R.drawable.image, R.drawable.image2,
            R.drawable.image, R.drawable.image2,
            R.drawable.image, R.drawable.image2,
            R.drawable.image, R.drawable.image2,
            R.drawable.image, R.drawable.image2,
            R.drawable.image, R.drawable.image2,
            R.drawable.image, R.drawable.image2,
            R.drawable.image, R.drawable.image2,
            R.drawable.image, R.drawable.image2,
            R.drawable.image, R.drawable.image2,
            R.drawable.image, R.drawable.image2,
            R.drawable.image, R.drawable.image2,
            R.drawable.image, R.drawable.image2,
            R.drawable.image, R.drawable.image2,R.drawable.image, R.drawable.image2,
            R.drawable.image, R.drawable.image2,
            R.drawable.image, R.drawable.image2,


    };


    ListView yorkdaleListView;
    ArrayAdapter yorkdaleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yorkdale_mall);


        yorkdaleListView = (ListView) findViewById(R.id.yorkdaleListView);
        // this-The current activity context.
        // Second param is the resource Id for list layout row item
        // Third param is input array

        yorkdaleAdapter = new SquareOne.SquareOneCustomAdapter(this, list_restaurants, imageId);

        yorkdaleListView.setAdapter(yorkdaleAdapter);

        yorkdaleListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String NameOfRow = String.valueOf(parent.getItemAtPosition(position));
                        //Toast.makeText(MainActivity.this, item, Toast.LENGTH_LONG).show();
                        try {
                            String NameOfClassString = MainActivity.switchActivity(NameOfRow);
                            Class NameOfClass = Class.forName(NameOfClassString);
                            startActivity(new Intent(YorkdaleMall.this, NameOfClass));
                        }
                        catch (ClassNotFoundException e){
                            startActivity(new Intent(YorkdaleMall.this, MainActivity.class));
                        }
                    }
                });


    };

    public static class YorkdaleMallCustomAdapter extends ArrayAdapter<String>  {

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
        YorkdaleMallCustomAdapter(Context context, String[] restaurants, Integer[] images) {

        super(context, R.layout.yorkdalecustomrow, restaurants);
        font= Typeface.createFromAsset(context.getAssets(), "Roboto-Regular.ttf");

        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater squareOneInflater = LayoutInflater.from(getContext());
            View customView = squareOneInflater.inflate(R.layout.yorkdalecustomrow, parent, false);

            String singleFoodItem = getItem(position);

            TextView yorkdalemallText = (TextView) customView.findViewById(R.id.yorkdalePlaceText);


            ImageView yorkdalemallImage = (ImageView) customView.findViewById(R.id.yorkdalePlaceImage); //buckysImage is after the .id


            yorkdalemallText.setText(singleFoodItem);
            yorkdalemallText.setTypeface(font);

            yorkdalemallImage.setImageResource(imageId[position]);
            return customView;
        }
    }
}
