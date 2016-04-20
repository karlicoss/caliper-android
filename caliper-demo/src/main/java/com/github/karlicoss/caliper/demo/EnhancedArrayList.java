package com.github.karlicoss.caliper.demo;

import java.util.ArrayList;
import java.util.Iterator;

public class EnhancedArrayList extends EnhancedIterable {

    private final ArrayList<Integer> data;

    public EnhancedArrayList(ArrayList<Integer> data) {
        this.data = data;
    }

    @Override
    public Iterator<Integer> iterator() {
        return data.iterator();
    }
}
