using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Strategy
{
    public class AbsoluteDiscount : IDiscount
    {
        private readonly double discount;

        public AbsoluteDiscount(double discount)
        {
            if (discount < 100.0)
            {
                this.discount = discount;
            }
            else
            {
                this.discount = 100.0;
            }
        }
        public double getDiscountedTotal(double total)
        {
            return total - discount;
        }
    }
}
