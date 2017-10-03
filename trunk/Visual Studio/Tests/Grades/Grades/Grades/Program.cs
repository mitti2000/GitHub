using System;
using System.Collections.Generic;
using System.Linq;
using System.Speech.Synthesis;
using System.Text;
using System.Threading.Tasks;

namespace Grades
{
    public class Program
    {
        static void Main(string[] args)
        {
            SpeechSynthesizer speechSynthesizer = new SpeechSynthesizer();
            speechSynthesizer.Speak("Hallo Thomas, wie geht es dir?");

            GradeBook book = new GradeBook();
            book.AddGrade(91);
            book.AddGrade(89.5f);

            GradeStatistics stats = book.ComputeStatistics();
            Console.WriteLine(stats.avgGrade);
            Console.WriteLine(stats.lowestGrade);
            Console.WriteLine(stats.highestGrade);
        }
    }
}
