using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ObjectCopy
{
    public class Person
    {

        public string Name { get; set; }
        public Adress Adresse { get; set; }

        public Person(string name, string adresse)
        {
            this.Name = name;
            this.Adresse = new Adress(adresse);
        }

        public Person DeepCopy()
        {
            var deepCopyPerson = new Person(this.Name, this.Adresse.Adresse);
            return deepCopyPerson;
        }

        public object ShallowCopy()
        {
            return this.MemberwiseClone();
        }
    }
}
