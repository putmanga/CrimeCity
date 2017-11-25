package com.company.players;

import com.company.util.ThreadUtils;

public class Agent extends Thread {
    private static final int SLEEP_SECONDS = 5000;

    public Agent(String name) {
        super(name);
    }

    public Agent(ThreadGroup group, String name) {
        super(group, name);
    }

    @Override
    public void run() {
        ThreadUtils.sleep(SLEEP_SECONDS);
        System.out.println(getName() + " pursues " + getThreadGroup().getName());
    }
}
