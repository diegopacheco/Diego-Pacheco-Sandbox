const requireLocal = require('app-root-path').require

// Error: Cannot find module 
// const AnimalsTSLib = requireLocal('../animal-lib-ts/src');

// Need to import the JS generated not the TS code
const AnimalsTSLib = requireLocal('../animal-lib-ts/lib');

console.log("JS Lib Calling TS lib FISH == " + AnimalsTSLib.Animals.Fish);