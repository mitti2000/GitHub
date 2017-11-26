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
            //(SpeechSynthesizer speechSynthesizer = new SpeechSynthesizer();
            //speechSynthesizer.Speak("Hallo Thomas, wie geht es dir?");

            GradeBook book = new GradeBook();

            book.NameChanged += new NameChangedDelegate(OnNameChanged);

            book.Name = "My Gradebook";
            book.Name = null;
            book.Name = "";
            book.AddGrade(91);
            book.AddGrade(89.5f);

            GradeStatistics stats = book.ComputeStatistics();
            Console.WriteLine(book.Name);
            WriteResult("Average", stats.avgGrade);
            //Console.WriteLine(stats.avgGrade);
            WriteResult("Highest", (int)stats.highestGrade);
            WriteResult("Lowest", stats.lowestGrade);
        }

        static void OnNameChanged(object sender, NameChangedEventArgs args)
        {
            Console.WriteLine($"Grade bok changing name from {args.ExistingName} to {args.NewName}");
        }


        static void WriteResult(string description, int result)
        {
            Console.WriteLine(description + ": " + result);
        }

        static void WriteResult(string description, float result)
        {
            Console.WriteLine("{0} : {1:F2}", description, result); //Parameter with formatting string
        }
    }
}
