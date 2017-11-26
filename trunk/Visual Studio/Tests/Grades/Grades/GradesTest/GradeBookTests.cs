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
    public class TypeTests
    {

        [TestMethod]
        public void UpperCaseString()
        {
            String name = "thomas";
            name = name.ToUpper();

            Assert.AreEqual("THOMAS", name);
        }

        [TestMethod]
        public void AddDaysToDateTime()
        {
            DateTime date = new DateTime(2015, 1, 1);
            date = date.AddDays(1);

            Assert.AreEqual(2, date.Day);
        }

        [TestMethod]
        public void IncrementInt()
        {
            int x = 46;
            IncrementeNumber(x);
            Assert.AreEqual(46, x);
        }

        private void IncrementeNumber(int number)
        {
            number += 1;
        }

        [TestMethod]
        public void ReferenceTypesPassByValue()
        {
            GradeBook book1 = new GradeBook();
            GradeBook book2 = book1;

            GiveBookAName(book2);
            Assert.AreEqual("A GradeBook", book1.Name);
        }

        private void GiveBookAName(GradeBook book)
        {
            book.Name = "A GradeBook";
        }

        [TestMethod]
        public void StringComparisons()
        {
        string name1 = "Thomas";
        string name2 = "thomas";
        bool result = String.Equals(name1, name2, StringComparison.InvariantCultureIgnoreCase);
        Assert.IsTrue(result);
        }

    }
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
