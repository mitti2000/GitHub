using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Timers;

namespace MyFirstAwesomeCSharpProject
{
    public delegate void IntervallChangeHandler(double oldValue, double newValue);

    public class ZbWTimer : IDisposable
    {
        private readonly Timer _myTimer;
        private double _interval;

        private Money _totalMoney;

        

        //public event IntervallChangeHandler IntervalChanged;
        public event Action<double, double> IntervalChanged;
        
        //mit Rückgabewert letzter Parameter ist Rückgabewert
        //public event Func<double, double> IntervalChanged; 

        public ZbWTimer()
        {
            _myTimer = new Timer();
            _myTimer.Elapsed += MyTimerOnElapsed;
            _totalMoney = new Money(0, "CHF");
        }

        public void StartTimer()
        {
            _myTimer.Start();
        }

        //public double Interval { get; private set; }

        public double Interval2
        {
            // get { return _interval; }
            get => _interval;
            set
            {

                    var oldValue = _myTimer.Interval;

                    _interval = value;
                    _myTimer.Interval = value;
                IntervalChanged?.Invoke(oldValue, value);
            }
        }


        //public double Interval3 => _interval;

        private void MyTimerOnElapsed(object sender, ElapsedEventArgs elapsedEventArgs)
        {
            Console.WriteLine($"Timer Event {elapsedEventArgs.SignalTime.Hour + 1}");
            //genau das gleiche
            //Console.WriteLine(string.Format("Timer Event {0}", elapsedEventArgs.SignalTime));
            
            var hourlyFee = new Money(100, "CHF");
            _totalMoney = _totalMoney + hourlyFee;
        }

        public void Dispose()
        {
            _myTimer.Elapsed -= MyTimerOnElapsed;
            _myTimer.Dispose();
        }
    }
}
