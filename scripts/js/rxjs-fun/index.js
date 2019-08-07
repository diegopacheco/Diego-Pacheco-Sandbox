var rxjs = require('rxjs');
const { range } = require('rxjs');
const { map, filter } = require('rxjs/operators');

console.log("1...");
rxjs.of(1, 2, 3).forEach( v => console.log(v) );

console.log("2...");
range(1, 10).pipe(
    filter(x => x % 2 === 1),
    map(x => x + x)
  ).subscribe(x => console.log(x));
