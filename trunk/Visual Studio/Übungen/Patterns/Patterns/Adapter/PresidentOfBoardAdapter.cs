using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Adapter
{
    public class PresidentOfBoardAdapter : IEmployee
    {
        private readonly PresidentOfBoard _presidentOfBoard;

        public PresidentOfBoardAdapter(PresidentOfBoard presidentOfBoard)
        {
            _presidentOfBoard = presidentOfBoard;
        }
        public decimal GetSalery()
        {
            return _presidentOfBoard.GetBonuses();
        }
    }
}
