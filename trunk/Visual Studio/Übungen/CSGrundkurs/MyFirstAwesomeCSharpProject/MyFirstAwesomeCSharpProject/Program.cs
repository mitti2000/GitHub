using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MyFirstAwesomeCSharpProject
{
    class Program
    {
        static void Main(string[] args)
        {
            using (var ZbWTimer = new ZbWTimer())
            {
                //Klasse hat Referenz
                //var money2 = new Money2(100, "CHF");
                //
                var money2 = new Money(100, "CHF");
                Console.WriteLine(money2.Value);
                decimal oldMoneyValue;
                var money3 = money2;
                money2.Value = 300;
                Console.WriteLine(money3.Value);

                money3 = ManipulateReference(ref money2, 777, out oldMoneyValue);
                Console.WriteLine(money3.Value);



                ZbWTimer.IntervalChanged += (oldValue, newValue) =>
                    Console.WriteLine($"Old Value: {oldValue} / new Value: {newValue}");
                ZbWTimer.Interval2 = 2000;
                ZbWTimer.StartTimer();
                ZbWTimer.Interval2 = 1000;
                Console.ReadKey();
            }
        }

        public static ref Money ManipulateReference(ref Money money, decimal newValue, out decimal oldValue)
        {
            oldValue = money.Value;
            money.Value = newValue;
            return ref money;
        }
    }
}