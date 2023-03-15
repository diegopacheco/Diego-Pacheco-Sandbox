var Calc = require('./calc.js');

const calc = new Calc("localhost:6379");
//const calc = new Calc();

console.log(calc);
console.log("2 + 3 == " + calc.sum(2,3) );
console.log("2 * 3 == " + calc.mul(2,3) );
console.log("3 / 3 == " + calc.div(3,3) );
console.log("3 - 2 == " + calc.sub(3,2) );

try{
    console.log("0 / 0 == " + calc.div(0,0) );
}catch(e){
    console.log(""+e)
}

calc.observability();
calc.disconnect();