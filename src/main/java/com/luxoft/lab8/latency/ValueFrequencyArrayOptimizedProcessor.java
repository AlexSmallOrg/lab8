package com.luxoft.lab8.latency;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ValueFrequencyArrayOptimizedProcessor implements AbstractProcessor<Long> {
    Long[] frequencies = new Long[256];
    @Override
    public Long process(int value) {
        Long freq = frequencies[value];
        if (freq == null) {
            freq = 0L;
        }
        freq++;
        frequencies[value]=freq;
        return freq;
    }
}

