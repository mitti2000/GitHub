var stuff =[
    {name: 'Thomas'},
    {name: 'Philip'},
    {name: 'Hans'},
    {name: 'Luzi'}
]

for(thing in stuff){
    console.log(thing); //0,1,2,3
}

for(thing of stuff){
    console.log(thing); // {name: "Thomas"}, {name:...}
}

var a = '5';
var b = 5;
var c = 5;

if(a==b) console.log("funktioniert");
if(a===b) console.log("funktioniert nicht");
if(a!==b) console.log("funktioniert");
if(b===c) console.log("funktioniert");