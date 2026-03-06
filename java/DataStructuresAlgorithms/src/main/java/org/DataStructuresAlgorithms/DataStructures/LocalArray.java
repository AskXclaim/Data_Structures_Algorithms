package org.DataStructuresAlgorithms.DataStructures;

import java.util.Arrays;

public class LocalArray {
    private int _size;
    private int[] _item;
    private int _current;
    private boolean _hasSizeBeenDoubled = false;
    private int _userExpectedSize;


    public LocalArray(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException();
        }
        _item = new int[size];
        _current = 0;
        _size = size;
        _userExpectedSize = size - 1;
    }

    public void insert(int value) {
        if (_size == _current) {
            _size *= 2; // double array size
            _item = Arrays.copyOf(_item, _size);
            _hasSizeBeenDoubled = true;
        }
        _item[_current++] = value;
        if (_hasSizeBeenDoubled && _current < _size) {
            _userExpectedSize = _current;
        }
    }

    public void removeAt(int index) {
        //Todo check index> _userExpectedSize edge cases
        if (index < 0 || index > _userExpectedSize) {
            throw new IndexOutOfBoundsException();
        }
        var holder = new int[_size - 1];
        for (int i = 0, ii = 0; i < _size; i++, ii++) {
            if (i == index) {
                ii--;
                continue;
            }
            holder[ii] = _item[i];
        }
        _item = holder;
        _userExpectedSize = _userExpectedSize - 1;
    }

    public int indexOf(int value) {
        for (int i = 0; i <= _userExpectedSize; i++) {
            if (_item[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public String printLn() {
        var builder = new StringBuilder();
        builder.append("[");
        if (_userExpectedSize < 0) {
            builder.append("]");
            return builder.toString();
        }

        for (int i = 0; i <= _userExpectedSize; i++) {
            builder.append(_item[i]);
        }
        builder.append("]");
        return builder.toString();
    }
}
