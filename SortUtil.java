package assignment04;

import java.util.ArrayList;
import java.util.Comparator;

public class SortUtil<T> {
  public static <T> void mergesort(ArrayList<T> inputList, Comparator<? super T> c) {
    
  }


  public static ArrayList<Integer> generateBestCase(int size) {
    return null;
    
  }

  public static ArrayList<Integer> generateAverageCase(int size){
    return null;
    
  }


  public static ArrayList<Integer> generateWorstCase(int size){
    return null;
    
  }
  /////////////////////////////////////////////////
  ////////////////////QUICK SORT///////////////////
  /////////////////////////////////////////////////
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
    quickSortRecursive(inputList, startIndex, pivot-1, c);
    quickSortRecursive(inputList, pivot, endIndex, c);

  }
  
  private static <T> int partition(ArrayList<T> inputList, int leftPoint, int rightPoint, Comparator<? super T> c, int pivotIndex) {
   
    while(leftPoint < rightPoint) {
      while(c.compare(inputList.get(leftPoint), inputList.get(pivotIndex)) <= 0 && leftPoint < rightPoint) {
        leftPoint++;
        if((leftPoint==rightPoint) && (c.compare(inputList.get(leftPoint), inputList.get(pivotIndex))<0)){
          swap(inputList, leftPoint, pivotIndex);
          return leftPoint;
        }
      }
      
      while(c.compare(inputList.get(rightPoint), inputList.get(pivotIndex)) > 0) {
        if(c.compare(inputList.get(leftPoint), inputList.get(rightPoint)) == 0 && rightPoint==leftPoint){
          break;
        }
        rightPoint--;

      }
  
      if(leftPoint < rightPoint) {
        swap(inputList, leftPoint, rightPoint);
        leftPoint ++;
        rightPoint--;
      }
      
    }
    if(pivotIndex > leftPoint) {
      T temp = inputList.get(pivotIndex);
      shiftElements(inputList, leftPoint, pivotIndex);
      inputList.set(leftPoint, temp);
      return leftPoint -1;
    }else {
      return leftPoint;
    }

  }


  /**
   * @param inputList
   * @param leftPoint
   * @param rightPoint
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
