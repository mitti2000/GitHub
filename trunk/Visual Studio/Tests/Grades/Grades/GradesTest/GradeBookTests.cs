using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Grades;

namespace Grades.Test
{
    [TestClass]
    public class GradeBookTests
    {
        [TestMethod]
        public void ComputesHighestGrade()
        {
            GradeBook gradeBook = new GradeBook();
            gradeBook.AddGrade(10);
            gradeBook.AddGrade(90);

            GradeStatistics result = gradeBook.ComputeStatistics();

            Assert.AreEqual(90, result.highestGrade);
        }

        [TestMethod]
        public void ComputesLowestGrade()
        {
            GradeBook gradeBook = new GradeBook();
            gradeBook.AddGrade(10);
            gradeBook.AddGrade(90);

            GradeStatistics result = gradeBook.ComputeStatistics();

            Assert.AreEqual(10, result.lowestGrade);
        }

        [TestMethod]
        public void ComputesAvgGrade()
        {
            GradeBook gradeBook = new GradeBook();
            gradeBook.AddGrade(91);
            gradeBook.AddGrade(89.5f);
            gradeBook.AddGrade(75);

            GradeStatistics result = gradeBook.ComputeStatistics();

            Assert.AreEqual(85.16f, result.avgGrade, 0.01);
            //Assert.AreEqual(85.166666666f, result.avgGrade); //schlägt fehl wegen ungenauigkeit
        }
    }
}
