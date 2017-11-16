using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace Fizzbuzz.Test2
{
    [TestClass]
    public class FizzbuzzTest
    {
        [TestMethod]
        public void testReturn_15_fizzbuzz()
        {
            Fizzbuzz fizzbuzz = new Fizzbuzz();
            String result = fizzbuzz.checkNumber(15);
            Assert.AreEqual("fizzbuzz", result);
        }

        [TestMethod]
        public void testReturn_5_fizz()
        {
            Fizzbuzz fizzbuzz = new Fizzbuzz();
            String result = fizzbuzz.checkNumber(5);
            Assert.AreEqual("fizz", result);
        }

        [TestMethod]
        public void testReturn_3_buzz()
        {
            Fizzbuzz fizzbuzz = new Fizzbuzz();
            String result = fizzbuzz.checkNumber(3);
            Assert.AreEqual("buzz", result);
        }

        [TestMethod]
        public void testReturn_11_11()
        {
            Fizzbuzz fizzbuzz = new Fizzbuzz();
            String result = fizzbuzz.checkNumber(11);
            Assert.AreEqual("11", result);
        }

        [TestMethod]
        public void testReturn_minus19_minus19()
        {
            Fizzbuzz fizzbuzz = new Fizzbuzz();
            String result = fizzbuzz.checkNumber(-19);
            Assert.AreEqual("-19", result);
        }

        [TestMethod]
        public void testReturn_1to100_correspondingResult()
        {
            Fizzbuzz fizzbuzz = new Fizzbuzz();
            String[] result = new string[100];
            for (int i = 0; i < result.Length; i++)
            {
                result[i] = fizzbuzz.checkNumber(i);
            }

            for (int i = 0; i < result.Length; i++)
            {
                if (i % 15 == 0) Assert.AreEqual(result[i], "fizzbuzz");
                else if (i%5==0) Assert.AreEqual(result[i], "fizz");
                else if(i%3==0) Assert.AreEqual(result[i], "buzz");
                else Assert.AreEqual(result[i], ""+i);
            }
            
        }
    }
}