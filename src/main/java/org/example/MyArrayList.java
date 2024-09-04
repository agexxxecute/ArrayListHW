package org.example;

import java.util.ArrayList;
import java.util.Arrays;

public class MyArrayList<T> {
    private final int DEFAULT_SIZE = 16;
    private Object[] list = new Object[DEFAULT_SIZE];
    private int pointer = 0;

    /**
     * Adds an element to the end of the array
     * @param element Element to be added
     */
    public void add(T element){
        if (pointer == list.length-1){
            resize(list.length + list.length/2);
        }
        list[pointer++] = element;
    }

    /**
     * Adds an element by index
     * @param element Element to be added
     * @param index Index of a new element
     */
    public void add (T element, int index){
        if (pointer == list.length-1){
            resize(list.length + list.length/2);
        }
        for(int i = pointer; i > index; i--){
            list[i] = list[i-1];
        }
        list[index] = element;
        pointer++;
    }

    private void resize(int newLength){
        Object[] tempList = new Object[newLength];
        System.arraycopy(list, 0, tempList, 0, pointer);
        list = tempList;
    }

    /**
     * Prints the full list to the console
     */
    public void print(){
        for (int i = 0; i < pointer; i++){
            System.out.print(list[i] + " ");
        }
        System.out.println();
    }





}
