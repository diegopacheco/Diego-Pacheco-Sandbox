var unique = require('uniq');
function getData(){
    var data = [1, 2, 2, 3, 4, 5, 5, 5, 6];
    var result = unique(data);
    return result;
};
console.log(getData());

module.exports=getData;
