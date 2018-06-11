using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _1._3_Nullable
{
    class Program
    {
        static void Main(string[] args)
        {
            int a = 0;
            bool b = false;
            int? c = 10;
            bool? d = null;
            int? e = null;

            var solA = c+a; //int? 10
            var solB = a + null; // int? null
            var solC = a<c; //bool true
            var solD = a + null < c; //bool false
            var solE = a > null; //bool false
            var solF = (a + c -e) * 9898 + 1000; //int? null
            var solG = d; //bool? null
            var solH = d == d; //bool true
            var solI = c ?? 1000; //int 10
            var solJ = e ?? 1000; //int 1000

            Console.ReadKey();

        }
    }
}
