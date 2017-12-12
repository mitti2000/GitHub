using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PriorityQ
{

    public class QueueElement
    {
        private int _priority;
        private int _number;

        public int Priority
        {
            get { return _priority; }
        }

        public int Number
        {
            get { return _number; }
        }

        public QueueElement(int number)
        {
            _priority = -1;
            _number = number;
        }

    }
}



