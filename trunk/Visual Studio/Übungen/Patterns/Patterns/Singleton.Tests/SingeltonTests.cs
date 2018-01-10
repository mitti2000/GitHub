using System;
using System.Threading;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace Singleton.Tests
{
    [TestClass]
    public class SingeltonTests
    {
        [TestMethod]
        public void PrintSpooler_WorkOnJobs_getJobs()
        {
            //arrange
            var printSpooler = PrintSpooler.GetInstance();
            

        }
    }
}
