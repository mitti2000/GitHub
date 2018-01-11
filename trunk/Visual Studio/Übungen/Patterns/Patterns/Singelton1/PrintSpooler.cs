using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading;

namespace Singleton
{
    public class PrintSpooler
    {
        private readonly List<PrintJob> _printQueue;

        private PrintSpooler()
        {
            _printQueue = new List<PrintJob>();
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

        public void Print(PrintJob printJob)
        {
            _printQueue.Add(printJob);
        }

        public void PrintOutput()
        {
            Thread.Sleep(1000);
            while (_printQueue.Count > 0)
            {
                Thread.Sleep(100);
                Console.WriteLine(_printQueue[0].GetText());
                _printQueue.RemoveAt(0);
            }
        }


    }
}
