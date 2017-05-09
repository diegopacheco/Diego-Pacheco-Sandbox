# checkdir

[![NPM version][npm-image]][npm-url]
[![Build Status][travis-image]][travis-url]
[![Dependency Status][david_img]][david_site]

> Check if dir exists, if it's empty and how many files are directly inside it.


## Install

```
$ npm install checkdir
```


## Usage

```js
var checkdir = require('checkdir');

checkdir('/some/test/dir').then(info => console.log(info));
//=> {
//    empty: false,
//    exists: true,
//    files: 1
// }

// or assuming that the only file in the dir is a 'dotfile'
checkdir('/some/test/dir', { ignoreDotFiles: true })
  .then(info => console.log(info));
//=> {
//    empty: true,
//    exists: true,
//    files: 0
// }
```


## API

### checkdir(directoryPath)

#### directoryPath

*Required*
Type: `String`

Path to directory.

#### options

##### ignoreDotFiles

Type: `Boolean` (Default: `false`)

Don't count files/folders that begin with the dot ('.') character, e.g.. '.git' or '.gitignore'.

## License

MIT © [DaveJ](https://twitter.com/DaveJ)

[npm-image]: https://badge.fury.io/js/checkdir.svg
[npm-url]: https://npmjs.org/package/checkdir
[travis-image]: https://travis-ci.org/davej/checkdir.svg
[travis-url]: https://travis-ci.org/davej/checkdir
[david_img]: https://david-dm.org/davej/checkdir.svg
[david_site]: https://david-dm.org/davej/checkdir
