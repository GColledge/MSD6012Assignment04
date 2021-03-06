package assignment04;

import java.util.ArrayList;
import java.util.Comparator;

import assignment04.MergeSortTiming.OrderNumerically;

public class quickSortTiming {

    private static final int ITER_COUNT = 100;

    public static void main(String[] args) {
      // you spin me round baby, right round
      long startTime = System.nanoTime();
      while (System.nanoTime() - startTime < 1_000_000_000);//wait for CPU to be ready
      OrderNumerically comp = new OrderNumerically();

        for (int size = 500; size <= 25000; size += 500) { // This is used as the exponent to calculate the size of the set.

          // Do the experiment multiple times, and average out the results
          long totalTime = 0;

          for (int iter = 0; iter < ITER_COUNT; iter++) {
            // SET UP!
            ArrayList<Integer> avg_arr = SortUtil.generateWorstCase(size);
            // TIME IT!
            long start = System.nanoTime();
            SortUtil.quicksort(avg_arr, comp);
            long stop = System.nanoTime();
            totalTime += stop - start;
          }
          double averageTime = totalTime / (double) ITER_COUNT;
//          System.out.println(size + "\t" + averageTime); // print to console
          System.out.println(averageTime); // print to console
        }
      }
    
    protected static class OrderNumerically implements Comparator<Integer> {

      @Override
      public int compare(Integer o1, Integer o2) {
        return (o1).compareTo(o2);
      }
    }
 }

