using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ContactDS {
    class Program {
        static DataSet CreatePersonContactDS() {

            DataSet ds = new DataSet("PersonContacts");
            DataTable personTable = new DataTable("Person");

            DataColumn col = new DataColumn();
            col.DataType = typeof(System.Int64);
            col.ColumnName = "ID";
            col.ReadOnly = true;
            col.Unique = true;          // values must be unique 
            col.AutoIncrement = true;   // keys are assigned automatically 
            col.AutoIncrementSeed = -1;     // first key starts with -1 
            col.AutoIncrementStep = -1;     // next key = prev. key - 1

            personTable.Columns.Add(col);
            personTable.PrimaryKey = new DataColumn[] { col };

            col = new DataColumn();
            col.DataType = typeof(string);
            col.ColumnName = "FirstName";
            personTable.Columns.Add(col);

            col = new DataColumn();
            col.DataType = typeof(string);
            col.ColumnName = "Name";
            personTable.Columns.Add(col);

            ds.Tables.Add(personTable);


            DataTable contactTable = new DataTable("Contact");

            col = new DataColumn();
            col.DataType = typeof(System.Int64);
            col.ColumnName = "ID";
            col.ReadOnly = true;
            col.Unique = true;          // values must be unique 
            col.AutoIncrement = true;   // keys are assigned automatically 
            col.AutoIncrementSeed = -1;     // first key starts with -1 
            col.AutoIncrementStep = -1;     // next key = prev. key - 1
            contactTable.Columns.Add(col);
            contactTable.PrimaryKey = new DataColumn[] { col };

            col = new DataColumn();
            col.DataType = typeof(string);
            col.ColumnName = "FirstName";
            contactTable.Columns.Add(col);

            col = new DataColumn();
            col.DataType = typeof(string);
            col.ColumnName = "Name";
            contactTable.Columns.Add(col);

            col = new DataColumn();
            col.DataType = typeof(string);
            col.ColumnName = "NickName";
            contactTable.Columns.Add(col);

            col = new DataColumn();
            col.DataType = typeof(string);
            col.ColumnName = "email";
            contactTable.Columns.Add(col);

            col = new DataColumn();
            col.DataType = typeof(string);
            col.ColumnName = "Phone";
            contactTable.Columns.Add(col);

            col = new DataColumn();
            col.DataType = typeof(System.Int64);
            col.ColumnName = "PersonID";
            contactTable.Columns.Add(col);
            ds.Tables.Add(contactTable);

            DataColumn parentCol = ds.Tables["Person"].Columns["ID"];
            DataColumn childCol = ds.Tables["Contact"].Columns["PersonID"];

            DataRelation rel = new DataRelation("PersonHasContacts", parentCol, childCol);
            ds.Relations.Add(rel);
            return ds;
        }


        [STAThread]
        static void Main(string[] args) {
            DataSet ds = CreatePersonContactDS();

            DataRow personRow = ds.Tables["Person"].NewRow();  //person
            personRow[1] = "Wolfgang";
            personRow["Name"] = "Beer";
            ds.Tables["Person"].Rows.Add(personRow);

            DataRow contactRow = ds.Tables[1].NewRow();
            contactRow[1] = "Hans";
            contactRow[2] = "Meier";
            contactRow[3] = "Housi";
            contactRow[4] = "hmeier@hsr.ch";
            contactRow[5] = "379";

            contactRow["PersonID"] = (long)personRow["ID"]; // defines relation
            ds.Tables[1].Rows.Add(contactRow);

            contactRow = ds.Tables[1].NewRow();
            contactRow[1] = "Vreni";
            contactRow[2] = "Müller";
            contactRow[3] = "Vreni";
            contactRow[4] = "vmueller@hsr.ch";
            contactRow[5] = "382";

            contactRow["PersonID"] = (long)personRow["ID"]; // defines relation
            ds.Tables[1].Rows.Add(contactRow);

            ds.AcceptChanges();

            foreach (DataRow person in ds.Tables["Person"].Rows) {
                Console.WriteLine("Contacts of {0}:", person["Name"]);
                foreach (DataRow contact in person.GetChildRows("PersonHasContacts")) {
                    Console.WriteLine("{0}, {1}: {2}", contact[0], contact["Name"], contact["Phone"]);
                }
            }

            Console.ReadLine();







        }
    }
}
