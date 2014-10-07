var expect = require('expect.js');
var Immutable = require('immutable');
var { reduce, iterate, append, empty, transduce,
      sequence, into, compose, map, filter, remove,
      cat, mapcat, keep, dedupe, take, takeWhile,
      drop, dropWhile } = require('transducers.js');

var ch = chan(1, compose(
  cat,
  map(x => x + 1),
  dedupe(),
  drop(3)
));

go(function*() {
  yield put(ch, [1, 2]);
  yield put(ch, [3, 4]);
  yield put(ch, [4, 5]);
});

go(function*() {
  while(!ch.closed) {
    console.log(yield take(ch));
  }
});