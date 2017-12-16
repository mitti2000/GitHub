using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DelegatesEvents
{
    class HandlerClass
    {
        
        public void WorkPerformed1(int hours, string text)
        {
            Console.WriteLine("Hours worked: "+hours+" with Text " + text);
        }
    }
}

