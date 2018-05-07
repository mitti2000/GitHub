using System;

namespace _1._2_CounterLib {

    public class Counter
    {
        public delegate void CounterEventHandler(Counter c, CounterEventArgs args);

        public event CounterEventHandler CountValueChanged;
        private int count;
        private CounterEventArgs args;

        public int Count
        {
            get { return count; }
            set { count = value; }
        }

        public Counter(int value)
        {
            args = new CounterEventArgs();
            args.Count = Count;
            this.count = value;
            
        }

        public Counter()
        {
            args = new CounterEventArgs();
            args.Count = Count;
            Count = 0;

        }

        public int Increment()
        {
            Count++;
            args.Count = Count;
            CountValueChanged(this, args);
            return Count;
        }

        public int Decrement()
        {
            Count--;
            args.Count = Count;
            CountValueChanged(this, args);
            return Count;
        }

        public void Reset()
        {
            Count = 0;
            args.Count = Count;
            CountValueChanged(this,args);
        }

        public void Reset(int value)
        {
            Count = value;
        }

    }

    public class CounterEventArgs : EventArgs
    {
        public int Count { get; set; }
    }
    // TODO: Klasse CounterEventArgs implementieren

    // TODO: Delegate CounterEventHandler

    // TODO: Klasse Counter implementieren

}
