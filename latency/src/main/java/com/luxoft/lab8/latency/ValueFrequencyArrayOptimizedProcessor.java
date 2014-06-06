package com.luxoft.lab8.latency;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ValueFrequencyArrayOptimizedProcessor implements AbstractProcessor<Long> {
    long[] frequencies = new long[256];
    @Override
    public Long process(int value) {
        return frequencies[value]++;
    }
}

