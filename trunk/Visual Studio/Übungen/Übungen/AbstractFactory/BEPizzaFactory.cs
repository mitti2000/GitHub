namespace AbstractFactory
{
    class BEPizzaFactory : IPizzaFactory
    {
        public IIngrediant CreateIngrediant1()
        {
            return new GruyereIngrediant();
        }

        public IIngrediant CreateIngrediant2()
        {
            return new SpeckIngrediant();
        }

        public IPizza CreatePizza()
        {
            return new BernerPizza(new SpeckIngrediant(), new GruyereIngrediant());
        }
    }
}
