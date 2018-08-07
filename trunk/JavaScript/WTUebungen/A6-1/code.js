
/* Beispielfunktion
function getName(vorname, nachname) {
    return vorname + ' ' + nachname;
}
*/

//Funktion mit Template Strings
function getName(vorname, nachname) {
	return `${vorname} ${nachname}`;
}
//Funktion mit Arrow Funktion
var x = (vorname, nachname) => { return vorname + ' ' + nachname };
console.log(x('James', 'Bond'));

//Arrow Funktion mit vorgegebenen Werten
console.log(((vorname = 'Hans', nachname = 'Muster') => { return vorname + ' ' + nachname })());

//Funktion mit Rest Parametern
var y = (nachname, ...vornamen) => { 
	var vornamen = "";
	vornamen.forEach(function(vorname) { 
    	vornamen += `${vorname} `;
	});

	return `${name}${nachname}`;
};
console.log(y('Bond', 'James', 'Henry'));

//Klasse mit Variablen und Methoden
class Student {
	constructor (nummer, vorname, nachname) {
		this.nummer = nummer;
		this.vorname = vorname;
		this.nachname = nachname;
		// Teilaufgabe 3
		this.noten = new Set(); //Set Collection
	}
	getName() { return this.vorname + ' ' + this.nachname };
	getDurchschnittsnote() {
		let noten = this.noten.values(); //let lokale Variable
		let sum = 0;
		let note = noten.next();
		while (note.done == false) {
			sum += note.value;
			note = noten.next();
		}
		return sum / this.noten.size;
	}
}

//Objekte von Klassen erstellen
var tonyStark = new Student(1, 'Tony', 'Stark');
tonyStark.noten.add(5.5);
tonyStark.noten.add(4.9);
tonyStark.noten.add(3.5);

console.log('Anzahl Noten: ' + tonyStark.noten.size);
console.log(tonyStark.getDurchschnittsnote());

var peterParker = new Student(2, 'Peter', 'Parker');
peterParker.noten.add(4.0);
peterParker.noten.add(4.6);
peterParker.noten.add(5.2);

class Schulklasse {
	constructor (bezeichnung) {
		this.bezeichnung = bezeichnung;
		this.Studenten = new Map(); //Key Value Set
	}	
}

var marvel = new Schulklasse('Marvel');
marvel.Studenten.set(tonyStark.nummer, tonyStark); //zu Map hinzufügen
marvel.Studenten.set(peterParker.nummer, peterParker);

console.log('Anzahl Studenten: ' + marvel.Studenten.size);

//Über die Studenten iterieren
marvel.Studenten.forEach(function(element) {
	console.log(element.getName());
});
