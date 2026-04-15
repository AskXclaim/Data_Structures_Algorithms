using DataStructures.Structures;

Console.WriteLine("Welcome to Data structures...");
var localArray = new LocalArray<int>(3);
localArray.Insert(10);
localArray.Insert(20);
localArray.Insert(30);
localArray.Insert(40);
localArray.PrintLn();
Console.WriteLine($"Max value:{localArray.Max()}");
localArray.Insert(50);

localArray.Delete(10);
localArray.Delete(20);
localArray.PrintLn();

Console.WriteLine($"Index of: {localArray.IndexOf(30)}");
Console.WriteLine($"Max value:{localArray.Max()}");

Console.WriteLine($"Intersect:{string.Join(",", localArray
    .Intersect([50, 30, 10, 40, 20]))}");
localArray.Reverse();
localArray.PrintLn();
var localArray2 = new LocalArray<int>(3);
localArray2.PrintLn();
localArray2.Insert(100);
localArray2.PrintLn();
localArray2.InsertAt(0,200);
localArray2.InsertAt(1,300);
localArray2.InsertAt(3,400);
localArray2.PrintLn();