import wrap  from "decorator-wrap";

var log = (callback, args, name, type) => {
  console.log('Starting  ', type, name);
  var result = callback();
  console.log('Ended: ', name);
  return result;
};

@wrap(log)
class SuperNiceClass {
    constructor(){
        console.log('hello from class');
    }
    @wrap(log)
    bar(a,b) {
        console.log('hello from bar method');
    }
}

new SuperNiceClass().bar(1,2);