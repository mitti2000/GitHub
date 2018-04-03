namespace AbstractFactory
{
    public class GruyereIngrediant : IIngrediant
    {
        public GruyereIngrediant()
        {
            Name = "Gruyere";
        }
        public string Name { get; }
    }
}
