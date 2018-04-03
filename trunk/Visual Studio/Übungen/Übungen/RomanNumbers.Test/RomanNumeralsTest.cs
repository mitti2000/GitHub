using System;
using FluentAssertions;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace RomanNumbers.Test
{
    [TestClass]
    public class RomanNumeralsTest
    {
        [TestMethod]
        [DataRow(0, "")]
        [DataRow(1, "I")]
        [DataRow(2, "II")]
        [DataRow(3, "III")]
        [DataRow(4, "IV")]
        [DataRow(9, "IX")]
        [DataRow(15, "XV")]
        [DataRow(149, "CXLIX")]
        public void ArabicToRoman_Input_Expected(int input, string expected)
        {
            //Arrange
            var romanNumbers = new RomanNumerals();
            //Act
            var result = romanNumbers.ArabicToRoman(input);
            //Assert
            result.Should().NotEndWith("A").And.NotBe("C");
            Assert.AreEqual(expected, result);
        }

    }

}