using System;
using System.Collections.Generic;
using System.Runtime;

namespace _1._6_Zusatzaufgaben {
    public static class Operators {
        #region Aufgabe 2 - ForAll

        public static void ForAll<T>(T[] array, Predicate<T> comparer, Action<T> elementAction)
        {
            for (int i = 0; i < array.Length; i++)
            {
                if (comparer(array[i]))
                {
                    elementAction(array[i]);
                }
            }
        }

        public static void TestForAll() {
            ForAll(
                new int[] { 1, 2, 3, 4 },
                delegate (int i) { return i > 2; },
                delegate (int i) { Console.WriteLine(i); }
            );
        }


        #endregion

        #region Aufgabe 3 - Comparison

        public static int DefaultCompare<T>(T x, T y)
            where T : IComparable<T>
        {
            return x.CompareTo(y);
        }

        public static void TestComparer() {
            Comparison<int> comparer = DefaultCompare;
            Console.WriteLine(comparer(7, 7));
        }

        #endregion

        #region Aufgabe 4 - Combiner

        public delegate TOut MyConverter<Tin1, Tin2, TOut>(Tin1 p1, Tin2 p2);

        // Implementation mit eigenem Delegate "MyConverter"
        public static TOut[] CombineAll<Tin1, Tin2, TOut>(Tin1[] array1, Tin2[] array2, MyConverter<Tin1, Tin2, TOut> converter)
        {

            if (array1.Length != array2.Length)
            {
                Console.WriteLine("Arrays ungleicher Grösse");
                return new TOut[]{};
            }
            TOut[] result = new TOut[array1.Length];
            for (int i = 0; i < array1.Length; i++)
            {
                result[i] = converter(array1[i], array2[i]);
            }

            return result;
        }

        public static void TestCombineAll() {
            int[] res = CombineAll<int, int, int>(
                new int[] { 2, 3, 4 },
                new int[] { 1, 2, 5 },
                delegate (int a, int b) { return a * b; }
            );
            foreach (int i in res)
            {
                Console.WriteLine(i);
            }

            string[] res1 = CombineAll<int, string, string>(
                new int[] { 2, 3, 4 },
                new string[] { "abc", "ef", "uv" },
                delegate (int a, string b) { return b + a.ToString(); }
            );
            foreach (string s in res1)
            {
                Console.WriteLine(s);
            }
        }

        #endregion

        #region Aufgabe 5 - Bubble Sort

        public static void BubbleSort<T>(int arraylength, Func<int, T> getter, Action<int, T> setter, Comparison<T> comparer)
        {

        }

        public static void TestSort() {
            int[] array = new int[] { 1, 23, 2, -10, 10, 1000, 23, 100000, -12 };
            BubbleSort<int>(array.Length,
                   delegate (int i) { return array[i]; },
                    delegate (int i, int e) { array[i] = e; },
                    DefaultCompare<int>);
            foreach (int e in array)
            {
                Console.WriteLine(e);
            }
        }

        #endregion

        #region Aufgabe 6 - FoldR

        public delegate T FoldHandler<T>(T p1, T p2);

        public static T FoldR<T>(T start, IEnumerable<T> elements, Func<T, T, T> foldHandler) {
            T akt = start;
            foreach (T element in elements) {
                akt = foldHandler(akt, element);
            }

            return akt;
        }


        //Minimumbestimmung mit Fold
        public static T Smallest<T>(T maxValue, IEnumerable<T> array, Comparison<T> comparer)
        {
            return FoldR(maxValue, array, delegate(T p1, T p2)
            {
                return comparer(p1, p2) <= 0 ? p1 : p2;
            });
        }

        //Variante mit IComparable
        public static T Smallest<T>(T maxValue, T[] array) where T : IComparable<T>
        {
            return Smallest(maxValue, array, DefaultCompare);
        }

        public static void TestFold()
        {
            int[] array = new int[] { 1, 23, 2, -10, 10, -1000, 23 };
            Console.WriteLine(
                Smallest(
                    int.MaxValue,
                    array,
                    delegate (int v1, int v2) { return ((IComparable)v1).CompareTo(v2); }
                )
            );
            Console.WriteLine(
                Smallest(
                    int.MaxValue,
                    array
                )
            );
        }

        #endregion
    }
}