var studenten = Array('Thomas', 'Dominic', 'Markus', 'Khoa');

var consoleOut = "";

studenten.sort();

for(var i=0; i<studenten.length; i++){
    consoleOut += studenten[i];
    if(i<studenten.length-1) consoleOut += ", ";
}
console.log(consoleOut);