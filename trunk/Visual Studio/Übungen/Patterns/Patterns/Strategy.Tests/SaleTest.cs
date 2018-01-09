using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace Strategy.Tests
{
    [TestClass]
    public class SaleTests
    {
        [TestMethod]
        public void Sale_35percentDiscount_getDiscopuntedTotal()
        {
            //arrage
            Sale sut = new Sale(new PercentualDiscount(75));

            //act
            double result = sut.getTotal(100.0);

            //assert
            Assert.AreEqual(25, result);
        }

        [TestMethod]
        public void Sale_110percentDiscount_getDiscopuntedTotal()
        {
            //arrage
            Sale sut = new Sale(new PercentualDiscount(110));

            //act
            double result = sut.getTotal(100.0);

            //assert
            Assert.AreEqual(0, result);
        }


        [TestMethod]
        public void Sale_AbsoluteDiscount60_getDiscountedTotal()
        {
            //Arrange
            Sale sut = new Sale(new AbsoluteDiscount(60.0));

            //Act
            double result = sut.getTotal(100.0);

            //Assert
            Assert.AreEqual(40, result);
        }

        [TestMethod]
        public void Sale_AbsoluteDiscountBiggerThanTotal_getDiscountedTotal()
        {
            //Arrange
            Sale sut = new Sale(new AbsoluteDiscount(110.0));

            //Act
            double result = sut.getTotal(100.0);

            //Assert
            Assert.AreEqual(0, result);
        }

        [TestMethod]
        public void Sale_TimedDiscountBeforeLunch_getDiscountedTotal()
        {
            //Arrange
            Sale sut = new Sale(new TimedDiscount(15, new FakeTimeOfDay(11,30)));

            //Act
            double result = sut.getTotal(100.0);

            //Assert
            Assert.AreEqual(85, result);
        }

        [TestMethod]
        public void Sale_TimedDiscountAfterLunch_getDiscountedTotal()
        {
            //Arrange
            Sale sut = new Sale(new TimedDiscount(15, new FakeTimeOfDay(12, 30)));

            //Act
            double result = sut.getTotal(100.0);

            //Assert
            Assert.AreEqual(70, result);
        }
    }
}
