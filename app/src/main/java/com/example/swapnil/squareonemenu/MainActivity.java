package com.example.swapnil.squareonemenu;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {
    public static String URLVariable = "";
    String[] list_restaurants = {"Square One", "Mapleview Mall", "Burlington Mall", "Eaton Centre",
            "Sherway Gardens", "Yorkdale Mall", "Erin Mills Centre"};

    Integer[] imageId = {R.drawable.image, R.drawable.image2, R.drawable.image, R.drawable.image,
            R.drawable.image, R.drawable.image, R.drawable.image,};


    ListView foodyListView;
    ArrayAdapter foodyAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);









        foodyListView = (ListView) findViewById(R.id.foodyListView);
        // this-The current activity context.
        // Second param is the resource Id for list layout row item
        // Third param is input array

        foodyAdapter = new CustomAdapter(this, list_restaurants, imageId);

        foodyListView = (ListView) findViewById(R.id.foodyListView);

        foodyListView.setAdapter(foodyAdapter);

        foodyListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                        String NameOfRow = String.valueOf(parent.getItemAtPosition(position));
                        //Toast.makeText(MainActivity.this, item, Toast.LENGTH_LONG).show();

                        try {
                            String NameOfClassString = switchActivity(NameOfRow);
                            Class NameOfClass = Class.forName(NameOfClassString);
                            startActivity(new Intent(MainActivity.this, NameOfClass));
                        }
                        catch (ClassNotFoundException e){
                            startActivity(new Intent(MainActivity.this, Starbucks.class));
                        }


                    }

                    ;
                });
    }


    public static String switchActivity(String item) {

                switch (item) {
                    case "Square One":
                        return "com.example.swapnil.squareonemenu.SquareOne";
                    case "Mapleview Mall":
                        return "com.example.swapnil.squareonemenu.Mapleview";
                    case "Burlington Mall":
                        return "com.example.swapnil.squareonemenu.BurlingtonMall";
                    case "Eaton Centre":
                        return "com.example.swapnil.squareonemenu.EatonCentre";
                    case "Sherway Gardens":
                        return "com.example.swapnil.squareonemenu.SherwayGardens";
                    case "Yorkdale Mall":
                        return "com.example.swapnil.squareonemenu.YorkdaleMall";
                    case "Erin Mills Centre":
                        return "com.example.swapnil.squareonemenu.ErinMillsTownCentre";
                    case "A&W":
                        URLVariable = "http://www.aw.ca/mobile.nsf/menu";
                        return "com.example.swapnil.squareonemenu.Amaya_Express";
                    case "Amaya Express":
                        URLVariable = "http://www.amayarestaurant.com/amayaex/index.php?pg=takeout";
                        return "com.example.swapnil.squareonemenu.Amaya_Express";
                    case "Basil Box":
                        URLVariable = "";
                        return "com.example.swapnil.squareonemenu.Amaya_Express";

                    case "Big Smoke Burger":
                        URLVariable = "http://www.bigsmokeburger.com/menu/";
                        return "com.example.swapnil.squareonemenu.Big_Smoke_Burger";
                    case "Bourbon Street Grill":
                        URLVariable = "http://www.bourbonstreetgrille.com/menu.htm";
                        return "com.example.swapnil.squareonemenu.Bourbon_Street_Grill";
                    case "Burger King":
                        URLVariable = "http://www.bk.com/menu";
                        return "com.example.swapnil.squareonemenu.burger_king";
                    case "Charleys Steakery":
                        URLVariable = "http://charleys.com/food/";
                        return "com.example.swapnil.squareonemenu.Charleys_Steakery";
                    case "Chipotle":
                        URLVariable = "http://chipotle.com/menu";
                        return "com.example.swapnil.squareonemenu.chipotle";
                    case "Cinnabon":
                        URLVariable = "http://www.cinnabon.com/bakery-treats";
                        return "com.example.swapnil.squareonemenu.cinnabon";
                    case "Cultures":
                        URLVariable = "http://www.cultures-restaurants.com/en/menu.php";
                        return "com.example.swapnil.squareonemenu.cultures";
                    case "Dairy Queen":
                        URLVariable = "http://www.dairyqueen.com/us-en/Menu/Full-Menu/?localechange=1&";
                        return "com.example.swapnil.squareonemenu.Dairy_Queen";
                    case "Jimmy The Greek":
                        URLVariable = "http://www.jimmythegreek.com/";
                        return "com.example.swapnil.squareonemenu.Jimmy_The_Greek";
                    case "KFC":
                        URLVariable = "http://www.kfc.ca/menu/index.aspx?gclid=Cj0KEQjw4qqrBRDE2K_z7Pbvjo8BEiQA39AImdM9HaLAaStv6y0OjumV1r8AAdHYtA83Uzoo-nOtKd0aAgun8P8HAQ";
                        return "com.example.swapnil.squareonemenu.KFC";
                    case "Manchu Wok":
                        URLVariable = "http://www.manchuwok.com/menu/";
                        return "com.example.swapnil.squareonemenu.Manchu_Wok";
                    case "Mrs Vanellis":
                        URLVariable = "http://www.vanellisrestaurants.com/en/menu";
                        return "com.example.swapnil.squareonemenu.Mrs_Vanellis";
                    case "New York Fries":
                        URLVariable = "http://www.newyorkfries.com/menu";
                        return "com.example.swapnil.squareonemenu.New_York_Fries";
                    case "Shanghai 360":
                        //No menuURLVariable = "";
                        return "com.example.swapnil.squareonemenu.Shanghai_360";
                    case "Starbucks":
                        URLVariable = "http://www.starbucks.ca/?gclid=Cj0KEQjw4qqrBRDE2K_z7Pbvjo8BEiQA39AImam-yh_ZY9qAoSJiARTwkxW7qweFflAH7U0bSHnqI14aAj1g8P8HAQ";
                        return "com.example.swapnil.squareonemenu.Starbucks";
                    case "Su Shi":
                        URLVariable = "http://www.starbucks.ca/?gclid=Cj0KEQjw4qqrBRDE2K_z7Pbvjo8BEiQA39AImam-yh_ZY9qAoSJiARTwkxW7qweFflAH7U0bSHnqI14aAj1g8P8HAQ";
                        return "com.example.swapnil.squareonemenu.Su_Shi";
                    case "Sushi O":
                        //No websiteURLVariable = "";
                        return "com.example.swapnil.squareonemenu.Sushi_O";
                    case "Szechuan Express":
                        URLVariable = "";
                        return "com.example.swapnil.squareonemenu.Szechuan_Express";
                    case "Taco Bell":
                        URLVariable = "https://www.tacobell.com/m/menu";
                        return "com.example.swapnil.squareonemenu.Taco_Bell";
                    case "Teriyaki Experience":
                        URLVariable = "http://www.teriyakiexperience.com/en/Our-Food.html";
                        return "com.example.swapnil.squareonemenu.Teriyaki_Experience";
                    case "Thai Express":
                        URLVariable = "http://www.thaiexpress.ca/menu/";
                        return "com.example.swapnil.squareonemenu.Thai_Express";
                    case "Villa Madina":
                        URLVariable = "http://www.villamadina.com/en/menu";
                        return "com.example.swapnil.squareonemenu.Villa_Madina";
                    case "Freshly Squeezed":
                        URLVariable = "http://www.freshlysqueezed.ca/index.php?r=web/products";
                        return "com.example.swapnil.squareonemenu.FreshlySqueezed";
                }
                return "Not matching string";
            }

}