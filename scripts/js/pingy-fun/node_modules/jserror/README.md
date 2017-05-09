jserror
========
[![NPM version](https://badge.fury.io/js/jserror.svg)](http://badge.fury.io/js/jserror)
[![Build Status](https://travis-ci.org/Munter/jserror.svg?branch=master)](https://travis-ci.org/Munter/jserror)
[![Coverage Status](https://img.shields.io/coveralls/Munter/jserror.svg)](https://coveralls.io/r/Munter/jserror?branch=master)
[![Dependency Status](https://david-dm.org/Munter/jserror.svg)](https://david-dm.org/Munter/jserror)

Generate a JS-based CSS error message that will show in the browser and browser console.


Usage
-----

```js
var jserror = require('jserror');

var errorScript = jserror('Your CSS has a syntax error!');

// Now send errorScript over http, or however you get it into the browser
```

License
-------
(The MIT License)

Copyright (c) 2015 Peter Müller <munter@fumle.dk>

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the 'Software'), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED 'AS IS', WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
