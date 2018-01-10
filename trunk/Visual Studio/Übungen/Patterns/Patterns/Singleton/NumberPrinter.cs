using System;
using System.Collections.Generic;
using System.Text;

namespace Singleton
{
    public class NumberPrinter
    {
        private readonly PrintSpooler _printSpooler;
        public NumberPrinter()
        {
            _printSpooler = PrintSpooler.GetInstance();
        }
        public void Startup()
        {
            for (int i = 0; i < 100; i++)
            {
                _printSpooler.Print(new PrintJob(i));
            }
        }
    }
}
