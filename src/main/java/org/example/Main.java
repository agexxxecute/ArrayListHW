package org.example;

import java.util.ArrayList;
import java.util.Comparator;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        for(int i = 20; i > 0; i--){
            myArrayList.add(i*i);
        }
        myArrayList.print();
        myArrayList.sort(Integer::compareTo);
        myArrayList.print();


    }
}