using System;
using System.CodeDom;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ZbW.SalesBuddy
{
    public class Sale : ISale
    {
        private readonly ICustomer _customer;
        private IEnumerable<ISalesLineItem> _salesLineItems;
        public Sale(Customer customer)
        {
            if(customer == null) throw new ArgumentException();
            _customer = customer;
            _salesLineItems = new List<ISalesLineItem>();
        }

        public ICustomer Customer { get => _customer; }
        public IEnumerable<ISalesLineItem> SalesLineItems => _salesLineItems;

        public void CreateSalesLine(IProduct product, int quantity)
        {
            throw new NotImplementedException();
        }

        public void RemoveSalesLine(IProduct product)
        {
            throw new NotImplementedException();
        }

        public void UpdateSalesLine(IProduct product, int quantity)
        {
            throw new NotImplementedException();
        }

        public decimal TotalOfSales { get; }
        public IProduct MostExpensiveProduct { get; }
        public IProduct CheapestProduct { get; }
    }
}
