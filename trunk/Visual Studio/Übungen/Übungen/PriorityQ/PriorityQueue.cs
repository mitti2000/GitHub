using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.CompilerServices;
using System.Text;
using System.Threading.Tasks;

namespace PriorityQ
{
    public class PriorityQueue<T>: IProrityQ<T>
    {
        private List<T> _queue = new List<T>();
        
        internal List<T> Queue { get { return _queue; } }

        public void Enqueue(T element, int priority)
        {
            element.
        }

        public T Dequeue()
        {
            throw new NotImplementedException();
        }

        public int Count()
        {
            throw new NotImplementedException();
        }
    }
}
