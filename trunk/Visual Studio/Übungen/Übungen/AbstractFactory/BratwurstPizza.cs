namespace AbstractFactory
{
    public class BratwurstPizza : IPizza
    {
        public BratwurstPizza(IIngrediant i1, IIngrediant i2)
        {
            Name = "Bratwurst Pizza";
            Ingredient1 = i1;
            Ingredient2 = i2;
        }

        public string Name { get; }
        public IIngrediant Ingredient1 { get; }
        public IIngrediant Ingredient2 { get; }
    }
}