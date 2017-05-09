'use strict';

var expect = require('unexpected');
var jserror = require('../lib/index');

describe('jserror', function () {
  it('should return a function', function () {
    return expect(jserror, 'to be a function');
  });

  it('should return an error message in a source comment', function () {
    return expect(jserror('foo'), 'to contain', '* foo');
  });
});
