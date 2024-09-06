package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayListTest {
    @Test
    void addElements() {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.add(1);
        myArrayList.add(3);
        myArrayList.add(4);
        myArrayList.add(2,1);
        String result = myArrayList.toString();
        String correctResult = "1 2 3 4 ";
        assertEquals(correctResult, result);
    }

    @Test
    void addALotOfElements() {
        String result = "";
        int newElement;
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        for(int i = 0; i < 1000; i++){
            newElement = (int)Math.random()*100;
            myArrayList.add(newElement);
            result+=newElement + " ";
        }
        assertEquals(result, myArrayList.toString());
    }

    @Test
    void sort() {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        for(int i = 20; i > 0; i--){
            myArrayList.add(i*i);
        }
        myArrayList.sort(Integer::compareTo);
        String result = myArrayList.toString();
        String correctResult = "1 4 9 16 25 36 49 64 81 100 121 144 169 196 225 256 289 324 361 400 ";
        assertEquals(correctResult, result);

    }

    @Test
    void clear() {
        MyArrayList<Character> myArrayList = new MyArrayList<>();
        myArrayList.add('a');
        myArrayList.add('b');
        myArrayList.add('c');
        myArrayList.clear();
        String result = myArrayList.toString();
        assertEquals("", result);
    }

    @Test
    void delete() {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);
        myArrayList.add(3);
        myArrayList.add(4);
        myArrayList.delete(3);
        assertEquals("1 2 3 4 ", myArrayList.toString());
    }

    @Test
    void changeElement() {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);
        myArrayList.add(3);
        myArrayList.add(5);
        myArrayList.changeElement(4,3);
        assertEquals("1 2 3 4 5 ", myArrayList.toString());
    }

    @Test
    void changeElementException() {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);
        myArrayList.add(3);
        myArrayList.add(4);
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> myArrayList.changeElement(10,20));

    }

    @Test
    void getElement() {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        for(int i = 0; i < 5; i++){
            myArrayList.add(i);
        }
        assertEquals(4, myArrayList.getElement(4));
    }
}