using System;
using System.Diagnostics.Eventing.Reader;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace Adapter.Tests
{
    [TestClass]
    public class AdapterTests
    {
        [TestMethod]
        public void EmployeeManager_GetSaleriesFromNormalEmployees_TotalSaleryIs9000()
        {
            //arrange
            EmployeeManager sut = new EmployeeManager();
            sut.AddEmployee(new Employee(5000));
            sut.AddEmployee(new Employee(4000));

            //act
            decimal result = sut.PaySaleries();

            //assert
            Assert.AreEqual(9000, result);
        }

        [TestMethod]
        public void EmployeeManager_GetSaleriesIncludingPresident_TotalSaleryIs19000()
        {
            //arrange
            EmployeeManager sut = new EmployeeManager();
            sut.AddEmployee(new Employee(5000));
            sut.AddEmployee(new Employee(4000));
            sut.AddEmployee(new PresidentOfBoardAdapter(new PresidentOfBoard(10000)));

            //act
            decimal result = sut.PaySaleries();

            //assert
            Assert.AreEqual(19000, result);
        }

    }
}
