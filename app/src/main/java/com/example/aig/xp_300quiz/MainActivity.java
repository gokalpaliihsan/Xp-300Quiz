package com.example.aig.xp_300quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button basla;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();


        basla = (Button)findViewById(R.id.basla);

        basla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent soru1 = new Intent(getApplicationContext(),Soru1.class);
                startActivity(soru1);

            }


        });}
    public void onBackPressed(){


            }
        }








