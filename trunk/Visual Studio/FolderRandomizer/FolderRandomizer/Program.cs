using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace FolderRandomizer
{
    class Program
    {
        static void Main(string[] args)
        {
            Randomizer randomizer = new Randomizer(@"C: \Users\mitti\Desktop\aaa",10);
            randomizer.Output();
            Console.ReadLine();

        }

        


    }
}
