package com.example.swapnil.squareonemenu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

class CustomAdapter extends ArrayAdapter<String> {

    Integer[] imageId = {R.drawable.image, R.drawable.image2};
    CustomAdapter(Context context, String[] restaurants, Integer[] images) {

        super(context, R.layout.custom_row, restaurants);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater foodyInflater = LayoutInflater.from(getContext());
        View customView = foodyInflater.inflate(R.layout.custom_row, parent, false);

        String singleFoodItem = getItem(position);

        TextView foodyText = (TextView) customView.findViewById(R.id.foodyText);

        ImageView foodyImage = (ImageView) customView.findViewById(R.id.foodyImage); //buckysImage is after the .id


        foodyText.setText(singleFoodItem);

        foodyImage.setImageResource(imageId[position]);
        return customView;
    }
}