function Calc(){

};

Calc.prototype.sum = function(a,b) {
    return a+b;
};

Calc.prototype.mul = function(a,b) {
    return a*b;
};

Calc.prototype.div = function(a,b) {
    return a*b;
};

Calc.prototype.sub = function(a,b) {
    return a-b;
};

module.exports = Calc;