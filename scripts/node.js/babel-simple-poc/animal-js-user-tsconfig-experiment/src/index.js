const requireLocal = require('app-root-path').require

const AnimalsTSLib = requireLocal('../animal-lib-ts/src/');
console.log("JS Lib Calling TS lib FISH == " + AnimalsTSLib.Animals);