package com.luxoft.performance.latency;

import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by alexsmall on 25.04.14.
 */
public class LatencyExample {
    private static boolean runing = true;
    private static AbstractProcessor<String> processor;

    public static void main(String[] args) {
        System.out.println("Start");
        InputStreamReader input = new InputStreamReader(System.in);
        processor = new ValueFrequencyProcessor();
        while (runing) {
            int value = 0;
            try {
                value = input.read();
            } catch (IOException e) {
                //gracefully stop on error
                e.printStackTrace();
                runing = false;
                continue;
            }
            if (value == 64 || value == -1) { // Stop and exit
                System.out.println("Stop");
                runing = false;
                continue;
            }
            String result = processor.process(value);
            System.out.println(((char)value) + "=" + result);
        }
    }
}
