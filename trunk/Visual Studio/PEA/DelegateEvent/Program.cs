using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DelegateEvent
{
    class Program
    {
        static void Main(string[] args)
        {
            Testclass tc = new Testclass();
            Eventtest et = new Eventtest();

            et.MyEvent += tc.EventMethod;

            et.ChangeSometing();

            Console.WriteLine("--------------------------------------------");

            SortArray sortArray = new SortArray();

            int[] sortedArray = sortArray.Sort(sortArray.intArray, sortArray.compElements);

            foreach (var VARIABLE in sortedArray)
            {
                Console.Write(VARIABLE + ",");
            }
        }

    }

    public class Testclass
    {
        public void EventMethod(string text)
        {
            Console.WriteLine(text);
        }
    }
}
