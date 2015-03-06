package cj.mf.statsylib.impl;

import cj.mf.statsylib.Stats;
import org.apache.commons.math3.stat.StatUtils;
import org.apache.commons.math3.util.FastMath;

/**
 * Created by cjm on 3/4/15.
 */
public class StatUtilsStatsImpl implements Stats {

    private double[] values;

    /**
     * Default constructor
     * DO NOT USE
     */
    private StatUtilsStatsImpl() {
    }

    /**
     * Constructor supporting parameters
     *
     * @param values the values
     */
    public StatUtilsStatsImpl(double[] values) {
        this.values = values;
    }

    /**
     * Gets the values
     *
     * @return the values
     */
    public double[] getValues() {
        return values;
    }

    /**
     * Sets the values
     *
     * @param values the values
     */
    public void setValues(double[] values) {
        this.values = values;
    }

    /**
     * StatsUtil implementation of doStats
     */
    @Override
    public void doStats() {
        doStatUtilsStats();
    }

    private void doStatUtilsStats() {
        // Compute statistics directly from the array
        // assume values is a double[] array
        double mean = StatUtils.mean(values);
        double std = FastMath.sqrt(StatUtils.variance(values));
        double median = StatUtils.percentile(values, 50);

        // Compute the mean of the first three values in the array
        mean = StatUtils.mean(values, 0, 3);
    }
}
