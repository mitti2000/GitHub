using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Grades
{
    public class GradeStatistics
    {
        public GradeStatistics()
        {
            highestGrade = 0;
            lowestGrade = float.MaxValue;
        }

        public string LetterGrade
        {
            get
            {
                string result;
                if(avgGrade >= 90)
                {
                    result = "A";
                }

                else if(avgGrade >= 80)
                {
                    result = "B";
                }
                else if(avgGrade >= 70)
                {
                    result = "C";
                }
                else if(avgGrade >= 60)
                {
                    result = "D";
                }
                else
                {
                    result = "F";
                }

                return result;
            }
        }

        public string Description
        {
            get
            {
                string result;
                switch (LetterGrade)
                {
                    case "A":
                        result = "Excellent";
                        break;
                    case "B":
                        result = "Good";
                        break;
                    case "C":
                        result = "Average";
                        break;
                    case "D":
                        result = "below Average";
                        break;
                    default:
                        result = "Failing";
                        break;
                }
                return result;
            }
        }
        public float avgGrade;
        public float highestGrade;
        public float lowestGrade;
    }
}
