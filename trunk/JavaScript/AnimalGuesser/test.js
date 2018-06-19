var outputTable = document.getElementById("output--table--content");
var sendButton = document.getElementById("sendquestionbutton");
var intent = "";
sendButton.addEventListener("click", function() {OnQuestionClick()});

var xmlhttp = new XMLHttpRequest();
var url = "https://westeurope.api.cognitive.microsoft.com/luis/v2.0/apps/2185e181-0dbb-42e5-9035-40fd7adc50ce?subscription-key=39cbf1d0da3f4160956129cce9ac564f&verbose=true&timezoneOffset=0&q=";
//var intent = "ist das tier schnell?";
xmlhttp.onreadystatechange = function(){
    if(this.readyState == 4 && this.status==200){
        var answer = JSON.parse(this.responseText);
        addOutputRow(answer);
    }
};


function OnQuestionClick(){
    var intentfield = document.getElementById("questioninput");
    intent = intentfield.value;
    xmlhttp.open("GET", url+intent, true);
    xmlhttp.send();
}

function addOutputRow(answer){
    console.log(answer.entities);
    var questionCell = document.createElement("td");
        questionCell.textContent = answer.query;
        questionCell.style.width ="21%";
    var topIntent = document.createElement("td");
        topIntent.textContent = answer.topScoringIntent.intent + ":" + answer.topScoringIntent.score;
        topIntent.style.width ="31%";
    var entities = document.createElement("td");
        entities.textContent = "Entity: " + answer.entities[0].entity + " / Type: " + answer.entities[0].type + " / Value: " + answer.entities[0].resolution.values;
        entities.style.width ="51%";
    var row = document.createElement("tr");
    row.appendChild(questionCell);
    row.appendChild(topIntent);
    row.appendChild(entities);
    outputTable.appendChild(row);
}
