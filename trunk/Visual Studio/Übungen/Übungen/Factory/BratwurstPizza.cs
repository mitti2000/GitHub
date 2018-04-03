using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Factory
{
    public class BratwurstPizza : IPizza
    {
        public BratwurstPizza()
        {
            Name = "Bratwurst Pizza";
        }

        public string Name { get; }
    }
}