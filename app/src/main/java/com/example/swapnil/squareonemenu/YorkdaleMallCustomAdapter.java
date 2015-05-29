package com.example.swapnil.squareonemenu;

/**
 * Created by oguzhan on 2015-05-29.
 */



import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class YorkdaleMallCustomAdapter extends ArrayAdapter<String>  {

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

    YorkdaleMallCustomAdapter(Context context, String[] restaurants, Integer[] images) {

    super(context, R.layout.yorkdalecustomrow, restaurants);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater squareOneInflater = LayoutInflater.from(getContext());
        View customView = squareOneInflater.inflate(R.layout.yorkdalecustomrow, parent, false);

        String singleFoodItem = getItem(position);

        TextView foodyText = (TextView) customView.findViewById(R.id.yorkdalePlaceText);


        ImageView foodyImage = (ImageView) customView.findViewById(R.id.yorkdalePlaceImage); //buckysImage is after the .id


        foodyText.setText(singleFoodItem);

        foodyImage.setImageResource(imageId[position]);
        return customView;
    }
}







