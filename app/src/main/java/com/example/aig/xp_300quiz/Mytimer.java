package com.example.aig.xp_300quiz;

/**
 * Created by AIG on 17.07.2017.
 */

public class Mytimer {

    private static int time = 60;

    public Mytimer() {
        if(time >= 60) {
            countDown();  //let countDown only run once
        }
    }

    private void countDown() {
        //insert a thread here, which counts your time down
    }

    public int getTime() {
        return this.time;
    }

}

