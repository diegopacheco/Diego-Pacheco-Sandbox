var jscov = require('jscov');
var should = require('should');
var fn = require(jscov.cover('..', 'src', 'fn'));

describe('fn', function() {

  describe('#at', function() {
    it('maps over strings', function() {
      var array = ['one', 'two', 'three'];
      var result = array.map(fn.at(2));
      result.should.eql(['e', 'o', 'r']);
    });

    it('maps over arrays', function() {
      var array = [[1, 2, 3, 4], [1001, 1002, 1003]];
      var result = array.map(fn.at(1));
      result.should.eql([2, 1002]);
    });
  });

  describe('#toString', function() {
    it('maps over strings', function() {
      var array = ['one', 'two', 'three'];
      var result = array.map(fn.toString());
      result.should.eql(['one', 'two', 'three']);
    });

    it('maps over numbers', function() {
      var array = [1, 2, 3, 4];
      var result = array.map(fn.toString());
      result.should.eql(['1', '2', '3', '4']);
    });
  });

  describe('#last', function() {
    it('maps over strings', function() {
      var array = ['one', 'two', 'three'];
      var result = array.map(fn.last());
      result.should.eql(['e', 'o', 'e']);
    });

    it('maps over arrays', function() {
      var array = [[1, 2, 3, 4], [1001, 1002, 1003]];
      var result = array.map(fn.last());
      result.should.eql([4, 1003]);
    });
  });

  describe('#keys', function() {
    it('maps over objects', function() {
      var array = [{ a: 1, b: 2 }, { c: 3 }];
      var result = array.map(fn.keys());
      result.should.eql([['a', 'b'], ['c']]);
    });
  });

});
