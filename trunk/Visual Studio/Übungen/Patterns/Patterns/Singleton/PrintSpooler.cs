using System;
using System.Collections.Generic;
using System.Linq;

namespace Singleton
{
    public class PrintSpooler
    {
        private readonly PrintJob[] _printQueue;

        private PrintSpooler()
        {
            _printQueue = new PrintJob[10];
        }

        private static PrintSpooler _printSpooler;

        public static PrintSpooler GetInstance()
        {
            if (_printSpooler == null)
            {
                _printSpooler = new PrintSpooler();
            }

            return _printSpooler;
        }

        public string Print(PrintJob printJob)
        {
            return _printQueue[0].GetText();
        }


    }
}
