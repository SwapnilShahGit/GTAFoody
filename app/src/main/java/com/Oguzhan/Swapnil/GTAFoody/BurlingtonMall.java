package com.Oguzhan.Swapnil.GTAFoody;

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
import android.widget.Toast;

import java.util.Arrays;


public class BurlingtonMall extends Activity {

    Integer[] imageId = {R.drawable.logo,R.drawable.logo,R.drawable.logo,R.drawable.logo,R.drawable.logo,
            R.drawable.logo,R.drawable.logo,R.drawable.logo,R.drawable.logo,R.drawable.logo,
            R.drawable.logo,R.drawable.logo,R.drawable.logo,R.drawable.logo,R.drawable.logo,
            R.drawable.logo,R.drawable.logo,R.drawable.logo,R.drawable.logo,R.drawable.logo,
            R.drawable.logo,R.drawable.logo,R.drawable.logo,R.drawable.logo,R.drawable.logo,
            R.drawable.logo,R.drawable.logo,R.drawable.logo,R.drawable.logo,R.drawable.logo,
            R.drawable.logo,R.drawable.logo,R.drawable.logo,R.drawable.logo,R.drawable.logo,
            R.drawable.logo,R.drawable.logo,R.drawable.logo,R.drawable.logo,R.drawable.logo};


    ListView burlingtonmallListView;
    ArrayAdapter burlingtonmallAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Arrays.sort(MainActivity.currentrestaurant);
        setContentView(R.layout.activity_burlington_mall);


        burlingtonmallListView = (ListView) findViewById(R.id.burlingtonmallListView);
        // this-The current activity context.
        // Second param is the resource Id for list layout row item
        // Third param is input array

        burlingtonmallAdapter = new BurlingtonMall.BurlingtonMallCustomAdapter(this, MainActivity.currentrestaurant, imageId);

        burlingtonmallListView = (ListView) findViewById(R.id.burlingtonmallListView);

        burlingtonmallListView.setAdapter(burlingtonmallAdapter);

        burlingtonmallListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String NameOfRow = String.valueOf(parent.getItemAtPosition(position));
                        try {
                            String NameOfClassString = MainActivity.switchActivity(NameOfRow);
                            if (MainActivity.URLVariable.equals("None")){
                                Toast.makeText(BurlingtonMall.this, "No Website Found",
                                        Toast.LENGTH_LONG).show();
                            }else{
                                Class NameOfClass = Class.forName(NameOfClassString);
                                startActivity(new Intent(BurlingtonMall.this, NameOfClass));
                            }
                        }
                        catch (ClassNotFoundException e){
                            startActivity(new Intent(BurlingtonMall.this, MainActivity.class));
                        }
                    }
                });


    }

    public static class BurlingtonMallCustomAdapter extends ArrayAdapter<String>{

        Integer[] imageId = {R.drawable.logo,R.drawable.logo,R.drawable.logo,R.drawable.logo,R.drawable.logo,
                R.drawable.logo,R.drawable.logo,R.drawable.logo,R.drawable.logo,R.drawable.logo,
                R.drawable.logo,R.drawable.logo,R.drawable.logo,R.drawable.logo,R.drawable.logo,
                R.drawable.logo,R.drawable.logo,R.drawable.logo,R.drawable.logo,R.drawable.logo,
                R.drawable.logo,R.drawable.logo,R.drawable.logo,R.drawable.logo,R.drawable.logo,
                R.drawable.logo,R.drawable.logo,R.drawable.logo,R.drawable.logo,R.drawable.logo,
                R.drawable.logo,R.drawable.logo,R.drawable.logo,R.drawable.logo,R.drawable.logo,
                R.drawable.logo,R.drawable.logo,R.drawable.logo,R.drawable.logo,R.drawable.logo,
                R.drawable.logo,R.drawable.logo,R.drawable.logo,R.drawable.logo,R.drawable.logo,
                R.drawable.logo,R.drawable.logo,R.drawable.logo,R.drawable.logo,R.drawable.logo,
                R.drawable.logo,R.drawable.logo,R.drawable.logo,R.drawable.logo,R.drawable.logo};


        Typeface font;
        BurlingtonMallCustomAdapter(Context context, String[] restaurants, Integer[] images) {

            super(context, R.layout.burlingtonmallcustomrow, restaurants);
            font= Typeface.createFromAsset(context.getAssets(), "Roboto-Regular.ttf");
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater burlingtonmallInflater = LayoutInflater.from(getContext());
            View customView = burlingtonmallInflater.inflate(R.layout.burlingtonmallcustomrow, parent, false);

            String burlingtonmallItem = getItem(position);

            TextView burlingtonmallText = (TextView) customView.findViewById(R.id.burlingtonmallPlaceText);


            ImageView burlingtonmallImage = (ImageView) customView.findViewById(R.id.burlingtonmallPlaceImage);


            burlingtonmallText.setText(burlingtonmallItem);
            burlingtonmallText.setTypeface(font);

            burlingtonmallImage.setImageResource(imageId[position]);
            return customView;
        }
    }
}
