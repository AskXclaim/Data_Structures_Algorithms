package org.dataStructuresAlgorithms;

import org.dataStructuresAlgorithms.dataStructures.LocalArray;

public class Main {
    static void main() {
        var array = new LocalArray(4);
        array.insert(10);
        array.insert(20);
        array.insert(30);
        array.insert(40);
        System.out.println("Index of:" + array.indexOf(50));
        System.out.println("Index of:" + array.indexOf(40));
        array.removeAt(2);
        System.out.println(array.print());
    }
}

