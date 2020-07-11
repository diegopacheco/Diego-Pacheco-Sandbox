// server.ts
import { Application } from "oak";

const app = new Application();
console.log("Goto http://http://localhost:8000/");
app.use((ctx) => {
  ctx.response.body = "Hello World!";
});

await app.listen({ port: 8000 });
