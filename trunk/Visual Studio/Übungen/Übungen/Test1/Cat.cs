using System;
using System.Collections.Generic;
using System.Linq;
using System.Media;
using System.Text;
using System.Threading.Tasks;

namespace Test1
{
    class Cat : Animal
    {
        public int age;

        public Cat(string name, int age) : base(name)
        {
            this.age = age;
        }

        public void giveSound()
        {
            Console.WriteLine("Miau");
        }
    }
}