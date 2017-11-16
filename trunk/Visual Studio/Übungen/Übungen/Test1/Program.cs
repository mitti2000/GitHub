using System;

namespace Test1
{
    class Program
    {
        static void Main(string[] args)
        {
            Cat cat = new Cat("Felix", 23);
            Console.WriteLine(cat.name);
            Console.WriteLine(cat.age);
            cat.giveSound();
        }
    }
}
