using System;
using System.Collections.Generic;
using System.Linq;
using System.Speech.Synthesis;
using System.Text;
using System.Threading.Tasks;

namespace Fizzbuzz
{
    class Program
    {
        static void Main(string[] args)
        {
            Fizzbuzz fizzbuzz = new Fizzbuzz();
            while (true)
            {
                Console.WriteLine("***********");
                SpeechSynthesizer speechSynthesizer = new SpeechSynthesizer();
                Console.WriteLine("Bitte Zahl eingeben:");
                speechSynthesizer.Speak("Bitte Zahl eingeben");
                int zahl = int.Parse(Console.ReadLine());
                Console.WriteLine(fizzbuzz.checkNumber(zahl));
                speechSynthesizer.Speak(fizzbuzz.checkNumber(zahl));
            }
        }
    }
}
