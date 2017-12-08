using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.CompilerServices;
using System.Text;
using System.Threading.Tasks;

namespace Eventtest
{
    //Recieves two Events end sends them to 2 methods in the Testdelegate delegate
    class Program
    {
        static void Main(string[] args)
        {
            var prog = new Program();
            var tc1 = new Testclass1();

            tc1.WriteOutput(Console.Out);

            tc1.MyEvent += new Testclass1.Testdelegate(prog.WriteOutputToConsole);
            tc1.MyEvent += new Testclass1.Testdelegate(prog.SecondOutput);

            tc1.ButtonPressSimulator();
        }

        public void WriteOutputToConsole(string text)
        {
            Console.WriteLine(text);
        }

        public void SecondOutput(string text)
        {
            int Zahl = 5;
            Console.Out.WriteLine((Zahl > 4) ? "Genau" : "nicht genau");
            Console.WriteLine("second Event: " + text);
        }
    }
}