using System;

namespace _1._1_UmbauGenerics {
    public class Person : IComparable<Person> {
        public string Name { get; private set; }
        public int Age { get; private set; }

        public Person(string name, int age) {
            Name = name;
            Age = age;
        }

        public int CompareTo(object p) {
            Person pers = p as Person;
            if (pers != null) {
                return Age - pers.Age;
            }

            throw new Exception("p has wrong type");
        }

        public override string ToString() {
            return Name + ":" + Age;
        }

        public int CompareTo(Person other)
        {
            if (ReferenceEquals(this, other)) return 0;
            if (ReferenceEquals(null, other)) return 1;
            var nameComparison = string.Compare(Name, other.Name, StringComparison.Ordinal);
            if (nameComparison != 0) return nameComparison;
            return Age.CompareTo(other.Age);
        }
    }

    class Program {
        static void Main(string[] args) {
            // Datenstrukturen erstellen
            string[] names = new string[] {"Franscoise", "Bill", "Li", "Sandra", "Gunnar", "Alok", "Hiroyuki", "Maria", "Alessandro", "Raul"};
            int[] ages = new int[] {45, 19, 28, 23, 18, 9, 108, 72, 30, 35};

            // MySortedList abfüllen
            MySortedList<Person> list = new MySortedList<Person>();
            for (int x = 0; x < names.Length; x++) {
                list.Add(new Person(names[x], ages[x]));
            }

            // MySortedList ausgeben vor Sortierung
            Console.WriteLine("Unsorted List:");
            foreach (Person p in list) {
                Console.WriteLine(p.ToString());
            }

            // MySortedList sortieren
            list.BubbleSort();

            // MySortedList ausgeben nach Sortierung
            Console.WriteLine();
            Console.WriteLine("Sorted List:");
            foreach (Person p in list) {
                Console.WriteLine(p.ToString());
            }

            Console.ReadKey();
        }
    }
}