package com.luxoft.performance.latency;

/**
 * Created by alexsmall on 25.04.14.
 */
public interface AbstractProcessor<T> {
    T process(int value);
}
