using System;
using System.Collections.Generic;
using System.IO;
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
            GetBookName(book);
            AddGrades(book);
            SaveData(book);
            WriteOutput(book);
        }

        private static void WriteOutput(GradeBook book)
        {
            GradeStatistics stats = book.ComputeStatistics();
            Console.WriteLine(book.Name);
            WriteResult("Average", stats.avgGrade);
            //Console.WriteLine(stats.avgGrade);
            WriteResult("Highest", (int)stats.highestGrade);
            WriteResult("Lowest", stats.lowestGrade);
            WriteResult(stats.Description, stats.LetterGrade);
        }

        private static void SaveData(GradeBook book)
        {
            using (StreamWriter outputFile = File.CreateText("grades.txt"))
            {
                book.WriteGrades(outputFile);
            }
        }

        private static void AddGrades(GradeBook book)
        {
            book.AddGrade(91);
            book.AddGrade(89.5f);
            book.AddGrade(75.0f);
        }

        private static void GetBookName(GradeBook book)
        {
            try
            {
                book.Name = "My Gradebook";
                book.Name = null;
                book.Name = "";
            }

            catch (ArgumentException ex)
            {
                Console.ForegroundColor = ConsoleColor.Red;
                Console.WriteLine(ex.Message);
                Console.ForegroundColor = ConsoleColor.White;
            }
        }

        static void OnNameChanged(object sender, NameChangedEventArgs args)
        {
            Console.WriteLine($"Grade bok changing name from {args.ExistingName} to {args.NewName}");
        }


        static void WriteResult(string description, int result)
        {
            Console.WriteLine(description + ": " + result);
        }

        static void WriteResult(string description, string result)
        {
            Console.WriteLine(description + ": " + result);
        }

        static void WriteResult(string description, float result)
        {
            Console.WriteLine("{0} : {1:F2}", description, result); //Parameter with formatting string
        }
    }
}
