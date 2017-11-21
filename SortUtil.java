package assignment04;

import java.util.ArrayList;
import java.util.Comparator;

public class SortUtil<T> {
  
  private static int threshold = 10;
  
  public static <T> void mergesort(ArrayList<T> arr, Comparator<? super T> comp) {
    ArrayList<T> temp = new ArrayList<T>(arr.size());
    for (int i = 0; i < temp.size(); i++) {
      temp.set(i, null);
    }
    mergesort(arr, temp, comp, 0, arr.size() - 1);
  }

  public static <T> void mergesort(ArrayList<T> arr, ArrayList<T> temp, 
      Comparator<? super T> comp, int left, int right) {
    
    if ((right - left) > threshold) {
      int center = (left + right) / 2;
      mergesort(arr, temp, comp, left, center);
      mergesort(arr, temp, comp, center + 1, right);
      merge(arr, temp, comp, left, center + 1, right);
    }
    else {
      insertionSort(arr, comp, left, right);
    }
  }
  
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
    
    for (int i = 0; i < temp.size(); i++) {
      if(!temp.get(i).equals(null)) {
        arr.set(i, temp.get(i));
      }
    }
  }

  public static ArrayList<Integer> generateBestCase(int size) {
    ArrayList<Integer> best_arr = new ArrayList<Integer>();
    for (int i = 0; i < size; i++) {
      best_arr.add(i);
    }
    return best_arr;
  }

  public static ArrayList<Integer> generateAverageCase(int size){
    return null;
  }


  public static ArrayList<Integer> generateWorstCase(int size){
    ArrayList<Integer> worst_arr = new ArrayList<Integer>();
    for (int i = size; i > 0; i--) {
      worst_arr.add(i);
    }
    return worst_arr;  }
  
  /** 
   * InsertionSort sorts the input array using an insertion 
   * sort algorithm and the input Comparator object. It assumes
   * the array contains strings (words) and, for the purposes of
   * finding anagrams, that the words themselves have been 
   * sorted. (alphabetized)
   * @param arr - a list of words
   * @param comp - a comparator that determines how the words are sorted
   * @return void - alphabetizes the list directly
   */
  public static <T> void insertionSort(ArrayList<T> arr, 
      Comparator<? super T> comp, int left, int right) {
    
    for(int i = left; i < right; i++){ // Sort the list 
      T index = arr.get(i); 
      int j = i;
      while(j > left && (comp.compare(arr.get(j-1), index) > 0)){ 
        // Swap everything until the proper insertion point is found
        arr.add(j + 1, arr.get(j-1)); 
        arr.remove(j-1);
        j--;
      }
    }
  }
  /////////////////////////////////////////////////
  ////////////////////QUICK SORT///////////////////
  /////////////////////////////////////////////////
  public static <T> void quicksort(ArrayList<T> arr, Comparator<? super T> comp) {
    
  }
}
