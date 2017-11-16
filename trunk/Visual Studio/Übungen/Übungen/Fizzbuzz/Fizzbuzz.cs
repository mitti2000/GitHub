using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Fizzbuzz
{
    public class Fizzbuzz
    {
        public String checkNumber(int number)
        {
            if (number % 15 == 0)
            {
                return "fizzbuzz";
            }
            else if (number % 5 == 0)
            {
                return "fizz";
            }
            else if (number % 3 == 0)
            {
                return "buzz";
            }
            else
            {
                return ""+number;
            }
        }
    }
}