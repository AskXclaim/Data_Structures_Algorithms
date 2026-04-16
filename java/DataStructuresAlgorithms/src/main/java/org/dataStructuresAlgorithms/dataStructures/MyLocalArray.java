package org.dataStructuresAlgorithms.dataStructures;

import java.lang.reflect.Array;
import org.dataStructuresAlgorithms.dataStructures.interfaces.CustomArray;

public class MyLocalArray<T> implements CustomArray<T> {
    private final Class<T> _clazz;
    private int _size;
    private int _currentPosition = 0;
    private T[] _items;

    public MyLocalArray(Class<T> clazz, int size) {
        this._clazz = clazz;
        if (size <= 0)
            throw new IllegalArgumentException("size has to be greater than zero");

        this._size = size;
        _items = (T[]) Array.newInstance(_clazz, _size);
    }

    /**
     * @param value
     */
    @Override
    public void insert(T value) {
        if(_currentPosition==_size){
            _size*=2;
           var items = (T[]) Array.newInstance(_clazz, _size);
            for (var i = 0; i <_currentPosition ; i++) {
                items[i]= _items[i];
            }
            _items=items;
        }
        if (value != null)
            _items[_currentPosition++] = value;
    }

    /**
     * @param index
     */
    @Override
    public void removeAt(int index) {

    }

    /**
     * @param value
     * @return
     */
    @Override
    public int indexOf(T value) {
        return 0;
    }

    /**
     *
     */
    @Override
    public void printLn() {

    }

    /**
     * @param value the object to be compared.
     * @return
     */
    @Override
    public int compareTo(T value) {
        return 0;
    }
}
