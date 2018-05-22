var xmlString = '<bookstore> \
    <book id="978-3-7645-0564-96"> \
      <title>Helix</title> \
      <author>Marc Elsberg</author> \
      <pages>648</pages> \
      <year>2016</year> \
      <language>Deutsch</language> \
    </book> \
    <book id="978-3-423-19904-9"> \
      <title>Selfies</title> \
      <author>Jussi Alder Olsen</author> \
      <pages>576</pages> \
      <year>2018</year> \
      <language>Deutsch</language> \
    </book> \
    <book id="978-1-5011-8098-9"> \
      <title>The Outsider</title> \
      <author>Stephen King</author> \
      <pages>576</pages> \
      <year>2018</year> \
      <language>Englisch</language> \
    </book> \
    <book id="978-3-431-03999-3"> \
      <title>Origin</title> \
      <author>Dan Brown</author> \
      <pages>672</pages> \
      <year>2017</year> \
      <language>Deutsch</language> \
    </book> \
    <book id="978-3-404-17503-1"> \
      <title>Diabolus</title> \
      <author>Dan Brown</author> \
      <pages>524</pages> \
      <year>2016</year> \
      <language>Deutsch</language> \
    </book> \
    <book id="978-3-404-15485-2"> \
      <title>Sakrileg</title> \
      <author>Dan Brown</author> \
      <pages>624</pages> \
      <year>2006</year> \
      <language>Deutsch</language> \
    </book> \
  </bookstore>';

var parser = new DOMParser();
var doc = parser.parseFromString(xmlString, "text/xml");

var xmlSerializer = new XMLSerializer();

//Aufgabe1
var books = doc.getElementsByTagName("book");
console.log(books.length);

for(var book of books){
    if(book.getAttribute("id") == "978-3-431-03999-3"){
        //Aufgabe2
        console.log(book.getElementsByTagName("title")[0].textContent);
        //Aufgabe3
        console.log(xmlSerializer.serializeToString(book));
    }

    //Aufgabe 4
    if(book.getElementsByTagName("language")[0].textContent == "Deutsch"){
        console.log(book.getElementsByTagName("title")[0].textContent);
    }
}
