
using DataStructures.Structures;

Console.WriteLine("Welcome to Data structures...");
var localArray = new LocalArray<int>(3);
localArray.Insert(10);
localArray.Insert(20);
localArray.Insert(30);
localArray.Insert(40);
localArray.PrintLn();

localArray.Delete(10);
localArray.Delete(20);
localArray.PrintLn();

Console.WriteLine($"{localArray.IndexOf(30)}");