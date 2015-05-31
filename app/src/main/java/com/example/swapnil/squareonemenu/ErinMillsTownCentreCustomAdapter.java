package com.example.swapnil.squareonemenu;

/**
 * Created by oguzhan on 2015-05-29.
 */

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class ErinMillsTownCentreCustomAdapter extends ArrayAdapter<String>{

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