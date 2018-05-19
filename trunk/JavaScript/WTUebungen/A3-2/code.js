var display = document.getElementById("display");
var button1 = document.getElementById("value1");
var button2 = document.getElementById("value2");
var button3 = document.getElementById("value3");
var button4 = document.getElementById("value4");
var button5 = document.getElementById("value5");
var button6 = document.getElementById("value6");
var button7 = document.getElementById("value7");
var button8 = document.getElementById("value8");
var button9 = document.getElementById("value9");
var button0 = document.getElementById("value0");
var buttons = document.getElementsByTagName("input");
var buttonReturn = document.getElementById("return");

for(button of buttons){
    if(button.type === 'button'){
        button.addEventListener('mouseenter', function(e){AddHoverEffect(this)});
        button.addEventListener('mouseleave', function(e){RemoveHoverEffect(this)});
    }

    if(button.id.startsWith("value")){
        button.addEventListener('click', function(e){WriteToDisplay(this.value);})
    }
};

buttonReturn.addEventListener('click', function(e){Backspace()});
window.addEventListener('load', function() {InitializeDisplay(0)});
window.addEventListener('keydown', function(e){OnKeyDown(e)});

function Backspace(){
    if(display.value.length>1){
        display.value = display.value.slice(0, -1);
    }
    else display.value = 0;
}

function InitializeDisplay(value){
    display.value = value;
}

function WriteToDisplay(value){
    if(display.value == 0){
        display.value = value;
        return;
    }
    
    if(display.value.length < 15){
        display.value += value;
    }

}

function AddHoverEffect(button){
    button.style.background = '#DADADA';
}

function RemoveHoverEffect(button){
    button.style.background = 'transparent';
}

function OnKeyDown(event){
    console.log(event);
    if(event.key >= 0 && event.key < 10){
        WriteToDisplay(event.key);
    }
    else if(event.key == "Backspace"){
        Backspace();
    }
}