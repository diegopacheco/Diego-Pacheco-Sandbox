// Include it and extract some methods for convenience
const server = require('server');
const { get, post } = server.router;

// // Launch server with options and a couple of routes
console.log("Server running on 8080. ")

server({ port: 8080 }, [
   get('/', ctx => 'Hello world'),
     post('/', ctx => console.log(ctx.data))
]);

