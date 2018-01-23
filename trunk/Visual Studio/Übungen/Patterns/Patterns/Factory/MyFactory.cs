using System;
using System.Collections.Generic;
using System.Linq;
using System.Reflection;
using System.Text;
using System.Threading.Tasks;

namespace Factory
{
    public class MyFactory
    {
        public IMyService Create(string serviceName)
        {
            Assembly.GetExecutingAssembly().GetTypes()
                .Where(t => t.Name.StartsWith("A"))
                ;
            Assembly.GetExecutingAssembly().GetTypes()
                .Select(x => x.Name);

            return (IMyService) Type.GetType($"Factory.{serviceName}")
                .GetConstructor(new Type[0])
                .Invoke(new object[0]);
        }

        public static void Main(string[] args)
        {
            var factory = new MyFactory();
            IMyService myService = factory.Create("MyService");
            myService.Write();
            Console.ReadLine();
        }
    }

    public interface IMyService
    {
        void Write();
    }

    class MyService : IMyService
    {
        public MyService()
        {
            Console.WriteLine("CTOR of Service 1 called");
        }
        public void Write()
        {
            Console.WriteLine("MyService1");
        }
    }

    class MyService2 : IMyService
    {
        public MyService2()
        {
            Console.WriteLine("CTOR of Service 2 called");
        }

        public void Write()
        {
            Console.WriteLine("MyService2");
        }
    }
}