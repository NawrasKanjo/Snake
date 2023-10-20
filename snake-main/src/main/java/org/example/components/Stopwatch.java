package org.example.components;

public class Stopwatch {
    private static long startTime;

    public static void startTimer(){
        startTime = System.currentTimeMillis(); // remembers the time when stopwatch is created aka started
    }

    public static double getElapsedTimeSeconds(){
        long now = System.currentTimeMillis();             // gets the current time
        double elapsedTime = (now - startTime) / 1000.0;   // calculates elapsed time and converts it to seconds (with decimals)
        return elapsedTime;
    }
}
