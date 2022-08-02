// index.ts
console.log("Running on: " + process.env.BUN_HTTP_PORT || 5000)
export default {
    port: 3000,
    fetch(request:Request) {
      return new Response("Welcome to Bun with TypeScript!");
    },
};