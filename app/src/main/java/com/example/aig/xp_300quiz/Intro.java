package com.example.aig.xp_300quiz;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Intro extends AppCompatActivity {
public void fade(View view) {

    ImageView Sysmex = (ImageView) findViewById(R.id.sysmex);
    Intent menu = new Intent(getApplicationContext(),MainActivity.class);
    startActivity(menu);
    overridePendingTransition(R.anim.fade_in,R.anim.fade_out);


}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        getSupportActionBar().hide();




    }
}
