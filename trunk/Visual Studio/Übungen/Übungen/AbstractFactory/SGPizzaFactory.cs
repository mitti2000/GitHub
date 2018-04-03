namespace AbstractFactory
{
    public class SGPizzaFactory : IPizzaFactory
    {
        public IIngrediant CreateIngrediant1()
        {
            return new BierIngrediant();
        }

        public  IIngrediant CreateIngrediant2()
        {
           return new BratwurstIngrediant();
        }

        public IPizza CreatePizza()
        {
            return new BratwurstPizza(CreateIngrediant1(), CreateIngrediant2());
        }
    }
}
