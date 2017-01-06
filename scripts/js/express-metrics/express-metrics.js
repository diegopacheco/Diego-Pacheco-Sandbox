var express = require('express');
var expressMetrics = require('express-metrics');
var app = express();
 
// start a metrics server 
app.use(expressMetrics({
  port: 8091
}));
 
// every time this handler returns the greet, express-metrics 
// will update the metrics with the calculated response time 
app.get('/', function (req, res, next) {
  res.json({ greet: 'Hello world!' });
});
app.listen(3000);


