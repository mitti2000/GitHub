using System;
using System.Collections.Generic;
using System.Linq;
using System.Security.Cryptography;
using System.Text;
using System.Threading.Tasks;

namespace ObjectCopy
{
    class Program
    {
        static void Main(string[] args)
        {
            Person a = new Person("Philip", "Herisau");
            //Person b = a.DeepCopy();
            Person b = a.ShallowCopy() as Person;

            a.Name = "Thomas";
            Console.WriteLine(a.Name);
            Console.WriteLine(b.Name);

            a.Adresse.Adresse = "St. Gallen";
            Console.WriteLine(a.Adresse.Adresse);
            Console.WriteLine(b.Adresse.Adresse);

            Console.ReadKey();

        }
    }
}
