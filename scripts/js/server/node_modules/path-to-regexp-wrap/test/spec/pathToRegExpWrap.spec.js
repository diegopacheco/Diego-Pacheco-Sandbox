/*!
 * path-to-regexp-wrap spec
 * @author Andrew Teologov <teologov.and@gmail.com>
 */

/* global define, describe, beforeEach, afterEach, it, assert, sinon, teoBase  */

"use strict";

const path = require('../../')();    // options object could be passed as well

describe('Testing path-to-regexp-wrap', () => {
  let route, match;

  beforeEach(() => {
    route = '/get/:id';
    match = path(route);
  });

  afterEach(() => {
    route = match = null;
  });

  it('correct footprint', () => {
    expect(path('/')).to.be.an.instanceof(Function);
    expect(path('/')('/')).to.be.an.instanceof(Object);
    expect(path('/')('/bla')).to.equal(false);
  });

  it('Should match the path and return parameters object', () => {
    assert.deepEqual(match('/get/1'), {id: '1'}, 'Should return matched parameters object');
  });

});


describe('root url', () => {
  it('matches the root', () => {
    expect(path('/')('/')).to.deep.equal({}, 'Simple equal match');
  });

  it('matches empty', () => {
    expect(path('/')('')).to.deep.equal({}, 'Empty url = root');
  });

  it.skip('matches asterisk', () => {
    expect(path('*')('/')).to.deep.equal({});
  });

  it('matches asterisk after slash', () => {
    expect(path('/*')('/')).to.deep.equal({}, 'Optional with asterisk');
  });

  it('skips when no match', () => {
    expect(path('/')('/hello')).to.equal(false, 'No match = false');
  });
});



describe('param matching', () => {
  const name = { name: 'john' };
  const fullname = { name: 'john', last: 'doe' };

  it('matches single param', () => {
    expect(path('/:name')('/john')).to.deep.equal(name);
  });

  it('skips with mandatory param', () => {
    expect(path('/:name')('/')).to.equal(false);
  });

  it('matches optional param', () => {
    expect(path('/:name?')('/john')).to.deep.equal(name, 'With question');
    expect(path('/:name*')('/john')).to.deep.equal(name, 'With asterisk');
  });

  it('matches with optional param', () => {
    expect(path('/:name?')('/')).to.deep.equal({}, 'With question');
    expect(path('/:name*')('/')).to.deep.equal({}, 'With asterisk');
  });

  it('matches two params', () => {
    expect(path('/:name/:last')('/john/doe')).to.deep.equal(fullname);
  });

  it('matches one mandatory and one optional', () => {
    expect(path('/:name/:last?')('/john/doe')).to.deep.equal(fullname);
    expect(path('/:name/:last?')('/john')).to.deep.equal(name);
  });

  it('matches even when reversed', () => {
    expect(path('/:last?/:name')('/john')).to.deep.equal(name);
  });
});
