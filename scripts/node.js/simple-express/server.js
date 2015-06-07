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

// routes
app.get('/', function (req, res) {
  res.send('Hello World!');
});

app.get('/simple',function(req,res){
 res.send('Routing just fine');
});

app.get('/template',function(req, res){
  res.render('index' ,{ title: "jade works" } );
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

