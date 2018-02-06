using System;
using System.Collections.Generic;
using System.Linq;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace ZbW.SalesBuddy.Tests
{
    [TestClass]
    public class CustomerTests
    {
        [TestMethod]
        public void createCustomer_withName_customerCreated()
        {
            //Arrange
            Customer sut = null;
            //Act
            sut = new Customer("Cust1");
            //Assert
            Assert.IsNotNull(sut);
        }

        [TestMethod]
        [ExpectedException(typeof(System.ArgumentException))]
        public void createCustomer_emptyName_noCustomerCreated()
        {
            //Arrange
            Customer sut = null;
            //Act
            sut = new Customer("");
        }

        [TestMethod]
        [ExpectedException(typeof(System.ArgumentException))]
        public void createCustomer_nullName_noCustomerCreated()
        {
            //Arrange
            Customer sut = null;
            //Act
            sut = new Customer(null);
        }

        [TestMethod]
        public void getName_normalName_returnsName()
        {
            //Arrange
            Customer sut = new Customer("Cust1");
            //Act
            string result = sut.Name;
            //Assert
            Assert.AreEqual("Cust1", result);
        }

        [TestMethod]
        public void setName_normalName_nameSet()
        {
            //Arrange
            Customer sut = new Customer("Cust1");
            //Act
            sut.Name = "newName";
            //Assert
            Assert.AreEqual("newName", sut.Name);
        }

        [TestMethod]
        [ExpectedException(typeof(System.ArgumentException))]
        public void setName_emptyName_throwArgumentException()
        {
            //Arrange
            Customer sut = new Customer("Cust1");
            //Act
            sut.Name = "";
        }

        [TestMethod]
        [ExpectedException(typeof(System.ArgumentException))]
        public void setName_nullName_throwArgumentException()
        {
            //Arrange
            Customer sut = new Customer("Cust1");
            //Act
            sut.Name = null;
        }

        [TestMethod]
        public void createSale_normalSale_returnSale()
        {
            //Arrange
            Customer sut = new Customer("Cust1");
            //Act
            Sale result = new Sale(sut);
            //Assert
            Assert.IsNotNull(result);
        }

        [TestMethod]
        public void getSales_noSales_emptyList()
        {
            //Arrange
            Customer sut = new Customer("Cust1");
            //Act
            IEnumerable<ISale> result = sut.Sales;
            //Assert
            Assert.AreEqual(0, result.Count());
        }

        [TestMethod]
        public void getSales_1Sale_return1Sale()
        {
            //Arrange
            Customer sut = new Customer("Cust1");
            sut.CreateSale();
            //Act
            IEnumerable<ISale> result = sut.Sales;
            //Assert
            Assert.AreEqual(1, result.Count());
        }

        [TestMethod]
        public void getSales_4Sales_return4Sales()
        {
            //Arrange
            Customer sut = new Customer("Cust1");
            sut.CreateSale();
            sut.CreateSale();
            sut.CreateSale();
            sut.CreateSale();
            //Act
            IEnumerable<ISale> result = sut.Sales;
            //Assert
            Assert.AreEqual(4, result.Count());
        }
    }
}

