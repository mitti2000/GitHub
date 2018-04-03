namespace AbstractFactory
{
    public class SpeckIngrediant : IIngrediant
    {
        public SpeckIngrediant()
        {
            Name = "Speck";
        }
        public string Name { get; }
    }
}
