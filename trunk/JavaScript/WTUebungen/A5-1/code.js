$(function () { //Main Function lädt nachdem alles geladen ist
//Daten lesen
//Aufgabe 1
var a = $('header'); //alle Header lesen

//Aufgabe 2
a = $('li:even'); //Alle geraden LI Elemente
a = $('li:last-child').text(); //Text von letztem LI
a = $('li:first-child').html(); //HTML von erstem LI
a= $('input[type="button"]').val(); //Text von Button
console.log(a);

//Daten ändern
//Aufgabe 1
$('li:eq(2)').html('<a href="referenzen.html">Objekt</a>'); //Inhalt von Element anpassen
$('h1').html('Lump <strong>Immobilien</strong> AG');

//Daten hinzufügen
var newItem = $('<li><a href="partner.html">Partner</a></li>'); //neues LI element erstellen
$('ul').append(newItem); //LI Element der Liste hinzufügen

//Daten löschen
$('address a').remove(); //a Element von Adress entfernen
var $content = $('address').html(); //Content von Address festlegen
$('adress').html($content.substring(0, $content.length - 2)); //letzte 2 Zeichen von address entfernen

//Attribute verändern
$('ul').attr("id", "menu"); //id zu UL hinzufügen
$('ul li:first a').attr("href", "index.html"); //href ändern
$('li:first').addClass("active"); //class hinzufügen
$('li a').css("text-decoration", "none"); //css anpassen

//Events
//Suchfeld leeren bei Buttonclick
$('input[type="button"]').click(function(){
    $('#txtSuchen').val("");
})

//Mouseover und Mouseout functions hinzufügen
$('p').mouseover(function(){
    console.log("called");
    $(this).css("background-color", "yellow");
})

$('p').mouseout(function(){
    $(this).css("background-color", "white");
});

//Iteration über Objekte
$('h1').click(function(){
    $('li').each(function(){
        alert($(this).text());
    });
});

//Style Eigenschaften
//Breite eine Bildes ausgeben
console.log($('img').width());

//Position eine Bildes ausgeben
console.log($('img').position().left + "/" + $('img').position().top);

// Effekte
//Bild zurück nach links schieben
$("img").dblclick(function(){
$(this).animate({left: "0"});
});

//Bild 50px nach rechts schieben
$("img").click(function(){
$(this).animate({left: "+=50px"});
});

}); //Main Function schliessen