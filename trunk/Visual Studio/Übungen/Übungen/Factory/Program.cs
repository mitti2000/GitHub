using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Factory
{
    class Program
    {
        static void Main(string[] args)
        {
            IPizzaStore sgPizzaStore = new SGPizzaStore();
            IPizzaStore bePizzaStore = new BEPizzaStore();

            Console.WriteLine(sgPizzaStore.CreatePizza().Name);
            Console.WriteLine(bePizzaStore.CreatePizza().Name);
        }
    }
}
