package cj.mf.statsylib.impl;

import cj.mf.statsylib.Stats;
import org.apache.commons.math3.stat.descriptive.SummaryStatistics;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * Created by cjm on 3/4/15.
 */
public class SummaryStatsImpl implements Stats {

    private DataInputStream in;
    private Double line;

    /**
     * Gets the inputStream
     * @return the inputStream
     */
    public DataInputStream getIn() {

        return in;
    }

    /**
     * Sets the inputStream
     * @param in the inputStream
     */
    public void setIn(DataInputStream in) {
        this.in = in;
    }

    /**
     * Default constructor
     */
    public SummaryStatsImpl() {
    }

    /**
     * Constructor supporting parameters
     * @param in
     */
    public SummaryStatsImpl(DataInputStream in) {
        this.in = in;
    }

    /**
     * SummaryStatistics implementation of doStats
     */
    @Override
    public void doStats() {
        // Get a SummaryStatistics instance
        SummaryStatistics stats = new SummaryStatistics();

        try {
            // Read data from an input stream,
            // adding values and updating sums, counters, etc.
            while (line != null) {
                line = in.readDouble();
                stats.addValue(line);
            }
            in.close();
        } catch (IOException e) {
            System.out.print(e);
        }

        // Compute the statistics
        double mean = stats.getMean();
        double std = stats.getStandardDeviation();
        //double median = stats.getMedian(); <-- NOT AVAILABLE
    }
}
