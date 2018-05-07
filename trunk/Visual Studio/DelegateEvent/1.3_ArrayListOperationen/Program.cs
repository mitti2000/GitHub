using System;
using System.Collections;
using System.Diagnostics.Eventing.Reader;

namespace _1._3_ArrayListOperationen {
    // TODO: Delegate "Action"
    public delegate void Action(string i);

    // TODO: Delegate "Predicate"
    public delegate bool Predicate(string s);

    class Program {
        static void Main() {
            ArrayList list = GetNameList();


            Console.WriteLine("--------------------------------------------------");
            Console.WriteLine("Liste aller Namen:");

            // TODO: list ausgeben (Methode ForAll)
            //ForAll(list, Ausgabe);
            ForAll(list, delegate(string i){Console.WriteLine(i);});


            Console.WriteLine("--------------------------------------------------");
            Console.WriteLine("Liste aller Namen mit 'S':");

            // TODO: list auf Namen beginnend mit "S" filtern mit anonymer Methode (Methode Find)
            ArrayList listStartsWithS = Find(list, s => s.StartsWith("S"));

            // TODO: listStartsWithS ausgeben (Methode ForAll)
            ForAll(listStartsWithS, Ausgabe);


            Console.WriteLine("--------------------------------------------------");
            Console.WriteLine("Liste aller Namen mit Länge >= 15:");

            // TODO: list auf Namen mit Länge >= 15 filtern mit anonymer Methode (Methode Find)
            ArrayList listLength15Plus = Find(list, i => i.Length >= 15);

            // TODO: listLength15Plus ausgeben (Methode ForAll)
            ForAll(listLength15Plus, Ausgabe);


            Console.WriteLine("--------------------------------------------------");
            Console.WriteLine("Konkatenierter String:");

            string concatenated = String.Empty;

            // TODO: list in einen string konkatenieren (Methode ForAll)
            ForAll(list, AusgabeConcat);

            // TODO: string "concatenated" auf Konsole ausgeben

            Console.ReadKey();
        }

        // TODO: Methode ForAll(...) implementieren
        private static void ForAll(ArrayList list, Action action)
        {
            foreach (var text in list)
            {
                action((string)text);
            }

        }

        private static void Ausgabe(string i)
        {
            Console.WriteLine(i);
        }

        private static void AusgabeConcat(string i)
        {
            Console.Write(i + " ");
        }

        // TODO: Methode Find(...) implementieren
        private static ArrayList Find(ArrayList list, Predicate predicate)
        {
            ArrayList filtered = new ArrayList();

            foreach (var text in list)
            {
                if (predicate((string)text)) filtered.Add(text);
            }
            return filtered;
        }

        private static ArrayList GetNameList() {
            return new ArrayList {
                "Shaun Byler",
                "Regenia Politte",
                "Earleen Huard",
                "Evelin Svoboda",
                "Phuong Briese",
                "Shea Sailor",
                "Kerri Seese",
                "Dulce Spalla",
                "Cedrick Bohr",
                "Pearline Abele",
                "Chas Grossi",
                "Teresa Winkelman",
                "Marilee Keaton",
                "Karisa Millender",
                "Nickie Borders",
                "Hoyt Eicher",
                "Ula Harjo",
                "Willodean Byerly",
                "Sirena Vives",
                "Johnnie Folkers"
            };
        }
    }
}
