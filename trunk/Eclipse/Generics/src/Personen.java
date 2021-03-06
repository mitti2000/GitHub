
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.lang.System.out;

class Person implements Comparable{
	private String name;
	public Person(String name){
		this.name = name;
	}
	
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	} 
  
}

class Student extends Person {
	private int nummer;
	public Student(String name, int nummer){
		super(name);
		this.nummer = nummer;
	}
  
}

class PersonenListe<T> {
	private List<T> mList = new ArrayList<T>();
  
  static final int INDENTATION = 25;
  
  /**
   * Add pPerson into this List in sorted Order (by Name).
   * @param pPerson The Person to be inserted.
   */
  public void add(T pPerson) {
    mList.add(pPerson);
  }
  
  /**
   * Merging this and pOtherlist into pMergeList in sorted Order.
   * @param pOtherList The other List which shall be merged with this List. 
   * @param pMergeList Resulting List.
   * @return Number of Entries in the resulting merged List.
   */
  public int merge(PersonenListe pOtherList, 
                   PersonenListe pMergeList) {
	  pMergeList.mList.addAll(mList);
    
    return -1;
  } 
  
  
  public void print(String pPrefix) {
    
  }
  
} // End of class PersonenListe

class PersonenTest {
  
  public static void main(String[] args) {
    
    PersonenListe<Person> personenListe = new PersonenListe<Person>();
    
    personenListe.add(new Person("Hans"));
    personenListe.add(new Person("Annelis"));
    personenListe.print("Personen-Liste  ");
    
    PersonenListe<Student> studentenListe = new PersonenListe<Student>();
    studentenListe.add(new Student("Max", 4711));
    studentenListe.add(new Student("Anna", 4712));
    studentenListe.add(new Student("Clara", 4713));
    studentenListe.print("Studenten-Liste ");
    
    PersonenListe<Person> mergeListe = new PersonenListe<Person>();
    int length = personenListe.merge(studentenListe, mergeListe);
    out.format("%-"+PersonenListe.INDENTATION+"s : %d\n",  
               "Number of merged Persons", length);
    mergeListe.print("Merge-Liste       ");
  }
} 

/* Session-Log: 

Personen-Liste            : Annelis  Hans  
Studenten-Liste           : Anna:4712  Clara:4713  Max:4711  
Number of merged Persons  : 5
Merge-Liste               : Anna:4712  Annelis  Clara:4713  Hans  Max:4711 

*/
