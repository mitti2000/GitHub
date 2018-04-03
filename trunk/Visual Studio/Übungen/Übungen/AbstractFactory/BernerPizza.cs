namespace AbstractFactory
{
    class BernerPizza : IPizza
    {
        public BernerPizza(IIngrediant i1, IIngrediant i2)
        {
            Name = "Berner Pizza";
            Ingredient1 = i1;
            Ingredient2 = i2;
        }

        public string Name { get; }
        public IIngrediant Ingredient1 { get; }
        public IIngrediant Ingredient2 { get; }
    }

}