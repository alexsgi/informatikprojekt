package com.stickjumper.utils;

import java.util.Timer;
import java.util.TimerTask;

public class CountDownTimer extends Timer {

    private final int period = 1000; // 1 sec
    private Timer timer;

    public CountDownTimer(int countDownFrom, CountDownCallback countDownCallback) {
        if (countDownFrom < 1) return;
        timer = new Timer();
        final int[] x = {countDownFrom};
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (x[0] <= 1) {
                    countDownCallback.onFinish();
                    timer.cancel();
                } else {
                    countDownCallback.onTick(x[0]);
                }
                x[0]--;

            }
        }, 0, period);
    }

    public void cancel() {
        if (timer != null) timer.cancel();
    }

    public interface CountDownCallback {

        void onTick(int sec);

        void onFinish();

    }

}
