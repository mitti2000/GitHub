using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Remoting.Messaging;
using System.Text;
using System.Threading.Tasks;

namespace DelegatesEvents
{
    class DelegateClass
    {
        
        private delegate void WorkPerformedHandler(int hours, string text);

        public WorkPerformedHandler getDelegate(Metho)
        {
            return new WorkPerformedHandler(hours, text);
        }

    }
}
