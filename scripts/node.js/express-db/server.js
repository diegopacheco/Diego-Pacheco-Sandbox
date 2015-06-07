var express = require('express');
var path = require('path');
var logger = require('morgan');
var cookieParser = require('cookie-parser');
var bodyParser = require('body-parser');
var app = express();

// view template engine - JADE
app.set('views', path.join( __dirname, '.' ) );
app.set('view engine', 'jade' );

// aditional config for express 
app.use(logger('dev'));
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: false }));
app.use(cookieParser());

function Counter(){
  this.count = 0;
}
Counter.prototype = {
    count: 0,
    get: function(){
      return this.count;
    },
    inc: function(){
       this.count = this.count + 1;
    }
};
module.exports = Counter;
var counter = new Counter();

// routes
app.get('/', function (req, res) {
  
  var sqlite3 = require('sqlite3').verbose();
  var db = new sqlite3.Database(':memory:');

  db.serialize(function() {
  	  db.run('CREATE TABLE lorem (info TEXT)');
	  var stmt = db.prepare('INSERT INTO lorem VALUES (?)');

	  for (var i = 0; i < 10; i++) {
	    stmt.run('Ipsum ' + i);
	  }
	  stmt.finalize();

	  db.each('SELECT rowid AS id, info FROM lorem', function(err, row) {
	    console.log(row.id + ': ' + row.info);
	    counter.inc();
	  });
  });
  db.close();
  res.send('Hello World! SQLite Query: ' + counter.get());

});

// Error handler
app.use(function(req, res, next) {
  res.status(404).send('Sorry cant find that! NodeJS/Express 404 :( ');
});

// server bootup
var server = app.listen(3000, function () {
  var host = server.address().address;
  var port = server.address().port;
  console.log('Example app listening at http://%s:%s', host, port);
});

