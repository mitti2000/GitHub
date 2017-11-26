﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Grades
{
    public class GradeBook
    {

        public GradeBook()
        {
            _name = "Empty";
            grades = new List<float>();
        }

        public void AddGrade(float grade)
        {
            grades.Add(grade);
        }

        public GradeStatistics ComputeStatistics()
        {
            GradeStatistics stats = new GradeStatistics();

            float sum = 0;
            foreach(float grade in grades)
            {
                sum += grade;
                stats.highestGrade = Math.Max(grade, stats.highestGrade);
                stats.lowestGrade = Math.Min(grade, stats.lowestGrade);

            }

            stats.avgGrade = sum / grades.Count;
            return stats;
        }

        public String Name
        {
            get
            {
                return _name;
            }
            set
            {
                if (!String.IsNullOrEmpty(value))
                {
                    if(_name != value)
                    {
                        NameChangedEventArgs args = new NameChangedEventArgs();
                        args.ExistingName = _name;
                        args.NewName = value;
                        NameChanged(this, args);
                    }

                    _name = value;
                }
            }
        }
        public event NameChangedDelegate NameChanged;
        private string _name;
        List<float> grades;

    }
}
