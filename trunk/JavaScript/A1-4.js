var pre1 = 0;
var pre2 = 0;
for(var i=1; i<=10; i++){
    if(i==1) {
        pre2 = 1;
        console.log(i);
    }
    else{
        console.log(pre1 + pre2);
        let temp = pre2;
        pre2 = pre1 + pre2;
        pre1 = temp;
    }
}