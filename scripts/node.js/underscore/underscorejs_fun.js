var _ = require('underscore');

var p = function(s){
   console.log(s);
}

var m1 = _.map([1, 2, 3], function(num){ return num * 3; });
p(m1);

var sum = _.reduce([1, 2, 3], function(memo, num){ return memo + num; }, 0);
p(sum);

var list = [[0, 1], [2, 3], [4, 5]];
var flat = _.reduceRight(list, function(a, b) { return a.concat(b); }, []);
p(flat);

var evens = _.filter([1, 2, 3, 4, 5, 6], function(num){ return num % 2 == 0; });
p(evens);

var isOdd = function(n){ return (n%2===0) ? true : false };
p( _.partition([0, 1, 2, 3, 4, 5], isOdd) );

p( _.first([5, 4, 3, 2, 1]) );

var add = function(a, b) { return a + b; };
add5 = _.partial(add, 5);
p( add5(10) );

var stooges = [{name: 'curly', age: 25}, {name: 'moe', age: 21}, {name: 'larry', age: 23}];
var youngest = _.chain(stooges)
			    .sortBy(function(stooge){ return stooge.age; })
			    .map(function(stooge){ return stooge.name + ' is ' + stooge.age; })
			    .first()
			    .value();
p(youngest);
