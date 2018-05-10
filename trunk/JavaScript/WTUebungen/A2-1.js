console.log("Höhe: " + (screen.height * devicePixelRatio) +",Breite: " + (screen.width * devicePixelRatio));
console.log("pixelRatio: "+window.devicePixelRatio);
console.log("length: "+window.history.length);
console.log("state: "+window.history.state);
console.log("back: "+window.history.back);
console.log("forward: "+window.history.forward);
console.log("go: "+window.history.go);
console.log("pushstate: "+window.history.pushState);
console.log("replaceState: "+window.history.replaceState);

for(property in window.history){
    console.log(property + ", "+ window.history[property]);
}
