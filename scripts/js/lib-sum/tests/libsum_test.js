var libsum = require('../');
var assert = require('assert');

var result = libsum.sum(2,4);
assert.strictEqual(6,result);
console.log('%d +  %d == %d',2,4,result);
