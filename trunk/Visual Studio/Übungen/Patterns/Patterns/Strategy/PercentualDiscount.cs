using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Strategy
{
    public class PercentualDiscount : IDiscount
    {
        private readonly double discount;
        public PercentualDiscount(double discountInPercent)
        {
            if (discountInPercent > 100.0)
            {
                discount = 100.0;
            }
            else
            {
                discount = discountInPercent;
            }
        }

        public double getDiscountedTotal(double total)
        {
            return total - (total * discount/100);
        }
    }
}
