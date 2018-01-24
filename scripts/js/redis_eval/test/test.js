'use strict';

var expect = require("chai").expect;

describe('Basic Redis Eval test', function(){
  var redis = null;
  var client = null;

  before(function() {
    console.log('    ✓ Global setup - setting up redis connection. ');
    redis  = require("redis");
    client = redis.createClient();
    client.on("error", function (err) {
      console.log("Error " + err);
    });
  });

  it('KEYS * should be ok', function(){
    client.keys("*", function (err, replies) {
        console.log("      " +replies.length + " replies for KEYS.");
        expect(true).to.be.true;
    });
  });

  it('EVAL should be ok', function(){
    client.eval(["return redis.call('get',KEYS[1])",1,"K1"], function (err, replies) {
        console.log("      Result: " + replies);
        expect(true).to.be.true;
    });
  });

  after(function() {
    console.log('    ✓ Global teardown - shutting down redis connection. ');
    client.quit();
  });

});
