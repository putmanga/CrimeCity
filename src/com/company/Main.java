package com.company;

import com.company.players.Robber;
import com.company.players.Slayer;
import com.company.util.ThreadUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    private static final int SLAYERS_COUNT = 3;
    private static final int ROBBERS_COUNT = 4;
    private static final int SLEEP_SECONDS = 10000;

    static List<Thread> band = new ArrayList<>();

    public static void main(String[] args) {

        startCrime();
        ThreadUtils.sleep(SLEEP_SECONDS);
        System.out.println("Police is here");
        nonViolentStopCrime();
        violentStopCrime();

    }

    private static void startCrime() {
        createSlayers();
        createRobbers();
        printBandInfo();

        band.forEach(Thread::start);
    }

    private static void createSlayers() {
        for (int i = 0; i < SLAYERS_COUNT; i++) {
            band.add(new Slayer("Slayer-" + (i + 1)));
        }
    }

    private static void createRobbers() {
        for (int i = 0; i < ROBBERS_COUNT; i++) {
            band.add(new Thread(new Robber(), "Robber-" + (i + 1)));
        }
    }

    private static void printBandInfo() {
        System.out.println("*************************");
        String bandSize = String.format("Band contains of %d members", band.size());
        System.out.println(bandSize);
        String bandList = band.stream()
                .map(Thread::getName)
                .collect(Collectors.toList())
                .toString();
        System.out.println(bandList);
        System.out.println("*************************");
    }

    private static void nonViolentStopCrime() {
        for (Thread criminal : band) {
            criminal.interrupt();
            ThreadUtils.sleep(50);
        }
    }

    private static void violentStopCrime() {
        for (Thread criminal : band) {
            if (criminal.isAlive()) {
                criminal.stop();
                System.out.println(criminal.getName() + " is killed by police!");
            }
        }
    }
}
