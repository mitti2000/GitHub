using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Adapter
{
    public class PresidentOfBoard
    {
        private readonly decimal _bonus;

        public PresidentOfBoard(decimal bonus)
        {
            _bonus = bonus;
        }

        public decimal GetBonuses()
        {
            return _bonus;
        }
    }
}