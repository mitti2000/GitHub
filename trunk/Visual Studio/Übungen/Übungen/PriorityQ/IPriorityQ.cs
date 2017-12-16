using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PriorityQ
{
    public interface IProrityQ<T>
    {
        void Enqueue(T element, int priority);
        T Dequeue();
        int Count();
    }
}
