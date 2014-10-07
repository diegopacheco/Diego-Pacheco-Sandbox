# fn [![Build Status](https://secure.travis-ci.org/jakobmattsson/fn.png)](http://travis-ci.org/jakobmattsson/fn)

Functions for your higher-order functions.



## Installing

`npm install fn`



## Usage

```
  var fn = require('fn');

  var thirdChars = ['one', 'two', 'three'].map(fn.at(2)); // ['e', 'o', 'r']
  var lastChars = ['one', 'two', 'three'].map(fn.last()); // ['e', 'o', 'e']
  var keys = [{ a: 1, b: 2 }, { c: 3 }].map(fn.keys()); // [['a', 'b'], ['c']]
```

The functions `at`, `last` and `keys` are only a few of the available ones.
Until there's a more complete list in the docs, please look at the source. It's quite easy to get what functions there are.
