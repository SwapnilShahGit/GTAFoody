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

class SquareOneCustomAdapter extends ArrayAdapter<String> {

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
    SquareOneCustomAdapter(Context context, String[] restaurants, Integer[] images) {

        super(context, R.layout.squareonecustomrow, restaurants);
        font= Typeface.createFromAsset(context.getAssets(), "Roboto-Regular.ttf");
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater squareOneInflater = LayoutInflater.from(getContext());
        View customView = squareOneInflater.inflate(R.layout.squareonecustomrow, parent, false);

        String singleFoodItem = getItem(position);

        TextView squareOneText = (TextView) customView.findViewById(R.id.squareOnePlaceText);


        ImageView squareOneImage = (ImageView) customView.findViewById(R.id.squareOnePlaceImage); //buckysImage is after the .id


        squareOneText.setText(singleFoodItem);
        squareOneText.setTypeface(font);

        squareOneImage.setImageResource(imageId[position]);
        return customView;
    }
}