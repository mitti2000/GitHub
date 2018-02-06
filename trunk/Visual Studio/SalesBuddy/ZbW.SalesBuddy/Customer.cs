using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ZbW.SalesBuddy
{
    public class Customer : ICustomer
    {
        private string _name;
        private List<ISale> _sales;

        public Customer(string name)
        {
            Name = name;
            _sales = new List<ISale>();
        }

        public string Name
        {
            get => _name;
            set
            {
                if(string.IsNullOrEmpty(value)) throw new ArgumentException();
                _name = value;
            }
        }

        public IEnumerable<ISale> Sales => _sales;

        public ISale CreateSale()
        {
            Sale sale = new Sale(this);
            _sales.Add(sale);
            return sale;
        }

        public decimal TotalOfAllSales { get; }
    }
}
