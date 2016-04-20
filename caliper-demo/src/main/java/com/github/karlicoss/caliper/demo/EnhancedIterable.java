package com.github.karlicoss.caliper.demo;

import java.util.Iterator;

public abstract class EnhancedIterable implements Iterable<Integer> {
    public int sum() {
        int res = 0;
        Iterator<Integer> iterator = iterator();
        while (iterator.hasNext()) {
            res += iterator.next();
        }
        return res;
    }

    public int product() {
        int res = 0;
        Iterator<Integer> iterator = iterator();
        while (iterator.hasNext()) {
            res *= iterator.next();
        }
        return res;
    }
}
