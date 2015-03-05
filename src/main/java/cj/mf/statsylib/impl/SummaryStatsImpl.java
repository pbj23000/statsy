package cj.mf.statsylib.impl;

import cj.mf.statsylib.Stats;
import org.apache.commons.math3.stat.descriptive.SummaryStatistics;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * Created by cjm on 3/4/15.
 */
public class SummaryStatsImpl implements Stats {

    private DataInputStream inputStream;
    private Double line;

    /**
     * Default constructor
     * DO NOT USE
     */
    private SummaryStatsImpl() {
    }

    /**
     * Constructor supporting parameters
     *
     * @param inputStream the inputStream
     */
    public SummaryStatsImpl(DataInputStream inputStream) {
        this.inputStream = inputStream;
    }

    /**
     * Gets the inputStream
     *
     * @return the inputStream
     */
    public DataInputStream getInputStream() {

        return inputStream;
    }

    /**
     * Sets the inputStream
     *
     * @param inputStream the inputStream
     */
    public void setInputStream(DataInputStream inputStream) {
        this.inputStream = inputStream;
    }

    /**
     * SummaryStatistics implementation of doStats
     */
    @Override
    public void doStats() throws IOException {
        // Get a SummaryStatistics instance
        SummaryStatistics stats = new SummaryStatistics();

        // Read data from an input stream,
        // adding values and updating sums, counters, etc.
        while (line != null) {
            line = inputStream.readDouble();
            stats.addValue(line);
        }
        inputStream.close();

        // Compute the statistics
        double mean = stats.getMean();
        double std = stats.getStandardDeviation();
        //double median = stats.getMedian(); <-- NOT AVAILABLE
    }
}
