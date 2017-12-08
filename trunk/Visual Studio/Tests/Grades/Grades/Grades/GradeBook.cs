using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Grades
{
    public class GradeBook : GradeTracker
    {

        public GradeBook()
        {
            _name = "Empty";
            grades = new List<float>();
        }

        public override void AddGrade(float grade)
        {
            grades.Add(grade);
        }

        public override GradeStatistics ComputeStatistics()
        {
            GradeStatistics stats = new GradeStatistics();
            Console.WriteLine("GradeBook::ComputerStatistics");
            float sum = 0;
            foreach (float grade in grades)
            {
                sum += grade;
                stats.highestGrade = Math.Max(grade, stats.highestGrade);
                stats.lowestGrade = Math.Min(grade, stats.lowestGrade);

            }

            stats.avgGrade = sum / grades.Count;
            return stats;
        }

        public override void WriteGrades(TextWriter destination)
        {
            for (int i = 0; i < grades.Count; i++)
            {
                destination.WriteLine(grades[i]);
            }
        }

        
        protected List<float> grades;

    }
}
