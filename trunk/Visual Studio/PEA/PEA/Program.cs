using System;
using System.Collections;
using System.Collections.Generic;
using System.Diagnostics;
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
                int counter = 0;
                int lineCounter = 0;
                //Primesieb.PrimeType[] primeArray = _primesieb.Eratosthenes();  // All numbers as notPrime or Prime
                //int[] primeArray = _primesieb.onlyPrimes(_primesieb.Eratosthenes());
                //List<int> primeArray = _primesieb.onlyPrimesList(_primesieb.Eratosthenes());
                Dictionary<int, int> primeArray = _primesieb.onlyPrimesDict(_primesieb.Eratosthenes());
                foreach (var number in primeArray)
                {
                    counter++;
                    lineCounter++;
                    Console.Write(counter + ": " + number + " // ");
                    if (lineCounter >= 9)
                    {
                        lineCounter = 0;
                        Console.WriteLine();
                    }
                    
                }

            }
        }


    }
}