using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace ZbW.SalesBuddy.Tests
{
    [TestClass]
    public class SaleTests
    {
        [TestMethod]
        public void getCustomer_customerExists_returnCustomer()
        {
            //Arrange
            Sale sut = new Sale(new Customer("Cust1"));
            //Act
            ICustomer result = sut.Customer;
            //Assert
            Assert.AreEqual("Cust1", result.Name);
        }

        
    }
}
