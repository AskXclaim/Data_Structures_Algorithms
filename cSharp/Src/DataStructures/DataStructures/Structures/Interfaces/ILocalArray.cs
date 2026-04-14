namespace DataStructures.Structures.Interfaces;

public interface ILocalArray<in T>
{
    public int IndexOf(T value);
    public void Insert(T value);
    public void Delete(T value);

    public void PrintLn();
}