package cj.mf.statsylib.impl;

import cj.mf.statsylib.Stats;
import org.apache.commons.math3.stat.descriptive.AggregateSummaryStatistics;
import org.apache.commons.math3.stat.descriptive.StatisticalSummary;
import org.apache.commons.math3.stat.descriptive.SummaryStatistics;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by cjm on 3/4/15.
 */
public class AggregateStats implements Stats {

    @Override
    public void doStats() {
        // Create a AggregateSummaryStatistics instance to accumulate the overall statistics
        // and AggregatingSummaryStatistics for the subsamples
        AggregateSummaryStatistics aggregate = new AggregateSummaryStatistics();
        SummaryStatistics setOneStats = aggregate.createContributingStatistics();
        SummaryStatistics setTwoStats = aggregate.createContributingStatistics();
        // Add values to the subsample aggregates
        setOneStats.addValue(2);
        setOneStats.addValue(3);
        setTwoStats.addValue(2);
        setTwoStats.addValue(4);
        // ...
        // Full sample data is reported by the aggregate
        double totalSampleSum = aggregate.getSum();
    }

    public void doMultithreadedStats() {
        // Create SummaryStatistics instances for the subsample data
        SummaryStatistics setOneStats = new SummaryStatistics();
        SummaryStatistics setTwoStats = new SummaryStatistics();
        // Add values to the subsample SummaryStatistics instances
        setOneStats.addValue(2);
        setOneStats.addValue(3);
        setTwoStats.addValue(2);
        setTwoStats.addValue(4);
        //...
        // Aggregate the subsample statistics
        Collection<SummaryStatistics> aggregate = new ArrayList<>();
        aggregate.add(setOneStats);
        aggregate.add(setTwoStats);
        StatisticalSummary aggregatedStats = AggregateSummaryStatistics.aggregate(aggregate);

        // Full sample data is reported by aggregatedStats
        double totalSampleSum = aggregatedStats.getSum();
    }
}
