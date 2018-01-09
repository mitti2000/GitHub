using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Strategy
{
    public class FakeTimeOfDay : ITimeOfDay
    {
        private DateTime dateTime;
        public FakeTimeOfDay(int hour, int minute)
        {
            this.dateTime = new DateTime(2018,1,9,hour,minute,0);
        }
        public DateTime getTimeOfDay()
        {
            return dateTime;
        }
    }
}
