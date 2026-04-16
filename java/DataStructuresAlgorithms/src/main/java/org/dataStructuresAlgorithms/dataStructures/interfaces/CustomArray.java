package org.dataStructuresAlgorithms.dataStructures.interfaces;

public interface CustomArray<T> extends Comparable<T> {
    void insert(T value);

    void removeAt(int index);

    int indexOf(T value);

    void printLn();

}
