using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using PriorityQ;

namespace PriorityQ.Test
{
    [TestClass]
    public class PriorityQueueTests
    {
        [TestMethod]
        public void Enqueue_Element()
        {
            //Arrange
            PriorityQueue<QueueElement> sut = new PriorityQueue<QueueElement>();
            //Act
            sut.Enqueue(new QueueElement(5), 1 );
            //Assert
            Assert.AreEqual(new QueueElement(5), sut.Queue);
        }
    }
}
