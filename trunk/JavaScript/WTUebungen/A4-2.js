var jsonString = '{"books": [ \
    {"id":"978-3-7645-0564-96","title":"Helix","author":"Marc Elsberg","pages":648,"year":2016,"language":"Deutsch"}, \
    {"id":"978-3-423-19904-9","title":"Selfies","author":"Jussi Alder Olsen","pages":576,"year":2018,"language":"Deutsch"}, \
    {"id":"978-1-5011-8098-9","title":"The Ousdider","author":"Stephen King","pages":576,"year":2018,"language":"Englisch"}, \
    {"id":"978-3-431-03999-3","title":"Origin","author":"Dan Brown","pages":672,"year":2017,"language":"Deutsch"},\
    {"id":"978-3-404-17503-1","title":"Diabolus","author":"Dan Brown","pages":524,"year":2016,"language":"Deutsch"}, \
    {"id":"978-3-404-15485-2","title":"Sakrileg","author":"Dan Brown","pages":624,"year":2006,"language":"Deutsch"} \
  ]}';

  var bookstore = JSON.parse(jsonString);

  console.log(bookstore.books.length);


console.log(bookstore.books.find(b => b.id == "978-3-431-03999-3").title);

bookstore.books.forEach(element => {
    if(element.id == "978-3-431-03999-3"){
        console.log(element.title);
        console.log(JSON.stringify(element));
    }

    if(element.language == "Deutsch"){
        console.log(element.title);
    }
});

