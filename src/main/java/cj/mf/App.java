package cj.mf;

import cj.mf.statsylib.Stats;
import cj.mf.statsylib.impl.*;

import java.io.*;

/**
 * Hello world!
 */
public class App {


    public static void main(String[] args) {

        double[] inputArray = populateArray((long) 5);
        File dataFile = new File(
                App.class.getClassLoader().getResource("data.dat").getFile());
        DataInputStream inputStream = null;
        try {
            inputStream = populateDataInputStream(dataFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Stats aggregateStats = new AggregateStatsImpl();
        Stats descriptiveStats = new DescriptiveStatsImpl(inputArray, inputStream);
        Stats statUtilsStats = new StatUtilsStatsImpl(inputArray);
        Stats summaryStats = new SummaryStatsImpl(inputStream);
        Stats threadSafeStats = new ThreadSafeStatsImpl(inputArray);

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

    private static double[] populateArray(long n) {
        double[] toReturn = new double[(int) n];
        for (int i = 0; i < n; i++) {
            toReturn[i] = (double) i;
        }
        return toReturn;
    }

    private static DataInputStream populateDataInputStream(File f) throws FileNotFoundException {
        DataInputStream toReturn = new DataInputStream(new FileInputStream(f));
        return toReturn;
    }
}
