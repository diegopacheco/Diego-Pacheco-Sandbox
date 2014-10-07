var fn = module.exports = function(name, f) {
  if (typeof name == 'function') {
    f = name;
    name = null;
  }
  if (typeof name == "string" && arguments.length == 1) {
    f = function() {
      return this[name].apply(this, arguments);
    };
  }

  var out = function() {
    var args = Array.prototype.slice.call(arguments, 0);
    return function(x) {
      return f.apply(x, args);
    };
  };
  if (name) {
    arguments.callee[name] = out;
  }
  return out;
};

// Arrays
// ======
fn('length', function() {
  return this.length;
});
fn('at', function(n) {
  return this[n];
});
fn('first', function() {
  return this[0];
});
fn('second', function() {
  return this[1];
});
fn('third', function() {
  return this[2];
});
fn('last', function() {
  return this[this.length-1];
});
fn('secondLast', function() {
  return this[this.length-2];
});
fn('thirdLast', function() {
  return this[this.length-3];
});
fn('reverse', function() {
  return this.slice(0).reverse();
});
fn('sort', function() {
  return this.slice(0).sort();
});
fn('join');
fn('slice');
fn('indexOf');
fn('lastIndexOf');


// Strings
// =======
fn('prepend', function(pre) {
  return pre.concat(this);
});
fn('append', function(post) {
  return this.concat(post);
});
fn('match');
fn('split');
fn('charAt');
fn('charCodeAt');
fn('replace');
fn('substr');
fn('substring');
fn('toLowerCase');
fn('toUpperCase');
fn('trim');
fn('trimLeft');
fn('trimRight');



// Misc
// ====
fn('identity', function() {
  return this;
});
fn('log', function() {
  console.log(this);
  return this;
});
fn('keys', function() {
  return Object.keys(this);
});
fn('create', function() {
  return Object.create(this);
});
fn('toString');
