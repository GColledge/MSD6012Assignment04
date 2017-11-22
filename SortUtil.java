package assignment04;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class SortUtil<T> {
  
  private static int threshold = 17; // When mergesort switches over to insertionsort
  
  /**
   * Driver for mergesort algorithm. Creates temporary array to aid in sorting.
   * @param arr - arraylist, of any type, that needs to 
   * be sorted. Provided by the user.
   * @param comp - comparator to use in sorting the items in arr.
   */
  public static <T> void mergesort(ArrayList<T> arr, Comparator<? super T> comp) {
    ArrayList<T> temp = new ArrayList<T>();
    for (int i = 0; i < arr.size(); i++) {
      temp.add(null);
    }
    mergesortRecursive(arr, temp, comp, 0, arr.size() - 1);
  }

  /**
   * The mergesort recursion. Splits the array until it reaches a certain threshold
   * size and then switches out to insertion sort. 
   * @param arr - list that needs to be sorted.
   * @param temp - empty list to aid in sorting.
   * @param comp - comparator used to determine ordering of values.
   * @param left - low bound of current section of list.
   * @param right - high bound of current section of list.
   */
  public static <T> void mergesortRecursive(ArrayList<T> arr, ArrayList<T> temp, 
      Comparator<? super T> comp, int left, int right) {
    
    if ((right - left) > threshold) {
      int center = (left + right) / 2;
      mergesortRecursive(arr, temp, comp, left, center);
      mergesortRecursive(arr, temp, comp, center + 1, right);
      merge(arr, temp, comp, left, center + 1, right);
    }
    else {
      insertionSort(arr, comp, left, right);
    }
  }
  
  /**
   * Merges two sorted list sections using temp. The two sections must be adjacent.
   * The sorted region in temp then replaces the equivalent slots in the original
   * list, arr.
   * @param arr - original list, requires sorting.
   * @param temp - temporary list, contains one sorted section. (rest null)
   * @param comp - comparator to determine ordering for the list.
   * @param left - beginning of first sorted portion.
   * @param center_plus_one - beginning of second sorted portion. 
   * (one past the end of the first portion)
   * @param right - end of second portion.
   */
  public static <T> void merge(ArrayList<T> arr, ArrayList<T> temp, 
      Comparator<? super T> comp, int left, int center_plus_one, int right) {
    int temp_counter = left;
    int lhc = left; // left-hand counter
    int rhc = center_plus_one; // right-hand counter
    while (temp_counter <= right) {
      if (rhc > right) {
        temp.set(temp_counter, arr.get(lhc));
        temp_counter++; lhc++;
        continue;
      }
      else if (lhc == center_plus_one) {
        temp.set(temp_counter, arr.get(rhc));
        temp_counter++; rhc++;
        continue;
      }
      else if (comp.compare(arr.get(lhc), arr.get(rhc)) > 0) {
        temp.set(temp_counter, arr.get(rhc));
        temp_counter++; rhc++;
        continue;
      }
      else {
        temp.set(temp_counter, arr.get(lhc));
        temp_counter++; lhc++;
        continue;
      }
    }
    
    for (int i = left; i <= right; i++) {
        arr.set(i, temp.get(i));
    }
  }
  
  /**
   * Creates an arraylist of ordered integers from 0 to size.
   * @param size - the size of the list.
   * @return - a new ordered list.
   */
  public static ArrayList<Integer> generateBestCase(int size) {
    ArrayList<Integer> best_arr = new ArrayList<Integer>();
    for (int i = 0; i < size; i++) {
      best_arr.add(i);
    }
    return best_arr;
  }
  /**
   * Creates a pseudorandom arraylist of the size size.
   * @param size - the size of the list.
   * @return - a new pseudorandom list.
   */
  public static ArrayList<Integer> generateAverageCase(int size) {
    ArrayList<Integer> avg_arr = new ArrayList<Integer>();
    Random rand = new Random();
    rand.setSeed(2732);
    for (int i = 0; i < size; i++) {
      avg_arr.add(rand.nextInt());
    }
    return avg_arr;
  }

  /**
   * Creates a reverse-ordered arraylist of size size.
   * @param size - the size of the list.
   * @return - a new reverse-ordered list.
   */
  public static ArrayList<Integer> generateWorstCase(int size) {
    ArrayList<Integer> worst_arr = new ArrayList<Integer>();
    for (int i = size - 1; i >= 0; i--) {
      worst_arr.add(i);
    }
    return worst_arr; 
  }
  
  /**
   * Creates a reverse-ordered arraylist of size size.
   * @param size - the size of the list.
   * @return - a new reverse-ordered list.
   */
  public static ArrayList<Integer> generateMergeWorstCase(int size) {
    ArrayList<Integer> worst_arr = new ArrayList<Integer>(size);
    for (int i = 0; i < size; i++) {
      worst_arr.add(1);
    }
    int counter = 0;
    for (int i = 0; i < threshold; i++) {
      for (int j = 0; j < size / threshold; j++) {
        worst_arr.set((j * threshold) + i, counter);
        counter ++;
      }

    }
    return worst_arr; 
  }
  /** 
   * InsertionSort sorts the input array using an insertion 
   * sort algorithm and the input Comparator object. It assumes
   * the array contains strings (words) and, for the purposes of
   * finding anagrams, that the words themselves have been 
   * sorted. (alphabetized)
   * @param arr - a list of words
   * @param comp - a comparator that determines how the words are sorted
   * @return void - alphabetizes the list in place, no return.
   */
  public static <T> void insertionSort(ArrayList<T> arr, 
      Comparator<? super T> comp, int left, int right) {
    
    for(int i = left; i <= right; i++){ // Sort the list 
      T index = arr.get(i); 
      int j = i;
      while(j > left && (comp.compare(arr.get(j-1), index) > 0)){ 
        // Swap everything until the proper insertion point is found
        swap(arr, j - 1, j);
        j--;
      }
    }
  }
  public static <T> void quicksort(ArrayList<T> inputList, Comparator<? super T> c) {
    quickSortRecursive(inputList, 0, inputList.size()-1, c);
  }
  
  private static <T> void quickSortRecursive(ArrayList<T> inputList, int startIndex, int endIndex, Comparator<? super T> c) {
    if(startIndex >= endIndex) {
      return;
    }
    //pick pivot
    //int pivot = ((int)(Math.random() * 100))%(inputList.size());//pick a random pivot
    int pivot = (endIndex - startIndex)/2 + startIndex;
    pivot = partition(inputList, startIndex, endIndex, c, pivot);
    System.out.println("start: " + startIndex);
    System.out.println("pivot: " + pivot);
    System.out.println("end: " + endIndex);
    quickSortRecursive(inputList, startIndex, pivot-1, c);
    quickSortRecursive(inputList, pivot+1, endIndex, c);
  }
  
  private static <T> int partition(ArrayList<T> inputList, int leftPoint, int rightPoint, Comparator<? super T> c, int pivotIndex) {
   int rightBoundIndex = rightPoint;
   int leftBoundIndex = leftPoint;
   T pivotValue = inputList.get(pivotIndex);
   
    while(leftPoint <= rightPoint) {
      if(c.compare(inputList.get(leftPoint), pivotValue) <= 0) {
        leftPoint++;
//        if((leftPoint==rightPoint) && (c.compare(inputList.get(leftPoint), inputList.get(pivotIndex))<=0)){
//          swap(inputList, leftPoint, pivotIndex);
//          return leftPoint;
//        }
        continue;
      }
      
      if(c.compare(inputList.get(rightPoint), pivotValue) > 0) {
//        if((c.compare(inputList.get(leftPoint), inputList.get(rightPoint)) >= 0 && rightPoint<=leftPoint) || rightPoint==0){
//          break;
//        }
        rightPoint--;
        continue;
      }
      
      if(leftPoint== pivotIndex) {
        leftPoint++;
        continue;
      }else if (rightPoint == pivotIndex) {
        rightPoint--;
        continue;
      }
      if(leftPoint < rightPoint) {
        swap(inputList, leftPoint, rightPoint);
        leftPoint ++;
        rightPoint--;
      }
      
    }
    
    if(leftPoint > rightBoundIndex) {//keeps the leftPointer in bounds
      leftPoint = rightPoint;
    }else if (rightPoint < leftBoundIndex) {
      rightPoint = leftPoint;
    }
    if(rightPoint <= leftPoint && rightPoint==pivotIndex) {
      return rightPoint;
    }
    if(rightPoint < leftPoint && leftPoint==pivotIndex) {
      return leftPoint;
    }
    
    if(rightPoint < leftPoint && c.compare(inputList.get(rightPoint), pivotValue) <=0 && rightPoint > pivotIndex) {//or if rightPoint Value < leftPoint value
      swap(inputList, rightPoint, pivotIndex);
      return rightPoint;
    }else if(rightPoint < leftPoint && c.compare(inputList.get(leftPoint), pivotValue) >=0){
      swap(inputList, leftPoint, pivotIndex);
      return leftPoint;
    }
    swap(inputList, leftPoint, pivotIndex);
    return leftPoint;

  }
 
  
  /**
   * Switches adjacent values in the inputList.
   * @param inputList - arraylist containing values to be swapped.
   * @param leftPoint - location of first value.
   * @param rightPoint - location of second value.
   */
  private static <T> void swap(ArrayList<T> inputList, int leftPoint, int rightPoint) {
    T temp = inputList.get(leftPoint);
    inputList.set(leftPoint, inputList.get(rightPoint));
    inputList.set(rightPoint, temp);
  }
  
  /**
   * This method shifts all of the elements in the input list between the
   *  startPos and endPos up ONE position. This results in the start element
   *   appearing twice in the array and the endPos element getting overwritten
   *   completely.
   * @param inputList - arrayList of type T that will have a chunk of the elements shifted.
   * @param startPos - the index of the first position to shift up.
   * @param endPos - the index of the last elememt. 
   *                  THIS ELEMENT WILL BE OVERWRITTEN!!!
   */
    private static <T> void shiftElements(ArrayList<T> inputList, int startPos, int endPos) {
      if(endPos<startPos) {
        for(int i = endPos; i < startPos; i++) {
          inputList.set(i, inputList.get(i+1));
        }
      }
      for(int i = endPos; i > startPos; i--) {
        inputList.set(i, inputList.get(i-1));
      }
    }
}
