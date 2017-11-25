package com.company.players;

import com.company.util.ThreadUtils;

import java.util.Random;

public class Robber implements Runnable {
    private static final int MIN_TIME = 1000;
    private static final int MAX_TIME = 6000;
    private static Random rnd = new Random();
    private Thread currentThread;
    private ThreadGroup threadGroup;

    @Override
    public void run() {
        currentThread = Thread.currentThread();
        threadGroup = new ThreadGroup(currentThread.getName());
        int agentCount = 0;
        while (!currentThread.isInterrupted()) {
            System.out.println(currentThread.getName() + " is robbing a bank!");
            cresteAgent(++agentCount);
            try {
                Thread.sleep(MIN_TIME + rnd.nextInt(MAX_TIME - MIN_TIME + 1));
            } catch (InterruptedException e) {
                currentThread.interrupt();
            }
        }
        System.out.println("I am " + currentThread.getName() + " and I surrender");
    }

    private void cresteAgent(int number) {
        Agent agent = new Agent(threadGroup, "Agent-" + number);
        agent.setDaemon(true);
        agent.start();
    }
}
