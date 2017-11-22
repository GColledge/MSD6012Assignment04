package assignment04;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Comparator;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import assignment04.smallTest.OrderNumerically;

public class MergeSortTest {
  ArrayList<Integer> testList;
  OrderNumerically c;
  
  @Before
  public void setUp() throws Exception {
    c = new OrderNumerically();
    testList = new ArrayList<Integer>();
    testList.add(9);
    testList.add(2);
    testList.add(6);
    testList.add(4);
    testList.add(3);
    testList.add(5);
    testList.add(9);
    testList.add(9);
    testList.add(2);
    testList.add(6);
    testList.add(4);
    testList.add(3);
    testList.add(5);
//    testList.add(1);
  }

  @After
  public void tearDown() throws Exception {
    
  }

  @Test
  public void testGenerateBestCase() {
    int size = 10;
    ArrayList<Integer> best = SortUtil.generateBestCase(size);
    for(int i = 0; i < size; i++) {
      if(best.get(i)!=i) {
        fail("Test failed: " + i + " " + best.get(i));
      }
    }
  }

  @Test
  public void testGenerateAverageCase() {
    int size = 10;
    ArrayList<Integer> first = SortUtil.generateAverageCase(size);
//test the randomness by comparing differences between consecutive elements
    int firstDif = first.get(0) - first.get(1);
    for(int i = 1; i < size -1; i++) {
      int dif = first.get(i) - first.get(i);
    }
  }

  @Test
  public void testGenerateWorstCase() {
    int size = 10;
    ArrayList<Integer> worst = SortUtil.generateWorstCase(size);
    for(int i = 0; i < size; i++) {
      if(worst.get(i)!= (size - i - 1)) {
        System.out.println("Worst Test failed: " + (size - i) + " " + worst.get(i));
        fail();
      }
    }
  }

  @Test
  public void testMergesortMediumSize() {
    int size = 1000;
    //create cases
    ArrayList<Integer> worst = SortUtil.generateWorstCase(size);
    ArrayList<Integer> aveCase = SortUtil.generateAverageCase(size);
    ArrayList<Integer> best = SortUtil.generateBestCase(size);

    //sort the arrays
    SortUtil.mergesort(worst, c);
    SortUtil.mergesort(best, c);
    SortUtil.mergesort(aveCase, c);
    //assertions
    Assert.assertArrayEquals(best.toArray(), worst.toArray());
    for(int i = 0 ; i < aveCase.size() - 1; i++) {
      assert(aveCase.get(i+1) - aveCase.get(i) >= 0);
    }
  }
  
  @Test
  public void testMergesortLargeSize() {
    int size = 100000;
    //create cases
    ArrayList<Integer> worst = SortUtil.generateWorstCase(size);
    ArrayList<Integer> aveCase = SortUtil.generateAverageCase(size);
    ArrayList<Integer> best = SortUtil.generateBestCase(size);
    //sort the arrays
    SortUtil.mergesort(worst, c);
    SortUtil.mergesort(best, c);
    SortUtil.mergesort(aveCase, c);
    //assertions
    Assert.assertArrayEquals(best.toArray(), worst.toArray());
    for(int i = 0 ; i < aveCase.size() - 1; i++) {
      assert(aveCase.get(i+1) - aveCase.get(i) >= 0);
    }
  }
  
  @Test
  public void testMergesortSmallSize() {
    int size = 2;
    //preliminary "at-a-glance" test
    SortUtil.mergesort(testList, c);
//    System.out.println(testList);
    //create cases
    ArrayList<Integer> worst = SortUtil.generateWorstCase(size);
    ArrayList<Integer> aveCase = SortUtil.generateAverageCase(size);
    ArrayList<Integer> best = SortUtil.generateBestCase(size);
    //sort the arrays
    SortUtil.mergesort(worst, c);
    SortUtil.mergesort(best, c);
    SortUtil.mergesort(aveCase, c);
    //assertions
    Assert.assertArrayEquals(best.toArray(), worst.toArray());
    for(int i = 0 ; i < aveCase.size() - 1; i++) {
      assert(aveCase.get(i+1) - aveCase.get(i) >= 0);
    }
  }
  
  @Test
  public void testMergesortRepeats() {
    int size = 200;
    ArrayList<Integer> repeats = new ArrayList<Integer>();
    for(int i = 0; i<size; i++) {
      repeats.add(i%17);
    }
    //sort the array
    SortUtil.mergesort(repeats, c);
    //assertions
    for(int i = 0 ; i < repeats.size() - 1; i++) {
      assert(repeats.get(i+1) - repeats.get(i) >= 0);
    }
  }
  @Test
  public void testMergesortEmpty() {
    ArrayList<Integer> empty = new ArrayList<Integer>();
    //sort the array
    SortUtil.mergesort(empty, c);
    //assertions
    assert(empty.isEmpty());
    }
  
  @Test
  public void testQuickSortSmallSize() {
    int size = 200;
    //preliminary "at-a-glance" test
    SortUtil.quicksort(testList, c);
//    System.out.println(testList);
    //create cases
    ArrayList<Integer> worst = SortUtil.generateWorstCase(size);
    ArrayList<Integer> aveCase = SortUtil.generateAverageCase(size);
    ArrayList<Integer> best = SortUtil.generateBestCase(size);
    //sort the arrays
    SortUtil.quicksort(worst, c);
    SortUtil.quicksort(best, c);
    SortUtil.quicksort(aveCase, c);
    //assertions
    Assert.assertArrayEquals(best.toArray(), worst.toArray());
    for(int i = 0 ; i < aveCase.size() - 1; i++) {
      assert(aveCase.get(i+1) - aveCase.get(i) >= 0);
    }
  }
  
  

  protected static class OrderNumerically implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
      return (o1).compareTo(o2);
    }
  }
}

