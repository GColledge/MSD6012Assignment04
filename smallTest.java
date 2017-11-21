package assignment04;

import java.util.ArrayList;
import java.util.Comparator;
import assignment04.SortUtil;

public class smallTest {

  public smallTest() {
    // TODO Auto-generated constructor stub
  }

  public static void main(String[] args) {
    int [] arr = new int[100];

    ArrayList<Integer> testList = new ArrayList<Integer>();
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
//    for (int i = 0; i < 1; i++) {
//      testList.add((int)(Math.random() *100)%10);
//    }
    


    OrderNumerically c = new OrderNumerically();
    SortUtil.quicksort(testList, c);
    
    System.out.println(testList);

  }

  protected static class OrderNumerically implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
      return (o1).compareTo(o2);
    }
  }
}


