using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PEA
{
    class Program
    {
        

        static void Main(string[] args)
        {
            

            if (args.Length > 0)
            {
                Primesieb _primesieb = new Primesieb(int.Parse(args[0]));
                foreach (var primeType in _primesieb.Eratosthenes())
                {
                    Console.WriteLine(primeType);
                }
            }
        }


    }
}