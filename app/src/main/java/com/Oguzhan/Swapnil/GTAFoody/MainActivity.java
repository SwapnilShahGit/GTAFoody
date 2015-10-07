package com.Oguzhan.Swapnil.GTAFoody;

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
import android.view.MotionEvent;
import android.view.GestureDetector;
import android.support.v4.view.GestureDetectorCompat;
import android.widget.Toast;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.jar.Attributes;


public class MainActivity extends Activity {

    public static Hashtable<String, String []> samplehashtable = new Hashtable<>();
    public static String URLVariable = "";
    public static String [] burlingtonmalllist = { "A&W", "Jimmy The Greek", "Thai Express",
            "New York Fries",
            "Taco Bell", "Mr.Sub", "Koya Japan", "Tim Hortons", "Sakura Ichiban Express",
            "Freshly Squeezed", "Rocky Mountain Chocolate Factory", "Kernels Popcorn"};
    public static String [] mapleviewmalllist = { "Dairy Queen", "Orange Julius",
            "Earls Kitchen & Bar",
            "Godiva Chocolatier", "Jugo Juice", "Kernels Popcorn", "Purdys Chocolates",
            "Sakura Ichiban Express", "Second Cup", "Starbucks", "Teavana",
            "Turtle Jack's Muskoka Grill", "A&W", "Cultures", "Extreme Pita", "Jimmy The Greek",
            "KFC", "Taco Bell", "Manchu Wok", "Mr.Sub", "New York Fries", "Ruby Thai Kitchen",
            "Teriyaki Experience", "Tim Hortons", "Villa Madina"};
    public static String [] yorkdalemall = { "A&W", "Amaya Express", "Big Smoke Burger",
            "Booster Juice",
            "Chipotle", "DAVIDsTEA", "Espressamente illy", "Famoso Neapolitan Pizzeria",
            "Freshly Squeezed", "Godiva Chocolatier", "Holts Cafe", "Jamba Juice",
            "Jimmy The Greek",
            "Kernels Popcorn", "KFC", "La Paloma Gelateria & Cafe", "Mac's Sushi", "Manchu Wok",
            "MICHEL's Bakery Cafe", "MII Sandwich Store", "Milestones Grill & Bar",
            "Moxies Classic Grill"
            , "New York Fries", "Pickel Barrel Grand", "Purdys Chocolates", "Second Cup",
            "Shanghai 360",
            "Starbucks", "Subway", "SU&SHI Noodle Bar", "Teavana", "Ten Ren's Tea Time",
            "Teriyaki Experience", "Thai Express", "Tim Hortons", "Villa Madina", "Yogen Fruz"};
    public static String [] cambridgecentre = { "A&W", "Big Orange", "California Thai",
            "Crepe de Licious",
            "Dairy Queen", "Orange Julius", "Famous Wok", "Jimmy The Greek", "KFC", "Taco Bell",
            "New York Fries", "Pizza Pizza", "Subway", "Teriyaki Experience", "Tim Hortons"};
    public static String [] eatoncentre = { "A&W", "Akashiro", "Amaya Express",
            "Aroma Espresso Bar", "Big Smoke Burger", "Bourbon Street Grill", "Crepe de Licious",
            "Froshberg Gelato", "Extreme Pita", "Fast Fresh Foods", "Jimmy The Greek", "KFC",
            "Liberty Noodle", "McDonalds", "Mucho Burrito", "New York Fries", "Ruby Thai Kitchen",
            "Shanghai 360", "Sbarro", "Subway", "Szechuan Express", "Teriyaki Experience",
            "Thai Express",
            "Tim Hortons", "Urban Herbivore", "Villa Madina"};
    public static String [] erinmillstowncentre = { "A&W", "Bourbon Street Grill", "Dairy Queen",
            "Fit for Life",
            "Fresh East", "Hero Burgers", "Jimmy The Greek", "KFC", "Mac's Sushi", "New York Fries",
            "Starbucks", "Subway", "Taco Bell", "KFC", "Teriyaki Experience", "Thai Express",
            "Tim Hortons", "Wendys"};
    public static String [] sherwaygardens = { "Bento", "Caribbean Queen", "Crepe de Licious",
            "Cultures",
            "Famous Wok", "Hero Burgers", "Jimmy The Greek", "McDonalds", "Michels Baguette",
            "New York Fries", "Subway", "Taco Bell", "KFC", "Teriyaki Experience", "Thai Express",
            "Tim Hortons", "Villa Madina"};
    public static String [] squareone = { "A&W", "Amaya Express",
            "Basil Box", "Big Smoke Burger", "Bourbon Street Grill", "Burger King",
            "Charley's Steakery", "Chipotle", "Cinnabon",
            "Cultures", "Dairy Queen", "Orange Julius", "Jimmy The Greek", "KFC", "Manchu Wok",
            "Mrs Vanellis", "New York Fries", "Shanghai 360", "Starbucks", "Su & Shi", "Sushi-Q",
            "Szechuan Express", "Taco Bell", "Teriyaki Experience", "Thai Express", "Villa Madina"};
    public static String [] bramaleacitycentre = {"The Keg", "The Pickle Barrel", "Moxie's",
            "Spring Rolls", "St. Louis Bar and Grill", "A&W",
    "Bar Burrito", "Bourbon Street Grill", "Bramalae City Pizza", "Burger King", "California Thai",
            "Dairy Queen", "Orange Julius", "Extreme Pita",
    "Five Guys", "Fresh Slice", "Grill It Up", "Ichiban Sushi Express", "Jimmy the Greek", "KFC",
            "Kung Pao Wok", "McDonalds", "New York Fries",
    "Paramount Fine Foods", "Popeye's Chicken", "Sbarro", "Shanghai 360", "Subway", "Taco Bell",
            "Thai Express",
    "Tiki Ming", "Tropical Joe's", "Villa Madina" };
    public static String [] scarboroughtowncentre = {"A&W", "Baskin Robbins", "Baton Rouge",
            "Booster Juice", "Boston Pizza",
    "Bourbon Street Grill", "Bulk Barn", "Canyon Creek Chophouse", "Caribbean Queen", "DAVID's TEA",
    "Freshly Squeezed", "Godiva Chocolatier", "Grill It Up", "Jack Astor's Bar and Grill",
            "Jimmy The Greek",
    "Jugo Juice", "KFC", "Kernels", "Koryo Korean Barbeque", "Koya Japan", "Laura Secord",
            "Mac's Sushi", "Manchu Wok",
    "McDonalds", "Michel's Baguette", "Milestone's Grill & Bar", "Moxie's Grill & Bar",
            "Mrs. Fields", "Pretzel Maker",
    "New York Fries", "Second Cup", "Shanghai 360", "Starbucks", "Subway",
            "Sweet Tooth Candy Emporium", "Swiss Chalet Rotisserie & Grill",
    "Taco Bell", "Tandori", "Ten Ren's Tea", "Thai Express", "Tim Horton's",
            "Timothy's World Coffee", "Vanelli", "Cultures",
    "Villa Madina", "Yogen Fruz"};
    public static String [] vaughnmills = {"Lucky Strike Lanes", "Szechuan",
            "Tim Hortons", "The Pickel Barrel", "Aroma Espresso Bar",
    "Jugo Juice", "Starbucks", "Bubble Tease", "Kernels Popcorn", "Baskin Robbins",
            "Sugar Mountain", "Teavana",
    "Purdy�s Chocolates", "Crepe De Licious", "David's Tea", "Rocky Mountain Chocolate Factory",
            "Thai Island",
    "South St. Burger Co.", "Dippin� Dots", "Spudniks", "Freshly Squeezed",
            "Starbucks", "Yogen Fruz",
    "Island Way Sorbet"};
    public static String [] thepencentre = {"A&W", "Booster Juice ", "Charley's Steakery",
            "Dairy Queen/Orange Julius", "Jimmy The Greek", "KFC", "Taco Bell",
    "Laura Secord", "Monsieur Cr�pe Sup�rieure", "Mrs. Fields", "Pretzelmaker", "New York Fries ",
            "Second Cup", "Subway",
    "Teavana", "Teriyaki Experience", "Thai Express", "Tiki Ming", "Tim Hortons", "Umi Sushi",
            "Vanellis", "Villa Madina", "Yogen Fruz"};
    public static String [] markvilleshoppingcentre = {"A&W", "Amaya Express",
            "Bourbon Street Grill", "Extreme Pita", "Harvey's",
    "Swiss Chalet Rotisserie & Grill", "Jimmy The Greek", "KFC", "Manchu Wok", "Mr. Sub", "New York Fries",
            "Sushi-Q", "Taco Bell",
    "Thai Express", "Tim Hortons", "Villa Madina", "East Side Mario's", "The Pickel Barrel",
            "Joey Markville", "Aroma Expresso Bar", "Freshly Squeezed",
    "Yogurt Delight", "Starbucks Coffee", "Teavana", "Kernels", "Bubble Tease", "Cinnabon",
            "Davids Tea", "Second Cup", "Yogen Fruz", "Ten Ren's Tea",
    "Purdy's Chocolatier"};
    public static String [] uppercanadamall = {"A&W", "Basking Robbins", "Cultures", "KFC",
            "Taco Bell", "New York Fries", "Opa! Of Greece", "Ruby Thai Chiken", "Sizzling Wok",
    "Subway", "Teriyaki Experience", "Tim Hortons", "Vanellis", "VIlla Madina", "Booster Juice",
            "Cob's Bread", "Crepe De Licious", "Freshly Squeezed", "Kernels",
    "Mac's Sushi", "MMMuffins", "Oil & Vinegar", "Old Time Confections", "Purdy's Chocolatier",
            "Starbucks", "Teavana", "Timothy's", "Yogen Fruz"};
    public static String [] pickeringtowncentre = {"A&W", "Bourbon Street Grill", "Edo Japan",
            "Extreme Pita", "Jimmy The Greek", "KFC", "Manchu Wok",
    "New York Fries", "Subway", "Taco Bell", "Thai Express", "Tim Hortons", "Umi Sushi Epress",
            "Vanellis", "Villa Madina", "Cinnabon",
    "Country Style Bistro Deli", "Dairy Queen", "David's Tea", "Freshly Squeezed", "Kernels",
            "Laura Secord", "Mrs. Fields",
    "Pretzelmaker", "Prange Julius", "Rocky Mountain Chocolate Factory", "Teavana", "Timothy's"};
    public static String [] rideaushoppingcentre = {"A&W", "KFC", ""};
    public static String [] bayshoreshoppingcentre= {"A&W", "Booster Juice", "Cinnabon", "Kernels",
            "KFC", "La Cr�mi�re", "Teriyaki Experience", "Manchu Wok", "Moxie's Classic Grill",
            "Moxie's Classic Grill",
    "New York Fries", "Second Cup", "Thai Express", "Treats", "Subway", "Taco Bell", "Starbucks",
            "DAVIDs TEA", "Tim Hortons", "Mac's Sushi", "Cultures", "Jugo Juice", "Jimmy The Greek",
            "Shanghai 360",
    "Torino Grill", "Barburrito", "Chimney Cake & Bake"};
    public static String [] oshawacentre = {"A&W", "Country Style Donuts", "Dairy Queen",
            "Orange Julius", "Druxy's ", "Jimmy The Greek", "KFC", "McDonalds",
    "Mrs. Vanelli's", "New York Fries", "Sizzling Wok", "Subway", "Taco Bell",
            "Teriyaki Experience", "Thai Express", "Tim Hortons", "Yogen Fruz",
    "Casey's Bar & Grill ", "The Keg", "Cinnabon", "Kernels", "Mac's Sushi", "Casey's Bar & Grill ",
            "Starbucks", "Teavana"};
    public static String [] fairviewmall = {"Bourbon Street Grill", "Caribbean Queen",
            "Fit for Life", "Grill It Up", "HERO CERTIFIED BURGERS", "Jimmy The Greek",
            "KFC", "Manchu Wok", "McDonald's", "Mr. Sub", "New York Fries", "Spring Rolls",
            "Taco Bell", "Teriyaki Experience", "Tim Hortons", "Villa Madina",
    "Druxy's", "Michel's Baguette", "Moxie's Classic Grill", "St. Louis Bar & Grill",
            "Z-Teca Gourmet Burritos", "Aroma Espresso Bar",
    "Kernels", "Starbucks", "Booster Juice", "Cinnabon", "Freshly Squeezed", "Godiva Chocolatier",
            "Purdys Chocolatier", "Mac's Sushi", "LCBO", "Laura Secord",
    "Teavana", "Ten Ren's Tea Time", "Yogen Fruz"};
    public static String [] stlaurentmall = {"A&W", "Lebanese Fine Cuisine", "Bento Nouveau",
            "Booster Juice", "Bourbon Street Grill"
    , "Cinnabon", "Crepe de Licious", "Dairy Queen", "Freshly Squeezed", "Yogurt Delight",
            "Jimmy The Greek", "Juge Juice", "KFC"
    , "Taco Bell", "Laura Secord", "Manchu Wok", "Michel's Bakery Cafe", "New York Fries",
            "Orange Julius", "Second Cup", "Starbucks",
    "Subway", "Sugar Mountain", "Teavana", "Teriyaki Experience", "Thai Express", "Tim Hortons",
            "Trattoria Tevere", "Treats", "Yogen Fruz"};
    public static String [] limeridgemall ={"A&W", "Arby's", "Bourbon Street Grill", "Extreme Pita",
            "Harvey's", "Swiss Chalet Rotisserie & Grill", "Jimmy The Greek"
    , "KFC", "Taco Bell", "Manchu Wok", "New York Fries", "Subway", "Teriyaki Experience",
            "Thai Express", "Tim Hortons", "UMI Sushi Express",
    "Villa Madina", "Yogen Fruz"};
    public static String [] placedorelans = {"A&W", "Booster Juice", "Cinnabon", "Farm Boy",
            "Freshly Squeezed", "Kernels", "KFC", "Taco Bell",
            "Laura Secord", "New York Fries", "Second Cup", "Subway", "Sugar Mountain",
            "Taco Del Mar", "Tandori", "Teavana", "Teriyaki Experience",
            "The Shawarma Kitchen", "Tiki Ming", "Tim Hortons", "Valentine", "Wine Rack"};
    public static String [] fairviewparkmall = {"A&W", "Bourbon Street Grill", "Famous Wok",
            "KFC", "Taco Bell", "New York Fries", "OPA! Of Greece",
    "Subway", "Swiss Chalet Rotisserie & Grill", "Thai Express", "Tim Hortons", "Umi Sushi", "Villa Madina"};
    public static String [] woodbinecentre = {"Baby O'Donuts", "Baskin Robbins",
            "Bourbon Street Grill", "Bulk Barn", "Burger King", "Caribbean Queen",
    "Charley's Steakery", "Cinnabon", "E Steam", "Fusia Asia Kitchen", "Jimmy The Greek",
            "KFC", "Taco Bell", "New York Fries", "Real Fruit Bubble Tea",
    "Subway", "Sushi House", "Sweet Fix Bakery", "Teriyaki Express", "Thai Express",
            "Tim Hortons", "Villa Madina"};
    public static String [] promenadeshoppingcentre = {"Bourbon Street Grill", "KFC",
            "McDonald's", "Subway", "Teriyaki Experience", "Thai Express",
    "Tiki Ming", "Tim Hortons"};
    public static String [] whiteoaksmall = {"A&W", "Cinnabon", "Cultures", "Davids Tea",
            "Dairy Queen", "Orange Julius", "Feta & Olives", "Freshly Squeezed",
    "Kernels Popcorn", "Laura Secord", "Mac's Sushi", "Manchu Wok", "New York Fries",
            "Pizza Pizza", "Purdys Chocolatier", "Starbucks", "Subway", "Taco Bell",
    "KFC", "Teavana", "Thai Express", "Tim Hortons", "Villa Madina", "Wasabi Grill and Noodle",
            "Wikki Hut", "YoYo's Yogurt Cafe"};
    public static String [] shoppersworld = {"A&W", "Bourbon Street Grill", "Bulk Barn",
            "Cinnabon", "Crack Me Up", "Edo Japan", "Freshly Squeezed", "Fusia Asian Kitchen",
    "KFC", "Taco Bell", "Little Caesars", "Mr.Souvlaki", "New York Fries", "Seens Bar & Grill",
            "Spoonful", "Subway", "The Beer Store", "Tim Hortons", "Tropiical Joe", "Yogen Fruz"};
    public static String [] conestogamall = {"A&W", "Bourbon Street Grill", "Cultures",
            "Feta & Olives", "KfC", "Taco Bell", "Manchu Wok", "New York Fries",
    "Spring Rolls Go", "Subway", "Tandori", "Tim Hortons", "Villa Madina"};
    public static String [] centrepointmall = {"Mac's Sushi", "Asian Gourmet", "Pinoy Hub",
            "Laffa Laffa Mediterranean Grill", "The Pickle Barrel", "Yogen Fruz"
, "Country Style", "McDonald's", "Tim Hortons", "Thai Express", "Jimmy The Greek",
            "Dolce Camerata Dessert Caffe", "KFC", "Taco Bell", "Freshly Squeezed", "Fresh 2 Serve",
    "Timothy's", "Congee Queen", "Freshly Slice Pizza", "Cafe on the GO", "Subway",
            "Teriyaki Experience", "Caribbean Queen", "Real Fruit Bubble Tea"};

