using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ZbW.SalesBuddy
{
    public class SalesLineItem : ISalesLineItem
    {
        private int _quantity;

        public SalesLineItem(Product product, int quantity)
        {
            if(product == null) throw new ArgumentException();
            else Product = product;
            Quantity = quantity;
        }

        public IProduct Product { get; }

        public int Quantity
        {
            get => _quantity;
            set
            {
                if (value <= 0) throw new ArgumentException();
                _quantity =  value;
            }
        }

        public decimal Total => _quantity * Product.Price;
    }
}
