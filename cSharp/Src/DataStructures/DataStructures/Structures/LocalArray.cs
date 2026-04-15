using DataStructures.Structures.Interfaces;

namespace DataStructures.Structures;

public class LocalArray<T>(int size) : ILocalArray<T> where T : IComparable<T>
{
    private int _size = size;
    private T[] _item = new T[size];
    private int _currentPosition;

    public int IndexOf(T value)
    {
        const int itemNotFoundIndex = -1;
        for (var i = 0; i < _currentPosition; i++)
        {
            if (_item[i].Equals(value))
                return i;
        }

        return itemNotFoundIndex;
    }

    public void Insert(T value)
    {
        const int startingIndex = 0;
        const int doubleTheValue = 2;
        if (_currentPosition > _size - 1)
        {
            _size *= doubleTheValue;
            var item = new T[_size];
            _item.CopyTo(item, startingIndex);
            _item = item;
        }

        _item[_currentPosition++] = value;
    }

    public void Delete(T value)
    {
        if (CurrentPositionIsZero())
            return;

        var items = new T[_size];
        var isItemFound = false;
        for (int i = 0, j = 0; i < _currentPosition; i++)
        {
            if (_item[i].Equals(value))
            {
                isItemFound = true;
                continue;
            }

            items[j++] = _item[i];
        }

        _item = items;

        if (isItemFound)
            _currentPosition--;
    }

    public T Max()
    {
        if (CurrentPositionIsZero())
            throw new InvalidOperationException("The array is empty");

        const int isLessThan = -1;
        var maxItem = _item[0];
        for (var i = 1; i < _currentPosition; i++)
        {
            if (maxItem.CompareTo(_item[i]) == isLessThan)
                maxItem = _item[i];
        }

        return maxItem;
    }

    public T[] Intersect(T[] array)
    {
        var size = array.Length > _currentPosition ? array.Length : _currentPosition;
        var intersectHolder = new T[size];
        var j = 0;
        for (var i = 0; i < _currentPosition; i++)
        {
            foreach (var item in array)
            {
                if (_item[i].Equals(item) && !intersectHolder.Contains(_item[i]))
                    intersectHolder[j++] = _item[i];
            }
        }

        var result = new T[j];
        for (var i = 0; i < j; i++)
        {
            result[i] = intersectHolder[i];
        }

        return result;
    }

    public void Reverse()
    {
        var reversed = new T[_currentPosition];
        for (var i = 0; i < _currentPosition; i++)
            reversed[i] = _item[_currentPosition - (i + 1)];

        _item = reversed;
    }

    public void InsertAt(int index, T value)
    {
        if (CurrentPositionIsZero())
            throw new InvalidOperationException("The array is empty. Try simply using Insert to add an item");
        if (index > _currentPosition - 1)
            throw new IndexOutOfRangeException();

        var items = new T[_currentPosition+1];

        for (int i = 0, j = 0; i < _currentPosition; i++, j++)
        {
            if (i.Equals(index))
                items[j++] = value;

            items[j] = _item[i];
        }

        _item = items;
        _currentPosition++;
    }

    private bool CurrentPositionIsZero() =>
        _currentPosition == 0;

    public void PrintLn()
    {
        if (CurrentPositionIsZero())
        {
            Console.WriteLine("No items to display");
            return;
        }

        for (var i = 0; i < _currentPosition; i++)
        {
            Console.Write(i == _currentPosition - 1 ? $"{_item[i]}" : $"{_item[i]},");
        }

        Console.WriteLine(" ");
    }
}