    public static String [] currentrestaurant;



    String[] list_restaurants = {"Square One                                                    " +
            "                                                                                   " +
            "                                                                                   " +
            "                                                                                   " +
            "Mississauga, ON",


            "Mapleview Mall                                                         " +
                    "                                                               " +
                    "                                                               " +
                    "                                                               " +
                    "                                                               " +
                    "Burlington, ON",


            "Burlington Mall                                                        " +
                    "                                                               " +
                    "                                                               " +
                    "                                                               " +
                    "                                                               " +
                    "Burlington, ON",


            "Eaton Centre                                                              " +
                    "                                                                  " +
                    "                                                                  " +
                    "                                                                  " +
                    "                                                                  " +
                    "Toronto, ON",


            "Sherway Gardens                                                              " +
            "                                                                  " +
                    "                                                                  " +
                    "                                                                  " +
                    "                                                                  " +
                    "Toronto, ON",


            "Yorkdale Mall                                                              " +
            "                                                                  " +
                    "                                                                  " +
                    "                                                                  " +
                    "                                                                  " +
                    "Toronto, ON",



            "Erin Mills Centre                                                         " +
            "                                                                          " +
                    "                                                                  " +
                    "                                                                  " +
                    "                                                                  " +
                    "Mississauga, ON",


            "Cambridge Centre                                                         " +
            "                                                                          " +
                    "                                                                  " +
                    "                                                                  " +
                    "                                                                  " +
                    "Cambridge, ON",


            "Bramalea City Centre                                                         " +
                    "                                                                          " +
                    "                                                                  " +
                    "                                                                  " +
                    "                                                                  " +
                    "Brampton, ON",

            "Scarborough Town Centre                                                         " +
                    "                                                                          " +
                    "                                                                  " +
                    "                                                                  " +
                    "                                                                  " +
                    "Toronto, ON",
            "Vaughan Mills                                                        " +
                    "                                                                          " +
                    "                                                                  " +
                    "                                                                  " +
                    "                                                                  " +
                    "Vaughan, ON",
            "The Pen Centre                                                         " +
                    "                                                                          " +
                    "                                                                  " +
                    "                                                                  " +
                    "                                                                  " +
                    "St.Catherines, ON",
            "Markville Shopping Centre                                                         " +
                    "                                                                          " +
                    "                                                                  " +
                    "                                                                  " +
                    "                                                                  " +
                    "Markham, ON",
            "Upper Canada Mall                                                         " +
                    "                                                                          " +
                    "                                                                  " +
                    "                                                                  " +
                    "                                                                  " +
                    "Newmarket, ON",
            "Pickering Town Centre                                                         " +
                    "                                                                          " +
                    "                                                                  " +
                    "                                                                  " +
                    "                                                                  " +
                    "Pickering, ON",
            "Rideau Shopping Centre                                                         " +
                    "                                                                          " +
                    "                                                                  " +
                    "                                                                  " +
                    "                                                                  " +
                    "Ottawa, ON",
            "Bayshore Shopping Centre                                                         " +
                    "                                                                          " +
                    "                                                                  " +
                    "                                                                  " +
                    "                                                                  " +
                    "Ottawa, ON",
            "Oshawa Centre                                                         " +
                    "                                                                          " +
                    "                                                                  " +
                    "                                                                  " +
                    "                                                                  " +
                    "Oshawa, ON",
            //----------------------------------------malls supported above---------------------------------------

            "Fairview Mall                                                         " +
                    "                                                                          " +
                    "                                                                  " +
                    "                                                                  " +
                    "                                                                  " +
                    "Toronto, ON",
            "St.Laurent Centre                                                         " +
                    "                                                                          " +
                    "                                                                  " +
                    "                                                                  " +
                    "                                                                  " +
                    "Ottawa, ON",
            "Lime Ridge Mall                                                         " +
                    "                                                                          " +
                    "                                                                  " +
                    "                                                                  " +
                    "                                                                  " +
                    " Hamilton, ON",
            "Place d'Orelans                                                         " +
                    "                                                                          " +
                    "                                                                  " +
                    "                                                                  " +
                    "                                                                  " +
                    " Ottawa, ON",
            "Fairview Park Mall                                                         " +
                    "                                                                          " +
                    "                                                                  " +
                    "                                                                  " +
                    "                                                                  " +
                    "Kitchener, ON",
            "Woodbine Centre                                                         " +
                    "                                                                          " +
                    "                                                                  " +
                    "                                                                  " +
                    "                                                                  " +
                    "Toronto, ON",
            "Promenade Shopping Centre                                                         " +
                    "                                                                          " +
                    "                                                                  " +
                    "                                                                  " +
                    "                                                                  " +
                    "Vaughn, ON",
            "White Oaks Mall                                                        " +
                    "                                                                          " +
                    "                                                                  " +
                    "                                                                  " +
                    "                                                                  " +
                    "London, ON",
            "Shoppers World                                                         " +
                    "                                                                          " +
                    "                                                                  " +
                    "                                                                  " +
                    "                                                                  " +
                    "Brampton, ON",
            "Conestoga Mall                                                         " +
                    "                                                                          " +
                    "                                                                  " +
                    "                                                                  " +
                    "                                                                  " +
                    "Waterloo, ON",
            "Centerpoint Mall                                                         " +
                    "                                                                          " +
                    "                                                                  " +
                    "                                                                  " +
                    "                                                                  " +
                    "Toronto, ON"};

