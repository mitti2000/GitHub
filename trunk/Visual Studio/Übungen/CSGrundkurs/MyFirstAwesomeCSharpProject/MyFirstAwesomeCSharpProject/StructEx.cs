using System;
using System.CodeDom;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.InteropServices;
using System.Text;
using System.Threading.Tasks;

namespace MyFirstAwesomeCSharpProject
{
    public struct Money
    {
        private decimal _value;
        private string _currecy;

        public Money(decimal value, string currecy)
        {
            _value = value;
            _currecy = currecy;
        }

        public decimal Value
        {
            get => _value;
            set => _value = value;
        }

        public string Currency
        {
            get => _currecy;
            set => _currecy = value;
        }

        public static Money operator +(Money left, Money right)
        {
            if (left.Currency == right.Currency)
            {
                return new Money(left.Value + right.Value, left.Currency);
            }
            throw new InvalidOperationException("Wrong Currency");
        }

        public override string ToString()
        {
            return base.ToString();
        }
    }

    public class Money2
    {
        private decimal _value;
        private string _currecy;

        public Money2(decimal value, string currecy)
        {
            _value = value;
            _currecy = currecy;
        }

        public decimal Value
        {
            get => _value;
            set => _value = value;
        }

        public string Currency
        {
            get => _currecy;
            set => _currecy = value;
        }

        public static Money2 operator +(Money2 left, Money2 right)
        {
            if (left.Currency == right.Currency)
            {
                return new Money2(left.Value + right.Value, left.Currency);
            }
            throw new InvalidOperationException("Wrong Currency");
        }
    }
}
