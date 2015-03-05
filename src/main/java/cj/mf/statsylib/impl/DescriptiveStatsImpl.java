package cj.mf.statsylib.impl;

import cj.mf.statsylib.Stats;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * Created by cjm on 3/4/15.
 */
public class DescriptiveStatsImpl implements Stats {

    private double[] inputArray;
    private DataInputStream in;

    /**
     * Default constructor
     */
    public DescriptiveStatsImpl() {
    }

    /**
     * Constructor with parameters
     *
     * @param inputArray the inputArray
     */
    public DescriptiveStatsImpl(double[] inputArray) {
        this.inputArray = inputArray;
    }

    /**
     * gets the inputArray
     *
     * @return the inputArray
     */
    public double[] getInputArray() {
        return inputArray;
    }

    /**
     * sets the inputArray
     *
     * @param inputArray the inputArray
     */
    public void setInputArray(double[] inputArray) {
        this.inputArray = inputArray;
    }

    /**
     * Gets the inputStream
     *
     * @return the inputStream
     */
    public DataInputStream getIn() {
        return in;
    }

    /**
     * Sets the inputStream
     *
     * @param in the inputStream
     */
    public void setIn(DataInputStream in) {
        this.in = in;
    }

    /**
     * DescriptiveStatistics implementation of doStats
     */
    @Override
    public void doStats() {
        // Get a DescriptiveStatistics instance
        DescriptiveStatistics stats = new DescriptiveStatistics();

        // Add the data from the array
        for (int i = 0; i < inputArray.length; i++) {
            stats.addValue(inputArray[i]);
        }

        // Compute some statistics
        double mean = stats.getMean();
        double std = stats.getStandardDeviation();
        double median = stats.getPercentile(50);

    }

    /**
     * Compute a rolling mean over the last 100 values seen
     */
    public void rollingMean() {
        Double line = new Double(0);
        // Create a DescriptiveStats instance and set the window size to 100
        DescriptiveStatistics stats = new DescriptiveStatistics();
        stats.setWindowSize(100);

        try {
            // Read data from an input stream,
            // displaying the mean of the most recent 100 observations
            // after every 100 observations
            long nLines = 0;
            while (line != null) {
                line = in.readDouble();
                stats.addValue(line);
                if (nLines == 100) {
                    nLines = 0;
                    System.out.println(stats.getMean());
                }
            }
            in.close();
        } catch (IOException e) {
            System.out.print(e);
        }
    }
}
