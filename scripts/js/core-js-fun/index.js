import 'core-js';

console.log(Array.from(new Set([1, 2, 3, 2, 1])));          // => [1, 2, 3]
console.log([1, [2, 3], [4, [5]]].flat(2));                 // => [1, 2, 3, 4, 5]
Promise.resolve(32).then(x => console.log(x));              // => 32