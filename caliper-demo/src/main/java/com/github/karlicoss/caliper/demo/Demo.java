package com.github.karlicoss.caliper.demo;

import com.google.common.collect.ContiguousSet;
import com.google.common.collect.DiscreteDomain;
import com.google.common.collect.Range;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Demo {

    public List<Integer> makeArrayListSequence(int count) {
        List<Integer> result = new ArrayList<>();
        result.addAll(ContiguousSet.create(Range.lessThan(count), DiscreteDomain.integers()));
        return result;
    }

    public List<Integer> makeLinkedListSequence(int count) {
        List<Integer> result = new LinkedList<>();
        result.addAll(ContiguousSet.create(Range.lessThan(count), DiscreteDomain.integers()));
        return result;
    }
}
