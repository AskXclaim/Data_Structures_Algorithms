package org.dataStructuresAlgorithms.dataStructures.interfaces;

public interface CustomArray<T extends Comparable<T>> {
    void insert(T value);

    void removeAt(int index);

    int indexOf(T value);
    T max();
    T[] intersect(T[] array);
    void reverse();
    T[] reverseTo();
    void insertAt(T value, int index);

    String printLn();

}
