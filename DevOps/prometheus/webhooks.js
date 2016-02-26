var request = require('request');
var url ='http://requestb.in/1dcqw561'
request(url, function (error, response, body) {
  if (!error) {
    console.log(body);
  }
});
