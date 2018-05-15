function ausgabe(text){
    console.log("Event: "+text);
}

var button2 = document.getElementById("testbutton");

console.log(button2);

button2.addEventListener("touchstart", function() {ausgabe("touchstart")});

button2.addEventListener("touchmove", function() { ausgabe("touchmove")});

button2.addEventListener("touchend", function() { ausgabe("touchend")});

button2.addEventListener("touchcancel", function() { ausgabe("touchcancel")});
