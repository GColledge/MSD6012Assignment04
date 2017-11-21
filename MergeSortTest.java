package assignment04;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Comparator;

import org.junit.After;
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
    testList.add(1);
  }

  @After
  public void tearDown() throws Exception {
    
  }

  @Test
  public void testMergesort() {
    SortUtil.mergesort(testList, c);
    System.out.println(testList);
  }

  @Test
  public void testGenerateBestCase() {
    fail("Not yet implemented"); // TODO
  }

  @Test
  public void testGenerateAverageCase() {
    fail("Not yet implemented"); // TODO
  }

  @Test
  public void testGenerateWorstCase() {
    fail("Not yet implemented"); // TODO
  }

  protected static class OrderNumerically implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
      return (o1).compareTo(o2);
    }
  }
}

