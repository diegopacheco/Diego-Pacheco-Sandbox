var http = require('http');
var fs = require('fs');
var index = fs.readFileSync('index.html');

console.log("Goto http://localhost:9090/")

http.createServer(function (req, res) {
  console.log(req.url);

  if (req.url=="/ghg_simple.csv"){
     res.writeHead(200, {'Content-Type': 'text/html'});
     res.end(fs.readFileSync('ghg_simple.csv'));
  }else{
    res.writeHead(200, {'Content-Type': 'text/html'});
    res.end(index);  
  }
  
}).listen(9090);
