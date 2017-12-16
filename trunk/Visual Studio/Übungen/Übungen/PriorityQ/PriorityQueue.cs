using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.CompilerServices;
using System.Text;
using System.Threading.Tasks;

namespace PriorityQ
{
    public class PriorityQueue : IProrityQ<IQueueElement>
    {
        private List<IQueueElement> _queue = new List<IQueueElement>();
        
        internal List<IQueueElement> Queue { get { return _queue; } }

        public void Enqueue(IQueueElement element, int priority)
        {
            IQueueElement el = element;
            el.Priority = priority;
            var en = _queue.GetEnumerator();
            if (_queue.Count == 0) _queue.Add(el);
            else
            {
                while (en.MoveNext())
                {
                    if (en.Current.Priority > el.Priority)
                    {
                        _queue.Insert(_queue.IndexOf(en.Current), el);
                    }
                }
            }
        }

        public IQueueElement Dequeue()
        {
            throw new NotImplementedException();
        }

        public int Count()
        {
            throw new NotImplementedException();
        }
    }
}
