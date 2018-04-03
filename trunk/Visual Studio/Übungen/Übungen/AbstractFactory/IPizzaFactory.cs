namespace AbstractFactory
{
    interface IPizzaFactory
    {
        IIngrediant CreateIngrediant1();
        IIngrediant CreateIngrediant2();
        IPizza CreatePizza();
    }
}
