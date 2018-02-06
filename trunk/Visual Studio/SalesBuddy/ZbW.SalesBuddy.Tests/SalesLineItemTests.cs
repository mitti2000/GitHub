using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace ZbW.SalesBuddy.Tests
{
    [TestClass]
    public class SalesLineItemTests
    {
        [TestMethod]
        public void createSaleLineItem_withProperProductsAndQuantity_SaleLineItemCreated()
        {
            //Arrange
            SalesLineItem sut = null;
            //Act
            sut = new SalesLineItem(new Product("p1", new decimal(50)), 5);
            //Assert
            Assert.IsNotNull(sut);
        }

        [TestMethod]
        [ExpectedException(typeof(System.ArgumentException))]
        public void createSaleLineItem_withNullProductsAndProperQuantity_ThrowArgumentException()
        {
            //Arrange
            SalesLineItem sut = null;
            //Act
            sut = new SalesLineItem(null, 5);
        }

        [TestMethod]
        [ExpectedException(typeof(System.ArgumentException))]
        public void createSaleLineItem_withZeroQuantity_ThrowArgumentException()
        {
            //Arrange
            SalesLineItem sut = null;
            //Act
            sut = new SalesLineItem(new Product("P1", new decimal(5)), 0);
        }

        [TestMethod]
        [ExpectedException(typeof(System.ArgumentException))]
        public void createSaleLineItem_withLessThanZeroQuantity_ThrowArgumentException()
        {
            //Arrange
            SalesLineItem sut = null;
            //Act
            sut = new SalesLineItem(new Product("P1", new decimal(5)), -3);
        }

        [TestMethod]
        public void getProduct_withProduct_returnProduct()
        {
            //Arrange
            SalesLineItem sut = new SalesLineItem(new Product("P1", new decimal(5)), 3);
            //Act
            IProduct result = sut.Product;
            //Assert
            Assert.IsNotNull(result);
        }

        [TestMethod]
        [ExpectedException(typeof(System.ArgumentException))]
        public void setQuantity_quantityZero_ThrowArgumentException()
        {
            //Arrange
            SalesLineItem sut = new SalesLineItem(new Product("P1", new decimal(5)), 3);
            //Act
            sut.Quantity = 0;
        }

        [TestMethod]
        [ExpectedException(typeof(System.ArgumentException))]
        public void setQuantity_quantityLessThanZero_ThrowArgumentException()
        {
            //Arrange
            SalesLineItem sut = new SalesLineItem(new Product("P1", new decimal(5)), 3);
            //Act
            sut.Quantity = -5;
        }

        [TestMethod]
        public void setQuantity_quantityGreaterThanZero_QuantitySet()
        {
            //Arrange
            SalesLineItem sut = new SalesLineItem(new Product("P1", new decimal(5)), 3);
            //Act
            sut.Quantity = 5;
            //Assert
            Assert.AreEqual(5,sut.Quantity);
        }

        [TestMethod]
        public void getTotal_productExists_returnTotal()
        {
            //Arrange
            SalesLineItem sut = new SalesLineItem(new Product("P1", new decimal(5)), 3);
            //Act
            decimal result = sut.Total;
            //Assert
            Assert.AreEqual(15,result);
        }
    }
}
