
//Teilaufgabe1
var wuerfel = {
    zahl: "",
    wuerfeln : function(){this.zahl = Math.round((Math.random()*6)+1);}
}

wuerfel.wuerfeln();
//alert(wuerfel.zahl);


// Teilaufgabe 2
function wuerfel2(){
    this.zahl;
    this.wuerfeln = function(){this.zahl = Math.round((Math.random()*6)+1);}
}

var wuerfel2 = new wuerfel2();
wuerfel2.wuerfeln();
//alert(wuerfel2.zahl);



//Teilaufgabe 3 + 4
function wuerfel3(id){
    this.id = id;
    this.zahl;
    this.wuerfeln = function(){this.zahl = Math.round((Math.random()*6)+1);}
}


var wuerfels = new Array();

for(var i =0; i<5; i++){
    wuerfels.push(new wuerfel3(i));
}

for(var j = 0; j<wuerfels.length; j++){
    wuerfels[j].wuerfeln();
    console.log(wuerfels[j].zahl);
}


