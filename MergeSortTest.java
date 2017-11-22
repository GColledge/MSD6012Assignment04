package assignment04;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Comparator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MergeSortTest {
  ArrayList<Integer> testList;
  OrderNumerically c;
  
  @Before
  public void setUp() throws Exception {
    c = new OrderNumerically();
    testList = new ArrayList<Integer>();
    testList = SortUtil.generateWorstCase(100);
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

