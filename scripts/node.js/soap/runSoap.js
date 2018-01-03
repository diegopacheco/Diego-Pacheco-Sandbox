function run(request,response){

  try{
    if(!request.body.result.parameters.number){
      console.log("CEP number not present!");
      return "Missing CEP number";
    }
  }catch(e){
    console.log("CEP number not present!");
    return "Missing CEP number";
  }

  var soap = require('soap');
  var url = 'http://ws.correios.com.br/calculador/CalcPrecoPrazo.asmx?WSDL';
  var args = {
    nCdServico:  "40010",
    sCepOrigem:  "94035330",
    sCepDestino: request.body.result.parameters.number
  };

  soap.createClient(url, function(err, client) {
       client.CalcPrazo(args, function(err, resoap) {
          console.log("ARGS: " + JSON.stringify(request));
          console.log("Using CEP: " + request.body.result.parameters.number);
          console.log("Trace[JSON from SOAP]: " + JSON.stringify(resoap));

          res =  resoap.CalcPrazoResult.Servicos.cServico[0].PrazoEntrega + " dias";
          response.setHeader('Content-Type', 'application/json');
          response.send(JSON.stringify( { "speech": res, "displayText": res }));
          response.end();
       });
  });
};

var response = {
   send: function(data){
       console.log("SEND data: " + data);
   },
   setHeader: function(k,v){
       console.log("Header KEY: " + k + " VALUE: " + v);
   },
   end: function(){
     console.log("END")
   }
};

run({"body": {"result":{"parameters":{"number": 94035330 }}}},response);
run(null,response);
