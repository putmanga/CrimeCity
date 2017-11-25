package com.company.util;

public class ThreadUtils {
    public static void sleep(int milliseconds) {
        Thread currentThread = Thread.currentThread();
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            currentThread.interrupt();
        }
    }
}
