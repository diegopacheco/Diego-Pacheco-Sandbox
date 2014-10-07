var fn = require('fn.js');

console.log( fn.concat( [ 'a', 1 ], [ 'b', 2 ], [ 'c', 3 ] ) );

var r = fn.map( function ( value ) {
	return value * 2;
}, [ 0, 1, 2, 3, 4, 5, 6 ] );
console.log( r );

var asyncLog = fn.async( console.log );
asyncLog( 'Invalid username or password.' );