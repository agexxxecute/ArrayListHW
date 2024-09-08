package org.example;

import java.util.Comparator;

/**
 * Resizable array
 * @param <T>
 */
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
    public void addByIndex (T element, int index){
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
            return list[index];
    }

    /**
     * Deletes the first occurrence of an element in array list
     * @param element deleting element
     */
    public boolean deleteElement(T element){
        boolean flag = false;
        for(int i = 0; i<pointer; i++){
            if(list[i].equals(element)){
                deleteByIndex(i);
                flag=true;
                break;
            }
        }
        return flag;
    }

    /**
     * Deletes an element by index
     * @param index Index of the deleting element
     */
    public void deleteByIndex (int index) throws ArrayIndexOutOfBoundsException{
            for (int i = index; i < pointer - 1; i++) {
                list[i] = list[i + 1];
            }
            pointer--;
            if (pointer < list.length / 2) {
                resize(list.length - list.length / 4);
            }
    }

    /**
     * Changes an element by index
     * @param element New element
     * @param index Index to change
     * @throws ArrayIndexOutOfBoundsException
     */
    public void changeElement (T element, int index) throws ArrayIndexOutOfBoundsException{
            list[index] = element;
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
     * Sorting array
     * @param comparator Comparing objects
     */
    public void sort(Comparator <? super T> comparator){
        QuickSort.quickSort(list, 0, pointer-1, comparator);
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

    /**
     * Returns ArrayList elements as String
     * @return String of elements
     */
    public String toString(){
        StringBuilder result = new StringBuilder();
       for (int i = 0; i < pointer; i++) {
                result.append(list[i].toString());
                result.append(" ");
       }
        return result.toString();
    }





}
