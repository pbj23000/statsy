package cj.mf.statsylib.impl;

import cj.mf.statsylib.Stats;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.apache.commons.math3.stat.descriptive.SynchronizedDescriptiveStatistics;

/**
 * Created by cjm on 3/4/15.
 */
public class ThreadSafeStatsImpl implements Stats {

    private double[] inputArray;

    /**
     * Constructor that accepts parameters
     *
     * @param inputArray the inputArray
     */
    public ThreadSafeStatsImpl(double[] inputArray) {

        this.inputArray = inputArray;
    }

    /**
     * Default constructor
     */
    private ThreadSafeStatsImpl() {

    }

    /**
     * Gets the inputArray
     *
     * @return the inputArray
     */
    public double[] getInputArray() {
        return inputArray;
    }

    /**
     * Sets the inputArray
     *
     * @param inputArray the inputArray
     */
    public void setInputArray(double[] inputArray) {
        this.inputArray = inputArray;
    }

    //todo: implement this as the other DescriptiveStatistics class inside threads
    @Override
    public void doStats() {
        doDescriptiveStats();
    }

    private void doDescriptiveStats() {
        // Create a SynchronizedDescriptiveStatistics instance and
        // use as any other DescriptiveStatistics instance
        DescriptiveStatistics stats = new SynchronizedDescriptiveStatistics();

        // Add the data from the array
        for (double anInputArray : inputArray) {
            stats.addValue(anInputArray);
        }

        // Compute some statistics
        double mean = stats.getMean();
        double std = stats.getStandardDeviation();
        double median = stats.getPercentile(50);
    }
}
