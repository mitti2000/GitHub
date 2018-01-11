using System;
using System.Collections.Generic;
using System.Text;

namespace Singleton
{
    public class PrintJob
    {
        private readonly string _textToPrint;

        public PrintJob(int number)
        {
            _textToPrint = "Number is " + number.ToString();
        }

        public PrintJob(string text)
        {
            _textToPrint = text;
        }

        public string GetText()
        {
            return _textToPrint;
        }
    }
}