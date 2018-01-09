using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Strategy
{
    class TimeOfDay : ITimeOfDay
    {
        public DateTime getTimeOfDay()
        {
            return DateTime.Now;
        }
    }
}
