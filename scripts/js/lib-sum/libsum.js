(function(global) {
    function sum(a,b) {
        var result = a + b;
        return result;
      }
    global.sum = sum;
}((typeof exports === 'undefined') ? (this.Libsum = {}) : exports));