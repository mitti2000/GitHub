using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Strategy
{
    public class Sale
    {
        private readonly IDiscount discount;
        public Sale(IDiscount discount)
        {

            this.discount = discount;
        }

        public double getTotal(double total)
        {
            return discount.getDiscountedTotal(total);
        }
    }
}
