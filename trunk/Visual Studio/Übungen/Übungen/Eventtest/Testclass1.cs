using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Resources;
using System.Text;
using System.Threading.Tasks;

namespace Eventtest
{
    //Throws Event in mehtod button press simulator
    class Testclass1

    {
        public delegate void Testdelegate(string text);
        public event Testdelegate MyEvent;

        public void WriteOutput(TextWriter tw)
        {
            tw.WriteLine("Hello World");
        }

        public void ButtonPressSimulator()
        {
            Console.WriteLine("Button Pressed");
            MyEvent?.Invoke("Event sent"); // Wie ist der Syntax zu lesen?
        }
    }
}