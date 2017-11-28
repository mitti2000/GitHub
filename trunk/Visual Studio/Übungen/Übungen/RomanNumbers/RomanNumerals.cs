using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace RomanNumbers
{
    public class RomanNumerals
    {
        public string ArabicToRoman(int arabic)
        {
            string result = "";
            string[] romanNumbers = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
            int[] faktoren = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
            int zahl = arabic;

            for (int i = 0; i < romanNumbers.Length; i++)
            {
                while (zahl >= faktoren[i])
                {
                    zahl -= faktoren[i];
                    result += romanNumbers[i];
                }
            }
            return result;
        }
    }
}