console.clear();
//Teilaufgabe 1
var zahl = Math.round((Math.random()*10)+1);
console.log("zahl: " +zahl);
var versuche = 0;

//Teilaufgabe 2
while(true){
    var inputzahl = prompt("Bitte geben Sie eine Zahl zwischen 1 und 10 ein");
    console.log(inputzahl);
    versuche++;

    if (inputzahl === null){
        alert("Spiel abgebrochen");
        win = true;
        versuche--;
        break;
    }

    if(inputzahl == ""){
        alert("Keine Zahl eingegeben");
        versuche--;
        continue;
    }

    if(inputzahl<1 || inputzahl>10){
        alert("Zahl ist kleiner als 1 oder grösser als 10!!");
        versuche--;
        continue;
    }

    if(inputzahl == zahl){
        alert("Gratulation! Die gesuchte Zahl ist "+zahl);
        win = true;
        break;
    }

}

//Teilaufgabe 3
