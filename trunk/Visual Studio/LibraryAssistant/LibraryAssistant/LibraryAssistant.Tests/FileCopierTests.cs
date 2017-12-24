using System;
using System.IO;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace LibraryAssistant.Tests
{
    [TestClass]
    public class FileCopierTests
    {
        [TestMethod]
        public void CreateFileCopierTest()
        {
            //Arrange
            FileCopier sut = new FileCopier("C:\\temp\\1\\2\\3\\test.txt");

            //Act

            //Assert
            Assert.IsTrue(sut != null);
        }

        [TestMethod]
        public void copyFileTest()
        {
            //Arrange
            FileCopier sut = new FileCopier("C:\\temp\\1\\2\\3\\test.txt");

            //Act
            bool result = sut.copyFile("C:\\temp");

            //Assert
            Assert.IsTrue(result);
        }
    }
}
