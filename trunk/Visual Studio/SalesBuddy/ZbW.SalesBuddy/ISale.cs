using System;
using System.Collections.Generic;

namespace ZbW.SalesBuddy
{
    public interface ISale {

        /// <summary>
        /// Gets the associated customer of this sales.
        /// </summary>
        ICustomer Customer { get; }

        /// <summary>
        /// Gets all sales line items of the sales.
        /// </summary>
        IEnumerable<ISalesLineItem> SalesLineItems { get; }

        /// <summary>
        /// Creates a new sale line item with a specific product and quantity.
        /// </summary>
        /// <param name="product">the product</param>
        /// <param name="quantity">the product</param>
        /// <exception cref="ArgumentException">if product is null</exception>
        /// <exception cref="ArgumentException">if quantity is less or equal 0</exception>
        void CreateSalesLine(IProduct product, int quantity);

        /// <summary>
        /// Removes the sale line item associated with the product.
        /// </summary>
        /// <param name="product">the product</param>
        /// <exception cref="ArgumentException">if product is null or does not exists</exception>
        void RemoveSalesLine(IProduct product);

        /// <summary>
        /// Updates the sale line item with a specific product and quantity.
        /// 
        /// If quantity is 0, then the sales line item will be removed.
        /// </summary>
        /// <param name="product">the product</param>
        /// <param name="quantity">the product</param>
        /// <exception cref="ArgumentException">if product is null</exception>
        /// <exception cref="ArgumentException">if quantity is less 0</exception>
        void UpdateSalesLine(IProduct product, int quantity);

        /// <summary>
        /// Gets the total of this sale.
        /// </summary>
        decimal TotalOfSales { get; }

        /// <summary>
        /// Gets the most expensive product or null.
        /// </summary>
        IProduct MostExpensiveProduct { get; }

        /// <summary>
        /// Gets the cheapest product or null
        /// </summary>
        IProduct CheapestProduct { get; }
    }
}
