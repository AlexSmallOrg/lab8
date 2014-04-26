package com.luxoft.lab8.latency;

import org.junit.Test;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: alexsmall
 * Date: 25.04.14
 * Time: 0:13
 * To change this template use File | Settings | File Templates.
 */
public class PerformanceLatencyTest {

    private static final int MAX_CYCLES = 10000000;
    private static final int DISPLAY_TIME = 100000;
    private Object result;

    @Test
    public void testHashMapString() {
        long minTime = Long.MAX_VALUE;
        long maxTime = Long.MIN_VALUE;
        long avgTime = 0;
        long beforeTime = 0;
        long afterTime = 0;
        long curTime = 0;
        Random random = new Random();
        int value;

        AbstractProcessor<String> processor = new ValueFrequencyProcessor();
        //warmup
        value = random.nextInt(255);
        beforeTime = System.nanoTime();
        result = processor.process(value + 1);
        afterTime = System.nanoTime();

        for (int i = 1; i < MAX_CYCLES; i++) {
            value = random.nextInt(255);
            beforeTime = System.nanoTime();
            result = processor.process(value + 1);
            afterTime = System.nanoTime();
            curTime = afterTime - beforeTime;
            avgTime = (avgTime + curTime) / 2;
            if (i % DISPLAY_TIME == 0) {
                maxTime = (avgTime > maxTime) ? avgTime : maxTime;
                minTime = (avgTime < minTime) ? avgTime : minTime;
                System.out.printf("Time: \t avg: %1$8dns\t min: %2$8dns\t max: %3$8dns\n", avgTime, minTime, maxTime);
                avgTime = curTime;
            }
        }

    }
    @Test
    public void testLinkedHashMapLong() {
        long minTime = Long.MAX_VALUE;
        long maxTime = Long.MIN_VALUE;
        long avgTime = 0;
        long beforeTime = 0;
        long afterTime = 0;
        long curTime = 0;
        Random random = new Random();
        int value;

        AbstractProcessor<Long> processor = new ValueFrequencyOptimizedProcessor();
        //warm up
        value = random.nextInt(255);
        beforeTime = System.nanoTime();
        result = processor.process(value + 1);
        afterTime = System.nanoTime();

        for (int i = 1; i < MAX_CYCLES; i++) {
            value = random.nextInt(255);
            beforeTime = System.nanoTime();
            result = processor.process(value + 1);
            afterTime = System.nanoTime();
            curTime = afterTime - beforeTime;
            avgTime = (avgTime + curTime) / 2;
            if (i % DISPLAY_TIME == 0) {
                maxTime = (avgTime > maxTime) ? avgTime : maxTime;
                minTime = (avgTime < minTime) ? avgTime : minTime;
                System.out.printf("Time: \t avg: %1$8dns\t min: %2$8dns\t max: %3$8dns\n", avgTime, minTime, maxTime);
                avgTime = curTime;
            }
        }

    }
    @Test
    public void testArrayListLong() {
        long minTime = Long.MAX_VALUE;
        long maxTime = Long.MIN_VALUE;
        long avgTime = 0;
        long beforeTime = 0;
        long afterTime = 0;
        long curTime = 0;
        Random random = new Random();
        int value;

        AbstractProcessor<Long> processor = new ValueFrequencyArrayOptimizedProcessor();
        //warm up
        value = random.nextInt(255);
        beforeTime = System.nanoTime();
        result = processor.process(value + 1);
        afterTime = System.nanoTime();

        for (int i = 1; i < MAX_CYCLES; i++) {
            value = random.nextInt(255);
            beforeTime = System.nanoTime();
            result = processor.process(value + 1);
            afterTime = System.nanoTime();
            curTime = afterTime - beforeTime;
            avgTime = (avgTime + curTime) / 2;
            if (i % DISPLAY_TIME == 0) {
                maxTime = (avgTime > maxTime) ? avgTime : maxTime;
                minTime = (avgTime < minTime) ? avgTime : minTime;
                System.out.printf("Time: \t avg: %1$8dns\t min: %2$8dns\t max: %3$8dns\n", avgTime, minTime, maxTime);
                avgTime = curTime;
            }
        }

    }
    @Test
    public void testArrayListLongLinear() {
        long minTime = Long.MAX_VALUE;
        long maxTime = Long.MIN_VALUE;
        long avgTime = 0;
        long beforeTime = 0;
        long afterTime = 0;
        long curTime = 0;
        int value;

        AbstractProcessor<Long> processor = new ValueFrequencyArrayOptimizedProcessor();
        //warm up
        value = 0;
        beforeTime = System.nanoTime();
        result = processor.process(value + 1);
        afterTime = System.nanoTime();

        for (int i = 1; i < MAX_CYCLES; i++) {
            value = i % 255;
            beforeTime = System.nanoTime();
            result = processor.process(value);
            afterTime = System.nanoTime();
            curTime = afterTime - beforeTime;
            avgTime = (avgTime + curTime) / 2;
            if (i % DISPLAY_TIME == 0) {
                maxTime = (avgTime > maxTime) ? avgTime : maxTime;
                minTime = (avgTime < minTime) ? avgTime : minTime;
                System.out.printf("Time: \t avg: %1$8dns\t min: %2$8dns\t max: %3$8dns\n", avgTime, minTime, maxTime);
                avgTime = curTime;
            }
        }

    }

}
