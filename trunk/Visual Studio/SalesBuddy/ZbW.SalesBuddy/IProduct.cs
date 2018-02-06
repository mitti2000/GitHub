namespace ZbW.SalesBuddy
{
    public interface IProduct
    {
        /// <summary>
        /// Gets the name of the product.
        /// </summary>
        string Name { get; }

        /// <summary>
        /// Gets the price of the product.
        /// </summary>
        decimal Price { get; }
    }
}
