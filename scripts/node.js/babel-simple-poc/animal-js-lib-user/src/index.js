const requireLocal = require('app-root-path').require
const AnimalsTSLib = requireLocal('../animal-lib-ts/lib');
console.log("JS Lib Calling TS lib FISH == " + AnimalsTSLib.Animals.Fish);