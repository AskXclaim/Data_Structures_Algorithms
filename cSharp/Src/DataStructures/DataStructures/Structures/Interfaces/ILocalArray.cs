namespace DataStructures.Structures.Interfaces;

public interface ILocalArray< T> where T:IComparable<T>
{
    public int IndexOf(T value);
    public void Insert(T value);
    public void Delete(T value);
    public T Max();
    public T[] Intersect(T[] array);
    public void Reverse();
    public void InsertAt(int index, T value);

    public void PrintLn();
}