using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DelegateEvent
{
    public delegate void MyDelegate(string text);

    public class Eventtest
    {
        public event MyDelegate MyEvent;

        public void ChangeSometing()
        {
            MyEvent?.Invoke("Event Invoked");
        }
    }
}