    Integer[] imageId = {R.drawable.logo,R.drawable.logo,R.drawable.logo,R.drawable.logo,R.drawable.logo,
            R.drawable.logo,R.drawable.logo,R.drawable.logo,R.drawable.logo,R.drawable.logo,
            R.drawable.logo,R.drawable.logo,R.drawable.logo,R.drawable.logo,R.drawable.logo,};


    ListView foodyListView;
    ArrayAdapter foodyAdapter;



    //////////////////On touch EVENTS//////////////////////////////

    /*@Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        return true;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return true;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return true;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return true;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        boolval = true;

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        this.gestureDetector.onTouchEvent(event);


        return super.onTouchEvent(event);
    }*/


    /////////////////ON TOUCH EVENTS END////////////////////



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        samplehashtable.put("BurlingtonMall", burlingtonmalllist);
        samplehashtable.put("MapleviewMall", mapleviewmalllist);
        samplehashtable.put("YorkdaleMall", yorkdalemall);
        samplehashtable.put("CambridgeCentre", cambridgecentre);
        samplehashtable.put("EatonCentre", eatoncentre);
        samplehashtable.put("ErinMillsTownCentre", erinmillstowncentre);
        samplehashtable.put("SherwayGardens", sherwaygardens);
        samplehashtable.put("SquareOne", squareone);
        samplehashtable.put("BramaleaCityCentre", bramaleacitycentre);
        samplehashtable.put("ScarboroughTownCentre", scarboroughtowncentre);
        samplehashtable.put("VaughnMills", vaughnmills);
        samplehashtable.put("ThePenCentre", thepencentre);
        samplehashtable.put("MarkvilleShoppingCentre", markvilleshoppingcentre);
        samplehashtable.put("UpperCanadaMall", uppercanadamall);
        samplehashtable.put("PickeringTownCentre", pickeringtowncentre);
        samplehashtable.put("RideauShoppingCentre", rideaushoppingcentre);
        samplehashtable.put("BayshoreShoppingCentre", bayshoreshoppingcentre);
        samplehashtable.put("OshawaCentre", oshawacentre);
        samplehashtable.put("FairviewMall", fairviewmall);
        samplehashtable.put("StLaurentCentre", stlaurentmall);
        samplehashtable.put("LimeRidgeMall", limeridgemall);
        samplehashtable.put("Placed'Orelans", placedorelans);
        samplehashtable.put("FairviewParkMall", fairviewparkmall);
        samplehashtable.put("WoodbineCentre", woodbinecentre);
        samplehashtable.put("PromenadeShoppingCentre", promenadeshoppingcentre);
        samplehashtable.put("WhiteOaksMall", whiteoaksmall);
        samplehashtable.put("ShoppersWorld", shoppersworld);
        samplehashtable.put("ConestogaMall", conestogamall);
        samplehashtable.put("CentrepointMall", centrepointmall);







