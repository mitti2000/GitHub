using System;
using System.Collections.Generic;
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
            PrimeType[] primes = new PrimeType[Siebgroesse];
            while (pos < Siebgroesse)
            {
                pos++;
                for (int i = 0; i < Siebgroesse; i++)
                {
                    if (intarray[i] == 1) primes[i] = PrimeType.Prim;
                    else if (intarray[i]%pos == 0) primes[i]= PrimeType.NotPrim;
                    else primes[i] = PrimeType.Prim;
                }
            }

            return primes;
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

        public enum PrimeType
        {
            Prim = 1,
            NotPrim = 2
        }
    }
}
