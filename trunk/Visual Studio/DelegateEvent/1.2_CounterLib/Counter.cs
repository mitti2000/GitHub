using System;

namespace _1._2_CounterLib {

    public class Counter
    {
        public delegate void CounterEventHandler(Counter c, CounterEventArgs args);

        public event CounterEventHandler CountValueChanged;
        private int count;

        public int Count
        {
            get { return count; }
            set { count = value; }
        }

        public Counter(int value)
        {
            this.count = value;
        }

        public Counter()
        {
            count = 0;
        }

        public int Increment()
        {
            count++;
            return Count;
        }

        public int Decrement()
        {
            count--;
            return Count;
        }

        public void Reset()
        {
            count = 0;
        }

        public void Reset(int value)
        {
            count = value;
        }

    }

    public class CounterEventArgs : EventArgs
    {
        
    }
    // TODO: Klasse CounterEventArgs implementieren

    // TODO: Delegate CounterEventHandler

    // TODO: Klasse Counter implementieren

}
