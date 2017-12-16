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
            Assert.AreEqual(1, sut.Queue.Count);
        }

        [TestMethod]
        public void Enque_WithPriority_correctPos()
        {
            //Arrange
            PriorityQueue<QueueElement> sut = new PriorityQueue<QueueElement>();
            var el1 = new QueueElement(1);
            var el2 = new QueueElement(2);
            var el3 = new QueueElement(3);
            var el4 = new QueueElement(4);
            //Act
            sut.Enqueue(el1,1);
            sut.Enqueue(el2,2);
            sut.Enqueue(el3,3);
            sut.Enqueue(el4,2);
            //Assert
            Assert.AreEqual(0, sut.Queue.IndexOf(el1));
        }
    }
}
