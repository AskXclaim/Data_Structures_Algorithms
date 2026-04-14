using DataStructures.Structures.Interfaces;

namespace DataStructures.Structures;

public class LocalArray<T>(int size) : ILocalArray<T>
{
    private int _size = size;
    private T[] _item = new T[size];
    private int _currentPosition;

    public int IndexOf(T value)
    {
        const int itemNotFoundIndex = -1;
        for (var i = 0; i < _currentPosition; i++)
        {
            if (_item[i]!.Equals(value))
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
        if (value == null || _currentPosition == 0)
            return;

        var items = new T[_size];
        var isItemFound = false;
        for (int i = 0, j = 0; i < _currentPosition; i++)
        {
            if (_item[i]!.Equals(value))
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

    public void PrintLn()
    {
        if (_currentPosition == 0)
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