        super.onCreate(savedInstanceState);
        Arrays.sort(list_restaurants);
        setContentView(R.layout.activity_main);


        foodyListView = (ListView) findViewById(R.id.foodyListView);
        // this-The current activity context.
        // Second param is the resource Id for list layout row item
        // Third param is input array

        foodyAdapter = new MainActivityCustomAdapter(this, list_restaurants, imageId);

        foodyListView = (ListView) findViewById(R.id.foodyListView);

        foodyListView.setAdapter(foodyAdapter);



        foodyListView.setOnItemLongClickListener(
                new AdapterView.OnItemLongClickListener(){
                    public boolean onItemLongClick(AdapterView<?> parent, View view, int position,
                                                   long id){
                        try {
                            String NameOfRow = String.valueOf(parent.getItemAtPosition(position));
                            String NameOfClassString = MainActivity.switchActivity(NameOfRow);
                            NameOfClassString = NameOfClassString.concat(".MallHours");
                            if (MainActivity.URLVariable.equals("None")) {
                                Toast.makeText(MainActivity.this, "No Website Found",
                                        Toast.LENGTH_LONG).show();
                            } else {
                                Class NameOfClass = Class.forName(NameOfClassString);
                                startActivity(new Intent(MainActivity.this, NameOfClass));
                            }
                        }
                        catch (ClassNotFoundException e){
                            startActivity(new Intent(MainActivity.this, MainActivity.class));
                        }
                        return true;
                    }

                });



        foodyListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {


                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position,
                                            long id) {
                        String NameOfRow = String.valueOf(parent.getItemAtPosition(position));
                        //Toast.makeText(MainActivity.this, item, Toast.LENGTH_LONG).show();

                        try {


                            String NameOfClassString = switchActivity(NameOfRow);
                            NameOfClassString = NameOfClassString.concat(".BurlingtonMall");
                            Class NameOfClass = Class.forName(NameOfClassString);
                            startActivity(new Intent(MainActivity.this, NameOfClass));


                        } catch (ClassNotFoundException e) {
                            startActivity(new Intent(MainActivity.this, MainActivity.class));
                        }
                    }

                });
    }




    public static String switchActivity(String item) {

                switch (item) {
                    case "Square One                                                    " +
                            "                                                                  " +
                            "                 " +

                            "                                                                  " +
                            "                 " +
                            "                                                        " +
                            "                           " +
                            "Mississauga, ON":
                        URLVariable = "http://www.shopsquareone.com/hours";
                        currentrestaurant = samplehashtable.get("SquareOne");
                        return "com.Oguzhan.Swapnil.GTAFoody";

                    case "Mapleview Mall                                                         " +
                            "                                                               " +
                            "                                                               " +
                            "                                                               " +
                            "                                                               " +
                            "Burlington, ON":
                        URLVariable = "http://www.mapleviewcentre.com/getting-here/";
                        currentrestaurant = samplehashtable.get("MapleviewMall");

                        return "com.Oguzhan.Swapnil.GTAFoody";


                    case "Burlington Mall                                                        " +
                            "                                                               " +
                            "                                                               " +
                            "                                                               " +
                            "                                                               " +
                            "Burlington, ON":
                        URLVariable = "http://www.burlingtonmall.com/Mallhours.aspx";
                        currentrestaurant = samplehashtable.get("BurlingtonMall");

                        return "com.Oguzhan.Swapnil.GTAFoody";



                    case "Eaton Centre                                                  " +
                            "            " +
                            "                                                                  " +
                            "                                                                  " +
                            "                                                                  " +
                            "                                                                  " +
                            "Toronto, ON":
                        URLVariable = "http://www.torontoeatoncentre.com/en/centreinfo/Pages/CentreHours.aspx";
                        currentrestaurant = samplehashtable.get("EatonCentre");

                        return "com.Oguzhan.Swapnil.GTAFoody";
                    case "Sherway Gardens                                                  " +
                            "            " +
                            "                                                                  " +
                            "                                                                  " +
                            "                                                                  " +
                            "                                                                  " +
                            "Toronto, ON":
                        URLVariable = "http://www.sherwaygardens.ca/en/centreinfo/Pages/CentreHours.aspx";
                        currentrestaurant = samplehashtable.get("SherwayGardens");

                        return "com.Oguzhan.Swapnil.GTAFoody";
                    case "Yorkdale Mall                                                    " +
                            "          " +
                            "                                                                  " +
                            "                                                                  " +
                            "                                                                  " +
                            "                                                                  " +
                            "Toronto, ON":
                        URLVariable ="http://www.yorkdale.com/centre-info/hours/";
                        currentrestaurant = samplehashtable.get("YorkdaleMall");

                        return "com.Oguzhan.Swapnil.GTAFoody";
                    case "Erin Mills Centre                                                 " +
                            "        " +
                            "                                                          " +
                            "                " +
                            "                                                                  " +
                            "                                                                  " +
                            "                                                                  " +
                            "Mississauga, ON":
                        URLVariable = "http://www.erinmills.ca/hours";
                        currentrestaurant = samplehashtable.get("ErinMillsTownCentre");

                        return "com.Oguzhan.Swapnil.GTAFoody";
                    case "Cambridge Centre                                                " +
                            "         " +
                            "                                                              " +
                            "            " +
                            "                                                                  " +
                            "                                                                  " +
                            "                                                                  " +
                            "Cambridge, ON":
                        URLVariable = "http://cambridge-centre.com/mall_hours.php";
                        currentrestaurant = samplehashtable.get("CambridgeCentre");
                        return "com.Oguzhan.Swapnil.GTAFoody";

                    case "Bramalea City Centre                                                         " +
                            "                                                                          " +
                            "                                                                  " +
                            "                                                                  " +
                            "                                                                  " +
                            "Brampton, ON":
                        URLVariable = "http://bramaleacitycentre.ca/hours";
                        currentrestaurant = samplehashtable.get("BramaleaCityCentre");

                        return "com.Oguzhan.Swapnil.GTAFoody";
                    case "Scarborough Town Centre                                                         " +
                            "                                                                          " +
                            "                                                                  " +
                            "                                                                  " +
                            "                                                                  " +
                            "Toronto, ON":
                        URLVariable = "http://www.scarboroughtowncentre.com/pages/stc-shopping-hours";
                        currentrestaurant = samplehashtable.get("ScarboroughTownCentre");

                        return "com.Oguzhan.Swapnil.GTAFoody";
                    case "Vaughan Mills                                                        " +
                            "                                                                          " +
                            "                                                                  " +
                            "                                                                  " +
                            "                                                                  " +
                            "Vaughan, ON":
                        URLVariable = "http://www.vaughanmills.com/Planning-Your-Visit/Getting-Here.aspx";
                        currentrestaurant = samplehashtable.get("VaughnMills");

                        return "com.Oguzhan.Swapnil.GTAFoody";
                    case "The Pen Centre                                                         " +
                            "                                                                          " +
                            "                                                                  " +
                            "                                                                  " +
                            "                                                                  " +
                            "St.Catherines, ON":
                        URLVariable = "http://www.thepencentre.com/hours";
                        currentrestaurant = samplehashtable.get("ThePenCentre");

                        return "com.Oguzhan.Swapnil.GTAFoody";
                    case "Markville Shopping Centre                                                         " +
                            "                                                                          " +
                            "                                                                  " +
                            "                                                                  " +
                            "                                                                  " +
                            "Markham, ON":
                        URLVariable = "http://www.markville.ca/en/centreinfo/Pages/CentreHours.aspx";
                        currentrestaurant = samplehashtable.get("MarkvilleShoppingCentre");

                        return "com.Oguzhan.Swapnil.GTAFoody";
                    case "Upper Canada Mall                                                         " +
                            "                                                                          " +
                            "                                                                  " +
                            "                                                                  " +
                            "                                                                  " +
                            "Newmarket, ON":
                        URLVariable = "http://uppercanadamall.com/hours";
                        currentrestaurant = samplehashtable.get("UpperCanadaMall");

                        return "com.Oguzhan.Swapnil.GTAFoody";
                    case "Pickering Town Centre                                                         " +
                            "                                                                          " +
                            "                                                                  " +
                            "                                                                  " +
                            "                                                                  " +
                            "Pickering, ON":
                        URLVariable = "http://www.pickeringtowncentre.com/hours";
                        currentrestaurant = samplehashtable.get("PickeringTownCentre");

                        return "com.Oguzhan.Swapnil.GTAFoody";
                    case "Rideau Shopping Centre                                                         " +
                            "                                                                          " +
                            "                                                                  " +
                            "                                                                  " +
                            "                                                                  " +
                            "Ottawa, ON":
                        URLVariable = "http://www.rideaucentre.com/en/centreinfo/Pages/CentreHours.aspx";
                        currentrestaurant = samplehashtable.get("RideauShoppingCentre");

                        return "com.Oguzhan.Swapnil.GTAFoody";
                    case "Bayshore Shopping Centre                                                         " +
                            "                                                                          " +
                            "                                                                  " +
                            "                                                                  " +
                            "                                                                  " +
                            "Ottawa, ON":
                        URLVariable = "http://www.bayshoreshoppingcentre.com/en/visit";
                        currentrestaurant = samplehashtable.get("BayshoreShoppingCentre");

                        return "com.Oguzhan.Swapnil.GTAFoody";
                    case "Oshawa Centre                                                         " +
                            "                                                                          " +
                            "                                                                  " +
                            "                                                                  " +
                            "                                                                  " +
                            "Oshawa, ON":
                        URLVariable = "http://www.oshawacentre.com/hours";
                        currentrestaurant = samplehashtable.get("OshawaCentre");

                        return "com.Oguzhan.Swapnil.GTAFoody";
                    case "Fairview Mall                                                         " +
                            "                                                                          " +
                            "                                                                  " +
                            "                                                                  " +
                            "                                                                  " +
                            "Toronto, ON":
                        URLVariable = "http://www.fairviewmall.ca/en/centreinfo/Pages/CentreHours.aspx";
                        currentrestaurant = samplehashtable.get("FairviewMall");
                        return "com.Oguzhan.Swapnil.GTAFoody";
                    case "St.Laurent Centre                                                         " +
                            "                                                                          " +
                            "                                                                  " +
                            "                                                                  " +
                            "                                                                  " +
                            "Ottawa, ON":
                        URLVariable = "http://www.stlaurent-centre.com/holiday-hours.html";
                        currentrestaurant = samplehashtable.get("StLaurentCentre");
                        return "com.Oguzhan.Swapnil.GTAFoody";
                    case "Lime Ridge Mall                                                         " +
                            "                                                                          " +
                            "                                                                  " +
                            "                                                                  " +
                            "                                                                  " +
                            " Hamilton, ON":
                        URLVariable = "http://www.limeridge.ca/en/centreinfo/Pages/CentreHours.aspx";
                        currentrestaurant = samplehashtable.get("LimeRidgeMall");
                        return "com.Oguzhan.Swapnil.GTAFoody";
                    case "Place d'Orelans                                                         " +
                            "                                                                          " +
                            "                                                                  " +
                            "                                                                  " +
                            "                                                                  " +
                            " Ottawa, ON":
                        URLVariable = "http://www.placedorleans.com/hours";
                        currentrestaurant = samplehashtable.get("Placed'Orelans");
                        return "com.Oguzhan.Swapnil.GTAFoody";
                    case "Fairview Park Mall                                                         " +
                            "                                                                          " +
                            "                                                                  " +
                            "                                                                  " +
                            "                                                                  " +
                            "Kitchener, ON":
                        URLVariable = "http://www.fairviewpark.ca/en/centreinfo/Pages/CentreHours.aspx";
                        currentrestaurant = samplehashtable.get("FairviewParkMall");
                        return "com.Oguzhan.Swapnil.GTAFoody";
                    case "Woodbine Centre                                                         " +
                            "                                                                          " +
                            "                                                                  " +
                            "                                                                  " +
                            "                                                                  " +
                            "Toronto, ON":
                        URLVariable = "http://www.woodbinecentre.ca/shopping-hours";
                        currentrestaurant = samplehashtable.get("WoodbineCentre");
                        return "com.Oguzhan.Swapnil.GTAFoody";
                    case "Promenade Shopping Centre                                                         " +
                            "                                                                          " +
                            "                                                                  " +
                            "                                                                  " +
                            "                                                                  " +
                            "Vaughn, ON":
                        URLVariable = "http://www.promenade.ca/en/centreinfo/Pages/CentreHours.aspx";
                        currentrestaurant = samplehashtable.get("PromenadeShoppingCentre");
                        return "com.Oguzhan.Swapnil.GTAFoody";
                    case "White Oaks Mall                                                        " +
                            "                                                                          " +
                            "                                                                  " +
                            "                                                                  " +
                            "                                                                  " +
                            "London, ON":
                        URLVariable = "http://www.whiteoaksmall.ca/mobile/index.php";
                        currentrestaurant = samplehashtable.get("WhiteOaksMall");
                        return "com.Oguzhan.Swapnil.GTAFoody";
                    case  "Shoppers World                                                         " +
                            "                                                                          " +
                            "                                                                  " +
                            "                                                                  " +
                            "                                                                  " +
                            "Brampton, ON":
                        URLVariable = "http://www.shoppersworldbrampton.com/Mallhours.aspx";
                        currentrestaurant = samplehashtable.get("ShoppersWorld");
                        return "com.Oguzhan.Swapnil.GTAFoody";
                    case "Conestoga Mall                                                         " +
                            "                                                                          " +
                            "                                                                  " +
                            "                                                                  " +
                            "                                                                  " +
                            "Waterloo, ON":
                        URLVariable = "http://www.conestogamall.com/en-CA/mall-hours";
                        currentrestaurant = samplehashtable.get("ConestogaMall");
                        return "com.Oguzhan.Swapnil.GTAFoody";
                    case "Centerpoint Mall                                                         " +
                            "                                                                          " +
                            "                                                                  " +
                            "                                                                  " +
                            "                                                                  " +
                            "Toronto, ON":
                        URLVariable = "http://www.centerpointshops.com/hours";
                        currentrestaurant = samplehashtable.get("CentrepointMall");
                        return "com.Oguzhan.Swapnil.GTAFoody";














                    case "A&W":
                        URLVariable = "http://www.aw.ca/mobile.nsf/menu";
                        return "com.Oguzhan.Swapnil.GTAFoody.Store_Menu";
                    case "Amaya Express":
                        URLVariable = "http://www.amayarestaurant.com/amayaex/index.php?pg=takeout";
                        return "com.Oguzhan.Swapnil.GTAFoody.Store_Menu";
                    case "Basil Box":
                        URLVariable = "None";
                        return "com.Oguzhan.Swapnil.GTAFoody.Store_Menu";
                    case "Big Smoke Burger":
                        URLVariable = "http://www.bigsmokeburger.com/menu/";
                        return "com.Oguzhan.Swapnil.GTAFoody.Store_Menu";
                    case "Bourbon Street Grill":
                        URLVariable = "http://www.bourbonstreetgrille.com/menu.htm";
                        return "com.Oguzhan.Swapnil.GTAFoody.Store_Menu";
                    case "Burger King":
                        URLVariable = "http://www.bk.com/menu";
                        return "com.Oguzhan.Swapnil.GTAFoody.Store_Menu";
                    case "Charleys Steakery":
                        URLVariable = "http://charleys.com/food/";
                        return "com.Oguzhan.Swapnil.GTAFoody.Store_Menu";
                    case "Chipotle":
                        URLVariable = "http://chipotle.com/menu";
                        return "com.Oguzhan.Swapnil.GTAFoody.Store_Menu";
                    case "Cinnabon":
                        URLVariable = "http://www.cinnabon.com/bakery-treats";
                        return "com.Oguzhan.Swapnil.GTAFoody.Store_Menu";
                    case "Cultures":
                        URLVariable = "http://www.cultures-restaurants.com/en/menu.php";
                        return "com.Oguzhan.Swapnil.GTAFoody.Store_Menu";
                    case "Dairy Queen":
                        URLVariable = "http://www.dairyqueen.com/us-en/Menu/Full-Menu/?" +
                                "localechange=1&";
                        return "com.Oguzhan.Swapnil.GTAFoody.Store_Menu";
                    case "Jimmy The Greek":
                        URLVariable = "http://www.jimmythegreek.com/";
                        return "com.Oguzhan.Swapnil.GTAFoody.Store_Menu";
                    case "KFC":
                        URLVariable = "http://www.kfc.ca/menu/index.aspx?gclid=Cj0KEQ" +
                                "jw4qqrBRDE2K_z7Pbvjo8BEiQA39AImdM9HaLAaStv6y0OjumV1r8AAdHYtA" +
                                "83Uzoo-nOtKd0aAgun8P8HAQ";
                        return "com.Oguzhan.Swapnil.GTAFoody.Store_Menu";
                    case "Manchu Wok":
                        URLVariable = "http://www.manchuwok.com/menu/";
                        return "com.Oguzhan.Swapnil.GTAFoody.Store_Menu";
                    case "Mrs Vanellis":
                        URLVariable = "http://www.vanellisrestaurants.com/en/menu";
                        return "com.Oguzhan.Swapnil.GTAFoody.Store_Menu";
                    case "Mr.Sub":
                        URLVariable = "http://www.mrsub.ca/menu.html";
                        return "com.Oguzhan.Swapnil.GTAFoody.Store_Menu";
                    case "New York Fries":
                        URLVariable = "http://www.newyorkfries.com/menu";
                        return "com.Oguzhan.Swapnil.GTAFoody.Store_Menu";
                    case "Koya Japan":
                        URLVariable = "http://www.koyajapan.com/en/menu.aspx";
                        return "com.Oguzhan.Swapnil.GTAFoody.Store_Menu";
                    case "Tim Hortons":
                        URLVariable = "http://www.timhortons.com/ca/en/menu/coffee.php";
                        return "com.Oguzhan.Swapnil.GTAFoody.Store_Menu";
                    case "Pizza Pizza":
                        URLVariable = "http://www.pizzapizza.ca/view-our-menu/";
                        return "com.Oguzhan.Swapnil.GTAFoody.Store_Menu";
                    case "Subway":
                        URLVariable = "http://www.subway.com/menu/";
                        return "com.Oguzhan.Swapnil.GTAFoody.Store_Menu";
                    case "Teriyaki Experience":
                        URLVariable = "http://www.teriyakiexperience.com/en/Our-Food.html";
                        return "com.Oguzhan.Swapnil.GTAFoody.Store_Menu";
                    case "Akashiro":
                        URLVariable = "http://akashiro.ca/menu.html";
                        return "com.Oguzhan.Swapnil.GTAFoody.Store_Menu";
                    case "Froshberg Gelato":
                        URLVariable = "None";
                        return "com.Oguzhan.Swapnil.GTAFoody.Store_Menu";
                    case "Aroma Espresso Bar":
                        URLVariable = "http://www.aroma.ca/menu/beverages/";
                        return "com.Oguzhan.Swapnil.GTAFoody.Store_Menu";
                    case "Urban Herbivore":
                        URLVariable = "http://www.herbivore.to/";
                        return "com.Oguzhan.Swapnil.GTAFoody.Store_Menu";

                    case "Sakura Ichiban Express":
                        URLVariable = "None";
                        return "com.Oguzhan.Swapnil.GTAFoody.Store_Menu";
                    case "Rocky Mountain Chocolate Factory":
                        URLVariable = "http://www.rockychoc.com/our-treats/";
                        return "com.Oguzhan.Swapnil.GTAFoody.Store_Menu";
                    case "Kernels Popcorn":
                        URLVariable = "https://www.kernelspopcorn.com/pdf/popcorn.pdf";
                        return "com.Oguzhan.Swapnil.GTAFoody.Store_Menu";
                    case "Big Orange":
                        URLVariable = "http://www.bigorange.ca/products/";
                        return "com.Oguzhan.Swapnil.GTAFoody.Store_Menu";
                    case "California Thai":
                        URLVariable = "http://www.californiathai.ca/#menu";
                        return "com.Oguzhan.Swapnil.GTAFoody.Store_Menu";
                    case "Crepe de Licious":
                        URLVariable = "http://crepedelicious.com/menu/";
                        return "com.Oguzhan.Swapnil.GTAFoody.Store_Menu";
                    case "Orange Julius":
                        URLVariable = "http://www.orangejulius.com/Menu/menu-and-nutrition/";
                        return "com.Oguzhan.Swapnil.GTAFoody.Store_Menu";
                    case "Famous Wok":
                        URLVariable = "http://eatfamouswok.com/our-menu/";
                        return "com.Oguzhan.Swapnil.GTAFoody.Store_Menu";
                    case "Extreme Pita":
                        URLVariable = "http://extremepita.com/menu/?category=signature-pitas";
                        return "com.Oguzhan.Swapnil.GTAFoody.Store_Menu";
                    case "Fast Fresh Foods":
                        URLVariable = "http://www.fastfreshfoods.ca/FastFreshFoodsMenu.pdf";
                        return "com.Oguzhan.Swapnil.GTAFoody.Store_Menu";
                    case "Libery Noodle":
                        URLVariable = "http://libertynoodle.ca/menu2.php";
                        return "com.Oguzhan.Swapnil.GTAFoody.Store_Menu";
                    case "McDonald's":
                        URLVariable = "http://mcdonalds.ca/ca/en/menu.html";
                        return "com.Oguzhan.Swapnil.GTAFoody.Store_Menu";
                    case "Mucho Burrito":
                        URLVariable = "http://muchoburrito.com/index.html";
                        return "com.Oguzhan.Swapnil.GTAFoody.Store_Menu";
                    case "Ruby Thai Kitchen":
                        URLVariable = "http://www.yelp.ca/menu/ruby-thai-kitchen-natick";
                        return "com.Oguzhan.Swapnil.GTAFoody.Store_Menu";
                    case "Sbarro":
                        URLVariable = "http://sbarro.ie/menu/";
                        return "com.Oguzhan.Swapnil.GTAFoody.Store_Menu";
                    case "Fit for Life":
                        URLVariable = "http://fitforlifefood.com/menu/";
                        return "com.Oguzhan.Swapnil.GTAFoody.Store_Menu";
                    case "Fresh East":
                        URLVariable = "http://fresheast.ca/menu.html";
                        return "com.Oguzhan.Swapnil.GTAFoody.Store_Menu";
                    case "Hero Burgers":
                        URLVariable = "http://www.heroburgers.com/menu.php";
                        return "com.Oguzhan.Swapnil.GTAFoody.Store_Menu";
                    case "Mac's Sushi":
                        URLVariable = "http://www.macssushi.com/menu/";
                        return "com.Oguzhan.Swapnil.GTAFoody.Store_Menu";
                    case "Wendys":
                        URLVariable = "https://www.wendys.com/en-ca/everyday-value-menu";
                        return "com.Oguzhan.Swapnil.GTAFoody.Store_Menu";
                    case "Earls Kitchen & Bar":
                        URLVariable = "https://earls.ca/menu";
                        return "com.Oguzhan.Swapnil.GTAFoody.Store_Menu";
                    case "Godiva Chocolatier":
                        URLVariable = "http://www.godiva.com/collections";
                        return "com.Oguzhan.Swapnil.GTAFoody.Store_Menu";
                    case "Jugo Juice":
                        URLVariable = "http://www.jugojuice.com/en/menu";
                        return "com.Oguzhan.Swapnil.GTAFoody.Store_Menu";
                    case "Purdys Chocolates":
                        URLVariable = "http://www.purdys.com/Chocolate-Assortments-C3.aspx";
                        return "com.Oguzhan.Swapnil.GTAFoody.Store_Menu";
                    case "Second Cup":
                        URLVariable = "http://www.secondcup.com/menu";
                        return "com.Oguzhan.Swapnil.GTAFoody.Store_Menu";
                    case "Teavana":
                        URLVariable = "http://www.teavana.com/";
                        return "com.Oguzhan.Swapnil.GTAFoody.Store_Menu";
                    case "Turtle Jack's Muskoka Grill":
                        URLVariable = "http://turtlejacks.com/menus/";
                        return "com.Oguzhan.Swapnil.GTAFoody.Store_Menu";
                    case "Bento":
                        URLVariable = "http://bentosushi.com/menu#popular";
                        return "com.Oguzhan.Swapnil.GTAFoody.Store_Menu";
                    case "Caribbean Queen":
                        URLVariable = "https://www.zomato.com/toronto/caribbean-queen-etobicoke-gta/menu";
                        return "com.Oguzhan.Swapnil.GTAFoody.Store_Menu";
                    case "Michels Baguette":
                        URLVariable = "None";
                        return "com.Oguzhan.Swapnil.GTAFoody.Store_Menu";
                    case "Booster Juice":
                        URLVariable = "http://boosterjuice.com/products/menu";
                        return "com.Oguzhan.Swapnil.GTAFoody.Store_Menu";
                    case "DAVIDsTEA":
                        URLVariable = "https://www.davidstea.com/our-teas";
                        return "com.Oguzhan.Swapnil.GTAFoody.Store_Menu";
                    case "Espressamente illy":
                        URLVariable = "http://www.espressamenteilly.com.my/combos.php";
                        return "com.Oguzhan.Swapnil.GTAFoody.Store_Menu";
                    case "Famoso Neapolitan Pizzeria":
                        URLVariable = "http://www.famoso.ca/menu/pizza.php";
                        return "com.Oguzhan.Swapnil.GTAFoody.Store_Menu";
                    case "Holts Cafe":
                        URLVariable = "http://s7d9.scene7.com/is/content/HoltRenfrew1/bloor-menupdf";
                        return "com.Oguzhan.Swapnil.GTAFoody.Store_Menu";
                    case "Jamba Juice":
                        URLVariable = "http://www.jambajuice.com/menu-and-nutrition/menu";
                        return "com.Oguzhan.Swapnil.GTAFoody.Store_Menu";
                    case "La Paloma Gelateria & Cafe":
                        URLVariable = "None";
                        return "com.Oguzhan.Swapnil.GTAFoody.Store_Menu";
                    case "MICHEL's Bakery Cafe":
                        URLVariable = "None";
                        return "http://www.michelsbakerycafe.com/en/menu-items/";
                    case "MII Sandwich Store":
                        URLVariable = "None";
                        return "http://www.michelsbakerycafe.com/en/menu-items/";
                    case "Milestones Grill & Bar":
                        URLVariable = "http://www.milestonesrestaurants.com/menu.php";
                        return "http://www.michelsbakerycafe.com/en/menu-items/";
                    case "Moxies Classic Grill  ":
                        URLVariable = "http://www.moxies.ca/menu/mains";
                        return "http://www.michelsbakerycafe.com/en/menu-items/";
                    case "Pickel Barrel Grand":
                        URLVariable = "http://www.picklebarrel.ca/restaurant/";
                        return "http://www.michelsbakerycafe.com/en/menu-items/";
                    case "SU&SHI Noodle Bar":
                        URLVariable = "http://www.su-shi.ca/menus/";
                        return "http://www.michelsbakerycafe.com/en/menu-items/";
                    case "Ten Ren's Tea Time":
                        URLVariable = "http://tenrenstea.com/start/menu/";
                        return "http://www.michelsbakerycafe.com/en/menu-items/";
                    case "Yogen Fruz":
                        URLVariable = "http://www.yogenfruz.com/menu/";
                        return "http://www.michelsbakerycafe.com/en/menu-items/";
                    case "Shanghai 360":
                        URLVariable = "http://www.irg168.com/shanghai.html";
                        return "com.Oguzhan.Swapnil.GTAFoody.Store_Menu";
                    case "Starbucks":
                        URLVariable = "http://www.starbucks.ca/?gclid=Cj0KEQjw4qqrBRDE2K_z7" +
                                "Pbvjo8BEiQA39AImam-yh_ZY9qAoSJiARTwkxW7qweFflAH7U0bSHnqI14aAj" +
                                "1g8P8HAQ";
                        return "com.Oguzhan.Swapnil.GTAFoody.Store_Menu";
                    case "Su & Shi":
                        URLVariable = "None";
                        return "com.Oguzhan.Swapnil.GTAFoody.Store_Menu";
                    case "Sushi-Q":
                        URLVariable = "None";
                        return "com.Oguzhan.Swapnil.GTAFoody.Store_Menu";
                    case "Szechuan Express":
                        URLVariable = "https://www.zomato.com/toronto/szechuan-express-" +
                                "financial-district/menu";
                        return "com.Oguzhan.Swapnil.GTAFoody.Store_Menu";
                    case "Taco Bell":
                        URLVariable = "https://www.tacobell.com/m/menu";
                        return "com.Oguzhan.Swapnil.GTAFoody.Store_Menu";
                    case "Thai Express":
                        URLVariable = "http://www.thaiexpress.ca/menu/";
                        return "com.Oguzhan.Swapnil.GTAFoody.Store_Menu";
                    case "Villa Madina":
                        URLVariable = "http://www.villamadina.com/en/menu";
                        return "com.Oguzhan.Swapnil.GTAFoody.Store_Menu";
                    case "Freshly Squeezed":
                        URLVariable = "http://www.freshlysqueezed.ca/index.php?r=web/products";
                        return "com.Oguzhan.Swapnil.GTAFoody.Store_Menu";
                    case "The Keg":
                        URLVariable = "https://www.kegsteakhouse.com/menu/";
                        return "com.Oguzhan.Swapnil.GTAFoody.Store_Menu";
                    case "Spring Rolls":
                        URLVariable = "http://www.springrolls.ca/menu.php";
                        return "com.Oguzhan.Swapnil.GTAFoody.Store_Menu";
                    case "St. Louis Bar and Grill":
                        URLVariable = "http://stlouiswings.com/menu/starters-1/";
                        return "com.Oguzhan.Swapnil.GTAFoody.Store_Menu";
                    case "Bramalae City Pizza":
                        URLVariable = "http://bramaleacitypizza.ca/flyer.html";
                        return "com.Oguzhan.Swapnil.GTAFoody.Store_Menu";
                    case "Five Guys":
                        URLVariable = "http://www.fiveguys.com/menu.aspx";
                        return "com.Oguzhan.Swapnil.GTAFoody.Store_Menu";
                    case "Fresh Slice":
                        URLVariable = "http://www.freshslice.com/menu/menu-ontario/";
                        return "com.Oguzhan.Swapnil.GTAFoody.Store_Menu";
                    case "Grill It Up":
                        URLVariable = "http://grillitup.ca/";
                        return "com.Oguzhan.Swapnil.GTAFoody.Store_Menu";
                    case "Ichiban Sushi Express":
                        URLVariable = "http://ichibansushiexpress.com/Roll_Maki/";
                        return "com.Oguzhan.Swapnil.GTAFoody.Store_Menu";
                    case "Kung Pao Wok":
                        URLVariable = "";
                        return "com.Oguzhan.Swapnil.GTAFoody.Store_Menu";
                    case "Paramount Fine Foods":
                        URLVariable = "http://www.paramountfinefoods.com/menu";
                        return "com.Oguzhan.Swapnil.GTAFoody.Store_Menu";
                    case "Popeye's Chicken":
                        URLVariable = "http://popeyeschicken.ca/menu/";
                        return "com.Oguzhan.Swapnil.GTAFoody.Store_Menu";
                    case "Tiki Ming":
                        URLVariable = "http://www.tikiming.com/en/menu.aspx";
                        return "com.Oguzhan.Swapnil.GTAFoody.Store_Menu";
                    case "Valentine":
                        URLVariable = "https://valentine.ca/en/discover-our-menu/details/";
                        return "com.Oguzhan.Swapnil.GTAFoody.Store_Menu";
                    case "Wine Rack":
                        URLVariable = "http://www.winerack.com/Products";
                        return "com.Oguzhan.Swapnil.GTAFoody.Store_Menu";
                    case "Tropical Joe's":
                        URLVariable = "";
                        return "com.Oguzhan.Swapnil.GTAFoody.Store_Menu";
                    case "Baskin Robbins":
                        URLVariable = "http://www.baskinrobbins.ca/";
                        return "com.Oguzhan.Swapnil.GTAFoody.Store_Menu";
                    case "Baton Rouge":
                        URLVariable = "http://www.batonrouge.ca/menus.html";
                        return "com.Oguzhan.Swapnil.GTAFoody.Store_Menu";
                    case "Boston Pizza":
                        URLVariable = "https://order.bostonpizza.com/#/menu/C47EDBBA-1392-4BD3-A852-4FF40BFD1F54/ToGo/Pickup";
                        return "com.Oguzhan.Swapnil.GTAFoody.Store_Menu";
                    case "Bulk Barn":
                        URLVariable = "http://www.bulkbarn.ca/en-ca/productcategories.html";
                        return "com.Oguzhan.Swapnil.GTAFoody.Store_Menu";
                    case "Canyon Creek Chophouse":
                        URLVariable = "http://canyoncreekrestaurant.ca/#";
                        return "com.Oguzhan.Swapnil.GTAFoody.Store_Menu";
                    case "DAVID's TEA":
                        URLVariable = "https://www.davidstea.com/";
                        return "com.Oguzhan.Swapnil.GTAFoody.Store_Menu";
                    case "Jack Astor's Bar and Grill":
                        URLVariable = "http://jackastors.com/menu/";
                        return "com.Oguzhan.Swapnil.GTAFoody.Store_Menu";
                    case "Koryo Korean Barbeque":
                        URLVariable = "";
                        return "com.Oguzhan.Swapnil.GTAFoody.Store_Menu";
                    case "Laura Secord":
                        URLVariable = "http://www.laurasecord.ca/en/";
                        return "com.Oguzhan.Swapnil.GTAFoody.Store_Menu";
                    case "Michel's Baguette":
                        URLVariable = "http://www.michelsbakerycafe.com/en/menu-items/";
                        return "com.Oguzhan.Swapnil.GTAFoody.Store_Menu";
                    case "Milestone's Grill & Bar":
                        URLVariable = "http://www.milestonesrestaurants.com/menu.php";
                        return "com.Oguzhan.Swapnil.GTAFoody.Store_Menu";
                    case "Mrs. Fields":
                        URLVariable = "https://www.mrsfields.ca/#";
                        return "com.Oguzhan.Swapnil.GTAFoody.Store_Menu";
                    case "Pretzel Maker":
                        URLVariable = "http://pretzelmaker.ca/";
                        return "com.Oguzhan.Swapnil.GTAFoody.Store_Menu";
                    case "Sweet Tooth Candy Emporium":
                        URLVariable = "";
                        return "com.Oguzhan.Swapnil.GTAFoody.Store_Menu";
                    case "Swiss Chalet Rotisserie & Grill":
                        URLVariable = "https://www.swisschalet.com/";
                        return "com.Oguzhan.Swapnil.GTAFoody.Store_Menu";
                    case "Tandori":
                        URLVariable = "http://www.tandori.ca/en/menu.php";
                        return "com.Oguzhan.Swapnil.GTAFoody.Store_Menu";
                    case "Timothy's World Coffee":
                        URLVariable = "http://timothyscafes.com/en/menu-items/";
                        return "com.Oguzhan.Swapnil.GTAFoody.Store_Menu";
                    case "Lucky Strike Lanes":
                        URLVariable = "http://www.bowlluckystrike.com/menu/";
                        return "com.Oguzhan.Swapnil.GTAFoody.Store_Menu";
                    case "Bubble Tease":
                        URLVariable = "http://www.bubbletease.com/";
                        return "com.Oguzhan.Swapnil.GTAFoody.Store_Menu";
                    case "Sugar Mountain":
                        URLVariable = "http://www.sugarmountain.ca/Products";
                        return "com.Oguzhan.Swapnil.GTAFoody.Store_Menu";
                    case "Purdy�s Chocolates":
                        URLVariable = "http://www.purdys.com/";
                        return "com.Oguzhan.Swapnil.GTAFoody.Store_Menu";
                    case "Thai Island":
                        URLVariable = "";
                        return "com.Oguzhan.Swapnil.GTAFoody.Store_Menu";
                    case "South St. Burger Co.":
                        URLVariable = "http://www.southstburger.com/signature-burgers.php";
                        return "com.Oguzhan.Swapnil.GTAFoody.Store_Menu";
                    case "Dippin� Dots":
                        URLVariable = "https://www.dippindots.com/products.html";
                        return "com.Oguzhan.Swapnil.GTAFoody.Store_Menu";
                    case "Spudniks":
                        URLVariable = "http://www.spudniks.com/";
                        return "com.Oguzhan.Swapnil.GTAFoody.Store_Menu";
                    case "Island Way Sorbet":
                        URLVariable = "http://thesorbet.com/products";
                        return "com.Oguzhan.Swapnil.GTAFoody.Store_Menu";
























                }
                URLVariable = "None";
                return "com.Oguzhan.Swapnil.GTAFoody.Store_Menu";
            }

    static class MainActivityCustomAdapter extends ArrayAdapter<String> {

        Integer[] imageId = {R.drawable.logo, R.drawable.logo, R.drawable.logo,
                R.drawable.logo,
                R.drawable.logo,R.drawable.logo,R.drawable.logo,R.drawable.logo,
                R.drawable.logo,
                R.drawable.logo,R.drawable.logo,R.drawable.logo,R.drawable.logo,
                R.drawable.logo,R.drawable.logo,R.drawable.logo,R.drawable.logo,R.drawable.logo,
                R.drawable.logo,R.drawable.logo,R.drawable.logo,R.drawable.logo,R.drawable.logo,
                R.drawable.logo,R.drawable.logo,R.drawable.logo,R.drawable.logo,R.drawable.logo,
                R.drawable.logo,R.drawable.logo,R.drawable.logo,R.drawable.logo,R.drawable.logo,
                R.drawable.logo,R.drawable.logo,R.drawable.logo,};

        Typeface font;
        MainActivityCustomAdapter(Context context, String[] restaurants, Integer[] images) {

            super(context, R.layout.custom_row, restaurants);
            font= Typeface.createFromAsset(context.getAssets(), "Roboto-Light.ttf");



        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater foodyInflater = LayoutInflater.from(getContext());
            View customView = foodyInflater.inflate(R.layout.custom_row, parent, false);

            String singleFoodItem = getItem(position);

            TextView foodyText = (TextView) customView.findViewById(R.id.foodyText);


            ImageView foodyImage = (ImageView) customView.findViewById(R.id.foodyImage);
            //buckysImage is after the .id


            foodyText.setText(singleFoodItem);
            foodyText.setTypeface(font);





            foodyImage.setImageResource(imageId[position]);
            return customView;
        }
    }
}