using System;
using _1._2_CounterLib;

namespace _1._2_CounterClient {
    class Program {
        // TODO:
        // Event-Handler Methode "OnCountValueChanged"
        // static void ...

        [STAThread]
        static void Main(string[] args) {
            // TODO:
            Counter counter = new Counter(10);

            // TODO:
            // CounterObserver-Instanzen "myObserver1" / "myObserver2" mit den Namen  "obs1" / "obs2"
            CounterObserver obs1 = new CounterObserver();
            CounterObserver obs2 = new CounterObserver();


            // TODO:
            // Registrieren der Event-Handler
            counter.CountValueChanged += obs1.CounterChanged;
            counter.CountValueChanged += obs2.CounterChanged;

            counter.Increment();
            counter.Increment();
            counter.Decrement();
            counter.Reset();


            // TODO:
            // Inkrementieren des Counters

            // TODO:
            // Deregistrieren des Events von myObserver1

            // TODO:
            // Counterwert auf "100" zurücksetzen.

            Console.ReadKey();
        }

        // TODO:
        // Implementieren Sie die Klasse "CounterObserver"
        public class CounterObserver
        {
            public void CounterChanged(Counter counter, CounterEventArgs args)
            {
                Console.WriteLine("Counter changed to: " + args.Count);
            }
        }


    }
}
