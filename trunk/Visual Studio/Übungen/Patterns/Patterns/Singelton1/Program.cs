using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Threading;

namespace Singleton
{
    public class Program
    {
        static void Main(string[] args)
        {
            Program program = new Program();
            NumberPrinter numberPrinter = new NumberPrinter();
            TextPrinter textPrinter = new TextPrinter();
            PrintSpooler spooler = PrintSpooler.GetInstance();
            var numberPrinterThread = new Thread(numberPrinter.Print);
            var textPrinterThread = new Thread(textPrinter.Print);
            var printSpoolerThread = new Thread(spooler.PrintOutput);
            /*
            var numberPrinterThread2 = new Thread(() =>
            {
                while (true)
                {
                    Console.WriteLine();
                };
            });
            numberPrinterThread2.Start();
            */
            numberPrinterThread.Start();
            textPrinterThread.Start();
            printSpoolerThread.Start();
            Console.WriteLine("Wait for Printjobs");
            Thread.Sleep(2000);
            Console.WriteLine("Start Printing");

            numberPrinterThread.Join();
            textPrinterThread.Join();
            printSpoolerThread.Join();

            Console.WriteLine("Printing done");
        }
    }
}
