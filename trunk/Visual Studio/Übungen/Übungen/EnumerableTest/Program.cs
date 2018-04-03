using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EnumerableTest
{
    class Program
    {
        static void Main(string[] args)
        {
            var lst = new List<string>();
            lst.Add("A");
            lst.Add("B");
            lst.Add("C");
            /*
            foreach (var element in lst)
            {
                lst.Remove(element); //throws exception
            }
            */
            foreach (var element in lst.ToList())
            {
                lst.Remove(element); //funktioniert, da neue Liste
            }

            Console.WriteLine(lst.Any());
            Console.ReadLine();
        }
    }
}
