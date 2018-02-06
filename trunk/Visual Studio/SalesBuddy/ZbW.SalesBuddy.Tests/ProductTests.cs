using System.Runtime.CompilerServices;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace ZbW.SalesBuddy.Tests
{
    [TestClass]
    public class ProductTests
    {
        [TestMethod]
        public void createProduct_withProperNameAndPrice_ProductCreated()
        {
            //Arrange
            Product sut = null;
            //Act
            sut = new Product("Product 1", new decimal(50.5));
            //Assert
            Assert.IsNotNull(sut);
        }

        [TestMethod]
        public void getName_withNormalName_returnName()
        {
            //Arrange
            Product sut = new Product("Product 1", new decimal(50.2));
            //Act
            string result = sut.Name;
            //Assert
            Assert.AreEqual("Product 1", result);
        }

        [TestMethod]
        public void getPrice_withNormalPrice_returnPrice()
        {
            //Arrange
            Product sut = new Product("Product 1", new decimal(50.2));
            //Act
            decimal result = sut.Price;
            //Assert
            Assert.AreEqual(new decimal(50.2), result);
        }

    }
}
