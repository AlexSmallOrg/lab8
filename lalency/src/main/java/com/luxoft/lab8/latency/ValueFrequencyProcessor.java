package com.luxoft.lab8.latency;

import java.util.HashMap;
import java.util.Map;

public class ValueFrequencyProcessor implements AbstractProcessor<String> {
    Map<String,String> frequencies = new HashMap<String, String>();
    @Override
    public String process(int value) {
        String freq = frequencies.get(String.valueOf(value));
        if (freq == null) {
            freq = "0";
        }
        long freqLong = Long.valueOf(freq);
        freqLong++;
        frequencies.put(String.valueOf(value),String.valueOf(freqLong));
//        try {
//            Thread.sleep(0,10);
//        } catch (InterruptedException e) {
//            //skip
//        }
        return String.valueOf(freqLong);
    }
}

