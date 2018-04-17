using System;
using System.Data;
using System.Data.SqlClient;

namespace EmployeeReader {
    class Program {
        public static void Main() {
            // Installation Northwind-Datenbank: https://northwinddatabase.codeplex.com/releases/view/71634

            // Connectionstring: https://www.connectionstrings.com/sqlconnection/
            string connStr = "Data Source=(local)\\symas;" + "Integrated Security=SSPI;" +
                             "Initial Catalog=Northwind";

            //string connStr = "provider=SQLOLEDB; data source=(local)\\NetSDK; " +
            //	"initial catalog=Northwind; user id=sa; password=; ";
            IDbConnection con = null;       // Verbindung deklarieren
            try {
                con = new SqlConnection(connStr);   //Verbindung erzeugen
                con.Open();
                //----- SQL-Kommando aufbauen
                IDbCommand cmd = con.CreateCommand();
                cmd.CommandText = "SELECT EmployeeID, LastName, FirstName FROM Employees";
                //----- SQL-Kommando ausführen; liefert einen OleDbDataReader
                IDataReader reader = cmd.ExecuteReader();


                object[] dataRow = new object[reader.FieldCount];
                //----- Daten zeilenweise lesen und verarbeiten
                while (reader.Read()) { // solange noch Daten vorhanden sind
                    int cols = reader.GetValues(dataRow); // tatsächliches Lesen 
                    for (int i = 0; i < cols; i++) Console.Write("| {0} ", dataRow[i]);
                    Console.WriteLine();
                }
                //----- Reader schließen
                reader.Close();
            } catch (Exception e) {
                Console.WriteLine(e.Message);
            } finally {
                try {
                    if (con != null)
                        // Verbindung schließen
                        con.Close();
                } catch (Exception ex) { Console.WriteLine(ex.Message); }
            }
            Console.ReadLine();
        }
    }
}
