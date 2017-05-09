csserror
========
[![NPM version](https://badge.fury.io/js/csserror.svg)](http://badge.fury.io/js/csserror)
[![Build Status](https://travis-ci.org/Munter/csserror.svg?branch=master)](https://travis-ci.org/Munter/csserror)
[![Coverage Status](https://img.shields.io/coveralls/Munter/csserror.svg)](https://coveralls.io/r/Munter/csserror?branch=master)
[![Dependency Status](https://david-dm.org/Munter/csserror.svg)](https://david-dm.org/Munter/csserror)

Generate a CSS-based error message that will show in the browser


Usage
-----

```js
var csserror = require('csserror');

var errorStyleSheet = csserror('Your CSS has a syntax error!');

// Now send errorStyleSheet over http, or however you get it into the browser
```

License
-------
(The MIT License)

Copyright (c) 2015 Peter Müller <munter@fumle.dk>

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the 'Software'), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED 'AS IS', WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
