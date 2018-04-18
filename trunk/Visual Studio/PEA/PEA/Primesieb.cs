using System;
using System.Collections.Generic;
using System.Dynamic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PEA
{
    public class Primesieb
    {
        public int Siebgroesse { get; set; }
       

        public Primesieb(int size)
        {
            Siebgroesse = size;
            PrimeType[] primes = Eratosthenes();
        }

        public PrimeType[] Eratosthenes( )
        {
            int pos = 0;
            int[] intarray = createArray();
            PrimeType[] primes = createPrimeArray();
            while (pos < Siebgroesse)
            {
                pos++;
                for (int i = pos-1; i < Siebgroesse; i++)
                {
                    int tempPrim = -1;
                    if (intarray[i] == 1)
                    {
                        primes[i] = PrimeType.Prim;
                        break;
                    }

                    if (primes[i] == PrimeType.Unchecked)
                    {
                        primes[i] = PrimeType.Prim;
                        tempPrim = intarray[i];
                        for (int j = i + 1; j < Siebgroesse; j++)
                        {
                            if (primes[j] == PrimeType.Unchecked && intarray[j] % tempPrim == 0)
                            {
                                primes[j] = PrimeType.NotPrim;
                            }
                        }

                        tempPrim = -1;
                        break;
                    }
                       
                }
            }

            return primes;
        }

        public int[] onlyPrimes(PrimeType[] erastosthenes)
        {
            List<int> onlyPrimes = new List<int>();
            int counter = 0;
            foreach (var prime in erastosthenes)
            {
                counter++;
                if (prime == PrimeType.Prim)
                {
                    onlyPrimes.Add(counter);
                }
            }

            return onlyPrimes.ToArray();
        }

        public List<int> onlyPrimesList(PrimeType[] eratosthenes)
        {
            List<int> onlyPrimes = new List<int>();
            int counter = 0;
            foreach (var prime in eratosthenes)
            {
                counter++;
                if (prime == PrimeType.Prim)
                {
                    onlyPrimes.Add(counter);
                }
            }

            return onlyPrimes;
        }

        public Dictionary<int, int> onlyPrimesDict(PrimeType[] erastosthenes)
        {
            int indexCounter = 0;
            Dictionary<int, int> onlyPrimes = new Dictionary<int, int>();
            int counter = 0;
            foreach (var prime in erastosthenes)
            {
                counter++;
                if (prime == PrimeType.Prim)
                {
                    indexCounter++;
                    onlyPrimes.Add(indexCounter,counter);
                }
            }

            return onlyPrimes;
        }

        private int[] createArray()
        {
            int[] intarray = new int[Siebgroesse];

            for(int i=0; i < Siebgroesse; i++)
            {
                intarray[i] = i + 1;
            }

            return intarray;
        }

        private PrimeType[] createPrimeArray()
        {
            PrimeType[] primeArray = new PrimeType[Siebgroesse];

            for (int i = 0; i < Siebgroesse; i++)
            {
                primeArray[i] = PrimeType.Unchecked;
            }

            return primeArray;
        }

        public enum PrimeType
        {
            Unchecked = 0,
            Prim = 1,
            NotPrim = 2
        }
    }
}
