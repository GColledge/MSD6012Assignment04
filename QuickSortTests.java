package assignment04;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Comparator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class QuickSortTests {
  
  ArrayList<Integer> best_empty, avg_empty, worst_empty;
  ArrayList<Integer> best_short, avg_short, worst_short;
  ArrayList<Integer> best_med, avg_med, worst_med;
  ArrayList<Integer> best_long, avg_long, worst_long;
  ArrayList<Integer> best_single, avg_single, worst_single;
  ArrayList<Integer> best_two, avg_two, worst_two;
  ArrayList<Integer> repeats;
  OrderNumerically comp;
  int size0, size, single_item, two_items, size1, size2, size3;
  
  @Before
  public void setUp() throws Exception {
    comp = new OrderNumerically();
    
    // Empty arrays
    size0 = 0;
    best_empty = SortUtil.generateBestCase(size0);
    avg_empty = SortUtil.generateAverageCase(size0);
    worst_empty = SortUtil.generateWorstCase(size0);
    
    // single item arrays
    single_item = 1;
    best_single = SortUtil.generateBestCase(single_item);
    avg_single = SortUtil.generateAverageCase(single_item);
    worst_single = SortUtil.generateWorstCase(single_item);
    
    // two item arrays
    two_items = 2;
    best_two = SortUtil.generateBestCase(two_items);
    avg_two = SortUtil.generateAverageCase(two_items);
    worst_two = SortUtil.generateWorstCase(two_items);
    
    // Short arrays
    size1 = 10;
    best_short = SortUtil.generateBestCase(size1);
    avg_short = SortUtil.generateAverageCase(size1);
    worst_short = SortUtil.generateWorstCase(size1);

    // Medium arrays
    size2 = 10000;
    best_med = SortUtil.generateBestCase(size2);
    avg_med = SortUtil.generateAverageCase(size2);
    worst_med = SortUtil.generateWorstCase(size2);
    
    // Long arrays
    size3 = 1000000;
    best_long = SortUtil.generateBestCase(size3);
    avg_long = SortUtil.generateAverageCase(size3);
    worst_long = SortUtil.generateWorstCase(size3);
    
    // Lots of repeats
    repeats = new ArrayList<>();
    for (int i = 0; i < 100; i++) {
      repeats.add(8);
      repeats.add(9);
    }
    for (int i = 0; i < 100; i++) {
      repeats.add(2);
    }
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testEmpty() {
    SortUtil.quicksort(best_empty, comp);
    SortUtil.quicksort(avg_empty, comp);
    SortUtil.quicksort(worst_empty, comp);

    assert worst_empty.equals(best_empty);
    assert avg_empty.size() == size0 && avg_empty.size() == worst_empty.size();
  }
  
  @Test
  public void testSingle() {
    SortUtil.quicksort(best_single, comp);
    SortUtil.quicksort(avg_single, comp);
    SortUtil.quicksort(worst_single, comp);
    // System.out.println(avg_single);
    assert worst_single.equals(best_single);
    assert avg_single.size() == single_item && avg_single.size() == worst_single.size();
  }
  
  @Test
  public void testTwo() {
    SortUtil.quicksort(best_two, comp);
    SortUtil.quicksort(avg_two, comp);
    SortUtil.quicksort(worst_two, comp);

    assert worst_two.equals(best_two);
    assert avg_two.size() == two_items && avg_two.size() == worst_two.size();
  }
  
  @Test
  public void testShort() {
    SortUtil.quicksort(best_short, comp);
    SortUtil.quicksort(avg_short, comp);
    SortUtil.quicksort(worst_short, comp);
    System.out.println(avg_short);
    System.out.println(worst_short);
    for (int i = 0; i < size1 - 1; i ++) {
      assert avg_short.get(i) <= avg_short.get(i + 1);
      assert worst_short.get(i) <= worst_short.get(i + 1);
    }
    assert worst_short.equals(best_short);
    assert best_short.size() == size1;
  }

  @Test
  public void testMed() {
    SortUtil.quicksort(best_med, comp);
    SortUtil.quicksort(avg_med, comp);
    SortUtil.quicksort(worst_med, comp);
    for (int i = 0; i < size2 - 1; i ++) {
      assert avg_med.get(i) <= avg_med.get(i + 1);
    }
    assert worst_med.equals(best_med);
    assert best_med.size() == size2;
  }
/*  
  @Test
  public void testLong() {
    SortUtil.quicksort(best_long, comp);
    SortUtil.quicksort(avg_long, comp);
    SortUtil.quicksort(worst_long, comp);
    for (int i = 0; i <= size3 - 1; i ++) {
      assert avg_long.get(i) <= avg_long.get(i + 1);
    }
    assert worst_long.equals(best_long);
    assert best_long.size() == size3;
  }
  */
  @Test
  public void testRepeats() {
    SortUtil.quicksort(repeats, comp);
    System.out.println(repeats);
    for (int i = 0; i < repeats.size() - 1; i ++) {
      assert repeats.get(i) <= repeats.get(i + 1);
    }

  }
  
  protected static class OrderNumerically implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
      return (o1).compareTo(o2);
    }
  }
}
