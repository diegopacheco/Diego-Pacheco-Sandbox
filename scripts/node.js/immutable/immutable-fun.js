var Immutable = require('immutable');
var map = Immutable.Map({a:1, b:2, c:3});
console.log(map);

var oddSquares = Immutable.Sequence(1,2,3,4,5,6,7,8)
  						  .filter( function(x){ return x%2; } ).map( function(x){ return x*x; } );
console.log(oddSquares);  						  