using System;
using System.Collections.Generic;
using System.Text;

namespace Singleton
{
    public class TextPrinter
    {
        private readonly PrintSpooler _printSpooler;

        public TextPrinter()
        {
            _printSpooler = PrintSpooler.GetInstance();
        }

        public void Startup()
        {
            for (int i = 0; i < 100; i++)
            {
                _printSpooler.Print(new PrintJob("Text is " + i));
            }
        }
    }
}
