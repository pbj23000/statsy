package cj.mf;

import cj.mf.statsylib.Stats;
import cj.mf.statsylib.impl.*;

import java.io.IOException;

/**
 * Hello world!
 */
public class App {


    public static void main(String[] args) {

        Stats aggregateStats = new AggregateStatsImpl();
        Stats descriptiveStats = new DescriptiveStatsImpl();
        Stats statUtilsStats = new StatUtilsStatsImpl();
        Stats summaryStats = new SummaryStatsImpl();
        Stats threadSafeStats = new ThreadSafeStatsImpl();

        try {

            System.out.println("Running aggregate stats...");
            aggregateStats.doStats();
            //aggregateStats.doMultithreadedStats();

            System.out.println("Running descriptiveStats...");
            descriptiveStats.doStats();
            //descriptiveStats.doRollingMean();

            System.out.println("Running statUtilsStats...");
            statUtilsStats.doStats();

            System.out.println("Running summaryStats...");
            summaryStats.doStats();

            System.out.println("Running threadSafeStats...");
            threadSafeStats.doStats();

        } catch (IOException e) {
            System.out.print(e);
        }

        System.out.println("Hello World!");
    }
}
