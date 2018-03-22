package hw2;

import edu.princeton.cs.algs4.StdRandom;

public class PercolationStats {

    int[] openSitesPerT;
    // array of number of open sites in each test

    public PercolationStats(int N, int T, PercolationFactory pf) {

        openSitesPerT = new int[T];
        // perform T independent experiments on an N-by-N grid
        if (N <= 0 || T <= 0) {
            throw new java.lang.IllegalArgumentException();
        }

        while (T > 0) {
            Percolation percolation = pf.make(N);
            int openSites = 0;

            while (!percolation.percolates()) {

                StdRandom.setSeed(System.currentTimeMillis());

                int randomRow = StdRandom.uniform(N);
                int randomCol = StdRandom.uniform(N);

                percolation.open(randomRow, randomCol);
                openSites++;
            }
            openSitesPerT[T] = openSites;
            T--;
        }

    }

    public double mean() {
        // sample mean of percolation threshold
        int count = 0;
        for (int i : openSitesPerT) {
            count += i;
        }

        return count / openSitesPerT.length;
    }

    public double stddev() {
        // sample standard deviation of percolation threshold
        double mean = mean();

        int total = 0;

        for (int i : openSitesPerT) {
            total += Math.pow((i - mean), 2);
        }

        return total / openSitesPerT.length - 1;
    }

    public double confidenceLow() {
        // low endpoint of 95% confidence interval
        double mean = mean();
        double stddev = stddev();

        return mean - 1.96 * stddev / Math.sqrt(openSitesPerT.length);
    }

    public double confidenceHigh() {
        // high endpoint of 95% confidence interval
        double mean = mean();
        double stddev = stddev();

        return mean + 1.96 * stddev / Math.sqrt(openSitesPerT.length);
    }
}
