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


public class BurlingtonMallCustomAdapter extends ArrayAdapter<String>{

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
    BurlingtonMallCustomAdapter(Context context, String[] restaurants, Integer[] images) {

        super(context, R.layout.burlingtonmallcustomrow, restaurants);
        font= Typeface.createFromAsset(context.getAssets(), "Amita-Bold.ttf");
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater squareOneInflater = LayoutInflater.from(getContext());
        View customView = squareOneInflater.inflate(R.layout.burlingtonmallcustomrow, parent, false);

        String singleFoodItem = getItem(position);

        TextView burlingtonmallText = (TextView) customView.findViewById(R.id.burlingtonmallPlaceText);


        ImageView burlingtonmallImage = (ImageView) customView.findViewById(R.id.burlingtonmallPlaceImage); //buckysImage is after the .id


        burlingtonmallText.setText(singleFoodItem);
        burlingtonmallText.setTypeface(font);

        burlingtonmallImage.setImageResource(imageId[position]);
        return customView;
    }
}
