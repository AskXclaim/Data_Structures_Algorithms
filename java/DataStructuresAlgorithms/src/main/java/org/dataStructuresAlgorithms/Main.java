package org.dataStructuresAlgorithms;

import org.dataStructuresAlgorithms.dataStructures.MyLocalArray;

import java.util.Arrays;

public class Main {
    static void main() {
        var array = new MyLocalArray<Integer>(Integer.class,3);
        array.insert(10);
        array.insert(20);
        array.insert(30);
        array.insert(40);
        System.out.println("Index of:" + array.indexOf(50));
        System.out.println("Index of:" + array.indexOf(40));
        array.removeAt(2);
        System.out.println(array.printLn());

        var reverseToResult= array.reverseTo();
        System.out.println(Arrays.toString(reverseToResult));
    }
}

