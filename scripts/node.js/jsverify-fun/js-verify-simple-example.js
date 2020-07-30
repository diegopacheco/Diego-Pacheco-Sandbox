const jsc = require('jsverify')
// With property based testing, we don't check for specific inputs and outputs, instead we are testing the boundaries of our code.
const additionIsCommutative = jsc.checkForall(jsc.integer, jsc.integer, 
  (a, b) => a + b === b + a)
const multiplicationIsDistributive = jsc.checkForall(jsc.integer, jsc.integer, jsc.integer, 
  (a, b, c) => a * (b + c) === a * b + a * c)
// log out whether or not the test passed
console.log({ additionIsCommutative, multiplicationIsDistributive })
