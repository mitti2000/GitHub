using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Factory
{
    class BernerPizza : IPizza
    {
        public BernerPizza()
        {
            Name = "Berner Pizza";
        }

        public string Name { get; }
    }
}