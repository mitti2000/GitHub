using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PriorityQ
{

    public class QueueElement<TElement> : IQueueElement
    {
        private int _priority;
        private int _number;

        public int Priority
        {
            get => _priority;
            set => _number = value;
        }

        public int Number
        {
            get => _number;
            set => _number = value;
        }

        public TElement Element { get; set; }

        public QueueElement(int number)
        {
            _priority = -1;
            _number = number;
        }

    }
}



