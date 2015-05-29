package com.example.swapnil.squareonemenu;

/**
 * Created by Swapnil on 5/29/2015.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class SherwayGardensCustomAdapter extends ArrayAdapter<String>{

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

    SherwayGardensCustomAdapter(Context context, String[] restaurants, Integer[] images) {

        super(context, R.layout.sherwaygardenscustomrow, restaurants);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater squareOneInflater = LayoutInflater.from(getContext());
        View customView = squareOneInflater.inflate(R.layout.sherwaygardenscustomrow, parent, false);

        String singleFoodItem = getItem(position);

        TextView sherwaygardensText = (TextView) customView.findViewById(R.id.sherwaygardensPlaceText);


        ImageView sherwaygardensImage = (ImageView) customView.findViewById(R.id.sherwaygardensPlaceImage); //buckysImage is after the .id


        sherwaygardensText.setText(singleFoodItem);

        sherwaygardensImage.setImageResource(imageId[position]);
        return customView;
    }
}