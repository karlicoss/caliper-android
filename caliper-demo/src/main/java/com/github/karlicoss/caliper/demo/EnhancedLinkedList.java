package com.github.karlicoss.caliper.demo;

import java.util.Iterator;
import java.util.LinkedList;

public class EnhancedLinkedList extends EnhancedIterable {

    private final LinkedList<Integer> data;

    public EnhancedLinkedList(LinkedList<Integer> data) {
        this.data = data;
    }

    @Override
    public Iterator<Integer> iterator() {
        return data.iterator();
    }
}
