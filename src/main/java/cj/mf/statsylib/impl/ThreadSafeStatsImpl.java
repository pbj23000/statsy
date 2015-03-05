package cj.mf.statsylib.impl;

import cj.mf.statsylib.Stats;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.apache.commons.math3.stat.descriptive.SynchronizedDescriptiveStatistics;

/**
 * Created by cjm on 3/4/15.
 */
public class ThreadSafeStatsImpl implements Stats {

    //todo: implement this as the other DescriptiveStatistics class inside threads
    @Override
    public void doStats() {
        // Create a SynchronizedDescriptiveStatistics instance and
        // use as any other DescriptiveStatistics instance
        DescriptiveStatistics stats = new SynchronizedDescriptiveStatistics();
    }
}
