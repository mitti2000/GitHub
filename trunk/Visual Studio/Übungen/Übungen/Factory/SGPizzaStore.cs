using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Factory
{
    public class SGPizzaStore : IPizzaStore
    {
        public IPizza CreatePizza()
        {
            return new BratwurstPizza();
        }
    }
}