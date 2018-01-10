using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Adapter
{
    public class Employee : IEmployee
    {
        private readonly decimal _salery;

        public Employee(decimal salery)
        {
            _salery = salery;
        }

        public decimal GetSalery()
        {
            return _salery;
        }
    }
}
