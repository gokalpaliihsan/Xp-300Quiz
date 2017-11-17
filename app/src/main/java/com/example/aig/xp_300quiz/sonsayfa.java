package com.example.aig.xp_300quiz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class sonsayfa extends AppCompatActivity {

    TextView sonuc;
    TextView soru1;
    TextView soru2;
    TextView soru3;
    TextView soru4;
    TextView soru5;
    TextView soru6;
    TextView soru7;
    TextView soru8;
    TextView soru9;
    TextView soru10;
    TextView total;
    TextView yorum;
    int score ;
    TextView süre ;

    @Override
    public void onBackPressed(){

    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sonsayfa);

        getSupportActionBar().hide();

        süre = (TextView) findViewById(R.id.süre);
        sonuc = (TextView) findViewById(R.id.sonuc);
        soru1 = (TextView) findViewById(R.id.soru1);
        soru2 = (TextView) findViewById(R.id.soru2);
        soru3 = (TextView) findViewById(R.id.soru3);
        soru4 = (TextView) findViewById(R.id.soru4);
        soru5 = (TextView) findViewById(R.id.soru5);
        soru6 = (TextView) findViewById(R.id.soru6);
        soru7 = (TextView) findViewById(R.id.soru7);
        soru8 = (TextView) findViewById(R.id.soru8);
        soru9 = (TextView) findViewById(R.id.soru9);
        soru10 = (TextView) findViewById(R.id.soru10);
        total = (TextView) findViewById(R.id.total);
        yorum = (TextView) findViewById(R.id. yorum);

        SharedPreferences app_preferences = PreferenceManager.getDefaultSharedPreferences(this);
        int q1ans = app_preferences.getInt("answer_value", 0);
        int q2ans = app_preferences.getInt("answer_value2", 0);
        int q3ans = app_preferences.getInt("answer_value3", 0);
        int q4ans = app_preferences.getInt("answer_value4", 0);
        int q5ans = app_preferences.getInt("answer_value5", 0);
        int q6ans = app_preferences.getInt("answer_value6", 0);
        int q7ans = app_preferences.getInt("answer_value7", 0);
        int q8ans = app_preferences.getInt("answer_value8", 0);
        int q9ans = app_preferences.getInt("answer_value9", 0);
        int q10ans = app_preferences.getInt("answer_value10", 0);

        if (q1ans == 1) {
            soru1.setText("     1.Soru                                                Dogru");
            soru1.setTextColor(Color.parseColor("#32e76b"));
        } else {
            soru1.setText("     1.Soru                                                Yanlıs");
            soru1.setTextColor(Color.parseColor("#DBDE3936"));
        }
        if (q2ans == 1) {
            soru2.setText("     2.Soru                                                Dogru");
            soru2.setTextColor(Color.parseColor("#32e76b"));
        }
        else {
            soru2.setText("     2.Soru                                                Yanlıs");
            soru2.setTextColor(Color.parseColor("#DBDE3936"));
        }
        if (q3ans == 1) {
            soru3.setText("     3.Soru                                                Dogru");
            soru3.setTextColor(Color.parseColor("#32e76b"));
        }
         else {
            soru3.setText("     3.Soru                                                Yanlıs");
            soru3.setTextColor(Color.parseColor("#DBDE3936"));
            }
        if (q4ans == 1){
            soru4.setText("     4.Soru                                                Dogru");
            soru4.setTextColor(Color.parseColor("#32e76b"));
        }
         else {
            soru4.setText("     4.Soru                                                Yanlıs");
            soru4.setTextColor(Color.parseColor("#DBDE3936"));
        }
        if(q5ans == 1){
            soru5.setText("     5.Soru                                                Dogru");
            soru5.setTextColor(Color.parseColor("#32e76b"));
        }
        else {
            soru5.setText("     5.Soru                                                Yanlıs");
            soru5.setTextColor(Color.parseColor("#DBDE3936"));
        }
        if(q6ans == 1 ) {
            soru6.setText("     6.Soru                                                Dogru");
            soru6.setTextColor(Color.parseColor("#32e76b"));
        }
        else {
            soru6.setText("     6.Soru                                                Yanlıs");
            soru6.setTextColor(Color.parseColor("#DBDE3936"));
        }
        if(q7ans == 1){
            soru7.setText("     7.Soru                                                Dogru");
            soru7.setTextColor(Color.parseColor("#32e76b"));
        }
        else {
            soru7.setText("     7.Soru                                                Yanlıs");
            soru7.setTextColor(Color.parseColor("#DBDE3936"));
        }
        if (q8ans == 1 ) {
            soru8.setText("     8.Soru                                                Dogru");
            soru8.setTextColor(Color.parseColor("#32e76b"));
        }
        else {
            soru8.setText("     8.Soru                                                Yanlıs");
            soru8.setTextColor(Color.parseColor("#DBDE3936"));
        }
        if (q9ans == 1) {
            soru9.setText("     9.Soru                                                Dogru");
            soru9.setTextColor(Color.parseColor("#32e76b"));
        }
        else {
            soru9.setText("     9.Soru                                                Yanlıs");
            soru9.setTextColor(Color.parseColor("#DBDE3936"));
        }
        if( q10ans == 1) {
            soru10.setText("    10.Soru                                               Dogru");
            soru10.setTextColor(Color.parseColor("#32e76b"));
        }
        else {
            soru10.setText("    10.Soru                                               Yanlıs");
            soru10.setTextColor(Color.parseColor("#DBDE3936"));
        }

        score = q1ans + q2ans + q3ans + q4ans + q5ans + q6ans + q7ans + q8ans + q9ans + q10ans;
        total.setText(score + " /10");

        if(8<= score && score<=10) {
            yorum.setText("Yarın gel işe başla");
        }
        else if ( 6<=score && score<=7){
            yorum.setText("Aferin kanki cogu şeyi hatırlıyorsun.");
        }
        else if (  4<=score && score<=5 ) {
            yorum.setText("Biraz unutmuşuz sanırım.");
        }
        else if ( 2<= score && score<=3){
            yorum.setText("Panpa naptın ya :/");
        }
        else {
            yorum.setText("Yaz okuluna bekleriz.");
        }
}}










