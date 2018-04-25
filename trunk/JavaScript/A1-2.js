var zahl = 5; //Zahl zw o und 5
switch(zahl)
{
    case 2:
    case 4:
        console.log("Die Zahl ist gerade");
        break;
    case 3:
        console.log("Die Zahl ist ungerade");
    case 5:
        console.log("Die Zahl ist eine Primzahl");
        break;
    default:
        console.log("Ungültige Eingabe");
        break;
}

if(zahl==2 || zahl == 4) console.log("2-Die Zahl ist gerade");
else if (zahl==3 || zahl==5) {
    console.log("2-Die Zahl ist ungerade")
    if(zahl==5){
        console.log("2-Die Zahl ist eine Primzahl")
    }
}
else console.log("2-Ungültige Eingabe");