package org.example;

import java.util.Comparator;

/**
 * Sorts an array using the quicksort algorithm
 */
public class QuickSort {
    /**
     * Sorts an array using the quicksort algorithm
     * @param arr an array to be sorted
     * @param low first element of the array
     * @param high last element of the array
     * @param comparator array type comparator
     * @param <T>
     */
    public static <T> void quickSort (T[] arr, int low, int high, Comparator <? super  T> comparator){
        if(low < high){
            int pi = partition(arr, low, high, comparator);
            quickSort(arr, low, pi - 1, comparator);
            quickSort(arr, pi + 1, high, comparator);
        }
    }

    private static <T>  int partition (T[] arr, int low, int high, Comparator <? super T> comparator){
        T pivot = arr[high];
        int i = low - 1;
        for(int j = low; j < high; j++){
            if(comparator.compare(arr[j],pivot) < 0){
                i++;
                T temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        T temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;

    }
}
