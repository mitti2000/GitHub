namespace AbstractFactory
{
    public interface IPizza
    {
        string Name { get; }
        IIngrediant Ingredient1 { get; }
        IIngrediant Ingredient2 { get; }
    }
}
