using System;

namespace AbstractFactory
{
    public class Program
    {
        static void Main(string[] args)
        {
            IPizzaFactory sgfactory = new SGPizzaFactory();

            IPizza sgPizza = sgfactory.CreatePizza();


            Console.WriteLine("sgPizza: " + sgPizza.Name + " with " + sgPizza.Ingredient1.Name +" and " + sgPizza.Ingredient2.Name);
                
        }
    }
}
