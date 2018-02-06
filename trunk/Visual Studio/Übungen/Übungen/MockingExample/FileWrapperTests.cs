using System;
using System.IO;
using System.Runtime.Remoting;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Moq;

namespace MockingExample
{
    [TestClass]
    public class FileWrapperTests
    {
        [TestMethod]
        public void Detete_WhenFIleDeletet_ThenThrowFileNotFoundException()
        {
            //Arrage
            Mock<IFileWrapper> fileMock = new Mock<IFileWrapper>();
            var fileManager = new FileManager(fileMock.Object);

            //Act
            Assert.ThrowsException<FileNotFoundException>(() => fileManager.deleteAll())
                
        }
    }
}
