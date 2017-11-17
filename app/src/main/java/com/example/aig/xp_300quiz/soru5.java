package com.example.aig.xp_300quiz;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class soru5 extends AppCompatActivity {

    RadioButton ans1;
    RadioButton ans2;
    RadioButton ans3;
    RadioButton ans4;
    TextView soru3;
    Button next;
    TextView timer;
    Long x;

    @Override
    public void onBackPressed(){

    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soru5);

        getSupportActionBar().hide();
        ans1 = (RadioButton) findViewById(R.id.ans1);
        ans2 = (RadioButton) findViewById(R.id.ans2);
        ans3 = (RadioButton) findViewById(R.id.ans3);
        ans4 = (RadioButton) findViewById(R.id.ans4);
        soru3 = (TextView) findViewById(R.id.soru2);
        next =  (Button) findViewById(R.id.next);
        timer = (TextView) findViewById(R.id.timer);

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
                timer.setText( x +  "    saniye kaldı. ");
                if ( 40< x ){
                    timer.setTextColor(Color.parseColor("#32e76b"));
                }
                else if(  20<=x && x<=40) {
                    timer.setTextColor(Color.parseColor("#FFE9DD33"));
                }
                else {
                    timer.setTextColor(Color.parseColor("#DBDE3936"));
                    timer.startAnimation(anim);
                    v.vibrate(400);
                }
            }

            public void onFinish() {
                SharedPreferences.Editor editor = sp.edit();
                if (ans1.isChecked()) {
                    editor.putInt("answer_value5", 1);
                } else {
                    editor.putInt("answer_value5", 0);
                }
                editor.commit();
                Intent next = new Intent(getApplicationContext(), soru6.class);
                startActivity(next);
            }
        }.start();
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sp.edit();
                if (ans1.isChecked()) {
                    editor.putInt("answer_value5", 1);
                } else {
                    editor.putInt("answer_value5", 0);
                }
                editor.commit();
                Intent soru6 = new Intent(getApplicationContext(), soru6.class);
                startActivity(soru6);
                countDownTimer.cancel();
            }
        });


}}
