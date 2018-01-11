using System;
using System.Collections.Generic;
using System.Text;
using System.Threading;

namespace Singleton
{
    public class NumberPrinter
    {
        private readonly PrintSpooler _printSpooler;
        public NumberPrinter()
        {
            _printSpooler = PrintSpooler.GetInstance();
        }
        public void Print()
        {
            for (int i = 0; i < 100; i++)
            {
                Thread.Sleep(50);
                _printSpooler.Print(new PrintJob(i));
            }
        }
    }
}
