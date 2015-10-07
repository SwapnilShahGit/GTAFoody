package com.Oguzhan.Swapnil.GTAFoody;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.github.paolorotolo.appintro.AppIntro;

import java.security.KeyStore;


public class IntroActivity extends AppIntro {

    // Please DO NOT override onCreate. Use init.
    @Override
    public void init(Bundle savedInstanceState) {

        // Add your slide's fragments here.
        // AppIntro will automatically generate the dots indicator and buttons.
        //need to add more fragments
        addSlide(new IntroActivityFragment(), getApplicationContext());
        addSlide(new IntroActivityFragment2(), getApplicationContext());

        // You can override bar/separator color if you want.
        setBarColor(Color.parseColor("#000000"));
        setSeparatorColor(Color.parseColor("#FFFFFF"));

        // You can also hide Skip button
        showSkipButton(true);
    }

    @Override
    public void onSkipPressed() {
        // Do something when users tap on Skip button.
        startActivity(new Intent(IntroActivity.this, MainActivity.class));

    }

    @Override
    public void onDonePressed() {
        // Do something when users tap on Done button.
        startActivity(new Intent(IntroActivity.this, MainActivity.class));

    }
}
