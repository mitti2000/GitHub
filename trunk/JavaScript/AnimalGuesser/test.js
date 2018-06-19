console.log("test");

var xmlhttp = new XMLHttpRequest();
var url = "https://westus.api.cognitive.microsoft.com/luis/v2.0/apps/76ad3351-da24-44da-8c1a-f3ec5625b7c8?subscription-key=11a1d0eb04be4256ab9bff518ec08285&verbose=true&timezoneOffset=0&q=";
var intent = "hat das Tier hörner";
xmlhttp.onreadystatechange = function(){
    if(this.readyState == 4 && this.status==200){
        var myArr = JSON.parse(this.responseText);
        myFunction(myArr);
    }
};

xmlhttp.open("GET", url+intent, true);
xmlhttp.send();

function myFunction(arr){
    console.log(arr.topScoringIntent);
}