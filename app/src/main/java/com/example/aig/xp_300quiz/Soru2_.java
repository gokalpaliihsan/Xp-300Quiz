package com.example.aig.xp_300quiz;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.os.Vibrator;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class Soru2_ extends AppCompatActivity  {

    RadioButton ans1;
    RadioButton ans2;
    RadioButton ans3;
    RadioButton ans4;
    TextView soru2;
    Button next;
    TextView zaman;
    long x;

    @Override
    public void onBackPressed(){

    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soru2_);

        getSupportActionBar().hide();

        ans1 = (RadioButton) findViewById(R.id.ans1);
        ans2 = (RadioButton) findViewById(R.id.ans2);
        ans3 = (RadioButton) findViewById(R.id.ans3);
        ans4 = (RadioButton) findViewById(R.id.ans4);
        zaman = (TextView) findViewById(R.id. zaman);
        soru2 = (TextView) findViewById(R.id.soru2);
        next =  (Button) findViewById(R.id.next);


        final Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        final Animation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(50);
        anim.setStartOffset(20);
        anim.setRepeatMode(Animation.REVERSE);
        anim.setRepeatCount(Animation.INFINITE);

        final SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());


        final CountDownTimer countDownTimer = new CountDownTimer(60000, 1000) {

            public void onTick(long millisUntilFinished) {
                x = millisUntilFinished/1000;
                zaman.setText( x +  "    saniye kaldı. ");
                if ( 40< x ){
                    zaman.setTextColor(Color.parseColor("#32e76b"));
                }
                else if(  20<=x && x<=40) {
                  zaman.setTextColor(Color.parseColor("#FFE9DD33"));
                }
                else {
                    zaman.setTextColor(Color.parseColor("#DBDE3936"));
                    zaman.startAnimation(anim);
                    v.vibrate(400);
                }
            }

            public void onFinish() {
                SharedPreferences.Editor editor = sp.edit();
                if (ans3.isChecked()) {
                    editor.putInt("answer_value2", 1);
                } else {
                    editor.putInt("answer_value2", 0);
                }
                editor.commit();
                Intent next = new Intent(getApplicationContext(), soru3.class);
                startActivity(next);
            }
        }.start();
                next.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SharedPreferences.Editor editor = sp.edit();
                        if (ans3.isChecked()) {
                            editor.putInt("answer_value2", 1);
                        } else {
                            editor.putInt("answer_value2", 0);
                        }
                        editor.commit();
                        Intent soru3 = new Intent(getApplicationContext(), soru3.class);
                        startActivity(soru3);
                        countDownTimer.cancel();


                        }}

                );






    }}























