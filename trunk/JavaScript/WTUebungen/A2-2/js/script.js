function aufgabe1(){
    return document.getElementById("data1").childNodes[1].textContent
}

var name = aufgabe1();
console.log(name);

function aufgabe2(){
    var elements = document.getElementsByTagName('tr');
    console.log(elements.length);
    for(i = 1; i<elements.length; i++){
        console.log(elements[i].childNodes[1].textContent);
    }
}
aufgabe2();

function aufgabe3(){
    var elements = document.getElementsByClassName('bright');
    for(element of elements){
        element.setAttribute('class','');
    }
}

aufgabe3();

function aufgabe4(element){
    var elements = document.getElementsByTagName('tr');
    elements[element].setAttribute('class', 'bright');
}

aufgabe4(1);


function aufgabe5(){
    var elements = document.getElementsByTagName('td');
    for(element of elements){
        if(element.textContent === "Hans"){
            var age = element.nextSibling.nextSibling.nextSibling.nextSibling;
            age.textContent = 32;
        }
    }
}

aufgabe5();

function aufgabe6(name){
    var elements = document.getElementsByTagName('td');
    for(element of elements){
        if(element.textContent === name){
            var age = element.nextSibling.nextSibling.nextSibling.nextSibling;
            var newAge = age.textContent;
            newAge++;
            age.textContent = newAge;
        }
    }
}

aufgabe6("Anna");


function aufgabe7(){
    var stuff = [
        {
            firstname : 'Thomas',
            lastname : 'Tanner',
            age : 45,
            departement : 'Informatik'
        },
        {
            firstname : 'Manuela',
            lastname : 'Inauen',
            age : 18,
            departement : 'Personal'
        },
        {
            firstname : 'Philip',
            lastname : 'Kellenberger',
            age : 29,
            departement : 'Support'
        }
    ]

    for(person of stuff){
        var trNode = document.createElement('tr');

        var tdfirstName = document.createElement('td');
        var textFirstname = document.createTextNode(person.firstname);
        tdfirstName.appendChild(textFirstname);
        trNode.appendChild(tdfirstName);

        var tdLastName = document.createElement('td');
        var textLastname = document.createTextNode(person.lastname);
        tdLastName.appendChild(textLastname);
        trNode.appendChild(tdLastName);

        var tdAge = document.createElement('td');
        var textAge = document.createTextNode(person.age);
        tdAge.appendChild(textAge);
        trNode.appendChild(tdAge);

        var tdDepartement = document.createElement('td');
        var textDepartement = document.createTextNode(person.departement);
        tdDepartement.appendChild(textDepartement);
        trNode.appendChild(tdDepartement);

        document.getElementsByTagName('tbody')[0].appendChild(trNode);
    }
}

aufgabe7();

function aufgabe8(position){
    var elements = document.getElementsByTagName('tbody')[0].getElementsByTagName('tr');
    console.log(elements);
    var element = elements[position-1];
    var container = element.parentNode;
    container.removeChild(element);
}

aufgabe8(3);