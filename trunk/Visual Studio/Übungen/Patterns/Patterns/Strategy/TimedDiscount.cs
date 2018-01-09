using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Strategy
{
    public class TimedDiscount : IDiscount
    {
        private readonly double discount;
        private readonly ITimeOfDay timeOfDay;

        public TimedDiscount(double discount, ITimeOfDay timeOfDay)
        {
            this.discount = discount;
            this.timeOfDay = timeOfDay;
        }
        public double getDiscountedTotal(double total)
        {
            if (timeOfDay.getTimeOfDay().Hour < 12)
            {
                return total - (total * discount / 100);
            }
            else
            {
                return total - (total * discount*2 / 100);
            }
        }
    }
}
