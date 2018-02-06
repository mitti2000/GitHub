using System;
using System.Collections.Generic;

namespace ZbW.SalesBuddy
{
    public interface ICustomer {

        /// <summary>
        /// Gets or sets the name of the customer.
        /// </summary>
        /// <exception cref="ArgumentException">if value is null or empty.</exception>
        string Name { get; set; }


        /// <summary>
        /// Gets all sales of the customer.
        /// </summary>
        IEnumerable<ISale> Sales { get; }

        /// <summary>
        /// Creates an new sale for the customer. 
        /// </summary>
        /// <returns>The newly created sale.</returns>
        ISale CreateSale();
	
        /// <summary>
        /// Gets the total sum of all sales of this customer.
        /// </summary>
        decimal TotalOfAllSales { get; }
    }
}
