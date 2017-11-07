
public class TestListe {
	public static void main(String[] args){
		PersonenListe<Person> personenListe = new PersonenListe<Person>();
		personenListe.add(new Person("Hans"));
		personenListe.add(new Person("Annelis"));
		personenListe.print("Personen-Liste ");
		PersonenListe<Student> studentenListe = new PersonenListe<Student>();
		studentenListe.add(new Student("Max", 4711));
		studentenListe.add(new Student("Anna", 4712));
		studentenListe.add(new Student("Clara", 4713));
		studentenListe.print("Studenten-Liste ");
		PersonenListe<Person> mergeListe = new PersonenListe<Person>();
		int length = personenListe.merge(studentenListe, mergeListe);
		System.out.print("Number of merged Persons : " + length);
		mergeListe.print("Merge-Liste ");
		/* Session-Log:
		Personen-Liste : Annelis Hans
		Studenten-Liste : Anna:4712 Clara:4713 Max:4711
		Number of merged Persons : 5
		Merge-Liste : Anna:4712 Annelis Clara:4713 Hans Max:4711
		*/
	}
}