namespace AbstractFactory
{
    internal class BierIngrediant : IIngrediant
    {
        public BierIngrediant()
        {
            Name = "Bier";
        }

        public string Name { get; }
    }
}