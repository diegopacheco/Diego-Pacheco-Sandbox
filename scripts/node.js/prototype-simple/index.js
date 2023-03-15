var Calc = require('./calc.js');

console.log(new Calc);
console.log("2 + 3 == " + new Calc().sum(2,3) );
console.log("2 * 3 == " + new Calc().mul(2,3) );
console.log("3 / 3 == " + new Calc().div(3,3) );
console.log("3 - 2 == " + new Calc().sub(3,2) );