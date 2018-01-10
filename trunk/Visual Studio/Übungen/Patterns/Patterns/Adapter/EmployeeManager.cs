using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Adapter
{
    public class EmployeeManager
    {
        private readonly List<IEmployee> _employees;
        private PresidentOfBoard _presidentOfBoard;

        public EmployeeManager()
        {
            _employees = new List<IEmployee>();
        }

        public decimal PaySaleries()
        {
            decimal totalSaleries = 0;

            foreach (var employee in _employees)
            {
                totalSaleries += employee.GetSalery();
            }

            return totalSaleries;
        }

        public void AddEmployee(IEmployee employee)
        {
            _employees.Add(employee);
        }

        public void RemoveEmployee(IEmployee employee)
        {
            _employees.Remove(employee);
        }

        public void SetPresidentOfBoard(PresidentOfBoard presidentOfBoard)
        {
            _presidentOfBoard = presidentOfBoard;
        }
    }
}