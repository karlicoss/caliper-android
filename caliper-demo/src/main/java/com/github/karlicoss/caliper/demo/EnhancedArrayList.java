package com.github.karlicoss.caliper.demo;

import android.content.Intent;

import java.util.ArrayList;
import java.util.Iterator;

public class EnhancedArrayList extends EnhancedIterable {

    private Intent intent;

    private final ArrayList<Integer> data;

    public EnhancedArrayList(ArrayList<Integer> data) {
        this.data = data;
    }

    @Override
    public Iterator<Integer> iterator() {
        return data.iterator();
    }
}
