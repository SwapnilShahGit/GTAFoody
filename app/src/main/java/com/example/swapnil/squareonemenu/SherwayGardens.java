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


public class SherwayGardens extends Activity {
    String[] list_restaurants = { "Bento", "Caribbean Queen", "Crepe Delicious", "Cultures",
            "Famous Wok", "Hero Burger", "Jimmy The Greek", "McDonald's", "Michel's Baguette",
    "New York Fries", "Subway", "Taco Bell", "KFC", "Teriyaki Experience", "Thai Express",
    "Tim Hortons", "Villa Madina"};

    Integer[] imageId = {R.drawable.image, R.drawable.image2, R.drawable.image, R.drawable.image2,
            R.drawable.image, R.drawable.image2,
            R.drawable.image, R.drawable.image2,
            R.drawable.image, R.drawable.image2,
            R.drawable.image, R.drawable.image2,
            R.drawable.image, R.drawable.image2,
            R.drawable.image, R.drawable.image2,
            R.drawable.image, R.drawable.image2,
            R.drawable.image, R.drawable.image2,};
    ListView sherwaygardensListView;
    ArrayAdapter sherwargaydensAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sherway_gardens);


        sherwaygardensListView = (ListView) findViewById(R.id.sherwaygardensListView);
        // this-The current activity context.
        // Second param is the resource Id for list layout row item
        // Third param is input array

        sherwargaydensAdapter = new SquareOne.SquareOneCustomAdapter(this, list_restaurants, imageId);

        sherwaygardensListView = (ListView) findViewById(R.id.sherwaygardensListView);

        sherwaygardensListView.setAdapter(sherwargaydensAdapter);

        sherwaygardensListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String NameOfRow = String.valueOf(parent.getItemAtPosition(position));
                        //Toast.makeText(MainActivity.this, item, Toast.LENGTH_LONG).show();
                        try {
                            String NameOfClassString = MainActivity.switchActivity(NameOfRow);
                            Class NameOfClass = Class.forName(NameOfClassString);
                            startActivity(new Intent(SherwayGardens.this, NameOfClass));
                        }
                        catch (ClassNotFoundException e){
                            startActivity(new Intent(SherwayGardens.this, MainActivity.class));
                        }
                    }
                });


    };

    public static class SherwayGardensCustomAdapter extends ArrayAdapter<String>{

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
        SherwayGardensCustomAdapter(Context context, String[] restaurants, Integer[] images) {

            super(context, R.layout.sherwaygardenscustomrow, restaurants);
            font= Typeface.createFromAsset(context.getAssets(), "Roboto-Regular.ttf");
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater squareOneInflater = LayoutInflater.from(getContext());
            View customView = squareOneInflater.inflate(R.layout.sherwaygardenscustomrow, parent, false);

            String singleFoodItem = getItem(position);

            TextView sherwaygardensText = (TextView) customView.findViewById(R.id.sherwaygardensPlaceText);


            ImageView sherwaygardensImage = (ImageView) customView.findViewById(R.id.sherwaygardensPlaceImage); //buckysImage is after the .id


            sherwaygardensText.setText(singleFoodItem);
            sherwaygardensText.setTypeface(font);

            sherwaygardensImage.setImageResource(imageId[position]);
            return customView;
        }
    }
}
