var app = require('http').createServer(handler)
  , io = require('socket.io').listen(app)
  , fs = require('fs')
  
app.listen(8080);

function handler (req, res) {
  fs.readFile(__dirname + '/calc.html',
  function (err, data) {
    if (err) {
      res.writeHead(500);
      return res.end('Error loading index.html');
    }
    res.writeHead(200);
    res.end(data);
  });
}

io.sockets.on('connection', function (socket) {
  socket.on('doop', function (data) {
    console.log('doop event received.');
	console.log(data);
	calc(socket,data);
  });
});

function calc(socket,data){
	
	var result = 0;
	var va = parseFloat(data.va);
	var vb = parseFloat(data.vb);
	
	if (data.op == '+') 
	   result = va + vb;
	else if (data.op == '-') 
	   result = va - vb;     
	else if (data.op == '*') 
	   result = va * vb;     
	else if (data.op == '/') 
	   result = va / vb;               

	socket.emit('result', { result: result });
}


