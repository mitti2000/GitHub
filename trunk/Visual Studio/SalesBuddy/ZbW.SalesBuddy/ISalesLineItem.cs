using System;

namespace ZbW.SalesBuddy
{
    public interface ISalesLineItem
    {

        /// <summary>
        /// Gets the product.
        /// </summary>
        IProduct Product { get; }

        /// <summary>
        /// Gets or sets the quantity.
        /// </summary>
        /// <exception cref="ArgumentException">if value is less or equal 0</exception>
        int Quantity { get; set; }

        /// <summary>
        /// Gets the total of this sale line item.
        /// </summary>
        decimal Total { get; }

    }
}
