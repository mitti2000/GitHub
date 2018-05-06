using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DelegateEvent
{
    class SortArray
    {
        public delegate int CompareElements(int x, int y);

        public  CompareElements compElements;

        public int[] intArray = new[] {5, 8, 1, 13, -5, 3, 2, 80, 35};

        public SortArray()
        {
            compElements = new CompareElements(Compare);
        }

        public int[] Sort(int[] arr, CompareElements compareElements)
        {
            bool isSorted = false;

            while (!isSorted)
            {
                int counter = 0;
                for (int i = 0; i < arr.Length; i++)
                {
                    if(i<(arr.Length-1) && compareElements(arr[i], arr[i + 1])> 0)
                    {
                        int temp = arr[i];
                        arr[i] = arr[i + 1];
                        arr[i + 1] = temp;
                        counter++;
                    }
                }

                if (counter == 0) isSorted = true;
            }

            return arr;
        }

        private static int Compare(int x, int y)
        {
            if (x > y) return 1;
            if (x < y) return -1;
            else return 0;
        }
    }
}
