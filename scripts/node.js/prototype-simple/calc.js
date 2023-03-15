const redis = require("redis");

let redisClient;

function Calc(url=""){
    // this way the connection in lazy, only happen when Calc is initialized
    let resolvedURL = "";
    if (""!=url){
        resolvedURL = 'redis://@' + url;
    }else{
        resolvedURL = 'redis://@127.0.0.1:6379';
    }   
    redisClient = redis.createClient({
        url: resolvedURL
    }); 
    redisClient.on("error", (error) => console.error(`Error on Redis : ${error}`));
    redisClient.connect();
};

Calc.prototype.sum = function(a,b) {
    try{
       let result = a+b;
       redisClient.incr('op-sum');
       return result;
    }catch(e){
       redisClient.incr('err-sum');
       throw e;
    }
};

Calc.prototype.mul = function(a,b) {
    try{
        let result = a*b;
        redisClient.incr('op-mul');
        return result;
     }catch(e){
        redisClient.incr('err-mul');
        throw e;
     }
};

Calc.prototype.div = function(a,b) {
    try{
        let result = a/b;
        if (isNaN(result) || undefined==result){
            throw new Error("DivisionError: " + a + " by " + b);
        }
        redisClient.incr('op-div');
        return result;
     }catch(e){
        redisClient.incr('err-div');
        throw e;
     }
};

Calc.prototype.sub = function(a,b) {
    try{
        let result = a-b;
        redisClient.incr('op-sub');
        return result;
     }catch(e){
        redisClient.incr('err-sub');
        throw e;
     }
};

Calc.prototype.disconnect = function() {
    try{
        (async () => {
            await redisClient.quit();
        })();
    }catch(e){}
};

Calc.prototype.observability = function(){
    (async () => {
       var result = await redisClient.mGet(["op-mul","op-sub","op-div","op-sum",
                                            "err-mul","err-sub","err-div","err-sum"]);
       console.log("Observability Status:")
       console.table({
        "OK-Ops-Mul": result[0],
        "OK-Ops-Sub": result[1],
        "OK-Ops-Div": result[2],
        "OK-Ops-Sum": result[3],
        "ERR-Ops-Mul": result[4],
        "ERR-Ops-Sub": result[5],
        "ERR-Ops-Div": result[6],
        "ERR-Ops-Sum": result[7],
       });
    })();
}

module.exports = Calc;