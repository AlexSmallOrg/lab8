package com.luxoft.performance.latency;

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
        int freqInt = Integer.valueOf(freq);
        freqInt++;
        frequencies.put(String.valueOf(value),String.valueOf(freqInt));
        return String.valueOf(freqInt);
    }
}

