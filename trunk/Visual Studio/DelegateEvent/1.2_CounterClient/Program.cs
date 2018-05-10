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

            // CounterObserver-Instanzen "myObserver1" / "myObserver2" mit den Namen  "obs1" / "obs2"
            CounterObserver obs1 = new CounterObserver("myObserver1");
            CounterObserver obs2 = new CounterObserver("myObserver2");


            // Registrieren der Event-Handler
            counter.CountValueChanged += obs1.CounterChanged;
            counter.CountValueChanged += obs2.CounterChanged;

            // Inkrementieren des Counters
            counter.Increment();
            counter.Increment();
            counter.Decrement();
            counter.Reset();


            // Deregistrieren des Events von myObserver1
            counter.CountValueChanged -= obs1.CounterChanged;

            // TODO:
            // Counterwert auf "100" zurücksetzen.
            counter.Reset(100);

            Console.ReadKey();
        }

        // TODO:
        // Implementieren Sie die Klasse "CounterObserver"
        public class CounterObserver
        {
            public string Name { get; set; }

            public CounterObserver(string name)
            {
                Name = name;
            }
            public void CounterChanged(Counter counter, CounterEventArgs args)
            {
                Console.WriteLine($"Counter {Name} changed to: {args.Count}");
            }
        }


    }
}
