package com.example.aig.xp_300quiz;

import android.widget.TextView;

import java.util.logging.Handler;
import java.util.logging.LogRecord;

/**
 * Created by AIG on 17.07.2017.
 */

public class TimerTextHelper implements Runnable {
    private final Handler handler = new Handler() {
        @Override
        public void publish(LogRecord record) {

        }

        @Override
        public void flush() {

        }

        @Override
        public void close() throws SecurityException {

        }
    };
    private final TextView textView;
    private volatile long startTime;
    private volatile long elapsedTime;

    public TimerTextHelper(TextView textView) {
        this.textView = textView;
    }

    @Override
    public void run() {
        long millis = System.currentTimeMillis() - startTime;
        int seconds = (int) (millis / 1000);
        int minutes = seconds / 60;
        seconds = seconds % 60;

        textView.setText(String.format("%d:%02d", minutes, seconds));

        if (elapsedTime == -1) {
            textView.postDelayed(this,500);
        }
    }

    public void start() {
        this.startTime = System.currentTimeMillis();
        this.elapsedTime = -1;
        textView.post(this);
    }

    public void stop() {
        this.elapsedTime = System.currentTimeMillis() - startTime;
        textView.removeCallbacks(this);
    }

    public long getElapsedTime() {
        return elapsedTime;
    }
}



