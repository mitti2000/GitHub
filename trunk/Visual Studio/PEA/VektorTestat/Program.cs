﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace VektorTestat
{
    class Program
    {
        static void Main(string[] args)
        {

            Vektor3D vek1 = new Vektor3D(1,2,3);
            Vektor3D vek2 = new Vektor3D(4,5,6);
            Vektor3D vek4 = new Vektor3D(5,7,8);
            vek4 = 8.5;
            Console.WriteLine(vek4);

            vek1[1] = 10;
            Console.WriteLine(vek1[1]);
            Console.WriteLine((double)vek1);
            

            Console.WriteLine(vek1.ToString());
            Console.WriteLine(vek2.ToString());

            Vektor3D vek3 = vek1 * vek2;

            Console.WriteLine(vek3.ToString());

            if(vek1 != vek2) Console.WriteLine("Vektoren 1 und 2 sind gleich");
            else Console.WriteLine("Vektoren 1 und 2 sind nicht gleich");

            Console.WriteLine("Vektor 1 Betrag: "+ vek1.VektorBetrag());
        }
    }
}
