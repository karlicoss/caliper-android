package benchmarks;

import com.github.karlicoss.caliper.demo.EnhancedArrayList;
import com.github.karlicoss.caliper.demo.EnhancedIterable;
import com.github.karlicoss.caliper.demo.EnhancedLinkedList;
import com.google.caliper.Param;
import com.google.caliper.Runner;
import com.google.caliper.SimpleBenchmark;

import java.util.ArrayList;
import java.util.LinkedList;

public class DemoBenchmark extends SimpleBenchmark {
    /**
     * Caliper can deserialize string values to simple types
     */
    @Param({"1", "10", "100", "1000", "10000"})
    private int length;

    /**
     * If you don't feed any values in @Param, it will iterate over enum's values
     * See {@link Param} javadoc for more information.
     */
    @Param
    private Method method;

    private EnhancedIterable enhancedIterable;

    /**
     * If necessary, you may initialize test data dependent on @Params here
     */
    @Override
    protected void setUp() throws Exception {
        this.enhancedIterable = method.prepareEnhancedIterable(length);
    }

    private enum Method {
        ARRAY_LIST {
            @Override
            EnhancedIterable prepareEnhancedIterable(int count) {
                ArrayList<Integer> data = new ArrayList<>();
                for (int i = 0; i < count; i++) {
                    data.add(i);
                }
                return new EnhancedArrayList(data);
            }
        },
        LINKED_LIST {
            @Override
            EnhancedIterable prepareEnhancedIterable(int count) {
                LinkedList<Integer> data = new LinkedList<>();
                for (int i = 0; i < count; i++) {
                    data.add(i);
                }
                return new EnhancedLinkedList(data);
            }
        },
        ;

        abstract EnhancedIterable prepareEnhancedIterable(int count);
    }

    /*
        Benchmarks are prefixed with "time" prefix
     */
    public int timeSum(int repetitions) {
        int blackhole = 0;
        for (int i = 0; i < repetitions; i++) {
            blackhole += enhancedIterable.sum();
        }
        return blackhole;
    }

    public int timeProduct(int repetitions) {
        int blackhole = 0;
        for (int i = 0; i < repetitions; i++) {
            blackhole += enhancedIterable.product();
        }
        return blackhole;
    }

    public static void main(String[] args) throws Exception {
        /**
         * Workaround for crash
         * An exception was thrown from the benchmark code.
         java.lang.NullPointerException: Attempt to invoke virtual method 'boolean java.lang.String.equals(java.lang.Object)' on a null object reference
         at com.google.caliper.EnvironmentGetter.getEnvironmentSnapshot(EnvironmentGetter.java:66)
         at com.google.caliper.Runner.runOutOfProcess(Runner.java:384)
         com.google.caliper.Runner.run(Runner.java:97)
         at com.google.caliper.Runner.main(Runner.java:423)
         at com.google.caliper.Runner.main(Runner.java:436)
         at benchmarks.DemoBenchmark.main(DemoBenchmark.java:83)

         */
        Runner.main(DemoBenchmark.class, args);
    }
}
