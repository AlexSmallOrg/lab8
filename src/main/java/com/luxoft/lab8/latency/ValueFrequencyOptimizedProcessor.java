package com.luxoft.lab8.latency;

import java.util.HashMap;
import java.util.Map;

public class ValueFrequencyOptimizedProcessor implements AbstractProcessor<Long> {
    Map<Integer,Long> frequencies = new HashMap<Integer, Long>();
    @Override
    public Long process(int value) {
        Long freq = frequencies.get(value);
        if (freq == null) {
            freq = 0L;
        }
        freq++;
        frequencies.put(value,freq);
        return freq;
    }
}

