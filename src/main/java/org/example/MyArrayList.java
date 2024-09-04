package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class MyArrayList<T> {
    private final int DEFAULT_SIZE = 16;
    private T[] list;
    private int pointer = 0;

    public MyArrayList(){
        list = (T[]) new Object[DEFAULT_SIZE];
    }

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

    /**
     * Get element by index
     * @param index Index of getting element
     * @return Element
     * @throws ArrayIndexOutOfBoundsException
     */
    public Object getElement (int index) throws ArrayIndexOutOfBoundsException{
        try{
            return list[index];
        } catch (ArrayIndexOutOfBoundsException e){
            return null;
        }
    }

    /**
     * Deletes an element by index
     * @param index Index of the deleting element
     */
    public void delete (int index){
        for(int i = index; i < pointer-1; i++){
            list[i] = list[i+1];
        }
        pointer--;
        if(pointer < list.length/2){
            resize(list.length - list.length/4);
        }
    }

    /**
     * Changes an element by index
     * @param element New element
     * @param index Index to change
     * @throws ArrayIndexOutOfBoundsException
     */
    public void changeElement (T element, int index) throws ArrayIndexOutOfBoundsException{
        try{
            list[index] = element;
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("No such element");
        }
    }

    /**
     * Deleting all elements
     */
    public void clear (){
        resize(0);
    }

    private void resize(int newLength){
        T[] tempList = (T[]) new Object[newLength];
        if(newLength > pointer) {
            System.arraycopy(list, 0, tempList, 0, pointer);
            list = tempList;
        } else pointer = newLength;
    }

    /**
     * Prints the full list to the console
     */
    public void print(){
        if(pointer!=0) {
            for (int i = 0; i < pointer; i++) {
                System.out.print(list[i] + " ");
            }
            System.out.println();
        }
        else System.out.println("Empty collection");
    }





}
