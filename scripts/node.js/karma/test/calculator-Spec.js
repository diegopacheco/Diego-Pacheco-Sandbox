#!javascript
var calculator = require("../js/calculator");

describe("multiplication", function () {
  it("should multiply 2 and 3", function () {
    var product = calculator.multiply(2, 3);
    expect(product).toBe(6);
  });
}); 
