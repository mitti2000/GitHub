namespace AbstractFactory
{
    internal class BratwurstIngrediant : IIngrediant
    {
        public BratwurstIngrediant()
        {
            Name = "Bratwurst";
        }
        public string Name { get; }
    }
}