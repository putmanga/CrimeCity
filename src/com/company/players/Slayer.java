package com.company.players;

import com.company.util.ThreadUtils;

import java.util.Random;

public class Slayer extends Thread {
    private static final int MIN_TIME = 1000;
    private static final int MAX_TIME = 6000;
    private static Random rnd = new Random();

    public Slayer(String name) {
        super(name);
    }

    @Override
    public void run() {
        Thread currentThread = Thread.currentThread();
        while (currentThread.isAlive()) {
            System.out.println(currentThread.getName() + " is killing people");
            try {
                Thread.sleep(MIN_TIME + rnd.nextInt(MAX_TIME - MIN_TIME + 1));
            } catch (InterruptedException e) {
                //ignore
            }
        }
    }
}
