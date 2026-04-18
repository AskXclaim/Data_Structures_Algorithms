package org.dataStructuresAlgorithms.dataStructures;

import java.lang.reflect.Array;

import org.dataStructuresAlgorithms.dataStructures.interfaces.CustomArray;

@SuppressWarnings("unchecked")
public class MyLocalArray<T extends Comparable<T>> implements CustomArray<T> {
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
     * @param value of item of type T to be added
     */
    @Override
    public void insert(T value) {
        if (_currentPosition == _size) {
            _size *= 2;
            var items = (T[]) Array.newInstance(_clazz, _size);
            for (var i = 0; i < _currentPosition; i++) {
                items[i] = _items[i];
            }
            _items = items;
        }
        if (value != null)
            _items[_currentPosition++] = value;
    }

    /**
     * @param index of the item to be deleted
     */
    @Override
    public void removeAt(int index) {
        if (index < 0 || index >= _currentPosition)
            throw new IndexOutOfBoundsException(index);

        var items = (T[]) Array.newInstance(_clazz, _currentPosition);
        for (int i = 0, j = 0; i < _currentPosition; i++) {
            if (i == index)
                continue;

            items[j++] = _items[i];
        }
        _items = items;
        _currentPosition--;
    }

    /**
     * @param value a generic item of type T
     * @return int
     */
    @Override
    public int indexOf(T value) {
        var itemNotPresentIndex = -1;
        for (int i = 0; i < _currentPosition; i++) {
            if (_items[i].equals(value))
                return i;
        }
        return itemNotPresentIndex;
    }

    /**
     * @return max item present in the class. If no items are present it returns null.
     */
    @Override
    public T max() {
        if (_currentPosition == 0)
            return null;

        var maxItem = _items[0];
        for (var i = 1; i < _currentPosition; i++) {
            if (maxItem.compareTo(_items[i]) < 0)
                maxItem = _items[i];
        }
        return maxItem;
    }

    /**
     * @param array an array of type T
     * @return an array of type T containing items that are present in both the class and the passed in array.
     */
    @Override
    public T[] intersect(T[] array) {
        if (array.length == 0)
            return (T[]) Array.newInstance(_clazz, 0);

        var size = Math.max(array.length, _items.length);
        var intersectedItems = (T[]) Array.newInstance(_clazz, size);
        var i = 0;
        for (int j = 0; j < _currentPosition; j++) {
            for (T t : array) {
                if (t.equals(_items[j]) && !contains(intersectedItems, i, _items[i])) {
                    intersectedItems[i++] = _items[j];
                    break;
                }
            }
        }
        var result = (T[]) Array.newInstance(_clazz, i);
        for (int j = 0; j < i; j++) {
            result[j] = intersectedItems[j];
        }
        return result;
    }


    private boolean contains(T[] array, int endPoint, T value) {
        if (array.length == 0)
            return false;

        for (int i = 0; i < endPoint; i++) {
            if (array[i].equals(value))
                return true;
        }
        return false;
    }
}

/**
 *
 */
@Override
public void reverse() {

}

/**
 * @return
 */
@Override
public T[] reverseTo() {
    return null;
}

/**
 * @param value
 * @param index
 */
@Override
public void insertAt(T value, int index) {

}

/**
 * Print items in the class
 * returns items in the class as string
 */
@Override
public String printLn() {
    if (_currentPosition == 0) return "";

    StringBuilder toDisplay = new StringBuilder("[");
    for (var i = 0; i < _currentPosition; i++) {
        toDisplay.append(_items[0].toString()).append(i != _currentPosition - 1 ? "," : "]");
    }
    System.out.print(toDisplay);
    return toDisplay.toString();
}

@Override
public String toString() {
    return printLn();
}
}
