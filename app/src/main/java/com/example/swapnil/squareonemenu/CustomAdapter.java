package com.example.swapnil.squareonemenu;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

class CustomAdapter extends ArrayAdapter<String> {

    Integer[] imageId = {R.drawable.image, R.drawable.image, R.drawable.image,
            R.drawable.image,
            R.drawable.image,R.drawable.image,R.drawable.image,R.drawable.image, R.drawable.image2,
            R.drawable.image,R.drawable.image,R.drawable.image,R.drawable.image,R.drawable.image,
            R.drawable.image, R.drawable.image2, R.drawable.image,R.drawable.image,R.drawable.image,
            R.drawable.image,R.drawable.image,R.drawable.image,R.drawable.image,
            R.drawable.image,R.drawable.image, R.drawable.image,R.drawable.image,
            R.drawable.image,R.drawable.image, R.drawable.image,R.drawable.image,
            R.drawable.image,R.drawable.image, R.drawable.image,R.drawable.image,
            R.drawable.image,R.drawable.image};

    Typeface font;
    CustomAdapter(Context context, String[] restaurants, Integer[] images) {

        super(context, R.layout.custom_row, restaurants);
        font= Typeface.createFromAsset(context.getAssets(), "Roboto-Light.ttf");



    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater foodyInflater = LayoutInflater.from(getContext());
        View customView = foodyInflater.inflate(R.layout.custom_row, parent, false);

        String singleFoodItem = getItem(position);

        TextView foodyText = (TextView) customView.findViewById(R.id.foodyText);


        ImageView foodyImage = (ImageView) customView.findViewById(R.id.foodyImage); //buckysImage is after the .id


        foodyText.setText(singleFoodItem);
        foodyText.setTypeface(font);


        foodyImage.setImageResource(imageId[position]);
        return customView;
    }
}